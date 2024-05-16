package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
    
    public void atualizarReais(Investidor investidor, double valor) throws SQLException {
        String sql = "update usuario set reais = ? where senha = ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, String.valueOf(valor));
        statement.setString(2, investidor.getSenha());
        statement.execute();
    }
    
    public void atualizarBitcoin(Investidor investidor, double valor) throws SQLException {
        String sql = "update usuario set bitcoin = ? where senha = ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, String.valueOf(valor));
        statement.setString(2, investidor.getSenha());
        statement.execute();
    }
    
    public void atualizarEthereum(Investidor investidor, double valor) throws SQLException {
        String sql = "update usuario set ethereum = ? where senha = ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, String.valueOf(valor));
        statement.setString(2, investidor.getSenha());
        statement.execute();
    }
     
    public void atualizarRipple(Investidor investidor, double valor) throws SQLException {
        String sql = "update usuario set ripple = ? where senha = ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, String.valueOf(valor));
        statement.setString(2, investidor.getSenha());
        statement.execute();
    }
    
    Date data = new Date();
    
    public void extrato(Investidor investidor, Date data, boolean tipo, double valor, double cotacao, String nome_moeda, double real, double bitcoin, double ethereum, double ripple) throws SQLException{
        String sql2 = "select * from public.usuario where cpf = ?";
        PreparedStatement statement2 = conn.prepareStatement(sql2);
        statement2.setString(1, investidor.getCpf());
        statement2.execute();
        ResultSet resul = statement2.getResultSet();
        int id = resul.getInt("id");
        String op;
        if (tipo == true){
            op = "+";
        }else{
            op = "-";
        }
        String sql = "insert into usuario (id, data, tipo, valor, cotacao,"
                + " nome_moeda, real, bitcoin, ethereum, ripple, id_pessoa)"
                + "values ('" + id + "', '" + String.valueOf(data.getTime()) + "', '"
                + op + "', '" + String.valueOf(valor) + "', '" + String.valueOf(cotacao)
                + "', '" + nome_moeda + "', '" + String.valueOf(real) + "', '" +
                String.valueOf(bitcoin) + "', '" + String.valueOf(ethereum)
                + "', '" + String.valueOf(ripple) + "', '" + id + "'";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
}
