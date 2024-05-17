package control;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
                double bitcoin = res.getDouble("bitcoin");
                double ethereum = res.getDouble("ethereum");
                double valorRipple = investidor.getCarteira().getRipple().getValor();

                double taxaVenda = investidor.getCarteira().getRipple().getTaxaVenda();

                double valorCotado = investidor.getCarteira().getRipple().cotarCompra(valor, taxaVenda);
                
                if(valorRipple == 0){
                    JOptionPane.showMessageDialog(view, "Por favor atualize a cotação antes.");
                }else{
                    if (valor <= ripple){    
                        double saldoReais = reais + valorCotado;
                        dao.atualizarReais(investidor,saldoReais);
                        
                        double saldoRipple = ripple - valor;
                        dao.atualizarRipple(investidor, saldoRipple);

                        JOptionPane.showMessageDialog(view, "Venda efetuada!");
                        Date data = new Date();
                        ResultSet res2 = dao.acharID(investidor);
                        if (res2.next()){
                            int id = res2.getInt("id");
                            dao.extrato(investidor, data, true, valorCotado, valorRipple, "Ripple", saldoReais, bitcoin, ethereum, saldoRipple);
                            conn.close();
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(view, "Não há ripples suficientes"
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
