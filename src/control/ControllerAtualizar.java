package control;

import view.Atualizar;
import java.util.Random;

/**
 *
 * @author Letizia
 */
public class ControllerAtualizar {
    private Atualizar view;
    private double cotacaoBitcoin = 323890.07;
    private double cotacaoEthereum = 15526.57;
    private double cotacaoRipple = 2.64;
    private double atualBitcoin;
    private double atualEthereum;
    private double atualRipple;
    
    Random aleatorio = new Random();

    public ControllerAtualizar(Atualizar view) {
        this.view = view;
    }
    
    public void atualizar(){
        double minBitcoin = cotacaoBitcoin - cotacaoBitcoin * 0.05;
        double maxBitcoin = cotacaoBitcoin + cotacaoBitcoin * 0.05;
        
        double minEthereum = cotacaoEthereum - cotacaoEthereum * 0.05;
        double maxEthereum = cotacaoEthereum + cotacaoEthereum * 0.05;
        
        double minRipple = cotacaoRipple - cotacaoRipple * 0.05;
        double maxRipple = cotacaoRipple + cotacaoRipple * 0.05;
        
        double atualizarBitcoin = minBitcoin + (maxBitcoin - minBitcoin) * aleatorio.nextDouble();
        atualBitcoin = atualizarBitcoin;
        
        double atualizarEthereum = minEthereum + (maxEthereum - minEthereum) * aleatorio.nextDouble();
        atualEthereum = atualizarEthereum;
        
        double atualizarRipple = minRipple + (maxRipple - minRipple) * aleatorio.nextDouble();
        atualRipple = atualizarRipple;
        
        view.getTxtBitcoin().setText(String.valueOf(atualizarBitcoin));
        view.getTxtEthereum().setText(String.valueOf(atualizarEthereum));
        view.getTxtRipple().setText(String.valueOf(atualizarRipple));
    }

    public double getAtualBitcoin() {
        return atualBitcoin;
    }

    public void setAtualBitcoin(double atualBitcoin) {
        this.atualBitcoin = atualBitcoin;
    }

    public double getAtualEthereum() {
        return atualEthereum;
    }

    public void setAtualEthereum(double atualEthereum) {
        this.atualEthereum = atualEthereum;
    }

    public double getAtualRipple() {
        return atualRipple;
    }

    public void setAtualRipple(double atualRipple) {
        this.atualRipple = atualRipple;
    }
}
