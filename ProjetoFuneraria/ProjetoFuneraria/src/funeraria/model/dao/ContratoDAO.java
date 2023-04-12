package funeraria.model.dao;

import funeraria.model.domain.Cliente;
import funeraria.model.domain.Contrato;
import funeraria.model.domain.Plano;
import funeraria.model.domain.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContratoDAO {
    
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public boolean inserir(Contrato contrato) {
        String sql = "INSERT INTO contrato(cli_id, pla_id, prod_id, contr_dataInicio, contr_dataFim) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, contrato.getCliente().getCli_id());
            stmt.setInt(2, contrato.getPlano().getPla_id());
            stmt.setInt(3, contrato.getProduto().getProd_id());
            stmt.setString(4, contrato.getContr_dataInicio());
            stmt.setString(5, contrato.getContr_dataFim());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean alterar(Contrato contrato) {
        String sql = "UPDATE contrato SET cli_id=?, pla_id=?, prod_id=?, contr_dataInicio=?, contr_dataFim=? WHERE contr_id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, contrato.getCliente().getCli_id());
            stmt.setInt(2, contrato.getPlano().getPla_id());
            stmt.setInt(3, contrato.getProduto().getProd_id());
            stmt.setString(4, contrato.getContr_dataInicio());
            stmt.setString(5, contrato.getContr_dataFim());
            stmt.setInt(6, contrato.getContr_id());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean remover(Contrato contrato) {
        String sql = "DELETE FROM contrato WHERE contr_id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, contrato.getContr_id());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     
    public List<Contrato> listar() {
        String sql = "SELECT * FROM contrato";
        List<Contrato> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                
                Contrato contrato = new Contrato();
                Cliente cliente = new Cliente();
                Plano plano = new Plano();
                Produto produto = new Produto();
 
                contrato.setContr_id(resultado.getInt("contr_id"));
                cliente.setCli_id(resultado.getInt("cli_id"));
                plano.setPla_id(resultado.getInt("pla_id"));
                produto.setProd_id(resultado.getInt("prod_id"));
                contrato.setContr_dataInicio(resultado.getString("contr_dataInicio"));
                contrato.setContr_dataFim(resultado.getString("contr_dataFim"));
                
                //Obtendo os dados completos do Cliente
                ClienteDAO clienteDAO = new ClienteDAO();
                clienteDAO.setConnection(connection);
                cliente = clienteDAO.buscar(cliente);
                
                //Obtendo os dados completos do Plano
                PlanoDAO planoDAO = new PlanoDAO();
                planoDAO.setConnection(connection);
                plano = planoDAO.buscar(plano);
                
                //Obtendo os dados completos do Produto
                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.setConnection(connection);
                produto = produtoDAO.buscar(produto);       
 
                contrato.setCliente(cliente);
                contrato.setPlano(plano);
                contrato.setProduto(produto);                
                
                retorno.add(contrato);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public List<Contrato> listarPorCliente(Cliente cliente) {
        String sql = "SELECT * FROM contrato WHERE cli_id=?";
        List<Contrato> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cliente.getCli_id());
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Contrato contrato = new Contrato();
                Plano plano = new Plano();
                Produto produto = new Produto();
                
                contrato.setContr_id(resultado.getInt("contr_id"));
                cliente.setCli_id(resultado.getInt("cli_id"));
                plano.setPla_id(resultado.getInt("pla_id"));
                produto.setProd_id(resultado.getInt("prod_id"));
                contrato.setContr_dataInicio(resultado.getString("contr_dataInicio"));
                contrato.setContr_dataFim(resultado.getString("contr_dataFim"));
                
                //Obtendo os dados completos do Plano
                PlanoDAO planoDAO = new PlanoDAO();
                planoDAO.setConnection(connection);
                plano = planoDAO.buscar(plano);
                
                //Obtendo os dados completos do Produto
                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.setConnection(connection);
                produto = produtoDAO.buscar(produto);       
 
                contrato.setCliente(cliente);
                contrato.setPlano(plano);
                contrato.setProduto(produto);                
                
                retorno.add(contrato);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public Contrato buscar(Contrato contrato) {
        String sql = "SELECT * FROM contrato WHERE contr_id=?";
        Contrato retorno = new Contrato();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, contrato.getContr_id());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                
                Cliente cliente = new Cliente();
                Plano plano = new Plano();
                Produto produto = new Produto();
 
                contrato.setContr_id(resultado.getInt("contr_id"));
                cliente.setCli_id(resultado.getInt("cli_id"));
                plano.setPla_id(resultado.getInt("pla_id"));
                produto.setProd_id(resultado.getInt("prod_id"));
                contrato.setContr_dataInicio(resultado.getString("contr_dataInicio"));
                contrato.setContr_dataFim(resultado.getString("contr_dataFim"));
                
                //Obtendo os dados completos do Cliente
                ClienteDAO clienteDAO = new ClienteDAO();
                clienteDAO.setConnection(connection);
                cliente = clienteDAO.buscar(cliente);
                
                //Obtendo os dados completos do Plano
                PlanoDAO planoDAO = new PlanoDAO();
                planoDAO.setConnection(connection);
                plano = planoDAO.buscar(plano);
                
                //Obtendo os dados completos do Produto
                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.setConnection(connection);
                produto = produtoDAO.buscar(produto);       
 
                contrato.setCliente(cliente);
                contrato.setPlano(plano);
                contrato.setProduto(produto); 
                
                retorno = contrato;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContratoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
