package funeraria.model.dao;

import funeraria.model.domain.Plano;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlanoDAO {
    
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public boolean inserir(Plano plano) {
        String sql = "INSERT INTO plano(pla_nome, pla_descricao, pla_preco) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, plano.getPla_nome());
            stmt.setString(2, plano.getPla_descricao());
            stmt.setDouble(3, plano.getPla_preco());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PlanoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean alterar(Plano plano) {
        String sql = "UPDATE plano SET pla_nome=?, pla_descricao=?, pla_preco=? WHERE pla_id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, plano.getPla_nome());
            stmt.setString(2, plano.getPla_descricao());
            stmt.setDouble(3, plano.getPla_preco());
            stmt.setInt(4, plano.getPla_id());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PlanoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean remover(Plano plano) {
        String sql = "DELETE FROM plano WHERE pla_id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, plano.getPla_id());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PlanoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Plano> listar() {
        String sql = "SELECT * FROM plano";
        List<Plano> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Plano plano = new Plano();
                plano.setPla_id(resultado.getInt("pla_id"));
                plano.setPla_nome(resultado.getString("pla_nome"));
                plano.setPla_descricao(resultado.getString("pla_descricao"));
                plano.setPla_preco(resultado.getDouble("pla_preco"));
                retorno.add(plano);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlanoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public Plano buscar(Plano plano) {
        String sql = "SELECT * FROM plano WHERE pla_id=?";
        Plano retorno = new Plano();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, plano.getPla_id());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                plano.setPla_nome(resultado.getString("pla_nome"));
                plano.setPla_descricao(resultado.getString("pla_descricao"));
                plano.setPla_preco(resultado.getDouble("pla_preco"));
                retorno = plano;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlanoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
