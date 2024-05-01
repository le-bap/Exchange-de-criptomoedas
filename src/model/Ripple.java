
package model;

/**
 *
 * @author uniflbaptistella
 */
public class Ripple extends Moedas implements Tarifacao{

    public Ripple(double taxaCompra, double taxaVenda, double saldo) {
        super(taxaCompra, taxaVenda, saldo);
    }

    @Override
    public double cotarCopra() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public double cotarVenda() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
