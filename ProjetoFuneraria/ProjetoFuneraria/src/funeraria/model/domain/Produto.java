package funeraria.model.domain;

import java.io.Serializable;

public class Produto implements Serializable {

    private int prod_id;
    private String prod_nome;
    private String prod_descricao;
    private String prod_marca;
    private double prod_preco;
    private double prod_largura;
    private double prod_comprimento;
    private double prod_altura;
    private int prod_qtdEstoque;
    
    public Produto(){
    }
    
    public Produto(int prod_id, String prod_nome, String prod_descricao, String prod_marca, double prod_preco, double prod_largura, double prod_comprimento, double prod_altura, int prod_qtdEstoque) {
        this.prod_id = prod_id;
        this.prod_nome = prod_nome;
        this.prod_descricao = prod_descricao;
        this.prod_marca = prod_marca;
        this.prod_preco = prod_preco;
        this.prod_largura = prod_largura;
        this.prod_comprimento = prod_comprimento;
        this.prod_altura = prod_altura;
        this.prod_qtdEstoque = prod_qtdEstoque;
    }
    
    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_nome() {
        return prod_nome;
    }

    public void setProd_nome(String prod_nome) {
        this.prod_nome = prod_nome;
    }

    public String getProd_descricao() {
        return prod_descricao;
    }

    public void setProd_descricao(String prod_descricao) {
        this.prod_descricao = prod_descricao;
    }

    public String getProd_marca() {
        return prod_marca;
    }

    public void setProd_marca(String prod_marca) {
        this.prod_marca = prod_marca;
    }

    public double getProd_preco() {
        return prod_preco;
    }

    public void setProd_preco(double prod_preco) {
        this.prod_preco = prod_preco;
    }

    public double getProd_largura() {
        return prod_largura;
    }

    public void setProd_largura(double prod_largura) {
        this.prod_largura = prod_largura;
    }

    public double getProd_comprimento() {
        return prod_comprimento;
    }

    public void setProd_comprimento(double prod_comprimento) {
        this.prod_comprimento = prod_comprimento;
    }

    public double getProd_altura() {
        return prod_altura;
    }

    public void setProd_altura(double prod_altura) {
        this.prod_altura = prod_altura;
    }

    public int getProd_qtdEstoque() {
        return prod_qtdEstoque;
    }

    public void setProd_qtdEstoque(int prod_qtdEstoque) {
        this.prod_qtdEstoque = prod_qtdEstoque;
    }
    
    @Override
    public String toString() {
        return this.prod_nome;
    }
}
