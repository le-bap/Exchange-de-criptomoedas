package control;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.VerificarSenha;

/**
 *
 * @author Letizia
 */
public class ControllerValidarSenha {
    private VerificarSenha view;

    public ControllerValidarSenha(VerificarSenha view) {
        this.view = view;
    }
    
    public boolean verificar(){
        Investidor investidor = new Investidor(null, null,
                                view.getTxtSenha().getText());
        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.verificarSenha(investidor);
            if (res.next()){
                JOptionPane.showMessageDialog(view, "Senha confirmada!");
                view.setVisible(false);
                return true;
            }else{
                JOptionPane.showMessageDialog(view, "Senha incorreta.");
                return false;
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao");
            return false;
        }
    }
    
}
