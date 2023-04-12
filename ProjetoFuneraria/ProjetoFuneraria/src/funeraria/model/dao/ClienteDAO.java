package funeraria.model.dao;

import funeraria.model.domain.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {
    
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public boolean inserir(Cliente cliente) {
        String sql = "INSERT INTO cliente(cli_nome, cli_sobrenome, cli_cpf, cli_rg, cli_dtNascimento, cli_genero, cli_profissao, cli_estadoCivil, cli_email, cli_telefone, cli_rua, cli_numero, cli_bairro, cli_complemento, cli_cidade, cli_cep, cli_uf) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getCli_nome());
            stmt.setString(2, cliente.getCli_sobrenome());
            stmt.setString(3, cliente.getCli_cpf());
            stmt.setString(4, cliente.getCli_rg());
            stmt.setString(5, cliente.getCli_dtNascimento());
            stmt.setString(6, cliente.getCli_genero());
            stmt.setString(7, cliente.getCli_profissao());
            stmt.setString(8, cliente.getCli_estadoCivil());
            stmt.setString(9, cliente.getCli_email());
            stmt.setString(10, cliente.getCli_telefone());
            stmt.setString(11, cliente.getCli_rua());
            stmt.setInt(12, cliente.getCli_numero());
            stmt.setString(13, cliente.getCli_bairro());
            stmt.setString(14, cliente.getCli_complemento());
            stmt.setString(15, cliente.getCli_cidade());
            stmt.setString(16, cliente.getCli_cep());
            stmt.setString(17, cliente.getCli_uf());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean alterar(Cliente cliente) {
        String sql = "UPDATE cliente SET cli_nome=?, cli_sobrenome=?, cli_cpf=?, cli_rg=?, cli_dtNascimento=?, cli_genero=?, cli_profissao=?, cli_estadoCivil=?, cli_email=?, cli_telefone=?, cli_rua=?, cli_numero=?, cli_bairro=?, cli_complemento=?, cli_cidade=?, cli_cep=?, cli_uf=? WHERE cli_id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getCli_nome());
            stmt.setString(2, cliente.getCli_sobrenome());
            stmt.setString(3, cliente.getCli_cpf());
            stmt.setString(4, cliente.getCli_rg());
            stmt.setString(5, cliente.getCli_dtNascimento());
            stmt.setString(6, cliente.getCli_genero());
            stmt.setString(7, cliente.getCli_profissao());
            stmt.setString(8, cliente.getCli_estadoCivil());
            stmt.setString(9, cliente.getCli_email());
            stmt.setString(10, cliente.getCli_telefone());
            stmt.setString(11, cliente.getCli_rua());
            stmt.setInt(12, cliente.getCli_numero());
            stmt.setString(13, cliente.getCli_bairro());
            stmt.setString(14, cliente.getCli_complemento());
            stmt.setString(15, cliente.getCli_cidade());
            stmt.setString(16, cliente.getCli_cep());
            stmt.setString(17, cliente.getCli_uf());
            stmt.setInt(18, cliente.getCli_id());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean remover(Cliente cliente) {
        String sql = "DELETE FROM cliente WHERE cli_id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cliente.getCli_id());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Cliente> listar() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                
                cliente.setCli_id(resultado.getInt("cli_id"));
                cliente.setCli_nome(resultado.getString("cli_nome"));
                cliente.setCli_sobrenome(resultado.getString("cli_sobrenome"));
                cliente.setCli_cpf(resultado.getString("cli_cpf"));
                cliente.setCli_rg(resultado.getString("cli_rg"));
                cliente.setCli_dtNascimento(resultado.getString("cli_dtNascimento"));
                cliente.setCli_genero(resultado.getString("cli_genero"));
                cliente.setCli_profissao(resultado.getString("cli_profissao"));
                cliente.setCli_estadoCivil(resultado.getString("cli_estadoCivil"));
                cliente.setCli_email(resultado.getString("cli_email"));
                cliente.setCli_telefone(resultado.getString("cli_telefone"));
                cliente.setCli_rua(resultado.getString("cli_rua"));
                cliente.setCli_numero(resultado.getInt("cli_numero"));
                cliente.setCli_bairro(resultado.getString("cli_bairro"));
                cliente.setCli_complemento(resultado.getString("cli_complemento"));
                cliente.setCli_cidade(resultado.getString("cli_cidade"));
                cliente.setCli_cep(resultado.getString("cli_cep"));
                cliente.setCli_uf(resultado.getString("cli_uf"));
                
                retorno.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public Cliente buscar(Cliente cliente) {
        String sql = "SELECT * FROM cliente WHERE cli_id=?";
        Cliente retorno = new Cliente();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cliente.getCli_id());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                cliente.setCli_nome(resultado.getString("cli_nome"));
                cliente.setCli_sobrenome(resultado.getString("cli_sobrenome"));
                cliente.setCli_cpf(resultado.getString("cli_cpf"));
                cliente.setCli_rg(resultado.getString("cli_rg"));
                cliente.setCli_dtNascimento(resultado.getString("cli_dtNascimento"));
                cliente.setCli_genero(resultado.getString("cli_genero"));
                cliente.setCli_profissao(resultado.getString("cli_profissao"));
                cliente.setCli_estadoCivil(resultado.getString("cli_estadoCivil"));
                cliente.setCli_email(resultado.getString("cli_email"));
                cliente.setCli_telefone(resultado.getString("cli_telefone"));
                cliente.setCli_rua(resultado.getString("cli_rua"));
                cliente.setCli_numero(resultado.getInt("cli_numero"));
                cliente.setCli_bairro(resultado.getString("cli_bairro"));
                cliente.setCli_complemento(resultado.getString("cli_complemento"));
                cliente.setCli_cidade(resultado.getString("cli_cidade"));
                cliente.setCli_cep(resultado.getString("cli_cep"));
                cliente.setCli_uf(resultado.getString("cli_uf"));
                retorno = cliente;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
