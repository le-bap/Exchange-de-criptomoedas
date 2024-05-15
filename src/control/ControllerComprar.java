package control;

import model.Investidor;
import view.Comprar;
import view.ComprarBitcoin;
import view.ComprarEthereum;
import view.ComprarRipple;

/**
 *
 * @author Letizia
 */
public class ControllerComprar {
    private Investidor investidor;
    private Comprar view;

    public ControllerComprar(Comprar view, Investidor invetidor) {
        this.view = view;
        this.investidor = invetidor;
    }
    
    public void comprarBitcoin(){
        ComprarBitcoin c = new ComprarBitcoin(investidor);
        c.setVisible(true);
        view.setVisible(false);
    }
    
    public void comprarEthereum(){
        ComprarEthereum c = new ComprarEthereum(investidor);
        c.setVisible(true);
        view.setVisible(false);
    }
    
    public void comprarRipple(){
        ComprarRipple c = new ComprarRipple(investidor);
        c.setVisible(true);
        view.setVisible(false);
    }
}
