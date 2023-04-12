package controller;

import dao.ObservacaoDAO;
import model.ObservacaoModel;
import factory.conectaPostgreSQL;
import java.sql.Connection;
import java.util.List;

public class ObservacaoController {

    public boolean inserir(String observacaoDescricao, int emprestimoID) {
        Connection conexaoBanco = conectaPostgreSQL.conectaBanco();
        ObservacaoDAO observacaoDAO = new ObservacaoDAO(conexaoBanco);
        ObservacaoModel observacaoModel = new ObservacaoModel();

        observacaoModel.setObservacaoDescricao(observacaoDescricao);
        observacaoModel.setEmprestimoID(emprestimoID);

        boolean resultado = observacaoDAO.criarObservacao(observacaoModel);
        conectaPostgreSQL.desconectaBanco(conexaoBanco);

        return resultado;
    }

    public List<ObservacaoModel> listar() {
        Connection conexaoBanco = conectaPostgreSQL.conectaBanco();
        ObservacaoDAO observacaoDAO = new ObservacaoDAO(conexaoBanco);
        List<ObservacaoModel> observacoes = observacaoDAO.buscarObservacoes();
        conectaPostgreSQL.desconectaBanco(conexaoBanco);

        return observacoes;
    }

    public List<ObservacaoModel> buscarPeloID(int id) {
        Connection conexaoBanco = conectaPostgreSQL.conectaBanco();
        ObservacaoDAO observacaoDAO = new ObservacaoDAO(conexaoBanco);
        List<ObservacaoModel> observacoes = observacaoDAO.buscarObservacaoPeloID(id);
        conectaPostgreSQL.desconectaBanco(conexaoBanco);

        return observacoes;
    }

    public boolean editar(String observacaoDescricao, int emprestimoID, int id) {
        Connection conexaoBanco = conectaPostgreSQL.conectaBanco();
        ObservacaoDAO observacaoDAO = new ObservacaoDAO(conexaoBanco);
        ObservacaoModel observacaoModel = new ObservacaoModel();

        observacaoModel.setObservacaoDescricao(observacaoDescricao);
        observacaoModel.setEmprestimoID(emprestimoID);
        observacaoModel.setObservacaoID(id);

        boolean resultado = observacaoDAO.editarObservacao(observacaoModel);
        conectaPostgreSQL.desconectaBanco(conexaoBanco);

        return resultado;
    }

    public boolean excluir(int id) {
        Connection conexaoBanco = conectaPostgreSQL.conectaBanco();
        ObservacaoDAO observacaoDAO = new ObservacaoDAO(conexaoBanco);

        boolean resultado = observacaoDAO.excluirObservacao(id);
        conectaPostgreSQL.desconectaBanco(conexaoBanco);

        return resultado;
    }
}
