public class Pulso extends Relogio { //pulso possui tudo de relogio
    // herança (extends) é um mecanismo por meio do qual vc cria uma nova classe com base em uma classe ja existente. Isso garante segurança de dar certo e é bom para a reusabilidade
    // só se cria uma herança quando os tipos da mesma coisa tem atributos diferentes (relogio de pulso é o unico que tem pulseira)
    // se um atributo por generico (tem em todas), por exemplo, material, se colocar na classe mãe (relogio)
    // manutenção, resusabilida e segurança
    private String corPuls;
    private String matPuls;
    private int compPuls;
    private int largPuls;

    public Pulso() { 
        super(); // chama o construtor da classe mãe
        corPuls = " ";
        matPuls = " ";
        compPuls = 0;
        largPuls = 0;
    }

    public void teste() { // super: objeto que aponta para membros da classe mãe e o this aponta para metodos da mesma classe
        System.out.println("\nEstou dentro da classe Pulso (filha)\n");
        //super.teste(); // na classe mãe utilize o teste
    }

    public void setCorPuls(String corPuls) {
        this.corPuls = corPuls;
    }

    public String getCorPuls() {
        return corPuls;
    }

    public void setMatPuls(String matPuls) {
        this.matPuls = matPuls;
    }

    public String getMatPuls() {
        return matPuls;
    }

    public void setCompPuls(int compPuls) {
        this.compPuls =compPuls;
    }

    public int getCompPuls() {
        return compPuls;
    }

    public void setLargPuls(int largPuls) {
        this.largPuls =largPuls;
    }

    public int getLargPuls() {
        return largPuls;
    }
}