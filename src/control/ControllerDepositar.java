package control;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.Depositar;

/**
 *
 * @author Letizia
 */
public class ControllerDepositar {
    private Depositar view;
    private Investidor investidor;

    public ControllerDepositar(Depositar view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    
    public void deposito(Investidor investidor){
        double deposito = Double.parseDouble(view.getTxtDeposito().getText());        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.acharInvestidor(investidor);
            if (res.next()){
                double reais = res.getDouble("reais");
                view.getLblSaldoAntes().setText(String.valueOf(reais));

                double saldo = reais + deposito;
                dao.atualizar(investidor,saldo);
                view.getLblSaldoDepois().setText(String.valueOf(saldo));
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(view, e);
        }
    }
}
