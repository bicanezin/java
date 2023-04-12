package funeraria.model.domain;

public class Cliente {
    
    private int cli_id;
    private String cli_nome;
    private String cli_sobrenome;
    private String cli_cpf;
    private String cli_rg;
    private String cli_dtNascimento;
    private String cli_genero;
    private String cli_profissao;
    private String cli_estadoCivil;
    private String cli_email;
    private String cli_telefone;
    private String cli_rua;
    private int cli_numero;
    private String cli_bairro;
    private String cli_complemento;
    private String cli_cidade;
    private String cli_cep;    
    private String cli_uf;   
    
    public Cliente() {
    }
    
    public Cliente(int cli_id, String cli_nome, String cli_sobrenome, String cli_cpf, String cli_rg, String cli_dtNascimento, String cli_genero, 
                   String cli_profissao, String cli_estadoCivil, String cli_email, String cli_telefone, String cli_rua, int cli_numero, String cli_bairro,
                   String cli_complemento, String cli_cidade, String cli_cep, String cli_uf) {
        this.cli_id = cli_id;
        this.cli_nome = cli_nome;
        this.cli_sobrenome = cli_sobrenome;
        this.cli_cpf = cli_cpf;
        this.cli_rg = cli_rg;
        this.cli_dtNascimento = cli_dtNascimento;
        this.cli_genero = cli_genero;
        this.cli_profissao = cli_profissao;
        this.cli_estadoCivil = cli_estadoCivil;
        this.cli_email = cli_email;
        this.cli_telefone = cli_telefone;
        this.cli_rua = cli_rua;
        this.cli_numero = cli_numero;
        this.cli_bairro = cli_bairro;
        this.cli_complemento = cli_complemento;
        this.cli_cidade = cli_cidade;
        this.cli_cep = cli_cep;
        this.cli_uf = cli_uf;
    }
    
    public int getCli_id() {
        return cli_id;
    }

    public void setCli_id(int cli_id) {
        this.cli_id = cli_id;
    }

    public String getCli_nome() {
        return cli_nome;
    }

    public void setCli_nome(String cli_nome) {
        this.cli_nome = cli_nome;
    }

    public String getCli_sobrenome() {
        return cli_sobrenome;
    }

    public void setCli_sobrenome(String cli_sobrenome) {
        this.cli_sobrenome = cli_sobrenome;
    }

    public String getCli_cpf() {
        return cli_cpf;
    }

    public void setCli_cpf(String cli_cpf) {
        this.cli_cpf = cli_cpf;
    }

    public String getCli_rg() {
        return cli_rg;
    }

    public void setCli_rg(String cli_rg) {
        this.cli_rg = cli_rg;
    }

    public String getCli_dtNascimento() {
        return cli_dtNascimento;
    }

    public void setCli_dtNascimento(String cli_dtNascimento) {
        this.cli_dtNascimento = cli_dtNascimento;
    }

    public String getCli_genero() {
        return cli_genero;
    }

    public void setCli_genero(String cli_genero) {
        this.cli_genero = cli_genero;
    }

    public String getCli_profissao() {
        return cli_profissao;
    }

    public void setCli_profissao(String cli_profissao) {
        this.cli_profissao = cli_profissao;
    }

    public String getCli_estadoCivil() {
        return cli_estadoCivil;
    }

    public void setCli_estadoCivil(String cli_estadoCivil) {
        this.cli_estadoCivil = cli_estadoCivil;
    }

    public String getCli_email() {
        return cli_email;
    }

    public void setCli_email(String cli_email) {
        this.cli_email = cli_email;
    }

    public String getCli_telefone() {
        return cli_telefone;
    }

    public void setCli_telefone(String cli_telefone) {
        this.cli_telefone = cli_telefone;
    }

    public String getCli_rua() {
        return cli_rua;
    }

    public void setCli_rua(String cli_rua) {
        this.cli_rua = cli_rua;
    }

    public int getCli_numero() {
        return cli_numero;
    }

    public void setCli_numero(int cli_numero) {
        this.cli_numero = cli_numero;
    }

    public String getCli_bairro() {
        return cli_bairro;
    }

    public void setCli_bairro(String cli_bairro) {
        this.cli_bairro = cli_bairro;
    }

    public String getCli_complemento() {
        return cli_complemento;
    }

    public void setCli_complemento(String cli_complemento) {
        this.cli_complemento = cli_complemento;
    }

    public String getCli_cidade() {
        return cli_cidade;
    }

    public void setCli_cidade(String cli_cidade) {
        this.cli_cidade = cli_cidade;
    }

    public String getCli_cep() {
        return cli_cep;
    }

    public void setCli_cep(String cli_cep) {
        this.cli_cep = cli_cep;
    }

    public String getCli_uf() {
        return cli_uf;
    }

    public void setCli_uf(String cli_uf) {
        this.cli_uf = cli_uf;
    }

    @Override
    public String toString() {
        return this.cli_nome;
    }
}
