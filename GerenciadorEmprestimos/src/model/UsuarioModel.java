package model;

public class UsuarioModel {

    private int usuarioID;
    private String usuarioNome;
    private String usuarioEmail;
    private String usuarioTelefone;

    /**
     * Métodos construtores
     */
    public UsuarioModel() {
    }

    public UsuarioModel(String usuarioNome, String usuarioEmail, String usuarioTelefone) {
        this.usuarioNome = usuarioNome;
        this.usuarioEmail = usuarioEmail;
        this.usuarioTelefone = usuarioTelefone;
    }

    /**
     * Getters e Setters
     */
    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getUsuarioTelefone() {
        return usuarioTelefone;
    }

    public void setUsuarioTelefone(String usuarioTelefone) {
        this.usuarioTelefone = usuarioTelefone;
    }

    /**
     * ToString
     */
    @Override
    public String toString() {
        return getUsuarioNome();
    }
}
