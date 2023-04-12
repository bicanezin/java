package sinalgo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Vector;

import sinalgo.configuration.AppConfig;
import sinalgo.configuration.Configuration;
import sinalgo.gui.ProjectSelector;
import sinalgo.io.xml.XMLParser;
import sinalgo.runtime.Global;
import sinalgo.runtime.Main;

public class Run {

	
	public static void main(String args[]) {
		String classPathSeparator = System.getProperty("path.separator");
		String dirSeparator = System.getProperty("file.separator");
		testJavaVersion();
		addJDOMtoClassPath();

		String command = "";
		try {
			{
				String cmdLineArgs = "";
				for(String s : args) {
					cmdLineArgs += s + " ";
				}
				AppConfig.getAppConfig().previousRunCmdLineArgs = cmdLineArgs;
				AppConfig.getAppConfig().writeConfig();
			}
			
			String projectName = new Run().projectSelector(args); 

			String tempConfigFileName = Global.getProjectSrcDir() + "/" + Configuration.configfileFileName; 
			XMLParser.parse(tempConfigFileName);

			Main.parseOverwriteParameters(args, false);

			Vector<String> cmds = new Vector<String>();
			for(String s : Configuration.javaCmd.split(" ")) {
				cmds.add(s);
			}

			String cp = System.getProperty("user.dir");
			cmds.add("-Xmx" + Configuration.javaVMmaxMem + "m");
			cmds.add("-cp");
			cmds.add("binaries" + dirSeparator + "bin" + classPathSeparator + "binaries" + dirSeparator +"jdom.jar");
			cmds.add("sinalgo.runtime.Main");
			
			if(projectName != null) { 
				cmds.add("-project");
				cmds.add(projectName);
			}
			for(int i=0; i<args.length; i++) {
				cmds.add(args[i]);
			}
			
			for(String s : cmds) {
				command += s + " ";
			}
			
			ProcessBuilder pb = new ProcessBuilder(cmds);
			pb.directory(new File(cp));
			pb.redirectErrorStream(true);
			mainProcess = pb.start();
			
			Runtime.getRuntime().addShutdownHook(new ShutdownThread()); 
			
			BufferedReader osr = new BufferedReader(new InputStreamReader(mainProcess.getInputStream()));
			String line = null;
			while((line = osr.readLine()) != null) {
				System.out.println(line);
			}
			int exitValue = 0;
			if((exitValue = mainProcess.waitFor()) != 0) {
				System.out.println("\n\nThe simulation terminated with exit value " + exitValue + "\n");
				System.out.println("Command: " + command); 
			}
			mainProcess = null;
			if(projectName != null) { 
				File configFile = new File(tempConfigFileName + ".run");
				if(configFile.exists()) {
					configFile.delete();
				}
			}

			System.exit(0); 
		} catch (IOException e) {
			Main.fatalError("Failed to create the simulation process with the following command:\n" +
			                command + "\n\n" + e.getMessage());
		} catch (InterruptedException e) {
			Main.fatalError("Failed to create the simulation process with the following command:\n" +
			                command + "\n\n" + e.getMessage());
		}
	}
	
	public static void addJDOMtoClassPath() {
		String cp = System.getProperty("java.class.path");
		
		if(!cp.contains("jdom.jar")) {
			try {
				if(!(ClassLoader.getSystemClassLoader() instanceof URLClassLoader)) {
					Main.fatalError("Cannot add 'binaries/jdom.jar' to the classpath. Add it manually on the command-line.");
				}
				URLClassLoader sysloader = (URLClassLoader)ClassLoader.getSystemClassLoader();
				Class<URLClassLoader> sysclass = URLClassLoader.class;
		    String fileSep = System.getProperty("file.separator");
				Method method = sysclass.getDeclaredMethod("addURL",URL.class);
				method.setAccessible(true);
				method.invoke(sysloader,new Object[]{ new File(System.getProperty("user.dir") + fileSep + "binaries"+fileSep+"jdom.jar").toURI().toURL()});
			} catch (Exception e) {
				Main.fatalError("Could not add 'binaries/jdom.jar' to the classpath. Add it manually on the command-line.");
			}
		}
	}
	

	private static void testJavaVersion() {
		String javaVersion = System.getProperty("java.vm.version");
		javaVersion = javaVersion.replace('.', '#');
		String[] versionParts = javaVersion.split("#"); 
		if(versionParts.length < 2) {
			System.err.println("You may have an invalid Java version: " + javaVersion);
		} else {
			try {
				int v = Integer.parseInt(versionParts[1]);
				if(v < 5) {
					System.err.println("You may have an invalid Java version: " + javaVersion + ". The application requires version 1.5 or more recent.");
				}
			} catch(NumberFormatException e) {
				System.err.println("You may have an invalid Java version: " + javaVersion + ". The application requires version 1.5 or more recent.");				
			}
		}
	}

	private String projectSelector(String[] args) {
		for(String s : args) { 
			if(s.equals("-help")) {
				Main.usage(false);
				System.exit(1);
			}
		}

		int guiBatch = 0; 
		for(String s : args) {
			if(s.toLowerCase().equals("-batch")) {
				if(guiBatch == 1) { 
					Main.fatalError("You may only specify the '-gui' xor the '-batch' flag.");
				}
				guiBatch = 2;
				Global.isGuiMode = false;
			} else if(s.toLowerCase().equals("-gui")) {
				if(guiBatch == 2) { // conflict
					Main.fatalError("You may only specify the '-gui' xor the '-batch' flag.");
				}
				guiBatch = 1;
				Global.isGuiMode = true;
			}
		}
		
		for(int i = 0; i < args.length; i++){
			if(args[i].equals("-project")) { 
				if(i+1 >= args.length) {
					Main.fatalError("The flag '-project' must be preceeded by the name of a project");
				}
				String path = Configuration.sourceDirPrefix + "/" + Configuration.userProjectsPath.replace('.', '/') + "/" + args[i+1];
				Global.getProjectSrcDir();
				File testProj = new File(path);
				if(testProj.exists()){
					Global.useProject = true;
					Global.projectName = args[i+1];
				}	else{
					Main.fatalError("Cannot find the specified project '" + args[i+1] + "'.\n" +
					                "In order to create a project '" + args[i+1] + "', create a folder '" + 
					                path + "'");
				}
			}
		}
		
		if(!Global.useProject){
			if(guiBatch == 2) { 
				Main.fatalError("Missing project: In batch mode, you need to specify a project on the command line using the -project flag.");
			}

			Global.isGuiMode = true;
			ProjectSelector pane = new ProjectSelector();
			pane.populate(this);
			
			try {
				synchronized(this){
					wait();
				}
			}
			catch (InterruptedException e) {
				Main.fatalError(e);
			}
			return Global.projectName;
		} else {
			return null;
		}
	}
	
	private static Process mainProcess = null; 

	public static class ShutdownThread extends Thread {

		public void run() {
			if(mainProcess != null) {
				mainProcess.destroy();
			}
		}
	}
	
	
}
