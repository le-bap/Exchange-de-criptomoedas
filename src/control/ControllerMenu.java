package control;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.ConsultarSaldo;
import view.Depositar;
import view.Menu;

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
        String senha = JOptionPane.showInputDialog(null, "Para prossegui digite sua senha novamente:",
                "Verificar Senha", JOptionPane.PLAIN_MESSAGE);

        if (senha != null) {
            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                ResultSet res = dao.verificarSenha(investidor);
                if (res.next()){
                    JOptionPane.showMessageDialog(null, "Senha confirmada!");
                    
                    String nome = res.getString("nome");
                    String cpf = res.getString("cpf");
                    
                    ConsultarSaldo view = new ConsultarSaldo(new Investidor(nome, cpf, null));
                    view.setVisible(true);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta.");
                }
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro de conexão");
            }
        } 
    }
    
    public void depositar(){
        String senha = JOptionPane.showInputDialog(null, "Para prossegui digite sua senha novamente:",
                "Verificar Senha", JOptionPane.PLAIN_MESSAGE);

        if (senha != null) {
            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                ResultSet res = dao.verificarSenha(investidor);
                if (res.next()){
                    JOptionPane.showMessageDialog(null, "Senha confirmada!");
                    
                    Depositar d = new Depositar(investidor);
                    d.setVisible(true);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta.");
                }
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro de conexão");
            }
        } 
    }
}
