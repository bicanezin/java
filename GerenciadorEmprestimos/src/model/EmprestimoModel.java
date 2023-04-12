package model;

public class EmprestimoModel {

    private int emprestimoID;
    private String emprestimoItem;
    private int usuarioID;

    /**
     * Métodos construtores
     */
    public EmprestimoModel() {
    }

    public EmprestimoModel(String emprestimoItem, int usuarioID) {
        this.emprestimoItem = emprestimoItem;
        this.usuarioID = usuarioID;
    }

    /**
     * Getters e Setters
     */
    public int getEmprestimoID() {
        return emprestimoID;
    }

    public void setEmprestimoID(int emprestimoId) {
        this.emprestimoID = emprestimoId;
    }

    public String getEmprestimoItem() {
        return emprestimoItem;
    }

    public void setEmprestimoItem(String emprestimoItem) {
        this.emprestimoItem = emprestimoItem;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    /**
     * ToString
     */
    @Override
    public String toString() {
        return getEmprestimoItem();
    }
}
