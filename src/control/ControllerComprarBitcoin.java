package control;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.ComprarBitcoin;

/**
 *
 * @author Letizia
 */
public class ControllerComprarBitcoin {
    private Investidor investidor;
    private ComprarBitcoin view;

    public ControllerComprarBitcoin(ComprarBitcoin view, Investidor invetidor) {
        this.view = view;
        this.investidor = invetidor;
    }
    
    public void comprar(Investidor investidor){
        double valorDigitado = Double.parseDouble(view.getTxtValor().getText());        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if (res.next()){
                double bitcoin = res.getDouble("bitcoin");
                double reais = res.getDouble("reais");
                
                double valorBitcoin = investidor.getCarteira().getBitcoin().getValor();
                
                double taxaCompra = investidor.getCarteira().getBitcoin().getTaxaCompra();
                
                double valorCotado = investidor.getCarteira().getBitcoin().cotarCompra(valorDigitado, taxaCompra);
                
                if (valorBitcoin == 0){
                    JOptionPane.showMessageDialog(view, "Por favor atualize a cotação antes.");
                }else{
                
                    if (valorCotado < reais){
                        dao.atualizarBitcoin(investidor,(valorDigitado + bitcoin));

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
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(view, e);
        }        
    }
}
