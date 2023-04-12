public class Pais {

    private String nome;
    private int codPais;

    public Pais() {
        nome = " ";
        codPais = 0;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodPais(int codPais) {
        this.codPais = codPais;
    }

    public String getNome () {
        return nome;
    }

    public int getCodPais () {
        return codPais;
    }
}