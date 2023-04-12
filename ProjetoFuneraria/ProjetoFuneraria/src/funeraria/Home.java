package funeraria;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Home extends Application{
    public static Stage stage;
    
    public void start(Stage stage) throws IOException { 
        // carrega arquivo FXML para ser exibido
        Parent root = FXMLLoader.load(getClass().getResource("/funeraria/view/Home.fxml"));
        
        // instancia de uma scene para exibir a tela
        Scene scene = new Scene(root);
        
        // atribui a scene a um stage
        stage.setScene(scene);
        
        // titulo
        stage.setTitle("Sistema para Funeraria");
        
        // não permitir manipulação da tela (aumentar, diminuir, etc...)
        stage.setResizable(false);
        
        // mostrar tela
        stage.show();
    }
}
