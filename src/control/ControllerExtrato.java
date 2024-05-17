package control;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Investidor;
import view.ConsultarExtrato;

/**
 *
 * @author Letizia
 */
public class ControllerExtrato {
    private Investidor investidor;
    private ConsultarExtrato view;

    public ControllerExtrato(ConsultarExtrato view, Investidor invetidor) {
        this.view = view;
        this.investidor = invetidor;
        view.getLblNome().setText(invetidor.getNome());
        view.getLblCpf().setText(investidor.getCpf());
        this.gerarExtrato();
    }
    
    public void gerarExtrato(){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(investidor);

            if (res.next()){
                int id = res.getInt("id");
                ResultSet res2 = dao.listarExtrato(investidor, id);
                StringBuilder extratoText = new StringBuilder(); 
                SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                DecimalFormat df = new DecimalFormat("#0.00");
                
                while (res2.next()){
                    Date data = res2.getTimestamp("data");
                    String op;
                    if (res2.getBoolean("tipo") == true){
                        op = "+";
                    }else{
                        op = "-";
                    }
                    String valor = String.valueOf(df.format(res2.getDouble("valor")));
                    String cotacao = String.valueOf(df.format(res2.getDouble("cotacao")));
                    String nomeMoeda = String.valueOf(res2.getString("nome_moeda"));
                    String reais = String.valueOf(df.format(res2.getDouble("reais")));
                    String bitcoin = String.valueOf(res2.getDouble("bitcoin"));
                    String ethereum = String.valueOf(res2.getDouble("ethereum"));
                    String ripple = String.valueOf(res2.getDouble("ripple"));

                    String dataFormatada = formatar.format(data); 

                    extratoText.append(dataFormatada).append("  ").append(op).append(" ").append(valor)
                        .append("  ").append(nomeMoeda).append("  CT: ").append(cotacao)
                        .append("  REAL: ").append(reais).append("  BTC: ").append(bitcoin)
                        .append("  ETH: ").append(ethereum).append("  XRP: ").append(ripple)
                        .append("\n\n"); 
                }

                // Definir o texto completo no campo de texto após o loop
                view.getTxtResult().setText(extratoText.toString());
            }

        }
        catch(SQLException e){
            System.out.println(e);
        }

    }

}
