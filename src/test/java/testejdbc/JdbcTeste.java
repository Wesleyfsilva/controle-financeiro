package testejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTeste {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:3008/controle-financeiro";
        String username = "postgres";
        String password = "Wesley@123";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            if (conn != null) {
                System.out.println("Conexão estabelecida com sucesso!");
            } else {
                System.out.println("Falha ao estabelecer a conexão!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
