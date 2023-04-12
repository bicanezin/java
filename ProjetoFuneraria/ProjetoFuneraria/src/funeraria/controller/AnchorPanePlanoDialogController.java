package funeraria.controller;

import funeraria.model.domain.Plano;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AnchorPanePlanoDialogController implements Initializable {
    
    @FXML
    private Label labelPlanoNome;
    @FXML
    private TextField textFieldPlanoNome;

    @FXML
    private Label labelPlanoDescricao;
    @FXML
    private TextField textFieldPlanoDescricao;

    @FXML
    private Label labelPlanoPreco;
    @FXML
    private TextField textFieldPlanoPreco;

    @FXML
    private Button buttonCancelar;
    @FXML
    private Button buttonConfirmar;
    
    private Stage dialogStage; // representa a tela 
    private boolean buttonConfirmarClicked = false; // para saber em qual botão a pessoa clicou
    private Plano plano; // onde vamos preencher os dados p/ mandar para o bd


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

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
        
        //se for plano já cadastrado seta com os campos preenchidos
        this.textFieldPlanoNome.setText(plano.getPla_nome());
        this.textFieldPlanoDescricao.setText(plano.getPla_descricao());
        this.textFieldPlanoPreco.setText(Double.toString(plano.getPla_preco()));
    }
    
    
    @FXML
    public void handleButtonCancelar() {
        dialogStage.close();
    }

    @FXML
    public void handleButtonConfirmar() {
        if (validarEntradaDeDados()){
            plano.setPla_nome(textFieldPlanoNome.getText());
            plano.setPla_descricao(textFieldPlanoDescricao.getText());
            plano.setPla_preco(Double.parseDouble(textFieldPlanoPreco.getText()));
          
            buttonConfirmarClicked = true;
            dialogStage.close();
        } 
    }
    
    private boolean validarEntradaDeDados(){
        String errorMessage = "";
        
        if (textFieldPlanoNome.getText() == null || textFieldPlanoNome.getText().length() == 0){
            errorMessage += "Nome inválido!\n";
        }
        if (textFieldPlanoDescricao.getText() == null || textFieldPlanoDescricao.getText().length() == 0){
            errorMessage += "Descrição inválida!\n";
        }
        if (textFieldPlanoPreco.getText() == null || textFieldPlanoPreco.getText().length() == 0){
            errorMessage += "Preço inválido!\n";
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
