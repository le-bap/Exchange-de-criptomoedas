package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author uniflbaptistella
 */
public class Conexao {
    public Connection getConnection() throws SQLException{
            Connection conexao = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/exchange",
            "postgres", "Loma1010");
            return conexao;
    }
}