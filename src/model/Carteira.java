
package model;

import control.ControllerAtualizar;

/**
 *
 * @author uniflbaptistella
 */
public class Carteira {
    private Bitcoin bitcoin;
    private Ethereum ethereum;
    private Ripple ripple;
    private Real real;
    
    public Carteira(){
        bitcoin = new Bitcoin(0.02, 0.03);
        ethereum = new Ethereum(0.01, 0.02);
        ripple = new Ripple(0.01, 0.01);
        real = new Real(0, 0);
    }

    public Bitcoin getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(Bitcoin bitcoin) {
        this.bitcoin = bitcoin;
    }

    public Ethereum getEthereum() {
        return ethereum;
    }

    public void setEthereum(Ethereum ethereum) {
        this.ethereum = ethereum;
    }

    public Ripple getRipple() {
        return ripple;
    }

    public void setRipple(Ripple ripple) {
        this.ripple = ripple;
    }

    public Real getReal() {
        return real;
    }

    public void setReal(Real real) {
        this.real = real;
    }
    
    
}
