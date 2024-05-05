package model;

/**
 *
 * @author uniflbaptistella
 */
public interface Tarifacao {
    public double cotarCompra(double valor, double taxaCompra);
    public double cotarVenda(double valor, double taxaVenda);
}
