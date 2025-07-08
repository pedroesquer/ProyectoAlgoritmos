package negocio;

import presentacion.PantallaKruskal;
import presentacion.Menu2;
import presentacion.MenuMST;
import presentacion.MenuPrincipal;
import presentacion.MenuRutaCorta;
import presentacion.PantallaBoruvka;
import presentacion.PantallaPrim;
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
        Menu2 menu = new Menu2();
        menu.setVisible(true);
    }
    
    public void abrirPantallaMenuMST(){
        MenuMST menuMST = new MenuMST();
        menuMST.setVisible(true);
    }
    
    public void abrirPantallaKruskal(){
        PantallaKruskal kruskal = new PantallaKruskal();
        kruskal.setVisible(true);
    }
    
    public void abrirPantallaPrim(){
        PantallaPrim prim = new PantallaPrim();
        prim.setVisible(true);
    }
    
    public void abrirPantallaBoruvka(){
        PantallaBoruvka boruvka = new PantallaBoruvka();
        boruvka.setVisible(true);
    }
    
    public void abrirRutaMasCorta(){
        MenuRutaCorta rc = new MenuRutaCorta();
        rc.setVisible(true);
    }
    
    
}
