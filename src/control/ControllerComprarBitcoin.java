package control;

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
        
    }
}
