
package model;

/**
 *
 * @author uniflbaptistella
 */
public abstract class Moedas{
    private double taxaCompra;
    private double taxaVenda;

    public Moedas(double taxaCompra, double taxaVenda) {
        this.taxaCompra = taxaCompra;
        this.taxaVenda = taxaVenda;
    }
    
}