package funeraria.controller;

import funeraria.model.domain.Falecido;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AnchorPaneFalecidoDialogController implements Initializable {
    
    @FXML
    private Button buttonCancelar;
    @FXML
    private Button buttonConfirmar;

    @FXML
    private Label labelFalecidoNome;
    @FXML
    private TextField textFieldFalecidoNome;

    @FXML
    private Label labelFalecidoSobrenome;
    @FXML
    private TextField textFieldFalecidoSobrenome;

    @FXML
    private Label labelFalecidoCPF;
    @FXML
    private TextField textFieldFalecidoCPF;

    @FXML
    private Label labelFalecidoRG;
    @FXML
    private TextField textFieldFalecidoRG;

    @FXML
    private Label labelFalecidoEstadoCivil;
    @FXML
    private TextField textFieldFalecidoEstadoCivil;

    @FXML
    private Label labelFalecidoNumMatricula;
    @FXML
    private TextField textFieldFalecidoNumMatricula;

    @FXML
    private Label labelFalecidoDataNasc;
    @FXML
    private TextField textFieldFalecidoDataNasc;

    @FXML
    private Label labelFalecidoDataFalec;
    @FXML
    private TextField textFieldFalecidoDataFalec;

    @FXML
    private Label labelFalecidoCausaMortis;
    @FXML
    private TextField textFieldFalecidoCausaMortis;

    @FXML
    private Label labelFalecidoCidade;
    @FXML
    private TextField textFieldFalecidoCidade;

    private Stage dialogStage; // representa a tela 
    private boolean buttonConfirmarClicked = false; // para saber em qual botão a pessoa clicou
    private Falecido falecido; // onde vamos preencher os dados p/ mandar para o bd
    
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

    public Falecido getFalecido() {
        return falecido;
    }

    public void setFalecido(Falecido falecido) {
        this.falecido = falecido;
        
        //se for falecido já cadastrado seta com os campos preenchidos
        this.textFieldFalecidoNome.setText(falecido.getFal_nome());
        this.textFieldFalecidoSobrenome.setText(falecido.getFal_sobrenome());
        this.textFieldFalecidoCPF.setText(falecido.getFal_cpf());
        this.textFieldFalecidoRG.setText(falecido.getFal_rg());
        this.textFieldFalecidoEstadoCivil.setText(falecido.getFal_estadoCivil());
        this.textFieldFalecidoNumMatricula.setText(falecido.getFal_matriculaCertidaoObito());
        this.textFieldFalecidoDataNasc.setText(falecido.getFal_dataNasc());
        this.textFieldFalecidoDataFalec.setText(falecido.getFal_dataFalec());
        this.textFieldFalecidoCausaMortis.setText(falecido.getFal_causaMorte());
        this.textFieldFalecidoCidade.setText(falecido.getFal_cidadeFalec());
    }
    
    
    @FXML
    public void handleButtonCancelar() {
        dialogStage.close();
    }

    @FXML
    public void handleButtonConfirmar() {
        if (validarEntradaDeDados()){
            falecido.setFal_nome(textFieldFalecidoNome.getText());
            falecido.setFal_sobrenome(textFieldFalecidoSobrenome.getText());
            falecido.setFal_cpf(textFieldFalecidoCPF.getText());
            falecido.setFal_rg(textFieldFalecidoRG.getText());
            falecido.setFal_estadoCivil(textFieldFalecidoEstadoCivil.getText());
            falecido.setFal_matriculaCertidaoObito(textFieldFalecidoNumMatricula.getText());
            falecido.setFal_dataNasc(textFieldFalecidoDataNasc.getText());
            falecido.setFal_dataFalec(textFieldFalecidoDataFalec.getText());
            falecido.setFal_causaMorte(textFieldFalecidoCausaMortis.getText());
            falecido.setFal_cidadeFalec(textFieldFalecidoCidade.getText()); 
            
            buttonConfirmarClicked = true;
            dialogStage.close();
        }   
    }
    
    private boolean validarEntradaDeDados(){
        String errorMessage = "";
        
        if (textFieldFalecidoNome.getText() == null || textFieldFalecidoNome.getText().length() == 0){
            errorMessage += "Nome inválido!\n";
        }
        if (textFieldFalecidoSobrenome.getText() == null || textFieldFalecidoSobrenome.getText().length() == 0){
            errorMessage += "Sobrenome inválido!\n";
        }
        if (textFieldFalecidoCPF.getText() == null || textFieldFalecidoCPF.getText().length() == 0){
            errorMessage += "CPF inválido!\n";
        }
        if (textFieldFalecidoRG.getText() == null || textFieldFalecidoRG.getText().length() == 0){
            errorMessage += "RG inválido!\n";
        }
        if (textFieldFalecidoDataNasc.getText() == null || textFieldFalecidoDataNasc.getText().length() == 0){
            errorMessage += "Data de nascimento inválida!\n";
        }
        if (textFieldFalecidoNumMatricula.getText() == null || textFieldFalecidoNumMatricula.getText().length() == 0){
            errorMessage += "Número de matrícula inválido!\n";
        }
        if (textFieldFalecidoDataFalec.getText() == null || textFieldFalecidoDataFalec.getText().length() == 0){
            errorMessage += "Data de falecimento inválida!\n";
        }
        if (textFieldFalecidoEstadoCivil.getText() == null || textFieldFalecidoEstadoCivil.getText().length() == 0){
            errorMessage += "Estado civil inválido!\n";
        }
        if (textFieldFalecidoCausaMortis.getText() == null || textFieldFalecidoCausaMortis.getText().length() == 0){
            errorMessage += "Causa mortis inválida!\n";
        }
        if (textFieldFalecidoCidade.getText() == null || textFieldFalecidoCidade.getText().length() == 0){
            errorMessage += "Cidade inválida!\n";
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
