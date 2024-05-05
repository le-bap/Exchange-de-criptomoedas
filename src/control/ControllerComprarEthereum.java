package control;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        double valor = Double.parseDouble(view.getTxtValor().getText());        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if (res.next()){
                double bitcoin = res.getDouble("ethereum");
                double reais = res.getDouble("reais");
                double valorCotado = investidor.getCarteira().getEthereum().
                        cotarCompra(valor, investidor.getCarteira().getEthereum().getTaxaCompra());
                
                if (valorCotado < reais){    
                    double saldo = bitcoin + valor ;
                    dao.atualizarEthereum(investidor,saldo);
                    
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
