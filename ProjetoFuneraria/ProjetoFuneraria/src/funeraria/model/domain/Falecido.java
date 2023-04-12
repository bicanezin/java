package funeraria.model.domain;

import java.io.Serializable;

public class Falecido implements Serializable {
  
    private int fal_id;
    private String fal_nome;
    private String fal_sobrenome;
    private String fal_cpf;
    private String fal_matriculaCertidaoObito;
    private String fal_rg;
    private String fal_dataNasc;
    private String fal_dataFalec;
    private String fal_causaMorte;
    private String fal_estadoCivil;
    private String fal_cidadeFalec;
    private Contrato contrato;
    
    public Falecido() {
    }

    public Falecido(int fal_id, String fal_nome, String fal_sobrenome, String fal_cpf, String fal_matriculaCertidaoObito, String fal_rg, String fal_dataNasc, String fal_dataFalec, String fal_causaMorte, String fal_estadoCivil, String fal_cidadeFalec) {
        this.fal_id = fal_id;
        this.fal_nome = fal_nome;
        this.fal_sobrenome = fal_sobrenome;
        this.fal_cpf = fal_cpf;
        this.fal_matriculaCertidaoObito = fal_matriculaCertidaoObito;
        this.fal_rg = fal_rg;
        this.fal_dataNasc = fal_dataNasc;
        this.fal_dataFalec = fal_dataFalec;
        this.fal_causaMorte = fal_causaMorte;
        this.fal_estadoCivil = fal_estadoCivil;
        this.fal_cidadeFalec = fal_cidadeFalec;
    }
    
    public int getFal_id() {
        return fal_id;
    }

    public void setFal_id(int fal_id) {
        this.fal_id = fal_id;
    }

    public String getFal_nome() {
        return fal_nome;
    }

    public void setFal_nome(String fal_nome) {
        this.fal_nome = fal_nome;
    }

    public String getFal_sobrenome() {
        return fal_sobrenome;
    }

    public void setFal_sobrenome(String fal_sobrenome) {
        this.fal_sobrenome = fal_sobrenome;
    }

    public String getFal_cpf() {
        return fal_cpf;
    }

    public void setFal_cpf(String fal_cpf) {
        this.fal_cpf = fal_cpf;
    }

    public String getFal_matriculaCertidaoObito() {
        return fal_matriculaCertidaoObito;
    }

    public void setFal_matriculaCertidaoObito(String fal_matriculaCertidaoObito) {
        this.fal_matriculaCertidaoObito = fal_matriculaCertidaoObito;
    }

    public String getFal_rg() {
        return fal_rg;
    }

    public void setFal_rg(String fal_rg) {
        this.fal_rg = fal_rg;
    }

    public String getFal_dataNasc() {
        return fal_dataNasc;
    }

    public void setFal_dataNasc(String fal_dataNasc) {
        this.fal_dataNasc = fal_dataNasc;
    }

    public String getFal_dataFalec() {
        return fal_dataFalec;
    }

    public void setFal_dataFalec(String fal_dataFalec) {
        this.fal_dataFalec = fal_dataFalec;
    }

    public String getFal_causaMorte() {
        return fal_causaMorte;
    }

    public void setFal_causaMorte(String fal_causaMorte) {
        this.fal_causaMorte = fal_causaMorte;
    }

    public String getFal_estadoCivil() {
        return fal_estadoCivil;
    }

    public void setFal_estadoCivil(String fal_estadoCivil) {
        this.fal_estadoCivil = fal_estadoCivil;
    }

    public String getFal_cidadeFalec() {
        return fal_cidadeFalec;
    }

    public void setFal_cidadeFalec(String fal_cidadeFalec) {
        this.fal_cidadeFalec = fal_cidadeFalec;
    }
    
    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
    
    @Override
    public String toString() {
        return this.fal_nome;
    }
}
