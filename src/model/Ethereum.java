
package model;

/**
 *
 * @author uniflbaptistella
 */
public class Ethereum extends Moedas implements Tarifacao{
    private double valor; 
    
    public Ethereum(double taxaCompra, double taxaVenda) {
        super(taxaCompra, taxaVenda);
    }

    @Override
    public double cotarCompra(double valorDigitado, double taxaCompra) {
        return valor + (taxaCompra * valor) * valorDigitado;
    }

    @Override
    public double cotarVenda(double valorDigitado, double taxaVenda) {
        return valor + (taxaVenda * valor) * valorDigitado;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
