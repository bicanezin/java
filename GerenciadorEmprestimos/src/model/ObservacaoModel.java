package model;

public class ObservacaoModel {

    private int observacaoID;
    private String observacaoDescricao;
    private int emprestimoID;

    /**
     * Métodos construtores
     */
    public ObservacaoModel() {
    }

    public ObservacaoModel(String observacaoDescricao, int emprestimoID) {
        this.observacaoDescricao = observacaoDescricao;
        this.emprestimoID = emprestimoID;
    }

    /**
     * Métodos Getters/Setters
     */
    public int getObservacaoID() {
        return observacaoID;
    }

    public void setObservacaoID(int observacaoID) {
        this.observacaoID = observacaoID;
    }

    public String getObservacaoDescricao() {
        return observacaoDescricao;
    }

    public void setObservacaoDescricao(String observacaoDescricao) {
        this.observacaoDescricao = observacaoDescricao;
    }

    public int getEmprestimoID() {
        return emprestimoID;
    }

    public void setEmprestimoID(int emprestimoID) {
        this.emprestimoID = emprestimoID;
    }

    /**
     * ToString
     */
    @Override
    public String toString() {
        return getObservacaoDescricao();
    }

}
