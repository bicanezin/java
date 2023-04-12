package funeraria.model.dao;

import funeraria.model.domain.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO {
    
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public boolean inserir(Produto produto) {
        String sql = "INSERT INTO produto(prod_nome, prod_descricao, prod_marca, prod_preco, prod_largura, prod_comprimento, prod_altura, prod_qtdEstoque) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getProd_nome());
            stmt.setString(2, produto.getProd_descricao());
            stmt.setString(3, produto.getProd_marca());
            stmt.setDouble(4, produto.getProd_preco());
            stmt.setDouble(5, produto.getProd_largura());
            stmt.setDouble(6, produto.getProd_comprimento());
            stmt.setDouble(7, produto.getProd_altura());
            stmt.setInt(8, produto.getProd_qtdEstoque());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean alterar(Produto produto) {
        String sql = "UPDATE produto SET prod_nome=?, prod_descricao=?, prod_marca=?, prod_preco=?, prod_largura=?, prod_comprimento=?, prod_altura=?, prod_qtdEstoque=? WHERE prod_id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getProd_nome());
            stmt.setString(2, produto.getProd_descricao());
            stmt.setString(3, produto.getProd_marca());
            stmt.setDouble(4, produto.getProd_preco());
            stmt.setDouble(5, produto.getProd_largura());
            stmt.setDouble(6, produto.getProd_comprimento());
            stmt.setDouble(7, produto.getProd_altura());
            stmt.setInt(8, produto.getProd_qtdEstoque());
            stmt.setInt(9, produto.getProd_id());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean remover(Produto produto) {
        String sql = "DELETE FROM produto WHERE prod_id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, produto.getProd_id());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Produto> listar() {
        String sql = "SELECT * FROM produto";
        List<Produto> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Produto produto = new Produto();
                produto.setProd_id(resultado.getInt("prod_id"));
                produto.setProd_nome(resultado.getString("prod_nome"));
                produto.setProd_descricao(resultado.getString("prod_descricao"));
                produto.setProd_marca(resultado.getString("prod_marca"));
                produto.setProd_preco(resultado.getDouble("prod_preco"));
                produto.setProd_largura(resultado.getDouble("prod_largura"));
                produto.setProd_comprimento(resultado.getDouble("prod_comprimento"));
                produto.setProd_altura(resultado.getDouble("prod_altura"));
                produto.setProd_qtdEstoque(resultado.getInt("prod_qtdEstoque"));
                retorno.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public Produto buscar(Produto produto) {
        String sql = "SELECT * FROM produto WHERE prod_id=?";
        Produto retorno = new Produto();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, produto.getProd_id());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                produto.setProd_nome(resultado.getString("prod_nome"));
                produto.setProd_descricao(resultado.getString("prod_descricao"));
                produto.setProd_marca(resultado.getString("prod_marca"));
                produto.setProd_preco(resultado.getDouble("prod_preco"));
                produto.setProd_largura(resultado.getDouble("prod_largura"));
                produto.setProd_comprimento(resultado.getDouble("prod_comprimento"));
                produto.setProd_altura(resultado.getDouble("prod_altura"));
                produto.setProd_qtdEstoque(resultado.getInt("prod_qtdEstoque"));
                retorno = produto;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
