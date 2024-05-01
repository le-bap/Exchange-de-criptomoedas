
package model;

/**
 *
 * @author uniflbaptistella
 */
public class Carteira {
    public Carteira(){
        Bitcoin bitcoin = new Bitcoin(0.02, 0.03);
        Ethereum ethereum = new Ethereum(0.01, 0.02);
        Ripple ripple = new Ripple(0.01, 0.01);
        Real real = new Real(0, 0);
    }
}
