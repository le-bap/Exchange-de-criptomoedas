package control;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.VenderRipple;

/**
 *
 * @author Letizia
 */
public class ControllerVenderRipple {
    private Investidor investidor;
    private VenderRipple view;

    public ControllerVenderRipple(VenderRipple view, Investidor investidor) {
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
                double ripple = res.getDouble("ripple");
                double reais = res.getDouble("reais");
                double valorCotado = investidor.getCarteira().getRipple().
                        cotarVenda(valor, investidor.getCarteira().getRipple().getTaxaVenda());
                System.out.println(valorCotado);
                if (valor <= ripple){    
                    double saldoReais = reais + valorCotado ;
                    dao.atualizarReais(investidor,saldoReais);
                    System.out.println(saldoReais);
                    double saldoRipple = ripple - valor;
                    dao.atualizarEthereum(investidor, saldoRipple);
                    System.out.println(saldoRipple);
                    JOptionPane.showMessageDialog(view, "Venda efetuada!");
                    conn.close();
                }
                else{
                    JOptionPane.showMessageDialog(view, "Não há ripples suficientes"
                            + "para efetuar esta venda.");
                }
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(view, e);
        }        
    }
}
