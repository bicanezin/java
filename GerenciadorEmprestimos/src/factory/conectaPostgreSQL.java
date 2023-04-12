package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectaPostgreSQL {

    public static Connection conectaBanco() {
        Connection conexaoPostgreSQL = null;
        try {
            String usuarioBD = "postgres";
            String senhaBD = "root";
            String nomeBanco = "bancoTrabalhoDesktop";

            Class.forName("org.postgresql.Driver");
            String urlConexao = "jdbc:postgresql://localhost/" + nomeBanco;
            conexaoPostgreSQL = DriverManager.getConnection(urlConexao, usuarioBD, senhaBD);
            conexaoPostgreSQL.setAutoCommit(false);
        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC/ODBC. " + erro);
        } catch (SQLException erro) {
            System.out.println("Falha ao conectar com o banco de dados " + erro);
        } finally {
            return conexaoPostgreSQL;
        }
    }

    public static void desconectaBanco(Connection conexaoMySQL) {
        try {
            conexaoMySQL.close();
        } catch (SQLException erro) {
            System.out.println("Falha ao desconectar do banco de dados" + erro);
        }
    }
}
