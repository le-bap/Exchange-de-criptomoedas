package control;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
                DecimalFormat df = new DecimalFormat("#0.00");
                
                double reais = res.getDouble("reais");
                view.getLblSaldoAntes().setText("R$ "+String.valueOf(df.format(reais)));

                double saldo = reais + deposito;
                dao.atualizarReais(investidor,saldo);
                view.getLblSaldoDepois().setText("R$ "+String.valueOf(df.format(saldo)));
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(view, e);
        }
    }
}
