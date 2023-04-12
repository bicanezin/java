package funeraria.controller;

import funeraria.model.dao.ClienteDAO;
import funeraria.model.dao.PlanoDAO;
import funeraria.model.dao.ProdutoDAO;
import funeraria.model.database.Database;
import funeraria.model.database.DatabaseFactory;
import funeraria.model.domain.Cliente;
import funeraria.model.domain.Contrato;
import funeraria.model.domain.Plano;
import funeraria.model.domain.Produto;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AnchorPaneContratoDialogController implements Initializable {
    
    @FXML
    private Button buttonCancelar;
    @FXML
    private Button buttonConfirmar;

    @FXML
    private ComboBox comboBoxContratoCliente;
    @FXML
    private ComboBox comboBoxContratoPlano;

    @FXML
    private TextField textFieldContratoInicio;
    @FXML
    private TextField textFieldContratoFim;

    @FXML
    private ComboBox comboBoxContratoProduto;
    
    private List<Cliente> listCliente;
    private List<Plano> listPlano;
    private List<Produto> listProduto;
    private ObservableList<Cliente> observableListCliente;
    private ObservableList<Plano> observableListPlano;
    private ObservableList<Produto> observableListProduto;
    
    //atributos para manipulação de Banco de Dados
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final PlanoDAO planoDAO = new PlanoDAO();
    private final ProdutoDAO produtoDAO = new ProdutoDAO();
    
    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Contrato contrato;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clienteDAO.setConnection(connection);
        planoDAO.setConnection(connection);
        produtoDAO.setConnection(connection);
        
        carregarComboBoxCliente();
        carregarComboBoxPlano();
        carregarComboBoxProduto();        
    }
    
    public void carregarComboBoxCliente(){
        listCliente = clienteDAO.listar();
        observableListCliente = FXCollections.observableArrayList(listCliente);
        comboBoxContratoCliente.setItems(observableListCliente);
    }
    
    public void carregarComboBoxPlano(){
        listPlano = planoDAO.listar();
        observableListPlano = FXCollections.observableArrayList(listPlano);
        comboBoxContratoPlano.setItems(observableListPlano);
    }
    
    public void carregarComboBoxProduto(){
        listProduto = produtoDAO.listar();
        observableListProduto = FXCollections.observableArrayList(listProduto);
        comboBoxContratoProduto.setItems(observableListProduto);
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
        
        this.comboBoxContratoCliente.getSelectionModel().select(contrato.getCliente());
        this.comboBoxContratoPlano.getSelectionModel().select(contrato.getPlano());
        this.comboBoxContratoProduto.getSelectionModel().select(contrato.getProduto());
        this.textFieldContratoInicio.setText(contrato.getContr_dataInicio());
        this.textFieldContratoFim.setText(contrato.getContr_dataFim());
    }
    
    
    @FXML
    public void handleButtonConfirmar(){
        if (validarEntradaDados()){
            contrato.setCliente((Cliente) comboBoxContratoCliente.getSelectionModel().getSelectedItem());
            contrato.setPlano((Plano) comboBoxContratoPlano.getSelectionModel().getSelectedItem());
            contrato.setProduto((Produto) comboBoxContratoProduto.getSelectionModel().getSelectedItem());
            contrato.setContr_dataInicio(textFieldContratoInicio.getText());
            contrato.setContr_dataFim(textFieldContratoFim.getText());
        
            buttonConfirmarClicked = true;
            dialogStage.close();
        }
    }
    
    public void handleButtonCancelar(){
        dialogStage.close();
    }
    
    private boolean validarEntradaDados(){
        String errorMessage = "";
        
        if (comboBoxContratoCliente.getSelectionModel().getSelectedItem() == null){
            errorMessage += "Cliente inválido!\n";
        }
        if (comboBoxContratoPlano.getSelectionModel().getSelectedItem() == null){
            errorMessage += "Plano inválido!\n";
        }
        if (comboBoxContratoProduto.getSelectionModel().getSelectedItem() == null){
            errorMessage += "Produto inválido!\n";
        }
        if (textFieldContratoInicio.getText() == null || textFieldContratoInicio.getText().length() == 0){
            errorMessage += "Data de início inválida!\n";
        }
        if (textFieldContratoFim.getText() == null || textFieldContratoFim.getText().length() == 0){
            errorMessage += "Data de fim inválida!\n";
        }
        
        if(errorMessage.length() == 0){
            return true;
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText("Campos inválidos, por favor, corrija...");
            alert.setContentText(errorMessage);
            alert.show();
            
            return false;
        }
    }
    
}
