package negocio;

import presentacion.MenuPrincipal;
import presentacion.Recorridos;

/**
 *
 * @author pedro
 */
public class ControladorVisual {

    private static ControladorVisual instancia;

    public ControladorVisual() {
    }

    public static ControladorVisual getInstancia() {
        if (instancia == null) {
            instancia = new ControladorVisual();
        }
        return instancia;
    }
    
    public void abrirPantallaRecorridos(){
        Recorridos frameRecorridos = new Recorridos();
        frameRecorridos.setVisible(true);
    }
    
    public void menuPrincipalVisible(){
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
    }
}
