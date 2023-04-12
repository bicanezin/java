package dao;

import model.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection conexaoMySQL;

    public UsuarioDAO(Connection conexao) {
        conexaoMySQL = conexao;
    }

    public boolean criarUsuario(UsuarioModel usuario) {
        String inserir = "INSERT INTO usuario(usuario_nome, usuario_email, usuario_telefone) VALUES(?,?,?)";
        try {
            PreparedStatement prepStatement = conexaoMySQL.prepareStatement(inserir);
            prepStatement.setString(1, usuario.getUsuarioNome());
            prepStatement.setString(2, usuario.getUsuarioEmail());
            prepStatement.setString(3, usuario.getUsuarioTelefone());
            int resultadoInsercao = prepStatement.executeUpdate();
            System.out.println(resultadoInsercao + " linha(s) inserida(s)");
            conexaoMySQL.commit();
            conexaoMySQL.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Falha ao criar usuário" + erro);
            return false;
        }
    }

    public List<UsuarioModel> buscarUsuarios() {
        List<UsuarioModel> usuarios = new ArrayList<>();
        ResultSet resultado = null;
        String buscar = "SELECT * FROM usuario";
        try {
            PreparedStatement prepStatement = conexaoMySQL.prepareStatement(buscar);
            resultado = prepStatement.executeQuery();
            while (resultado.next()) {
                UsuarioModel usuario = new UsuarioModel();

                usuario.setUsuarioID(resultado.getInt("usuario_id"));
                usuario.setUsuarioNome(resultado.getString("usuario_nome"));
                usuario.setUsuarioEmail(resultado.getString("usuario_email"));
                usuario.setUsuarioTelefone(resultado.getString("usuario_telefone"));

                usuarios.add(usuario);
            }
            conexaoMySQL.close();

        } catch (SQLException erro) {
            System.out.println("Falha ao listar os usuários" + erro);
        } finally {
            return usuarios;
        }
    }

    public List<UsuarioModel> buscarUsuarioPeloID(int id) {
        List<UsuarioModel> usuarios = new ArrayList<>();
        ResultSet resultado = null;
        String buscar = "SELECT * FROM usuario WHERE usuario_id = ?";
        try {
            PreparedStatement prepStatement = conexaoMySQL.prepareStatement(buscar);
            prepStatement.setInt(1, id);
            resultado = prepStatement.executeQuery();
            while (resultado.next()) {
                UsuarioModel usuario = new UsuarioModel();

                usuario.setUsuarioID(resultado.getInt("usuario_id"));
                usuario.setUsuarioNome(resultado.getString("usuario_nome"));
                usuario.setUsuarioEmail(resultado.getString("usuario_email"));
                usuario.setUsuarioTelefone(resultado.getString("usuario_telefone"));

                usuarios.add(usuario);
            }
            conexaoMySQL.close();

        } catch (SQLException erro) {
            System.out.println("Falha ao listar os usuarios" + erro);
        } finally {
            return usuarios;
        }
    }

    public boolean editarUsuario(UsuarioModel usuario) {
        String editar = "UPDATE usuario SET usuario_nome = ?, usuario_email = ?, usuario_telefone = ? WHERE usuario_id = ?";
        try {
            PreparedStatement prepStatement = conexaoMySQL.prepareStatement(editar);
            prepStatement.setString(1, usuario.getUsuarioNome());
            prepStatement.setString(2, usuario.getUsuarioEmail());
            prepStatement.setString(3, usuario.getUsuarioTelefone());
            prepStatement.setInt(4, usuario.getUsuarioID());
            int resultadoEdicao = prepStatement.executeUpdate();
            System.out.println(resultadoEdicao + " linha(s) atualizada(s)");
            conexaoMySQL.commit();
            conexaoMySQL.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Falha ao editar usuario" + erro);
            return false;
        }
    }

    public boolean excluirUsuario(int id) {
        String excluir = "DELETE FROM usuario WHERE usuario_id = ?";
        try {
            PreparedStatement prepStatement = conexaoMySQL.prepareStatement(excluir);
            prepStatement.setInt(1, id);
            int resultadoExclusao = prepStatement.executeUpdate();
            conexaoMySQL.commit();
            conexaoMySQL.close();
            System.out.println(resultadoExclusao + " linha(s) excluida(s)");
            return true;
        } catch (SQLException erro) {
            System.out.println("Falha ao excluir usuario" + erro);
            return false;
        }
    }

}
