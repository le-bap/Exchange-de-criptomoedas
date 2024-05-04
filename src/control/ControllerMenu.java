package control;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.Comprar;
import view.ConsultarSaldo;
import view.Depositar;
import view.Menu;
import view.Sacar;

/**
 *
 * @author Letizia
 */
public class ControllerMenu {
    private Menu menu;
    private Investidor investidor;
    
    public ControllerMenu(Menu menu, Investidor investidor){
        this.menu = menu;
        this.investidor = investidor;
    }
    
    public void consultarSaldo(){
        String senha = JOptionPane.showInputDialog(null, "Para prosseguir,"
                + " digite sua senha novamente:",
                "Verificar Senha", JOptionPane.PLAIN_MESSAGE);

        if (senha != null) {
            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                ResultSet res = dao.consultar(investidor);
                
                if (res.next()){
                    if(senha.equals(res.getString("senha"))){
                        JOptionPane.showMessageDialog(null, "Senha confirmada!");

                        String nome = res.getString("nome");
                        String cpf = res.getString("cpf");

                        ConsultarSaldo view = new ConsultarSaldo(investidor);
                        view.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Senha incorreta.");
                    }
                }    
               
            }catch(SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro de conexão");
            }
        } 
    }
    
    public void depositar(){
        String senha = JOptionPane.showInputDialog(null, "Para prosseguir, "
                + "digite sua senha novamente:",
                "Verificar Senha", JOptionPane.PLAIN_MESSAGE);

        if (senha != null) {
            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                ResultSet res = dao.consultar(investidor);
                if (res.next()){
                    if(senha.equals(res.getString("senha"))){
                        JOptionPane.showMessageDialog(null, "Senha confirmada!");

                        Depositar d = new Depositar(investidor);
                        d.setVisible(true);
                        
                     }else {
                        JOptionPane.showMessageDialog(null, "Senha incorreta.");
                    } 
                }
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro de conexão");
            }
        } 
    }
    
    
    public void sacar(){
        String senha = JOptionPane.showInputDialog(null, "Para "
                + "prosseguir, digite sua senha novamente:",
                "Verificar Senha", JOptionPane.PLAIN_MESSAGE);

        if (senha != null) {
            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                ResultSet res = dao.consultar(investidor);
                if (res.next()){
                    if(senha.equals(res.getString("senha"))){
                        JOptionPane.showMessageDialog(null, "Senha confirmada!");

                        Sacar s = new Sacar(investidor);
                        s.setVisible(true);
                    }else {
                        JOptionPane.showMessageDialog(null, "Senha incorreta.");
                    }
                }
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro de conexão");
            }
        } 
    }
    
    public void comprar(){
         String senha = JOptionPane.showInputDialog(null, "Para "
                 + "prosseguir, digite sua senha novamente:",
                "Verificar Senha", JOptionPane.PLAIN_MESSAGE);

        if (senha != null) {
            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                ResultSet res = dao.consultar(investidor);
                if (res.next()){
                    if(senha.equals(res.getString("senha"))){
                        JOptionPane.showMessageDialog(null, "Senha confirmada!");

                        Comprar c = new Comprar(investidor);
                        c.setVisible(true);
                    }else {
                        JOptionPane.showMessageDialog(null, "Senha incorreta.");
                    }
                }
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro de conexão");
            }
        } 
    }
}
