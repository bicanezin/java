package controller;

import dao.EmprestimoDAO;
import model.EmprestimoModel;
import factory.conectaPostgreSQL;
import java.sql.Connection;
import java.util.List;

public class EmprestimoController {

    public boolean inserir(String emprestimoItem, int usuarioID) {
        Connection conexaoBanco = conectaPostgreSQL.conectaBanco();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO(conexaoBanco);
        EmprestimoModel emprestimoModel = new EmprestimoModel();

        emprestimoModel.setEmprestimoItem(emprestimoItem);
        emprestimoModel.setUsuarioID(usuarioID);

        boolean resultado = emprestimoDAO.criarEmprestimo(emprestimoModel);
        conectaPostgreSQL.desconectaBanco(conexaoBanco);

        return resultado;
    }

    public List<EmprestimoModel> listar() {
        Connection conexaoBanco = conectaPostgreSQL.conectaBanco();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO(conexaoBanco);
        List<EmprestimoModel> emprestimos = emprestimoDAO.buscarEmprestimos();
        conectaPostgreSQL.desconectaBanco(conexaoBanco);

        return emprestimos;
    }

    public List<EmprestimoModel> buscarPeloID(int id) {
        Connection conexaoBanco = conectaPostgreSQL.conectaBanco();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO(conexaoBanco);
        List<EmprestimoModel> emprestimos = emprestimoDAO.buscarEmprestimoPeloID(id);
        conectaPostgreSQL.desconectaBanco(conexaoBanco);

        return emprestimos;
    }

    public boolean editar(String emprestimoItem, int usuarioID, int id) {
        Connection conexaoBanco = conectaPostgreSQL.conectaBanco();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO(conexaoBanco);
        EmprestimoModel emprestimoModel = new EmprestimoModel();

        emprestimoModel.setEmprestimoItem(emprestimoItem);
        emprestimoModel.setUsuarioID(usuarioID);
        emprestimoModel.setEmprestimoID(id);

        boolean resultado = emprestimoDAO.editarEmprestimo(emprestimoModel);
        conectaPostgreSQL.desconectaBanco(conexaoBanco);

        return resultado;
    }

    public boolean excluir(int id) {
        Connection conexaoBanco = conectaPostgreSQL.conectaBanco();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO(conexaoBanco);

        boolean resultado = emprestimoDAO.excluirEmprestimo(id);
        conectaPostgreSQL.desconectaBanco(conexaoBanco);

        return resultado;
    }

}
