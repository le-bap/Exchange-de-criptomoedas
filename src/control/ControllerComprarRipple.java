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
        double valorDigitado = Double.parseDouble(view.getTxtValor().getText());        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if (res.next()){
                double ripple = res.getDouble("ripple");
                double reais = res.getDouble("reais");
                
                double valorRipple = investidor.getCarteira().getRipple().getValor();

                double taxaCompra = investidor.getCarteira().getRipple().getTaxaCompra();

                double valorCotado = investidor.getCarteira().getRipple().cotarCompra(valorDigitado, taxaCompra);

                if (valorRipple == 0){
                    JOptionPane.showMessageDialog(view, "Por favor atualize a cotação antes.");
                }else{
                    if (valorCotado < reais){
                        dao.atualizarRipple(investidor,(valorDigitado + ripple));

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
