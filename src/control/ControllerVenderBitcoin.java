package control;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.VenderBitcoin;

/**
 *
 * @author Letizia
 */
public class ControllerVenderBitcoin {
    private Investidor investidor;
    private VenderBitcoin view;

    public ControllerVenderBitcoin(VenderBitcoin view, Investidor investidor) {
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
                double bitcoin = res.getDouble("bitcoin");
                double reais = res.getDouble("reais");
                
                double valorBitcoin = investidor.getCarteira().getBitcoin().getValor();
                
                double taxaVenda = investidor.getCarteira().getBitcoin().getTaxaVenda();
                
                double valorCotado = investidor.getCarteira().getBitcoin().cotarCompra(valor, taxaVenda);
                
                if(valorBitcoin == 0){
                    JOptionPane.showMessageDialog(view, "Por favor atualize a cotação antes");
                }
                else{
                    if (valor <= bitcoin){    
                        double saldoReais = reais + valorCotado ;
                        dao.atualizarReais(investidor,saldoReais);

                        double saldoBitcoin = bitcoin - valor;
                        dao.atualizarBitcoin(investidor, saldoBitcoin);

                        JOptionPane.showMessageDialog(view, "Venda efetuada!");
                        conn.close();
                    }
                    else{
                        JOptionPane.showMessageDialog(view, "Não há bitcoins suficientes"
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
