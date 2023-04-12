public class Leitura{
import java.io.InputStreamReader; //
import java.io.BufferedReader;
import java.io.IOException;

public class Entrada{

	public String inData(String rotulo){

		System.out.println(rotulo); //ajuda p usuario

		String retorno = "";

		InputStreamReader teclado = new InputStreamReader(System.in);

		BufferedReader organiza = new BufferedReader(teclado);

		try{
			retorno = organiza.readLine();
		}
		catch(IOException io){
			System.out.println("\n Erro de sistema");
		}

		return retorno;
	}
}
	
}