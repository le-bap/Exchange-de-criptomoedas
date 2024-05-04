
package model;

/**
 *
 * @author uniflbaptistella
 */
public class Bitcoin extends Moedas implements Tarifacao{
    
    public Bitcoin(double taxaCompra, double taxaVenda, double saldo) {
        super(taxaCompra, taxaVenda, saldo);
    }

    
    @Override
    public double cotarCompra(double valor) {
        return valor + valor*0.02;
    }

    @Override
    public double cotarVenda(double valor) {
        return valor + valor*0.03;
    }
    
}
