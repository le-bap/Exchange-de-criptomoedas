
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
        return (valorDigitado + valorDigitado*taxaCompra) * valor;
    }

    @Override
    public double cotarVenda(double valorDigitado, double taxaVenda) {
        return (valorDigitado - valorDigitado*taxaVenda) * valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
