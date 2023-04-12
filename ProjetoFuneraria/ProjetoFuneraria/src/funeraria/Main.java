package funeraria;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    Stage stage = new Stage();
    
    @Override
    public void start(Stage stage) throws IOException { 
        // carrega arquivo FXML para ser exibido
        Parent root = FXMLLoader.load(getClass().getResource("view/Login.fxml"));
        
        // instancia de uma scene para exibir a tela
        Scene scene = new Scene(root);
        
        // atribui a scene a um stage
        stage.setScene(scene);
        
        // titulo
        stage.setTitle("Login");
        
        // não permitir manipulação da tela (aumentar, diminuir, etc...)
        stage.setResizable(false);
        
        // mostrar tela
        stage.show();
    }
    
    public void close(){
        stage.close();
    }

    public static void main(String[] args) {
        launch(args);
    }    
}
