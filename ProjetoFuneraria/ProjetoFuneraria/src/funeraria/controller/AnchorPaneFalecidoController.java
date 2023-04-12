package funeraria.controller;

import funeraria.model.dao.FalecidoDAO;
import funeraria.model.database.Database;
import funeraria.model.database.DatabaseFactory;
import funeraria.model.domain.Falecido;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

public class AnchorPaneFalecidoController implements Initializable {
    
    @FXML
    private TableView<Falecido> tableViewFalecido;
    @FXML
    private TableColumn<Falecido, String> tableColumnFalecidoNome;
    @FXML
    private TableColumn<Falecido, String> tableColumnFalecidoDataFalec;

    @FXML
    private Label labelFalecidoNome;
    @FXML
    private Label labelFalecidoSobrenome;
    @FXML
    private Label labelFalecidoCPF;
    @FXML
    private Label labelFalecidoRG;
    @FXML
    private Label labelFalecidoEstadoCivil;
    @FXML
    private Label labelFalecidoNumMatricula;
    @FXML
    private Label labelFalecidoDataNasc;
    @FXML
    private Label labelFalecidoDataFalec;
    @FXML
    private Label labelFalecidoCausaMortis;
    @FXML
    private Label labelFalecidoCidade;

    @FXML
    private Button buttonExcluir;
    @FXML
    private Button buttonAlterar;
    @FXML
    private Button buttonNovo;
    
   //Classe tem como objetivo carregar todos os falecidos e mostrar numa tabela
   private List<Falecido> listFalecido; // no BD retorna uma lista de falecidos
   private ObservableList<Falecido> observableListFalecido;  //no tableview eu setar os componentes com observable
    
   // atributos para manipulação de BD
   private final Database database = DatabaseFactory.getDatabase("mysql");
   private final Connection connection = database.conectar();
   private final FalecidoDAO falecidoDAO = new FalecidoDAO();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        falecidoDAO.setConnection(connection);
        carregarTableViewFalecido();
        
        //Listen acionado quando qualquer alteração na seleção de itens do TableView
        tableViewFalecido.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> selecionarItemTableViewFalecido(newValue));
    }    
    
    public void carregarTableViewFalecido(){
        tableColumnFalecidoNome.setCellValueFactory(new PropertyValueFactory<>("fal_nome"));
        tableColumnFalecidoDataFalec.setCellValueFactory(new PropertyValueFactory<>("fal_dataFalec"));
    
        listFalecido = falecidoDAO.listar();
        
        observableListFalecido = FXCollections.observableArrayList(listFalecido);
        tableViewFalecido.setItems(observableListFalecido);
    }
    
    public void selecionarItemTableViewFalecido(Falecido falecido){
        if (falecido != null){
            labelFalecidoNome.setText(falecido.getFal_nome());
            labelFalecidoSobrenome.setText(falecido.getFal_sobrenome());
            labelFalecidoCPF.setText(falecido.getFal_cpf());
            labelFalecidoRG.setText(falecido.getFal_rg());
            labelFalecidoEstadoCivil.setText(falecido.getFal_estadoCivil()); 
            labelFalecidoNumMatricula.setText(falecido.getFal_matriculaCertidaoObito());
            labelFalecidoDataNasc.setText(falecido.getFal_dataNasc());
            labelFalecidoDataFalec.setText(falecido.getFal_dataFalec());
            labelFalecidoCausaMortis.setText(falecido.getFal_causaMorte()); 
            labelFalecidoCidade.setText(falecido.getFal_cidadeFalec()); 
        }
        else {
            labelFalecidoNome.setText("");
            labelFalecidoSobrenome.setText("");
            labelFalecidoCPF.setText("");
            labelFalecidoRG.setText("");
            labelFalecidoEstadoCivil.setText(""); 
            labelFalecidoNumMatricula.setText("");
            labelFalecidoDataNasc.setText("");
            labelFalecidoDataFalec.setText("");
            labelFalecidoCausaMortis.setText(""); 
            labelFalecidoCidade.setText("");
        }
    }
    
    //Evento botão NOVO
    @FXML
    public void handleButtonNovo() throws IOException{
        Falecido falecido = new Falecido(); //novo falecido
        boolean buttonConfirmarClicked = showAnchorPaneFalecidoDialog(falecido); //essa funcao abre a tela para inserção
        
        if (buttonConfirmarClicked){
            falecidoDAO.inserir(falecido); //insere o falecido
            carregarTableViewFalecido(); // carrega para mostrar o falecido na tabela
        }
    }
    
    //Evento botão ALTERAR
    @FXML
    public void handleButtonAlterar()throws IOException{
        Falecido falecido = tableViewFalecido.getSelectionModel().getSelectedItem(); // pega falecido selecionado na tabela
        
        if (falecido != null){
            boolean buttonConfirmarClicked = showAnchorPaneFalecidoDialog(falecido);//essa funcao abre a tela para inserção
            
            if (buttonConfirmarClicked){
                falecidoDAO.alterar(falecido);
                carregarTableViewFalecido();
            }
        }
        else { // se a pessoa apertar no botão e não selecionar um falecido
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um falecido na tabela");
            alert.show();
        }
    }
    
    //Evento botão EXCLUIR
    @FXML
    public void handleButtonRemover()throws IOException{
        Falecido falecido = tableViewFalecido.getSelectionModel().getSelectedItem(); // pega falecido selecionado na tabela
        
        if (falecido != null){
            falecidoDAO.remover(falecido);
            carregarTableViewFalecido();
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Falecido excluído com sucesso!");
            alert.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um falecido na tabela");
            alert.show();
        }
    }
    
    //método que mostra a tela
    public boolean showAnchorPaneFalecidoDialog (Falecido falecido) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AnchorPaneFalecidoDialogController.class.getResource("/funeraria/view/AnchorPaneFalecidoDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        
        //criando um estágio de diálogo (stage dialog) 
        //para a tela aparecer para o usuário
        Stage dialogStage = new Stage(); 
        dialogStage.setTitle("Cadastro de Falecidos");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
        //Setando o Falecido no Controller
        AnchorPaneFalecidoDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setFalecido(falecido);
        
        //Mostra o dialog e espera até que o usuário o feche 
        //mostra a tela
        dialogStage.showAndWait();
        
        return controller.isButtonConfirmarClicked();
    }
}
