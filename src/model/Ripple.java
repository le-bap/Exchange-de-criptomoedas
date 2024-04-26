
package model;

/**
 *
 * @author uniflbaptistella
 */
public class Ripple extends Moedas implements Tarifacao{

    @Override
    public double cotarCopra() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public double cotarVenda() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
