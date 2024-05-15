package control;

import view.Atualizar;
import java.util.Random;
import model.Investidor;

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
    
    private Investidor investidor;

    public ControllerAtualizar(Atualizar view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
        double minBitcoin = cotacaoBitcoin - cotacaoBitcoin * 0.05;
        double maxBitcoin = cotacaoBitcoin + cotacaoBitcoin * 0.05;
        
        double minEthereum = cotacaoEthereum - cotacaoEthereum * 0.05;
        double maxEthereum = cotacaoEthereum + cotacaoEthereum * 0.05;
        
        double minRipple = cotacaoRipple - cotacaoRipple * 0.05;
        double maxRipple = cotacaoRipple + cotacaoRipple * 0.05;
        
        double atualizarBitcoin = minBitcoin + (maxBitcoin - minBitcoin) * aleatorio.nextDouble();
        investidor.getCarteira().getBitcoin().setValor(atualizarBitcoin);
        
        double atualizarEthereum = minEthereum + (maxEthereum - minEthereum) * aleatorio.nextDouble();
        investidor.getCarteira().getEthereum().setValor(atualizarEthereum);
        
        double atualizarRipple = minRipple + (maxRipple - minRipple) * aleatorio.nextDouble();
        investidor.getCarteira().getRipple().setValor(atualizarRipple);
        
        view.getTxtBitcoin().setText(String.valueOf(atualizarBitcoin));
        view.getTxtEthereum().setText(String.valueOf(atualizarEthereum));
        view.getTxtRipple().setText(String.valueOf(atualizarRipple));
    }
    
    public void atualizar(){
        double minBitcoin = cotacaoBitcoin - cotacaoBitcoin * 0.05;
        double maxBitcoin = cotacaoBitcoin + cotacaoBitcoin * 0.05;
        
        double minEthereum = cotacaoEthereum - cotacaoEthereum * 0.05;
        double maxEthereum = cotacaoEthereum + cotacaoEthereum * 0.05;
        
        double minRipple = cotacaoRipple - cotacaoRipple * 0.05;
        double maxRipple = cotacaoRipple + cotacaoRipple * 0.05;
        
        double atualizarBitcoin = minBitcoin + (maxBitcoin - minBitcoin) * aleatorio.nextDouble();
        investidor.getCarteira().getBitcoin().setValor(atualizarBitcoin);
        
        double atualizarEthereum = minEthereum + (maxEthereum - minEthereum) * aleatorio.nextDouble();
        investidor.getCarteira().getEthereum().setValor(atualizarEthereum);
        
        double atualizarRipple = minRipple + (maxRipple - minRipple) * aleatorio.nextDouble();
        investidor.getCarteira().getRipple().setValor(atualizarRipple);
        
        view.getTxtBitcoin().setText(String.valueOf(atualizarBitcoin));
        view.getTxtEthereum().setText(String.valueOf(atualizarEthereum));
        view.getTxtRipple().setText(String.valueOf(atualizarRipple));
    }
}
