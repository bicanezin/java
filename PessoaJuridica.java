public class PessoaJuridica extends ClienteBanco {
    private int cnpj;
    private String razaoSocial;

    public PessoaJuridica() {
        cnpj = 0;
        razaoSocial = " ";
    }

    public void setCnpj (int cnpj) {
        this.cnpj = cnpj;
     }

    public void setRazaoSocial (String razaoSocial) {
        this.razaoSocial = razaoSocial;
   }

    public int getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
         return razaoSocial;
    }

    public void verifDoc() {
        if (cnpj < 50 || cnpj > 100) {
             System.out.println("CNPJ invalido");
         }
    }
}