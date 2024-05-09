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
                double valorCotado = investidor.getCarteira().getBitcoin().
                        cotarVenda(valor, investidor.getCarteira().getBitcoin().getTaxaVenda());
                System.out.println(valorCotado);
                if (valorCotado <= bitcoin){    
                    double saldoReais = reais + valorCotado ;
                    dao.atualizarReais(investidor,saldoReais);
                    System.out.println(saldoReais);
                    
                    double saldoBitcoin = bitcoin - valor;
                    dao.atualizarBitcoin(investidor, saldoBitcoin);
                    System.out.println(saldoBitcoin);
                    
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
