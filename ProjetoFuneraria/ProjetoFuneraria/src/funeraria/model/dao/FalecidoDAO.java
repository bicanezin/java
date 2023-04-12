package funeraria.model.dao;

import funeraria.model.domain.Contrato;
import funeraria.model.domain.Falecido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FalecidoDAO {
    
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public boolean inserir(Falecido falecido) {
        String sql = "INSERT INTO falecido(fal_nome, fal_sobrenome, fal_cpf, fal_matriculaCertidaoObito, fal_rg, fal_dataNasc, fal_dataFalec, fal_causaMorte, fal_estadoCivil, fal_cidadeFalec, contr_id) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, falecido.getFal_nome());
            stmt.setString(2, falecido.getFal_sobrenome());
            stmt.setString(3, falecido.getFal_cpf());
            stmt.setString(4, falecido.getFal_matriculaCertidaoObito());
            stmt.setString(5, falecido.getFal_rg());
            stmt.setString(6, falecido.getFal_dataNasc());
            stmt.setString(7, falecido.getFal_dataFalec());
            stmt.setString(8, falecido.getFal_causaMorte());
            stmt.setString(9, falecido.getFal_estadoCivil());
            stmt.setString(10, falecido.getFal_cidadeFalec());
            stmt.setInt(11, falecido.getContrato().getContr_id());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FalecidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean alterar(Falecido falecido) {
        String sql = "UPDATE falecido SET fal_nome=?, fal_sobrenome=?, fal_cpf=?, fal_matriculaCertidaoObito=?, fal_rg=?, fal_dataNasc=?, fal_dataFalec=?, fal_causaMorte=?, fal_estadoCivil=?, fal_cidadeFalec=?, contr_id=? WHERE fal_id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, falecido.getFal_nome());
            stmt.setString(2, falecido.getFal_sobrenome());
            stmt.setString(3, falecido.getFal_cpf());
            stmt.setString(4, falecido.getFal_matriculaCertidaoObito());
            stmt.setString(5, falecido.getFal_rg());
            stmt.setString(6, falecido.getFal_dataNasc());
            stmt.setString(7, falecido.getFal_dataFalec());
            stmt.setString(8, falecido.getFal_causaMorte());
            stmt.setString(9, falecido.getFal_estadoCivil());
            stmt.setString(10, falecido.getFal_cidadeFalec());
            stmt.setInt(11, falecido.getContrato().getContr_id());
            stmt.setInt(12, falecido.getFal_id());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FalecidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean remover(Falecido falecido) {
        String sql = "DELETE FROM falecido WHERE fal_id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, falecido.getFal_id());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FalecidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Falecido> listar() {
        String sql = "SELECT * FROM falecido";
        List<Falecido> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Falecido falecido = new Falecido();
                Contrato contrato = new Contrato();
                
                falecido.setFal_id(resultado.getInt("fal_id"));
                falecido.setFal_nome(resultado.getString("fal_nome"));
                falecido.setFal_sobrenome(resultado.getString("fal_sobremome"));
                falecido.setFal_cpf(resultado.getString("fal_cpf"));
                falecido.setFal_matriculaCertidaoObito(resultado.getString("fal_matriculaCertidaoObito"));
                falecido.setFal_rg(resultado.getString("fal_rg"));
                falecido.setFal_dataNasc(resultado.getString("fal_dataNasc"));
                falecido.setFal_dataFalec(resultado.getString("fal_dataFalec"));
                falecido.setFal_causaMorte(resultado.getString("fal_causaMorte"));
                falecido.setFal_estadoCivil(resultado.getString("fal_estadoCivil"));
                falecido.setFal_cidadeFalec(resultado.getString("fal_cidadeFalec"));
                contrato.setContr_id(resultado.getInt("contr_id"));

                //Obtendo os dados completos do Contrato associado ao Falecido
                ContratoDAO contratoDAO = new ContratoDAO();
                contratoDAO.setConnection(connection);
                contrato = contratoDAO.buscar(contrato);

                falecido.setContrato(contrato);
                retorno.add(falecido);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FalecidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public Falecido buscar(Falecido falecido) {
        String sql = "SELECT * FROM falecido WHERE fal_id=?";
        Falecido retorno = new Falecido();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, falecido.getFal_id());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                Contrato contrato = new Contrato();
                falecido.setFal_id(resultado.getInt("fal_id"));
                falecido.setFal_nome(resultado.getString("fal_nome"));
                falecido.setFal_sobrenome(resultado.getString("fal_sobremome"));
                falecido.setFal_cpf(resultado.getString("fal_cpf"));
                falecido.setFal_matriculaCertidaoObito(resultado.getString("fal_matriculaCertidaoObito"));
                falecido.setFal_rg(resultado.getString("fal_rg"));
                falecido.setFal_dataNasc(resultado.getString("fal_dataNasc"));
                falecido.setFal_dataFalec(resultado.getString("fal_dataFalec"));
                falecido.setFal_causaMorte(resultado.getString("fal_causaMorte"));
                falecido.setFal_estadoCivil(resultado.getString("fal_estadoCivil"));
                falecido.setFal_cidadeFalec(resultado.getString("fal_cidadeFalec"));
                contrato.setContr_id(resultado.getInt("contr_id"));
                
                falecido.setContrato(contrato);
                retorno = falecido;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FalecidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }    
}
