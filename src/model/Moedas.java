
package model;

/**
 *
 * @author uniflbaptistella
 */
public abstract class Moedas{
    private double taxaCompra, taxaVenda, saldo;

    public Moedas(double taxaCompra, double taxaVenda, double saldo) {
        this.taxaCompra = taxaCompra;
        this.taxaVenda = taxaVenda;
        this.saldo = saldo;
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
}