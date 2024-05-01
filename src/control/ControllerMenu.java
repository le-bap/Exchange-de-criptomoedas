package control;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Carteira;
import model.Investidor;
import view.ConsultarSaldo;
import view.Menu;

/**
 *
 * @author Letizia
 */
public class ControllerMenu {
    private Menu menu;
    
    public ControllerMenu(Menu menu){
        this.menu = menu;
    }
    
    public void consultarSaldo(){
        String senha = JOptionPane.showInputDialog(null, "Para prossegui digite sua senha novamente:",
                "Verificar Senha", JOptionPane.PLAIN_MESSAGE);

        if (senha != null) {
            Investidor investidor = new Investidor(null, null, senha);
            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                ResultSet res = dao.verificarSenha(investidor);
                if (res.next()){
                    JOptionPane.showMessageDialog(null, "Senha confirmada!");
                    
                    String nome = res.getString("nome");
                    String cpf = res.getString("cpf");
                    String bitcoin = res.getString("bitcoins");
                    
                    ConsultarSaldo consultarSaldoView = new ConsultarSaldo(
                            new Investidor(nome, cpf, null));
                    consultarSaldoView.setVisible(true);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta.");
                }
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro de conexão");
            }
        } 
    }
}
