package funeraria.controller;

import funeraria.model.domain.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AnchorPaneClienteDialogController implements Initializable {

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
    private Label labelClienteEndereco;
    @FXML
    private Label labelClienteNumero;
    @FXML
    private Label labelClienteTelefone;
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
    
    @FXML
    private TextField textFieldClienteNome;
    @FXML
    private TextField textFieldClienteSobrenome;
    @FXML
    private TextField textFieldClienteCPF;
    @FXML
    private TextField textFieldClienteRG;
    @FXML
    private TextField textFieldClienteDataNasc;
    @FXML
    private TextField textFieldClienteGenero;
    @FXML
    private TextField textFieldClienteProfissao;
    @FXML
    private TextField textFieldClienteEstadoCivil;
    @FXML
    private TextField textFieldClienteEmail;
    @FXML
    private TextField textFieldClienteTelefone;
    @FXML
    private TextField textFieldClienteEndereco;
    @FXML
    private TextField textFieldClienteNumero;
    @FXML
    private TextField textFieldClienteComplemento;
    @FXML
    private TextField textFieldClienteBairro;
    @FXML
    private TextField textFieldClienteCEP;
    @FXML
    private TextField textFieldClienteEstado;
    @FXML
    private TextField textFieldClienteCidade;
    
    @FXML
    private Button buttonCancelar;
    @FXML
    private Button buttonConfirmar;
    
    
    private Stage dialogStage; // representa a tela 
    private boolean buttonConfirmarClicked = false; // para saber em qual botão a pessoa clicou
    private Cliente cliente; // onde vamos preencher os dados p/ mandar para o bd

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        //se for cliente já cadastrado seta com os campos preenchidos
        this.textFieldClienteNome.setText(cliente.getCli_nome());
        this.textFieldClienteSobrenome.setText(cliente.getCli_sobrenome());
        this.textFieldClienteCPF.setText(cliente.getCli_cpf());
        this.textFieldClienteRG.setText(cliente.getCli_rg());
        this.textFieldClienteDataNasc.setText(cliente.getCli_dtNascimento());
        this.textFieldClienteGenero.setText(cliente.getCli_genero());
        this.textFieldClienteProfissao.setText(cliente.getCli_profissao());
        this.textFieldClienteEstadoCivil.setText(cliente.getCli_estadoCivil());
        this.textFieldClienteEmail.setText(cliente.getCli_email());
        this.textFieldClienteTelefone.setText(cliente.getCli_telefone());
        this.textFieldClienteEndereco.setText(cliente.getCli_rua());
        this.textFieldClienteNumero.setText(Integer.toString(cliente.getCli_numero()));
        this.textFieldClienteComplemento.setText(cliente.getCli_complemento());
        this.textFieldClienteBairro.setText(cliente.getCli_bairro());
        this.textFieldClienteCEP.setText(cliente.getCli_cep());
        this.textFieldClienteEstado.setText(cliente.getCli_uf());
        this.textFieldClienteCidade.setText(cliente.getCli_cidade());
        
    }
    
    @FXML
    public void handleButtonConfirmar(){
        
        if (validarEntradaDeDados()){
            cliente.setCli_nome(textFieldClienteNome.getText());
            cliente.setCli_sobrenome(textFieldClienteSobrenome.getText());
            cliente.setCli_dtNascimento(textFieldClienteDataNasc.getText());
            cliente.setCli_cpf(textFieldClienteCPF.getText());
            cliente.setCli_rg(textFieldClienteRG.getText());
            cliente.setCli_genero(textFieldClienteGenero.getText());
            cliente.setCli_profissao(textFieldClienteProfissao.getText());
            cliente.setCli_estadoCivil(textFieldClienteEstadoCivil.getText());
            cliente.setCli_email(textFieldClienteEmail.getText());
            cliente.setCli_telefone(textFieldClienteTelefone.getText());
            cliente.setCli_rua(textFieldClienteEndereco.getText());
            cliente.setCli_numero(Integer.parseInt(textFieldClienteNumero.getText()));
            cliente.setCli_complemento(textFieldClienteComplemento.getText());
            cliente.setCli_bairro(textFieldClienteBairro.getText());
            cliente.setCli_cep(textFieldClienteCEP.getText());
            cliente.setCli_uf(textFieldClienteEstado.getText());
            cliente.setCli_cidade(textFieldClienteCidade.getText());
            

            buttonConfirmarClicked = true;
            dialogStage.close();
        }
    }  
    
    public void handleButtonCancelar(){
        dialogStage.close();
    }
    
    private boolean validarEntradaDeDados(){
        String errorMessage = "";
        
        if (textFieldClienteNome.getText() == null || textFieldClienteNome.getText().length() == 0){
            errorMessage += "Nome inválido!\n";
        }
        if (textFieldClienteSobrenome.getText() == null || textFieldClienteSobrenome.getText().length() == 0){
            errorMessage += "Sobrenome inválido!\n";
        }
        if (textFieldClienteCPF.getText() == null || textFieldClienteCPF.getText().length() == 0){
            errorMessage += "CPF inválido!\n";
        }
        if (textFieldClienteRG.getText() == null || textFieldClienteRG.getText().length() == 0){
            errorMessage += "RG inválido!\n";
        }
        if (textFieldClienteDataNasc.getText() == null || textFieldClienteDataNasc.getText().length() == 0){
            errorMessage += "Data de nascimento inválida!\n";
        }
        if (textFieldClienteGenero.getText() == null || textFieldClienteGenero.getText().length() == 0){
            errorMessage += "Gênero inválido!\n";
        }
        if (textFieldClienteProfissao.getText() == null || textFieldClienteProfissao.getText().length() == 0){
            errorMessage += "Profissão inválida!\n";
        }
        if (textFieldClienteEstadoCivil.getText() == null || textFieldClienteEstadoCivil.getText().length() == 0){
            errorMessage += "Estado civil inválido!\n";
        }
        if (textFieldClienteEmail.getText() == null || textFieldClienteEmail.getText().length() == 0){
            errorMessage += "Email inválido!\n";
        }
        if (textFieldClienteTelefone.getText() == null || textFieldClienteTelefone.getText().length() == 0){
            errorMessage += "Telefone inválido!\n";
        }
        if (textFieldClienteEndereco.getText() == null || textFieldClienteEndereco.getText().length() == 0){
            errorMessage += "Rua inválida!\n";
        }
        if (textFieldClienteNumero.getText() == null || textFieldClienteNumero.getText().length() == 0){
            errorMessage += "Número inválido inválido!\n";
        }
        if (textFieldClienteBairro.getText() == null || textFieldClienteBairro.getText().length() == 0){
            errorMessage += "Bairro inválido!\n";
        }
        if (textFieldClienteCEP.getText() == null || textFieldClienteCEP.getText().length() == 0){
            errorMessage += "CEP inválido!\n";
        }
        if (textFieldClienteEstado.getText() == null || textFieldClienteEstado.getText().length() == 0){
            errorMessage += "Estado inválido!\n";
        }
        if (textFieldClienteCidade.getText() == null || textFieldClienteCidade.getText().length() == 0){
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
