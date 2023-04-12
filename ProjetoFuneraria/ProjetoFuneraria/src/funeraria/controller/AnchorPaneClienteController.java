package funeraria.controller;

import funeraria.model.dao.ClienteDAO;
import funeraria.model.database.Database;
import funeraria.model.database.DatabaseFactory;
import funeraria.model.domain.Cliente;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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


public class AnchorPaneClienteController implements Initializable {

    @FXML
    private TableView<Cliente> tableViewClientes;
    @FXML
    private TableColumn<Cliente, String> tableColumnClienteNome;
    @FXML
    private TableColumn<Cliente, String> tableColumnClienteCPF;
    
    @FXML
    private Button buttonExcluir;
    @FXML
    private Button buttonAlterar;
    @FXML
    private Button buttonNovo;
 
    @FXML
    private Label labelClienteNome;
    @FXML
    private Label labelClienteSobrenome;
    @FXML
    private Label labelClienteCPF;
    @FXML
    private Label labelClienteRG;
    @FXML
    private Label labelClienteDataNasc;
    @FXML
    private Label labelClienteGenero;
    @FXML
    private Label labelClienteProfissao;
    @FXML
    private Label labelClienteEstadoCivil;
    @FXML
    private Label labelClienteEmail;
    @FXML
    private Label labelClienteTelefone;
    @FXML
    private Label labelClienteEndereco;
    @FXML
    private Label labelClienteNumero;
    @FXML
    private Label labelClienteComplemento;
    @FXML
    private Label labelClienteBairro;
    @FXML
    private Label labelClienteCEP;
    @FXML
    private Label labelClienteEstado;
    @FXML
    private Label labelClienteCidade; 
    
    
    //Classe tem como objetivo carregar todos os clientes e mostrar numa tabela
    private List<Cliente> listCliente; // no BD retorna uma lista de clientes
    private ObservableList<Cliente> observableListClientes;  //no tableview eu setar os componentes com observable
    
   // atributos para manipulação de BD
   private final Database database = DatabaseFactory.getDatabase("mysql");
   private final Connection connection = database.conectar();
   private final ClienteDAO clienteDAO = new ClienteDAO();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clienteDAO.setConnection(connection); // vai até o BD
        carregarTableViewCliente(); // solicita que sejam carregados os clientes
    
        //Listen acionado quando qualquer alteração na seleção de itens do TableView
        tableViewClientes.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> selecionarItemTableViewCliente(newValue));
    }   
    
    //método para carregar tableview
    public void carregarTableViewCliente(){
        tableColumnClienteNome.setCellValueFactory(new PropertyValueFactory<>("cli_nome"));
        tableColumnClienteCPF.setCellValueFactory(new PropertyValueFactory<>("cli_cpf"));
    
        listCliente = clienteDAO.listar();
        
        observableListClientes = FXCollections.observableArrayList(listCliente);
        tableViewClientes.setItems(observableListClientes);
        
    }
    
    public void selecionarItemTableViewCliente(Cliente cliente){
        if (cliente != null){
            labelClienteNome.setText(cliente.getCli_nome());
            labelClienteSobrenome.setText(cliente.getCli_sobrenome());
            labelClienteCPF.setText(cliente.getCli_cpf());
            labelClienteRG.setText(cliente.getCli_rg());
            labelClienteDataNasc.setText(cliente.getCli_dtNascimento());
            labelClienteGenero.setText(cliente.getCli_genero());
            labelClienteProfissao.setText(cliente.getCli_profissao());
            labelClienteEstadoCivil.setText(cliente.getCli_estadoCivil());
            labelClienteEmail.setText(cliente.getCli_email());
            labelClienteTelefone.setText(cliente.getCli_telefone());
            labelClienteEndereco.setText(cliente.getCli_rua());
            labelClienteNumero.setText(Integer.toString(cliente.getCli_numero()));
            labelClienteComplemento.setText(cliente.getCli_complemento());
            labelClienteBairro.setText(cliente.getCli_bairro());
            labelClienteCEP.setText(cliente.getCli_cep());
            labelClienteEstado.setText(cliente.getCli_uf());
            labelClienteCidade.setText(cliente.getCli_cidade());
        }
        else {
            labelClienteNome.setText(" ");
            labelClienteSobrenome.setText(" ");
            labelClienteCPF.setText(" ");
            labelClienteRG.setText(" ");
            labelClienteDataNasc.setText(" ");
            labelClienteGenero.setText(" ");
            labelClienteProfissao.setText(" ");
            labelClienteEstadoCivil.setText(" ");
            labelClienteEmail.setText(" ");
            labelClienteTelefone.setText(" ");
            labelClienteEndereco.setText(" ");
            labelClienteNumero.setText(" ");
            labelClienteComplemento.setText(" ");
            labelClienteBairro.setText(" ");
            labelClienteCEP.setText(" ");
            labelClienteEstado.setText(" ");
            labelClienteCidade.setText(" ");
        }
    }
    
    //Evento botão NOVO
    @FXML
    public void handleButtonNovo() throws IOException{
        Cliente cliente = new Cliente(); //novo cliente
        boolean buttonConfirmarClicked = showAnchorPaneClienteDialog(cliente); //essa funcao abre a tela para inserção
        
        if (buttonConfirmarClicked){
            clienteDAO.inserir(cliente); //insere o cliente
            carregarTableViewCliente(); // carrega para mostrar o cliente na tabela
        }
    }
    
    //Evento botão ALTERAR
    @FXML
    public void handleButtonAlterar()throws IOException{
        Cliente cliente = tableViewClientes.getSelectionModel().getSelectedItem(); // pega cliente selecionado na tabela
        
        if (cliente != null){
            boolean buttonConfirmarClicked = showAnchorPaneClienteDialog(cliente);
            
            if (buttonConfirmarClicked){
                clienteDAO.alterar(cliente);
                carregarTableViewCliente();
            }
        }
        else { // se a pessoa apertar no botão e não selecionar um cliente
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na tabela");
            alert.show();
        }
    }
    
    //Evento botão EXCLUIR
    @FXML
    public void handleButtonRemover()throws IOException{
        Cliente cliente = tableViewClientes.getSelectionModel().getSelectedItem();
        
        if (cliente != null){
            clienteDAO.remover(cliente);
            carregarTableViewCliente();
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Cliente excluído com sucesso!");
            alert.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na tabela");
            alert.show();
        }
    }
    
    public boolean showAnchorPaneClienteDialog (Cliente cliente) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AnchorPaneClienteDialogController.class.getResource("/funeraria/view/AnchorPaneClienteDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        
        //criando um estágio de diálogo (stage dialog) 
        //para a tela aparecer para o usuário
        Stage dialogStage = new Stage(); 
        dialogStage.setTitle("Cadastro de Clientes");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
        //Setando o cliente no Controller
        AnchorPaneClienteDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setCliente(cliente);
        
        //Mostra o dialog e espera até que o usuário o feche 
        //mostra a tela
        dialogStage.showAndWait();
        
        return controller.isButtonConfirmarClicked();
    }
}
