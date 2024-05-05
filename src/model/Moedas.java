
package model;

/**
 *
 * @author uniflbaptistella
 */
public abstract class Moedas{
    private double taxaCompra, taxaVenda;

    public Moedas(double taxaCompra, double taxaVenda) {
        this.taxaCompra = taxaCompra;
        this.taxaVenda = taxaVenda;
    }

    public double getTaxaCompra() {
        return taxaCompra;
    }

    public void setTaxaCompra(double taxaCompra) {
        this.taxaCompra = taxaCompra;
    }

    public double getTaxaVenda() {
        return taxaVenda;
    }

    public void setTaxaVenda(double taxaVenda) {
        this.taxaVenda = taxaVenda;
    }
}