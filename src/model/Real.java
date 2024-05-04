
package model;

/**
 *
 * @author uniflbaptistella
 */
public class Real extends Moedas implements Tarifacao{

    public Real(double taxaCompra, double taxaVenda, double saldo) {
        super(taxaCompra, taxaVenda, saldo);
    }


    @Override
    public double cotarCompra(double valor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double cotarVenda(double valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
