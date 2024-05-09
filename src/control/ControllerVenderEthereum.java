
package control;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.VenderBitcoin;
import view.VenderEthereum;

/**
 *
 * @author Letizia
 */
public class ControllerVenderEthereum {
    private Investidor investidor;
    private VenderEthereum view;

    public ControllerVenderEthereum(VenderEthereum view, Investidor investidor) {
        this.investidor = investidor;
        this.view = view;
    }
    
    public void vender(Investidor investidor){
        double valor = Double.parseDouble(view.getTxtValor().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if (res.next()){
                double ethereum = res.getDouble("ethereum");
                double reais = res.getDouble("reais");
                double valorCotado = investidor.getCarteira().getEthereum().
                        cotarVenda(valor, investidor.getCarteira().getEthereum().getTaxaVenda());
                System.out.println(valorCotado);
                if (valorCotado <= ethereum){    
                    double saldoReais = reais + valorCotado ;
                    dao.atualizarReais(investidor,saldoReais);
                    System.out.println(saldoReais);
                    double saldoEthereum = ethereum - valor;
                    dao.atualizarEthereum(investidor, saldoEthereum);
                    System.out.println(saldoEthereum);
                    JOptionPane.showMessageDialog(view, "Compra efetuada!");
                    conn.close();
                }
                else{
                    JOptionPane.showMessageDialog(view, "Não há bitcoins suficiente"
                            + "para efetuar esta venda.");
                }
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(view, e);
        }        
    }
}
