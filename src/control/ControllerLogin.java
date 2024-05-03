package control;

import DAO.Conexao;
import DAO.UsuarioDAO;
import model.Investidor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.Login;
import view.Menu;


/**
 *
 * @author uniflbaptistella
 */
public class ControllerLogin {
    private Login view;

    public ControllerLogin(Login view) {
        this.view = view;
    }
    
    public void loginInvestidor(){
        Investidor investidor = new Investidor(null, view.getTxtCpf().getText(),
                                view.getTxtSenha().getText());
        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if (res.next()){
                JOptionPane.showMessageDialog(view, "Login realizado!");
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");
                Menu menu = new Menu( new Investidor(nome, cpf, senha));
                menu.setVisible(true);
                view.setVisible(false);
                
            }else{
                JOptionPane.showMessageDialog(view, "Login nao efetuado");
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao");
        }
    }
}
