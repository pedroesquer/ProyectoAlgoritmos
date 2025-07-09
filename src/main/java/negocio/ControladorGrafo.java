package negocio;

import base.Carretera;
import base.Grafo;
import base.Localidad;
import java.util.List;

/**
 *
 * @author Pedro, Christopher y Katia
 */
public class ControladorGrafo {

    /**
     * Crea y devuelve un grafo de localidades y carreteras del estado de
     * Guanajuato.
     *
     * @return un objeto Grafo completamente armado.
     */
    public static Grafo getGrafo() {
        Grafo grafo = new Grafo();

        // Localidades con nombres cortos
        Localidad leon = new Localidad("León");
        Localidad irapuato = new Localidad("Irapuato");
        Localidad celaya = new Localidad("Celaya");
        Localidad salamanca = new Localidad("Salamanca");
        Localidad silao = new Localidad("Silao");
        Localidad sfrincon = new Localidad("S.F. del Rincón");
        Localidad vdesantiago = new Localidad("Valle de Santiago");
        Localidad sma = new Localidad("S.M. de Allende");
        Localidad gto = new Localidad("Guanajuato");
        Localidad cortazar = new Localidad("Cortazar");
        Localidad dolores = new Localidad("Dolores Hidalgo");
        Localidad acambaro = new Localidad("Acámbaro");
        Localidad purisima = new Localidad("Purísima");
        Localidad uriangato = new Localidad("Uriangato");
        Localidad slpaz = new Localidad("S.L. de la Paz");
        Localidad jrosas = new Localidad("J. Rosas");
        Localidad penjamo = new Localidad("Pénjamo");
        Localidad moroleon = new Localidad("Moroleón");
        Localidad salvatierra = new Localidad("Salvatierra");
        Localidad marfil = new Localidad("Marfil");
        Localidad sfelipe = new Localidad("San Felipe");
        Localidad apaseog = new Localidad("Apaseo el Grande");
        Localidad apaseoa = new Localidad("Apaseo el Alto");
        Localidad abasolo = new Localidad("Abasolo");
        Localidad villagran = new Localidad("Villagrán");
        Localidad sjiturbide = new Localidad("S.J. Iturbide");
        Localidad yuriria = new Localidad("Yuriria");
        Localidad romita = new Localidad("Romita");
        Localidad comonfort = new Localidad("Comonfort");
        Localidad jaral = new Localidad("Jaral del Progreso");

        // Agregar localidades al grafo
        List<Localidad> todas = List.of(leon, irapuato, celaya, salamanca, silao, sfrincon, vdesantiago, sma, gto, cortazar,
                dolores, acambaro, purisima, uriangato, slpaz, jrosas, penjamo, moroleon, salvatierra, marfil, sfelipe,
                apaseog, apaseoa, abasolo, villagran, sjiturbide, yuriria, romita, comonfort, jaral);

        todas.forEach(grafo::agregarLocalidad);

        // Conexiones (carreteras reales)
        grafo.agregarCarretera(new Carretera(leon, silao, 20));
        grafo.agregarCarretera(new Carretera(leon, sfrincon, 18));
        grafo.agregarCarretera(new Carretera(sfrincon, purisima, 7));
        grafo.agregarCarretera(new Carretera(leon, romita, 22));
        grafo.agregarCarretera(new Carretera(romita, irapuato, 25));
        grafo.agregarCarretera(new Carretera(romita, abasolo, 20));
        grafo.agregarCarretera(new Carretera(abasolo, irapuato, 18));
        grafo.agregarCarretera(new Carretera(silao, gto, 28));
        grafo.agregarCarretera(new Carretera(gto, marfil, 7));
        grafo.agregarCarretera(new Carretera(gto, dolores, 45));
        grafo.agregarCarretera(new Carretera(dolores, sma, 40));
        grafo.agregarCarretera(new Carretera(sma, comonfort, 15));
        grafo.agregarCarretera(new Carretera(comonfort, celaya, 15));
        grafo.agregarCarretera(new Carretera(celaya, jrosas, 20));
        grafo.agregarCarretera(new Carretera(celaya, cortazar, 10));
        grafo.agregarCarretera(new Carretera(cortazar, villagran, 6));
        grafo.agregarCarretera(new Carretera(celaya, salamanca, 38));
        grafo.agregarCarretera(new Carretera(salamanca, irapuato, 22));
        grafo.agregarCarretera(new Carretera(irapuato, penjamo, 55));
        grafo.agregarCarretera(new Carretera(irapuato, vdesantiago, 40));
        grafo.agregarCarretera(new Carretera(vdesantiago, yuriria, 26));
        grafo.agregarCarretera(new Carretera(yuriria, uriangato, 15));
        grafo.agregarCarretera(new Carretera(uriangato, moroleon, 5));
        grafo.agregarCarretera(new Carretera(uriangato, acambaro, 36));
        grafo.agregarCarretera(new Carretera(moroleon, salvatierra, 25));
        grafo.agregarCarretera(new Carretera(salvatierra, jaral, 28));
        grafo.agregarCarretera(new Carretera(jaral, celaya, 20));
        grafo.agregarCarretera(new Carretera(jrosas, apaseog, 25));
        grafo.agregarCarretera(new Carretera(apaseog, celaya, 15));
        grafo.agregarCarretera(new Carretera(apaseog, apaseoa, 10));
        grafo.agregarCarretera(new Carretera(jrosas, sjiturbide, 35));
        grafo.agregarCarretera(new Carretera(sjiturbide, slpaz, 30));
        grafo.agregarCarretera(new Carretera(marfil, sfelipe, 36));
        grafo.agregarCarretera(new Carretera(comonfort, apaseog, 22));
        grafo.agregarCarretera(new Carretera(jaral, vdesantiago, 17));

        return grafo;
    }

}
