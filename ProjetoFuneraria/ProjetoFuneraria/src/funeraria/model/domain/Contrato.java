package funeraria.model.domain;

import java.io.Serializable;

public class Contrato implements Serializable {
    
    private int contr_id;
    private Cliente cliente;
    private Plano plano;
    private Produto produto;
    private String contr_dataInicio;
    private String contr_dataFim;
    
    // falta construtor
    public Contrato() {
    }
    
    public int getContr_id() {
        return contr_id;
    }

    public void setContr_id(int contr_id) {
        this.contr_id = contr_id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getContr_dataInicio() {
        return contr_dataInicio;
    }

    public void setContr_dataInicio(String contr_dataInicio) {
        this.contr_dataInicio = contr_dataInicio;
    }

    public String getContr_dataFim() {
        return contr_dataFim;
    }

    public void setContr_dataFim(String contr_dataFim) {
        this.contr_dataFim = contr_dataFim;
    }
}
