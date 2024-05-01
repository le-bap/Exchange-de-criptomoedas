
package control;

import DAO.Conexao;
import model.Investidor;
import view.ConsultarSaldo;
import view.VerificarSenha;

/**
 *
 * @author Letizia
 */
public class ControllerConsultarSaldo {
     private ConsultarSaldo view;
     private Investidor investidor;

    public ControllerConsultarSaldo(ConsultarSaldo view, Investidor investidor){
        this.view = view;
        this.investidor = investidor;
    }
    
    public void listar(){
        String cpf = investidor.getCpf();
        String nome = investidor.getNome();
 
        view.getLblNome().setText(nome);
        view.getLblCpf().setText(nome);
    }
}
