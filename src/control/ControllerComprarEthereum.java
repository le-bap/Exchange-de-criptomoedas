package control;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Investidor;
import view.ComprarEthereum;

/**
 *
 * @author Letizia
 */
public class ControllerComprarEthereum {
    private Investidor investidor;
    private ComprarEthereum view;

    public ControllerComprarEthereum(ComprarEthereum view, Investidor invetidor) {
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
                double ethereum = res.getDouble("ethereum");
                double reais = res.getDouble("reais");
                double ripple = res.getDouble("ripple");
                double bitcoin = res.getDouble("bitcoin");
                
                double valorEthereum = investidor.getCarteira().getEthereum().getValor();
                
                double taxaCompra = investidor.getCarteira().getEthereum().getTaxaCompra();
                
                double valorCotado = investidor.getCarteira().getEthereum().cotarCompra(valorDigitado, taxaCompra);
                
                if(valorEthereum == 0){
                    JOptionPane.showMessageDialog(view, "Por favor atualize a cotação antes");
                }else{
                    if (valorCotado <= reais){
                        dao.atualizarEthereum(investidor,(valorDigitado + ethereum));

                        double saldoReal = reais - valorCotado;
                        dao.atualizarReais(investidor, saldoReal);
                        JOptionPane.showMessageDialog(view, "Compra efetuada!");
                        
                        Date data = new Date();
                        ResultSet res2 = dao.acharID(investidor);
                        if (res2.next()){
                            int id = res2.getInt("id");
                            dao.extrato(investidor, data, false, valorCotado, valorEthereum, "Ethereum", reais, bitcoin, (valorDigitado + ethereum), ripple);
                            conn.close();
                        }
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
