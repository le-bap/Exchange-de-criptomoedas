package control;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.ConsultarSaldo;
import view.Menu;

/**
 *
 * @author Letizia
 */
public class ControllerConsultarSaldo {
     private ConsultarSaldo view;
    
    public ControllerConsultarSaldo(ConsultarSaldo view){
        this.view = view;
    }
    
    public void consulta(Investidor investidor){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.listar(investidor);
            
            if (res.next()){
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                double bitcoin = res.getDouble("bitcoin");
                double ethereum = res.getDouble("ethereum");
                double real = res.getDouble("reais");
                double ripple = res.getDouble("ripple");

                view.getLblNome().setText(nome);
                view.getLblCpf().setText(cpf);
                view.getLblReais().setText(String.valueOf(real));
                view.getLblBitcoins().setText(String.valueOf(bitcoin));
                view.getLblEthereum().setText(String.valueOf(ethereum));
                view.getLblRipple().setText(String.valueOf(ripple));
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão");
        }
    
    }
}
