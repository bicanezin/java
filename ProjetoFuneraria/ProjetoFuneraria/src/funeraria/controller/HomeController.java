package funeraria.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;


public class HomeController implements Initializable{

    //incluindo os atributos visuais os quais trabalhamos    
    @FXML
    private MenuItem menuItemCliente;
    @FXML
    private MenuItem menuItemContrato;
    @FXML
    private MenuItem menuItemFalecido;
    @FXML
    private MenuItem menuItemPlano;
    @FXML
    private MenuItem menuItemProduto;

    
    @FXML
    private Menu menuContrato;
    @FXML
    private Menu menuFalecido;
    @FXML
    private Menu menuPlano;
    @FXML
    private Menu menuProduto;
    
    @FXML
    private AnchorPane anchorPane;
    

    public void initialize(URL url, ResourceBundle rb) {
    
    }    
    
    
    //evento que abre a tela clientes
    @FXML
    public void manipulaMenuItemCliente() throws IOException{
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/funeraria/view/AnchorPaneCliente.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    
    @FXML
    public void manipulaMenuItemContrato() throws IOException{
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/funeraria/view/AnchorPaneContrato.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    
    @FXML
    public void manipulaMenuItemFalecido() throws IOException{
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/funeraria/view/AnchorPaneFalecido.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    
    @FXML
    public void manipulaMenuItemPlano() throws IOException{
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/funeraria/view/AnchorPanePlano.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    
    @FXML
    public void manipulaMenuItemProduto() throws IOException{
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/funeraria/view/AnchorPaneProduto.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    
}
