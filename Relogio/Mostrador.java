public class Mostrador {

    private String mostrador;
    private Horario horario;

    public Mostrador() {
        mostrador = " ";
        horario = new Horario();
    }

    public void setMostrador(String mostrador) { // public void setMostrador(String mostrador) é a assinatura do método
        this.mostrador = mostrador;
    }

    public String getMostrador () {
        return mostrador;
    }

    public Horario getHorario() {
        return horario;
    }

}