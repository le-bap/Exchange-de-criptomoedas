package control;

import model.Investidor;
import view.Vender;
import view.VenderBitcoin;
import view.VenderEthereum;
import view.VenderRipple;

/**
 *
 * @author Letizia
 */
public class ControllerVender {
    private Investidor investidor;
    private Vender view;

    public ControllerVender(Vender view, Investidor invetidor) {
        this.view = view;
        this.investidor = invetidor;
    }
    
    public void venderBitcoin(){
        VenderBitcoin v = new VenderBitcoin(investidor);
        v.setVisible(true);
    }
    
    public void venderEthereum(){
        VenderEthereum v = new VenderEthereum(investidor);
        v.setVisible(true);
    }
    
    public void venderRipple(){
        VenderRipple v = new VenderRipple(investidor);
        v.setVisible(true);
    }
}
