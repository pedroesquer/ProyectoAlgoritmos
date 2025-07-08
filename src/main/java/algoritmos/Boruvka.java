/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmos;

import base.Carretera;
import base.Grafo;
import base.Localidad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.graphstream.graph.Graph;
import resultados.ResultadoMST;
import visualizacion.VisualizadorUtils;

/**
 * Clase que implementa el algoritmo de Boruvka para encontrar el Árbol de 
 * Expansión Mínima de un grafo.
 * @author Pedro, Christopher y Katia
 */
public class Boruvka {
    /**
     * Ejecuta el algoritmo de Boruvka sobre un grafo
     * @param grafo Grafo lógico que contiene las localidades y carreteras.
     * @param grafoVisual Grafo visual para pintar el proceso.
     * @return Resultado del MST con las aristas seleccionadas.
     */
    public static ResultadoMST ejecutar(Grafo grafo, Graph grafoVisual) {
        List<Carretera> mst = new ArrayList<>();
        List<Carretera> aristas = new ArrayList<>(grafo.getCarreteras());

        // Inicializar conjuntos disjuntos
        Map<Localidad, Localidad> padre = new HashMap<>();
        for (Localidad loc : grafo.getLocalidades()) {
            padre.put(loc, loc);
        }

        int componentes = grafo.getLocalidades().size();

        while (componentes > 1) {
            Map<Localidad, Carretera> masBarata = new HashMap<>();

            // Para cada arista, verifica si conecta diferentes componentes
            for (Carretera c : aristas) {
                Localidad a = c.getOrigen();
                Localidad b = c.getDestino();

                Localidad raizA = encontrar(padre, a);
                Localidad raizB = encontrar(padre, b);

                if (!raizA.equals(raizB)) {
                    masBarata.putIfAbsent(raizA, c);
                    masBarata.putIfAbsent(raizB, c);

                    if (c.getPeso() < masBarata.get(raizA).getPeso()) {
                        masBarata.put(raizA, c);
                    }

                    if (c.getPeso() < masBarata.get(raizB).getPeso()) {
                        masBarata.put(raizB, c);
                    }
                }
            }

            // Agregar aristas más baratas y unir componentes
            for (Carretera c : new HashSet<>(masBarata.values())) {
                Localidad a = c.getOrigen();
                Localidad b = c.getDestino();

                Localidad raizA = encontrar(padre, a);
                Localidad raizB = encontrar(padre, b);

                if (!raizA.equals(raizB)) {
                    padre.put(raizA, raizB);
                    mst.add(c);
                    componentes--;

                    VisualizadorUtils.pintarNodo(grafoVisual, a.getNombre(), "visitado");
                    VisualizadorUtils.pintarNodo(grafoVisual, b.getNombre(), "visitado");
                    VisualizadorUtils.pintarArista(grafoVisual, a.getNombre(), b.getNombre(), "seleccionada");

                    System.out.println("Agregando arista: " + a.getNombre()
                            + " - " + b.getNombre()
                            + " (" + c.getPeso() + " km)");

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        return new ResultadoMST(mst);
    }

    /**
     * Encuentra el representante del conjunto al que pertenece una localidad.
     * @param padre Mapa de conjuntos disjuntos.
     * @param x Localidad actual.
     * @return La raíz del conjunto.
     */
    private static Localidad encontrar(Map<Localidad, Localidad> padre, Localidad x) {
        if (!padre.get(x).equals(x)) {
            padre.put(x, encontrar(padre, padre.get(x)));
        }
        return padre.get(x);
    }
}
