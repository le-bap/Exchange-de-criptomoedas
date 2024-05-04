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
        double valor = Double.parseDouble(view.getTxtValor().getText());        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if (res.next()){
                double bitcoin = res.getDouble("bitcoin");
                double reais = res.getDouble("reais");
                double valorCotado = investidor.getCarteira().getBitcoin().cotarCompra(valor);
                
                System.out.println(reais);
                System.out.println(valorCotado);
                
                if (valorCotado < reais){    
                    double saldo = bitcoin + valor ;
                    double saldoReais = reais - valorCotado;
                    System.out.println(saldoReais);
                    dao.atualizarBitcoin(investidor,saldo);
                    System.out.println("chegou aqui");
                    
                    dao.atualizarReais(investidor, saldoReais);
                    System.out.println("chegou aqui2");
                    
                    JOptionPane.showMessageDialog(view, "Compra efetuada!");
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
