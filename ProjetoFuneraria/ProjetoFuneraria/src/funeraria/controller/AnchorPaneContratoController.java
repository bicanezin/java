
package funeraria.controller;

import funeraria.model.dao.ClienteDAO;
import funeraria.model.dao.ContratoDAO;
import funeraria.model.dao.PlanoDAO;
import funeraria.model.dao.ProdutoDAO;
import funeraria.model.database.Database;
import funeraria.model.database.DatabaseFactory;
import funeraria.model.domain.Contrato;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AnchorPaneContratoController implements Initializable {

    @FXML
    private TableView<Contrato> tableViewContrato;
    @FXML
    private TableColumn<Contrato, Contrato> tableColumnContratoCliente;
    @FXML
    private TableColumn<Contrato, Contrato> tableColumnContratoPlano;

    @FXML
    private Label labelContratoCliente;
    @FXML
    private Label labelContratoPlano;
    @FXML
    private Label labelContratoProduto;
    @FXML
    private Label labelContratoDataInicio;
    @FXML
    private Label labelContratoDataFim;

    @FXML
    private Button buttonExcluir;
    @FXML
    private Button buttonAlterar;
    @FXML
    private Button buttonNovo;
    
    private List<Contrato> listContrato;
    private ObservableList<Contrato> observableListContrato;
    
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final ContratoDAO contratoDAO = new ContratoDAO();
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final PlanoDAO planoDAO = new PlanoDAO();
    private final ProdutoDAO produtoDAO = new ProdutoDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        contratoDAO.setConnection(connection);
        carregarTableViewContrato();
        
        selecionarItemTableViewContrato(null);
        
        //Listen acionado quando qualquer alteração na seleção de itens do TableView
        tableViewContrato.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> selecionarItemTableViewContrato(newValue));
    } 
    
    public void carregarTableViewContrato(){    
        tableColumnContratoPlano.setCellValueFactory(new PropertyValueFactory<>("plano")); 
        tableColumnContratoCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        
        listContrato = contratoDAO.listar();
        
        observableListContrato = FXCollections.observableArrayList(listContrato);
        tableViewContrato.setItems(observableListContrato);
    }
    
    public void selecionarItemTableViewContrato(Contrato contrato){
        if (contrato != null){
            labelContratoCliente.setText(String.valueOf(contrato.getCliente().getCli_nome()));
            labelContratoPlano.setText(String.valueOf(contrato.getPlano()));
            labelContratoProduto.setText(String.valueOf(contrato.getProduto()));
            labelContratoDataInicio.setText(contrato.getContr_dataInicio());
            labelContratoDataFim.setText(contrato.getContr_dataFim());  
        }
        else {
            labelContratoCliente.setText("");
            labelContratoPlano.setText("");
            labelContratoProduto.setText("");
            labelContratoDataInicio.setText("");
            labelContratoDataFim.setText(""); 
        }
    }
    
    @FXML
    public void handleButtonNovo() throws IOException{
        Contrato contrato = new Contrato(); //novo contrato
        boolean buttonConfirmarClicked = showAnchorPaneContratoDialog(contrato); //essa funcao abre a tela para inserção
        
        if (buttonConfirmarClicked){
            contratoDAO.inserir(contrato); //insere o contrato
            carregarTableViewContrato(); // carrega para mostrar o contrato na tabela
        }
    }
    
    @FXML
    public void handleButtonRemover() throws IOException, SQLException {
        Contrato contrato = tableViewContrato.getSelectionModel().getSelectedItem();
        if (contrato != null){
            contratoDAO.remover(contrato);
            carregarTableViewContrato();
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Contrato excluído com sucesso!");
            alert.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um contrato na tabela");
            alert.show();
        }
    }
    
    @FXML
    public void handleButtonAlterar()throws IOException{
        Contrato contrato = tableViewContrato.getSelectionModel().getSelectedItem(); // pega contrato selecionado na tabela
        
        if (contrato != null){
            boolean buttonConfirmarClicked = showAnchorPaneContratoDialog(contrato);
            
            if (buttonConfirmarClicked){
                contratoDAO.alterar(contrato);
                carregarTableViewContrato();
            }
        }
        else { // se a pessoa apertar no botão e não selecionar um contrato
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um contrato na tabela");
            alert.show();
        }
    }
    
    public boolean showAnchorPaneContratoDialog(Contrato contrato)throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AnchorPaneContratoDialogController.class.getResource("/funeraria/view/AnchorPaneContratoDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        
        //criando um estágio de diálogo (stage dialog) 
        //para a tela aparecer para o usuário
        Stage dialogStage = new Stage(); 
        dialogStage.setTitle("Cadastro de Contrato");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
        //Setando o contrato no Controller
        AnchorPaneContratoDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setContrato(contrato);
        
        //Mostra o dialog e espera até que o usuário o feche 
        //mostra a tela
        dialogStage.showAndWait();
        
        return controller.isButtonConfirmarClicked();
    }
}
