package funeraria.controller;

import funeraria.model.domain.Produto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AnchorPaneProdutoDialogController implements Initializable {

    @FXML
    private Button buttonCancelar;
    @FXML
    private Button buttonConfirmar;

    @FXML
    private Label labelProdutoNome;
    @FXML
    private TextField textFieldProdutoNome;

    @FXML
    private Label labelProdutoDescricao;
    @FXML
    private TextArea textFieldProdutoDescricao;

    @FXML
    private Label labelProdutoMarca;
    @FXML
    private TextField textFieldProdutoMarca;

    @FXML
    private Label labelProdutoPreco;
    @FXML
    private TextField textFieldProdutoPreco;

    @FXML
    private Label labelProdutoLargura;
    @FXML
    private TextField textFieldProdutoLargura;

    @FXML
    private Label labelProdutoComprimento;
    @FXML
    private TextField textFieldProdutoComprimento;
    
    @FXML
    private Label labelProdutoAltura;
    @FXML
    private TextField textFieldProdutoAltura;

    @FXML
    private Label labelProdutoQtdEstoque;
    @FXML
    private TextField textFieldProdutoQtdEstoque;

    private Stage dialogStage; // representa a tela 
    private boolean buttonConfirmarClicked = false; // para saber em qual botão a pessoa clicou
    private Produto produto; // onde vamos preencher os dados p/ mandar para o bd

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

    public void setButtonConfirmarClicked(boolean buttonConfirmarClicked) {
        this.buttonConfirmarClicked = buttonConfirmarClicked;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        
        //se for produto já cadastrado seta com os campos preenchidos
        this.textFieldProdutoNome.setText(produto.getProd_nome());
        this.textFieldProdutoDescricao.setText(produto.getProd_descricao());
        this.textFieldProdutoMarca.setText(produto.getProd_marca());
        this.textFieldProdutoPreco.setText(Double.toString(produto.getProd_preco()));
        this.textFieldProdutoLargura.setText(Double.toString(produto.getProd_largura()));
        this.textFieldProdutoComprimento.setText(Double.toString(produto.getProd_comprimento()));
        this.textFieldProdutoAltura.setText(Double.toString(produto.getProd_altura()));
        this.textFieldProdutoQtdEstoque.setText(Integer.toString(produto.getProd_qtdEstoque()));
    }
    
    
    @FXML
    public void handleButtonCancelar() {
        dialogStage.close();
    }

    @FXML
    public void handleButtonConfirmar() {
        if (validarEntradaDeDados()){
            produto.setProd_nome(textFieldProdutoNome.getText());
            produto.setProd_descricao(textFieldProdutoDescricao.getText());
            produto.setProd_marca(textFieldProdutoMarca.getText());
            produto.setProd_preco(Double.parseDouble(textFieldProdutoPreco.getText()));
            produto.setProd_largura(Double.parseDouble(textFieldProdutoLargura.getText()));
            produto.setProd_comprimento(Double.parseDouble(textFieldProdutoComprimento.getText()));
            produto.setProd_altura(Double.parseDouble(textFieldProdutoAltura.getText()));
            produto.setProd_qtdEstoque(Integer.parseInt(textFieldProdutoQtdEstoque.getText()));
            
          
            buttonConfirmarClicked = true;
            dialogStage.close();
        } 
    }
    
    private boolean validarEntradaDeDados(){
        String errorMessage = "";
        
        if (textFieldProdutoNome.getText() == null || textFieldProdutoNome.getText().length() == 0){
            errorMessage += "Nome inválido!\n";
        }
        if (textFieldProdutoDescricao.getText() == null || textFieldProdutoDescricao.getText().length() == 0){
            errorMessage += "Descrição inválida!\n";
        }
        if (textFieldProdutoMarca.getText() == null || textFieldProdutoMarca.getText().length() == 0){
            errorMessage += "Marca inválida!\n";
        }
        if (textFieldProdutoPreco.getText() == null || textFieldProdutoPreco.getText().length() == 0){
            errorMessage += "Preço inválido!\n";
        }
        if (textFieldProdutoLargura.getText() == null || textFieldProdutoLargura.getText().length() == 0){
            errorMessage += "Largura inválida!\n";
        }
        if (textFieldProdutoComprimento.getText() == null || textFieldProdutoComprimento.getText().length() == 0){
            errorMessage += "Comprimento inválido!\n";
        }
        if (textFieldProdutoAltura.getText() == null || textFieldProdutoAltura.getText().length() == 0){
            errorMessage += "Altura inválida!\n";
        }
        if (textFieldProdutoQtdEstoque.getText() == null || textFieldProdutoQtdEstoque.getText().length() == 0){
            errorMessage += "Quantidade em estoque inválida!\n";
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
