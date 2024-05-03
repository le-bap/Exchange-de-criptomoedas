package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Investidor;

/**
 *
 * @author Letizia
 */
public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Investidor investidor) throws SQLException{
        
        String sql = "select * from usuario where cpf = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        // corrigindo problema de injeção de sql
        statement.setString(1, investidor.getCpf());
        statement.setString(2, investidor.getSenha());
        statement.execute();
        ResultSet resul = statement.getResultSet();
        return resul;
    }
    
    public ResultSet verificarSenha(Investidor investidor) throws SQLException{
        
        String sql = "select * from usuario where senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        // corrigindo problema de injeção de sql
        statement.setString(1, investidor.getSenha());
        statement.execute();
        ResultSet resul = statement.getResultSet();
        return resul;
    }
    
    public ResultSet acharInvestidor(Investidor investidor) throws SQLException{
        
        String sql = "select * from usuario where senha = ? and cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getSenha());
        statement.setString(2, investidor.getCpf());
        statement.execute();
        ResultSet resul = statement.getResultSet();
        return resul;
    }
    
    public ResultSet listar(Investidor investidor) throws SQLException{
        
        String sql = "select * from public.usuario where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getCpf());
        statement.execute();
        ResultSet resul = statement.getResultSet();
        return resul;
    }
    
   public void atualizar(Investidor investidor, double valor) throws SQLException {
    String sql = "update usuario set reais = ? where senha = ?";
    
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, String.valueOf(valor));
    statement.setString(2, investidor.getSenha());
    statement.execute();
    conn.close();
    }
}
