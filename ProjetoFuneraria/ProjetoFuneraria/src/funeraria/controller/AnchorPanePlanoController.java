package funeraria.controller;

import funeraria.model.dao.PlanoDAO;
import funeraria.model.database.Database;
import funeraria.model.database.DatabaseFactory;
import funeraria.model.domain.Plano;
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

public class AnchorPanePlanoController implements Initializable {
    
    @FXML
    private TableView<Plano> tableViewPlano;
    @FXML
    private TableColumn<Plano, Integer> tableColumnPlanoID;
    @FXML
    private TableColumn<Plano, String> tableColumnPlanoNome;

    @FXML
    private Label labelPlanoID;
    @FXML
    private Label labelPlanoNome;
    @FXML
    private Label labelPlanoDescricao;
    @FXML
    private Label labelPlanoPreco;

    @FXML
    private Button buttonExcluir;
    @FXML
    private Button buttonAlterar;
    @FXML
    private Button buttonNovo;
    
    //Classe tem como objetivo carregar todos os planos e mostrar numa tabela
    private List<Plano> listPlano; // no BD retorna uma lista de planos
    private ObservableList<Plano> observableListPlano;  //no tableview eu setar os componentes com observable
    
   // atributos para manipulação de BD
   private final Database database = DatabaseFactory.getDatabase("mysql");
   private final Connection connection = database.conectar();
   private final PlanoDAO planoDAO = new PlanoDAO();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        planoDAO.setConnection(connection);
        carregarTableViewPlano();
        
        //Listen acionado quando qualquer alteração na seleção de itens do TableView
        tableViewPlano.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> selecionarItemTableViewPlano(newValue));
    }  
    
    public void carregarTableViewPlano(){
        tableColumnPlanoID.setCellValueFactory(new PropertyValueFactory<>("pla_id"));
        tableColumnPlanoNome.setCellValueFactory(new PropertyValueFactory<>("pla_nome"));
    
        listPlano = planoDAO.listar();
        
        observableListPlano = FXCollections.observableArrayList(listPlano);
        tableViewPlano.setItems(observableListPlano);
    }

    public void selecionarItemTableViewPlano(Plano plano){
        if (plano != null){
            labelPlanoID.setText(String.valueOf(plano.getPla_id()));
            labelPlanoNome.setText(plano.getPla_nome());
            labelPlanoDescricao.setText(plano.getPla_descricao());
            labelPlanoPreco.setText(String.valueOf(plano.getPla_preco()));
        }
        else {
            labelPlanoID.setText("");
            labelPlanoNome.setText("");
            labelPlanoDescricao.setText("");
            labelPlanoPreco.setText("");
        }
    }
    
    //Evento botão NOVO
    @FXML
    public void handleButtonNovo() throws IOException{
        Plano plano = new Plano(); //novo plano
        boolean buttonConfirmarClicked = showAnchorPanePlanoDialog(plano); //essa funcao abre a tela para inserção
        
        if (buttonConfirmarClicked){
            planoDAO.inserir(plano); //insere o plano
            carregarTableViewPlano(); // carrega para mostrar o plano na tabela
        }
    }
    
    //Evento botão ALTERAR
    @FXML
    public void handleButtonAlterar()throws IOException{
        Plano plano = tableViewPlano.getSelectionModel().getSelectedItem(); // pega o plano selecionado na tabela
        
        if (plano != null){
            boolean buttonConfirmarClicked = showAnchorPanePlanoDialog(plano);//essa funcao abre a tela para inserção
            
            if (buttonConfirmarClicked){
                planoDAO.alterar(plano);
                carregarTableViewPlano();
            }
        }
        else { // se a pessoa apertar no botão e não selecionar um plano
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um plano na tabela");
            alert.show();
        }
    }
    
    //Evento botão EXCLUIR
    @FXML
    public void handleButtonRemover()throws IOException{
        Plano plano = tableViewPlano.getSelectionModel().getSelectedItem(); // pega plano selecionado na tabela
        
        if (plano != null){
            planoDAO.remover(plano);
            carregarTableViewPlano();
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Plano excluído com sucesso!");
            alert.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um plano na tabela");
            alert.show();
        }
    }
    
    //método que mostra a tela
    public boolean showAnchorPanePlanoDialog (Plano plano) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AnchorPanePlanoDialogController.class.getResource("/funeraria/view/AnchorPanePlanoDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        
        //criando um estágio de diálogo (stage dialog) 
        //para a tela aparecer para o usuário
        Stage dialogStage = new Stage(); 
        dialogStage.setTitle("Cadastro de Plano");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
        //Setando o plano no Controller
        AnchorPanePlanoDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setPlano(plano);
        
        //Mostra o dialog e espera até que o usuário o feche 
        //mostra a tela
        dialogStage.showAndWait();
        
        return controller.isButtonConfirmarClicked();
    }
    
}
