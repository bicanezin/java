public class PessoaFisica extends ClienteBanco {
    private int cpf;
    private String nome;

    public PessoaFisica() {
        cpf = 0;
        nome = " ";
    }

    public void setCpf (int cpf) {
        this.cpf = cpf;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void verifDoc() {
        if (cpf < 10 || cpf > 20) {
            System.out.println ("CPF inválido");
        }
    }
}