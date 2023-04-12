package funeraria.controller;

import funeraria.Home;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {
    
    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Button btnEntrar;   
    
    @FXML
    private Label lblUsuarioIncorreto;
    
    @FXML
    void entrar(ActionEvent event) throws IOException {
        
        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();
        
        if(usuario.equals("admin") && senha.equals("1234")) {  
            Home h = new Home();
            lblUsuarioIncorreto.setVisible(false);
            try {
                Stage s = new Stage();
                h.start(s);                
            }
            catch (IOException e) {
            }       
        }
        else {
            loginIncorreto();
        }
    }
    
    public void loginIncorreto() {
        lblUsuarioIncorreto.setVisible(true);
        txtUsuario.setText("");
        txtSenha.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }       
}
