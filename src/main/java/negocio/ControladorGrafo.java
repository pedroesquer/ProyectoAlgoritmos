package negocio;

import base.Carretera;
import base.Grafo;
import base.Localidad;

public class ControladorGrafo {

    /**
     * Crea y devuelve un grafo de localidades y carreteras del estado de Guanajuato.
     * @return un objeto Grafo completamente armado.
     */
    public static Grafo getGrafo() {
        Grafo grafo = new Grafo();

        Localidad leon = new Localidad("León");
        Localidad irapuato = new Localidad("Irapuato");
        Localidad guanajuato = new Localidad("Guanajuato");
        Localidad celaya = new Localidad("Celaya");
        Localidad salamanca = new Localidad("Salamanca");
        Localidad dolores = new Localidad("Dolores Hidalgo");
        Localidad sanMiguel = new Localidad("San Miguel de Allende");

        grafo.agregarLocalidad(leon);
        grafo.agregarLocalidad(irapuato);
        grafo.agregarLocalidad(guanajuato);
        grafo.agregarLocalidad(celaya);
        grafo.agregarLocalidad(salamanca);
        grafo.agregarLocalidad(dolores);
        grafo.agregarLocalidad(sanMiguel);

        grafo.agregarCarretera(new Carretera(leon, guanajuato, 55));
        grafo.agregarCarretera(new Carretera(leon, irapuato, 65));
        grafo.agregarCarretera(new Carretera(irapuato, salamanca, 25));
        grafo.agregarCarretera(new Carretera(salamanca, celaya, 40));
        grafo.agregarCarretera(new Carretera(celaya, sanMiguel, 60));
        grafo.agregarCarretera(new Carretera(sanMiguel, dolores, 40));
        grafo.agregarCarretera(new Carretera(dolores, guanajuato, 45));
        grafo.agregarCarretera(new Carretera(irapuato, celaya, 70));

        return grafo;
    }
}
