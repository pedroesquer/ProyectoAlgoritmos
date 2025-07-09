package negocio;

import base.Grafo;
import presentacion.PantallaKruskal;
import presentacion.MenuMST;
import presentacion.MenuRutaCorta;
import presentacion.PantallaBoruvka;
import presentacion.PantallaPrim;
import presentacion.Recorridos;
import presentacion.MenuPrincipal;
import presentacion.Matriz;

/**
 *
 * @author Pedro, Christopher y Katia
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

    public void abrirPantallaRecorridos() {
        Recorridos frameRecorridos = new Recorridos();
        frameRecorridos.setVisible(true);
    }

    public void menuPrincipalVisible() {
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
    }

    public void abrirPantallaMenuMST() {
        MenuMST menuMST = new MenuMST();
        menuMST.setVisible(true);
    }

    public void abrirPantallaKruskal() {
        PantallaKruskal kruskal = new PantallaKruskal();
        kruskal.setVisible(true);
    }

    public void abrirPantallaPrim() {
        PantallaPrim prim = new PantallaPrim();
        prim.setVisible(true);
    }

    public void abrirPantallaBoruvka() {
        PantallaBoruvka boruvka = new PantallaBoruvka();
        boruvka.setVisible(true);
    }

    public void abrirRutaMasCorta() {
        MenuRutaCorta rc = new MenuRutaCorta();
        rc.setVisible(true);
    }

    public void abrirTablaGrafo(Grafo grafo) {
        Matriz matriz = new Matriz(grafo);
        matriz.setVisible(true);

    }

}
