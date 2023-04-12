package funeraria.model.domain;

import java.io.Serializable;

public class Plano implements Serializable {

    private int pla_id;
    private String pla_nome;
    private String pla_descricao;
    private double pla_preco;
    
    public Plano(){
    }
    
    public Plano(int pla_id, String pla_nome, String pla_descricao, double pla_preco) {
        this.pla_id = pla_id;
        this.pla_nome = pla_nome;
        this.pla_descricao = pla_descricao;
        this.pla_preco = pla_preco;
    }
    
    public int getPla_id() {
        return pla_id;
    }

    public void setPla_id(int pla_id) {
        this.pla_id = pla_id;
    }

    public String getPla_nome() {
        return pla_nome;
    }

    public void setPla_nome(String pla_nome) {
        this.pla_nome = pla_nome;
    }

    public String getPla_descricao() {
        return pla_descricao;
    }

    public void setPla_descricao(String pla_descricao) {
        this.pla_descricao = pla_descricao;
    }

    public double getPla_preco() {
        return pla_preco;
    }

    public void setPla_preco(double pla_preco) {
        this.pla_preco = pla_preco;
    }
    
    @Override
    public String toString() {
        return this.pla_nome;
    }
}
