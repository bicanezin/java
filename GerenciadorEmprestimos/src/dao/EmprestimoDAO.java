package dao;

import model.EmprestimoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO {

    private Connection conexaoMySQL;

    public EmprestimoDAO(Connection conexao) {
        conexaoMySQL = conexao;
    }

    public boolean criarEmprestimo(EmprestimoModel emprestimo) {
        String inserir = "INSERT INTO emprestimo(emprestimo_item, usuario_id) VALUES(?,?)";
        try {
            PreparedStatement prepStatement = conexaoMySQL.prepareStatement(inserir);
            prepStatement.setString(1, emprestimo.getEmprestimoItem());
            prepStatement.setInt(2, emprestimo.getUsuarioID());
            int resultadoInsercao = prepStatement.executeUpdate();
            System.out.println(resultadoInsercao + " linha(s) inserida(s)");
            conexaoMySQL.commit();
            conexaoMySQL.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Falha ao criar emprestimo" + erro);
            return false;
        }
    }

    public List<EmprestimoModel> buscarEmprestimos() {
        List<EmprestimoModel> emprestimos = new ArrayList<>();
        ResultSet resultado = null;
        String buscar = "SELECT * FROM emprestimo";
        try {
            PreparedStatement prepStatement = conexaoMySQL.prepareStatement(buscar);
            resultado = prepStatement.executeQuery();
            while (resultado.next()) {
                EmprestimoModel emprestimo = new EmprestimoModel();

                emprestimo.setEmprestimoID(resultado.getInt("emprestimo_id"));
                emprestimo.setEmprestimoItem(resultado.getString("emprestimo_item"));
                emprestimo.setUsuarioID(resultado.getInt("usuario_id"));

                emprestimos.add(emprestimo);
            }
            conexaoMySQL.close();

        } catch (SQLException erro) {
            System.out.println("Falha ao listar os emprestimos" + erro);
        } finally {
            return emprestimos;
        }
    }

    public List<EmprestimoModel> buscarEmprestimoPeloID(int id) {
        List<EmprestimoModel> emprestimos = new ArrayList<>();
        ResultSet resultado = null;
        String buscar = "SELECT * FROM emprestimo WHERE emprestimo_id = ?";
        try {
            PreparedStatement prepStatement = conexaoMySQL.prepareStatement(buscar);
            prepStatement.setInt(1, id);
            resultado = prepStatement.executeQuery();
            while (resultado.next()) {
                EmprestimoModel emprestimo = new EmprestimoModel();

                emprestimo.setEmprestimoID(resultado.getInt("emprestimo_id"));
                emprestimo.setEmprestimoItem(resultado.getString("emprestimo_item"));
                emprestimo.setUsuarioID(resultado.getInt("usuario_id"));

                emprestimos.add(emprestimo);
            }
            conexaoMySQL.close();

        } catch (SQLException erro) {
            System.out.println("Falha ao listar os emprestimos" + erro);
        } finally {
            return emprestimos;
        }
    }

    public boolean editarEmprestimo(EmprestimoModel emprestimo) {
        String editar = "UPDATE emprestimo SET emprestimo_item = ?, usuario_id = ? WHERE emprestimo_id = ?";
        try {
            PreparedStatement prepStatement = conexaoMySQL.prepareStatement(editar);
            prepStatement.setString(1, emprestimo.getEmprestimoItem());
            prepStatement.setInt(2, emprestimo.getUsuarioID());
            prepStatement.setInt(3, emprestimo.getEmprestimoID());
            int resultadoEdicao = prepStatement.executeUpdate();
            System.out.println(resultadoEdicao + " linha(s) atualizada(s)");
            conexaoMySQL.commit();
            conexaoMySQL.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Falha ao editar emprestimo" + erro);
            return false;
        }
    }

    public boolean excluirEmprestimo(int id) {
        String excluir = "DELETE FROM emprestimo WHERE emprestimo_id = ?";
        try {
            PreparedStatement prepStatement = conexaoMySQL.prepareStatement(excluir);
            prepStatement.setInt(1, id);
            int resultadoExclusao = prepStatement.executeUpdate();
            conexaoMySQL.commit();
            conexaoMySQL.close();
            System.out.println(resultadoExclusao + " linha(s) excluida(s)");
            return true;
        } catch (SQLException erro) {
            System.out.println("Falha ao excluir emprestimo" + erro);
            return false;
        }
    }

}
