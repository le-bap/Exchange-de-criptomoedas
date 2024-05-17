package control;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Investidor;
import view.Sacar;

/**
 *
 * @author Letizia
 */
public class ControllerSacar {
    private Sacar view;
    private Investidor investidor;

    public ControllerSacar(Sacar view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    
    public void saque(Investidor investidor){
        double saque = Double.parseDouble(view.getTxtSaque().getText()); 
        DecimalFormat df = new DecimalFormat("#0.00");
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.acharInvestidor(investidor);
            if (res.next()){
                double reais = res.getDouble("reais");
                double bitcoin = res.getDouble("bitcoin");
                double ethereum = res.getDouble("ethereum");
                double ripple = res.getDouble("ripple");
                
                view.getLblSaldoAntes().setText("R$ " + String.valueOf(df.format(reais)));

                if (reais == 0){
                    JOptionPane.showMessageDialog(view, "Saque não pode ser "
                            + "realizado pois o saldo é nulo");
                    view.setVisible(false);
                }
                else{
                    double saldo = reais - saque;
                    dao.atualizarReais(investidor,saldo);
                    view.getLblSaldoDepois().setText("R$ " +String.valueOf(df.format(saldo)));
                    
                    Date data = new Date();
                    ResultSet res2 = dao.acharID(investidor);
                    if (res2.next()){
                        int id = res2.getInt("id");
                        dao.extrato(investidor, data, false, saque, 0, "Real", saldo, bitcoin, ethereum, ripple);
                        conn.close();
                    }
                }
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(view, e);
        }
    }
}
