package controller;

import dao.UsuarioDAO;
import model.UsuarioModel;
import factory.conectaPostgreSQL;
import java.sql.Connection;
import java.util.List;

public class UsuarioController {

    public boolean inserir(String usuarioNome, String usuarioEmail, String usuarioTelefone) {
        Connection conexaoBanco = conectaPostgreSQL.conectaBanco();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexaoBanco);
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setUsuarioNome(usuarioNome);
        usuarioModel.setUsuarioEmail(usuarioEmail);
        usuarioModel.setUsuarioTelefone(usuarioTelefone);

        boolean resultado = usuarioDAO.criarUsuario(usuarioModel);
        conectaPostgreSQL.desconectaBanco(conexaoBanco);

        return resultado;
    }

    public List<UsuarioModel> listar() {
        Connection conexaoBanco = conectaPostgreSQL.conectaBanco();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexaoBanco);
        List<UsuarioModel> usuarios = usuarioDAO.buscarUsuarios();
        conectaPostgreSQL.desconectaBanco(conexaoBanco);

        return usuarios;
    }

    public List<UsuarioModel> buscarPeloID(int id) {
        Connection conexaoBanco = conectaPostgreSQL.conectaBanco();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexaoBanco);
        List<UsuarioModel> usuarios = usuarioDAO.buscarUsuarioPeloID(id);
        conectaPostgreSQL.desconectaBanco(conexaoBanco);

        return usuarios;
    }

    public boolean editar(String usuarioNome, String usuarioEmail, String usuarioTelefone, int id) {
        Connection conexaoBanco = conectaPostgreSQL.conectaBanco();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexaoBanco);
        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setUsuarioNome(usuarioNome);
        usuarioModel.setUsuarioEmail(usuarioEmail);
        usuarioModel.setUsuarioTelefone(usuarioTelefone);
        usuarioModel.setUsuarioID(id);

        boolean resultado = usuarioDAO.editarUsuario(usuarioModel);
        conectaPostgreSQL.desconectaBanco(conexaoBanco);

        return resultado;
    }

    public boolean excluir(int id) {
        Connection conexaoBanco = conectaPostgreSQL.conectaBanco();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexaoBanco);

        boolean resultado = usuarioDAO.excluirUsuario(id);
        conectaPostgreSQL.desconectaBanco(conexaoBanco);

        return resultado;
    }
}
