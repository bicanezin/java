package dao;

import model.ObservacaoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObservacaoDAO {

    private Connection conexaoMySQL;

    public ObservacaoDAO(Connection conexao) {
        conexaoMySQL = conexao;
    }

    public boolean criarObservacao(ObservacaoModel observacao) {
        String inserir = "INSERT INTO observacao(observacao_descricao, emprestimo_id) VALUES(?,?)";
        try {
            PreparedStatement prepStatement = conexaoMySQL.prepareStatement(inserir);
            prepStatement.setString(1, observacao.getObservacaoDescricao());
            prepStatement.setInt(2, observacao.getEmprestimoID());
            int resultadoInsercao = prepStatement.executeUpdate();
            System.out.println(resultadoInsercao + " linha(s) inserida(s)");
            conexaoMySQL.commit();
            conexaoMySQL.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Falha ao criar observação" + erro);
            return false;
        }
    }

    public List<ObservacaoModel> buscarObservacoes() {
        List<ObservacaoModel> observacoes = new ArrayList<>();
        ResultSet resultado = null;
        String buscar = "SELECT * FROM observacao";
        try {
            PreparedStatement prepStatement = conexaoMySQL.prepareStatement(buscar);
            resultado = prepStatement.executeQuery();
            while (resultado.next()) {
                ObservacaoModel observacao = new ObservacaoModel();

                observacao.setObservacaoID(resultado.getInt("observacao_id"));
                observacao.setObservacaoDescricao(resultado.getString("observacao_descricao"));
                observacao.setEmprestimoID(resultado.getInt("emprestimo_id"));

                observacoes.add(observacao);
            }
            conexaoMySQL.close();

        } catch (SQLException erro) {
            System.out.println("Falha ao listar as observações" + erro);
        } finally {
            return observacoes;
        }
    }

    public List<ObservacaoModel> buscarObservacaoPeloID(int id) {
        List<ObservacaoModel> observacoes = new ArrayList<>();
        ResultSet resultado = null;
        String buscar = "SELECT * FROM observacao WHERE observacao_id = ?";
        try {
            PreparedStatement prepStatement = conexaoMySQL.prepareStatement(buscar);
            prepStatement.setInt(1, id);
            resultado = prepStatement.executeQuery();
            while (resultado.next()) {
                ObservacaoModel observacao = new ObservacaoModel();

                observacao.setObservacaoID(resultado.getInt("observacao_id"));
                observacao.setObservacaoDescricao(resultado.getString("observacao_descricao"));
                observacao.setEmprestimoID(resultado.getInt("emprestimo_id"));

                observacoes.add(observacao);
            }
            conexaoMySQL.close();

        } catch (SQLException erro) {
            System.out.println("Falha ao listar as observações" + erro);
        } finally {
            return observacoes;
        }
    }

    public boolean editarObservacao(ObservacaoModel observacao) {
        String editar = "UPDATE observacao SET observacao_descricao = ?, emprestimo_id = ? WHERE observacao_id = ?";
        try {
            PreparedStatement prepStatement = conexaoMySQL.prepareStatement(editar);
            prepStatement.setString(1, observacao.getObservacaoDescricao());
            prepStatement.setInt(2, observacao.getEmprestimoID());
            prepStatement.setInt(3, observacao.getObservacaoID());
            int resultadoEdicao = prepStatement.executeUpdate();
            System.out.println(resultadoEdicao + " linha(s) atualizada(s)");
            conexaoMySQL.commit();
            conexaoMySQL.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Falha ao editar observação" + erro);
            return false;
        }
    }

    public boolean excluirObservacao(int id) {
        String excluir = "DELETE FROM observacao WHERE observacao_id = ?";
        try {
            PreparedStatement prepStatement = conexaoMySQL.prepareStatement(excluir);
            prepStatement.setInt(1, id);
            int resultadoExclusao = prepStatement.executeUpdate();
            conexaoMySQL.commit();
            conexaoMySQL.close();
            System.out.println(resultadoExclusao + " linha(s) excluida(s)");
            return true;
        } catch (SQLException erro) {
            System.out.println("Falha ao excluir observação" + erro);
            return false;
        }
    }

}
