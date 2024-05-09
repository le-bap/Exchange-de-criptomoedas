
package model;

/**
 *
 * @author uniflbaptistella
 */
public class Bitcoin extends Moedas implements Tarifacao{
    
    public Bitcoin(double taxaCompra, double taxaVenda) {
        super(taxaCompra, taxaVenda);
    }

    @Override
    public double cotarCompra(double valor, double taxaCompra) {
        return valor + valor*taxaCompra;
    }

    @Override
    public double cotarVenda(double valor, double taxaVenda) {
        return valor - valor*taxaVenda;
    }
    
}
