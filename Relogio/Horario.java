public class Horario {

    private int hora;
    private int minuto;
    private Data data;

    public Horario() {
        hora = 0;
        minuto = 0;
        data = new Data();
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getHora(){
        return hora;
    }

    public int getMinuto(){
        return minuto;
    }

    public Data getData() {
        return data;
    }

}