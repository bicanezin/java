public abstract class Relogio {

    private Material material;
    private String modelo;
    private String marca;
    private int qteBotoes;
    private int preco;

    public Relogio() { // método construtor
        material = new Material();
        modelo = " ";
        marca = " ";
        qteBotoes = 0;
        preco = 0;
    }

    public abstract void teste();

    public Relogio (int preco) { //método construtor com argumento (isso sobrecarrega o metodo, posso sobrecarregar qualuqer método).  
        this.preco = preco;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setQteBotoes(int qteBotoes) {
        this.qteBotoes = qteBotoes;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Material getMaterial() {
        return material;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getQteBotoes() {
        return qteBotoes;
    }

    public int getPreco() {
        return preco;
    }

}