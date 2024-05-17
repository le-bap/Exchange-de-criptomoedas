
package control;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
                double ripple = res.getDouble("ripple");
                double bitcoin = res.getDouble("bitcoin");
                
                double valorEthereum = investidor.getCarteira().getEthereum().getValor();
                
                double taxaVenda = investidor.getCarteira().getEthereum().getTaxaVenda();
                
                double valorCotado = investidor.getCarteira().getEthereum().cotarCompra(valor, taxaVenda);

                if(valorEthereum == 0){
                    JOptionPane.showMessageDialog(view, "Por favor atualize a cotação antes");
                }else{
                    if (valor <= ethereum){    
                        double saldoReais = reais + valorCotado ;
                        dao.atualizarReais(investidor,saldoReais);

                        double saldoEthereum = ethereum - valor;
                        dao.atualizarEthereum(investidor, saldoEthereum);

                        JOptionPane.showMessageDialog(view, "Venda efetuada!");
                        
                        Date data = new Date();
                        ResultSet res2 = dao.acharID(investidor);
                        if (res2.next()){
                            int id = res2.getInt("id");
                            dao.extrato(investidor, data, true, valorCotado, valorEthereum, "Ethereum", saldoReais, bitcoin, saldoEthereum, ripple);
                            conn.close();
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(view, "Não há ethereuns suficientes"
                                + "para efetuar esta venda.");
                    }
                }
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(view, e);
        }        
    }
}
