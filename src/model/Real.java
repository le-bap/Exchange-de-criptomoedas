
package model;

/**
 *
 * @author uniflbaptistella
 */
public class Real extends Moedas implements Tarifacao{

    public Real(double taxaCompra, double taxaVenda) {
        super(taxaCompra, taxaVenda);
    }

    @Override
    public double cotarCompra(double valor, double taxaVenda) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double cotarVenda(double valor, double taxaVenda) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
