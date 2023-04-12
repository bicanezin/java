package funeraria.controller;

import funeraria.model.dao.ProdutoDAO;
import funeraria.model.database.Database;
import funeraria.model.database.DatabaseFactory;
import funeraria.model.domain.Produto;
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

public class AnchorPaneProdutoController implements Initializable {

    @FXML
    private TableView<Produto> tableViewProduto;
    @FXML
    private TableColumn<Produto, String> tableColumnProdutoNome;
    @FXML
    private TableColumn<Produto, String> tableColumnProdutoDescricao;
    
    @FXML
    private Label labelProdutoNome;
    @FXML
    private Label labelProdutoDescricao;
    @FXML
    private Label labelProdutoMarca;
    @FXML
    private Label labelProdutoPreco;
    @FXML
    private Label labelProdutoLargura;
    @FXML
    private Label labelProdutoComprimento;
    @FXML
    private Label labelProdutoAltura;
    @FXML
    private Label labelProdutoQtdEstoque;

    @FXML
    private Button buttonExcluir;
    @FXML
    private Button buttonAlterar;
    @FXML
    private Button buttonNovo;

    //Classe tem como objetivo carregar todos os produtos e mostrar numa tabela
    private List<Produto> listProduto; // no BD retorna uma lista de produtos
    private ObservableList<Produto> observableListProduto;  //no tableview eu setar os componentes com observable
    
   // atributos para manipulação de BD
   private final Database database = DatabaseFactory.getDatabase("mysql");
   private final Connection connection = database.conectar();
   private final ProdutoDAO produtoDAO = new ProdutoDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        produtoDAO.setConnection(connection);
        carregarTableViewProduto();
        
        //Listen acionado quando qualquer alteração na seleção de itens do TableView
        tableViewProduto.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> selecionarItemTableViewProduto(newValue));
    }  
    
    public void carregarTableViewProduto(){
        tableColumnProdutoNome.setCellValueFactory(new PropertyValueFactory<>("prod_nome"));
        tableColumnProdutoDescricao.setCellValueFactory(new PropertyValueFactory<>("prod_descricao"));
    
        listProduto = produtoDAO.listar();
        
        observableListProduto = FXCollections.observableArrayList(listProduto);
        tableViewProduto.setItems(observableListProduto);
    }
        
    public void selecionarItemTableViewProduto(Produto produto){
        if (produto != null){
            labelProdutoNome.setText(produto.getProd_nome());
            labelProdutoDescricao.setText(produto.getProd_descricao());
            labelProdutoMarca.setText(produto.getProd_marca());
            labelProdutoPreco.setText(String.valueOf(produto.getProd_preco()));
            labelProdutoLargura.setText(String.valueOf(produto.getProd_largura()));
            labelProdutoComprimento.setText(String.valueOf(produto.getProd_comprimento()));
            labelProdutoAltura.setText(String.valueOf(produto.getProd_altura()));
            labelProdutoQtdEstoque.setText(String.valueOf(produto.getProd_qtdEstoque()));

        }
        else {
            labelProdutoNome.setText("");
            labelProdutoDescricao.setText("");
            labelProdutoMarca.setText("");
            labelProdutoPreco.setText("");
            labelProdutoLargura.setText("");
            labelProdutoComprimento.setText("");
            labelProdutoAltura.setText("");
            labelProdutoQtdEstoque.setText("");
        }
    }
    
    //Evento botão NOVO
    @FXML
    public void handleButtonNovo() throws IOException{
        Produto produto = new Produto(); //novo produto
        boolean buttonConfirmarClicked = showAnchorPaneProdutoDialog(produto); //essa funcao abre a tela para inserção
        
        if (buttonConfirmarClicked){
            produtoDAO.inserir(produto); //insere o produto
            carregarTableViewProduto(); // carrega para mostrar o produto na tabela
        }
    }
    
    //Evento botão ALTERAR
    @FXML
    public void handleButtonAlterar()throws IOException{
        Produto produto = tableViewProduto.getSelectionModel().getSelectedItem(); // pega o produto selecionado na tabela
        
        if (produto != null){
            boolean buttonConfirmarClicked = showAnchorPaneProdutoDialog(produto);//essa funcao abre a tela para inserção
            
            if (buttonConfirmarClicked){
                produtoDAO.alterar(produto);
                carregarTableViewProduto();
            }
        }
        else { // se a pessoa apertar no botão e não selecionar um produto
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um produto na tabela");
            alert.show();
        }
    }
    
    //Evento botão EXCLUIR
    @FXML
    public void handleButtonRemover()throws IOException{
        Produto produto = tableViewProduto.getSelectionModel().getSelectedItem(); // pega produto selecionado na tabela
        
        if (produto != null){
            produtoDAO.remover(produto);
            carregarTableViewProduto();
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Produto excluído com sucesso!");
            alert.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um produto na tabela");
            alert.show();
        }
    }
    
    //método que mostra a tela
    public boolean showAnchorPaneProdutoDialog (Produto produto) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AnchorPaneProdutoDialogController.class.getResource("/funeraria/view/AnchorPaneProdutoDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        
        //criando um estágio de diálogo (stage dialog) 
        //para a tela aparecer para o usuário
        Stage dialogStage = new Stage(); 
        dialogStage.setTitle("Cadastro de Produto");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
        //Setando o produto no Controller
        AnchorPaneProdutoDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setProduto(produto);
        
        //Mostra o dialog e espera até que o usuário o feche 
        //mostra a tela
        dialogStage.showAndWait();
        
        return controller.isButtonConfirmarClicked();
    }
    
}
