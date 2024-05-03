package control;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.acharInvestidor(investidor);
            if (res.next()){
                double reais = res.getDouble("reais");
                view.getLblSaldoAntes().setText(String.valueOf(reais));

                if (reais == 0){
                    JOptionPane.showMessageDialog(view, "Saque não pode ser "
                            + "realizado pois o saldo é nulo");
                    view.setVisible(false);
                }
                else{
                    double saldo = reais - saque;
                    dao.atualizar(investidor,saldo);
                    view.getLblSaldoDepois().setText(String.valueOf(saldo));
                }
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(view, e);
        }
    }
}
