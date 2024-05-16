package DAO;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
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
    
    public ResultSet acharID(Investidor investidor) throws SQLException{
        String sql2 = "select * from public.usuario where cpf = ?";
        PreparedStatement statement2 = conn.prepareStatement(sql2);
        statement2.setString(1, investidor.getCpf());
        statement2.execute();
        ResultSet resul = statement2.getResultSet();
        return resul;
    }
    
    Date data = new Date();
    
    public void extrato(Investidor investidor, Date data, boolean tipo, double valor, double cotacao, String nome_moeda, double real, double bitcoin, double ethereum, double ripple) throws SQLException {
    Conexao conexao = new Conexao();
    try {
        Connection conn = conexao.getConnection();
        UsuarioDAO dao = new UsuarioDAO(conn);
        ResultSet res = this.acharID(investidor);
        if (res.next()) {
            int id = res.getInt("id");
            String sql = "insert into extrato (data, tipo, valor, cotacao,"
                    + " nome_moeda, reais, bitcoin, ethereum, ripple, id_pessoa)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setTimestamp(1, new java.sql.Timestamp(data.getTime()));
            statement.setBoolean(2, tipo);
            statement.setDouble(3, valor);
            statement.setDouble(4, cotacao);
            statement.setString(5, nome_moeda);
            statement.setDouble(6, real);
            statement.setDouble(7, bitcoin);
            statement.setDouble(8, ethereum);
            statement.setDouble(9, ripple);
            statement.setInt(10, id);

            statement.execute();
            conn.close();
        }
    } catch (SQLException e) {
        System.out.println(e);
    }
    }

}
