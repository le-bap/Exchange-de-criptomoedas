package control;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.ComprarEthereum;
import view.ComprarRipple;

/**
 *
 * @author Letizia
 */
public class ControllerComprarRipple {
private Investidor investidor;
    private ComprarRipple view;

    public ControllerComprarRipple(ComprarRipple view, Investidor invetidor) {
        this.view = view;
        this.investidor = invetidor;
    }
    
    public void comprar(Investidor investidor){
        double valor = Double.parseDouble(view.getTxtValor().getText());        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if (res.next()){
                double ripple = res.getDouble("ripple");
                double reais = res.getDouble("reais");
                double valorCotado = investidor.getCarteira().getRipple().
                        cotarCompra(valor, investidor.getCarteira().getRipple().getTaxaCompra());
                
                if (valorCotado < reais){    
                    double saldo = ripple + valor ;
                    dao.atualizarRipple(investidor,saldo);
                    
                    double saldoReal = reais - valorCotado;
                    dao.atualizarReais(investidor, saldoReal);
                    JOptionPane.showMessageDialog(view, "Compra efetuada!");
                    conn.close();

                }
                else{
                    JOptionPane.showMessageDialog(view, "Não há saldo suficiente"
                            + "para efetuar esta compra.");
                }
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(view, e);
        }        
    }    
}
