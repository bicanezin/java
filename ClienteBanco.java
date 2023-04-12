public abstract class ClienteBanco {
    private int numeroConta;
    private float saldo;

    public ClienteBanco() {
        numeroConta = 0;
        saldo = 0;
    }

    public abstract void verifDoc(); // só posso ter método abstrato dentro de classe abstrata

    public void setNumeroConta (int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void saldo (float saldo) {
        this.saldo = saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public float getSaldo() {
        return saldo;
    }
}