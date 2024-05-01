package control;

import view.Menu;
import view.VerificarSenha;

/**
 *
 * @author Letizia
 */
public class ControllerMenu {
    private Menu menu;
    
    public ControllerMenu(Menu menu){
        this.menu = menu;
    }
    
    public void consultarSaldo(){
        VerificarSenha v = new VerificarSenha();
        v.setVisible(true);
    }
}
