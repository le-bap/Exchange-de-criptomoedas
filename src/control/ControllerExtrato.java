package control;

import model.Investidor;
import view.ConsultarExtrato;

/**
 *
 * @author Letizia
 */
public class ControllerExtrato {
    private Investidor investidor;
    private ConsultarExtrato view;

    public ControllerExtrato(ConsultarExtrato view, Investidor invetidor) {
        this.view = view;
        this.investidor = invetidor;
    }
}
