/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmos;

import base.Carretera;
import base.Grafo;
import base.Localidad;

import java.util.*;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import visualizacion.VisualizadorUtils;

/**
 *
 * @author Pedro, Christopher y Katia
 */
public class Dijkstra {

    public static void ejecutar(Grafo grafo, Localidad origen, Localidad destino, Graph grafoVisual) throws InterruptedException {
        Map<Localidad, Double> distancias = new HashMap<>();
        Map<Localidad, Localidad> anteriores = new HashMap<>();
        Set<Localidad> visitados = new HashSet<>();
        PriorityQueue<Localidad> cola = new PriorityQueue<>(Comparator.comparingDouble(distancias::get));

        for (Localidad l : grafo.getLocalidades()) {
            distancias.put(l, Double.POSITIVE_INFINITY);
        }

        distancias.put(origen, 0.0);
        cola.add(origen);

        while (!cola.isEmpty()) {
            Localidad actual = cola.poll();
            if (!visitados.add(actual)) {
                continue;
            }

            VisualizadorUtils.pintarNodo(grafoVisual, actual.getNombre(), "amarillo");
            Thread.sleep(300);

            if (actual.equals(destino)) {
                break;
            }

            for (Carretera carretera : grafo.getCarreteras()) {
                if (carretera.getOrigen().equals(actual)) {
                    Localidad vecino = carretera.getDestino();
                    double nuevaDistancia = distancias.get(actual) + carretera.getPeso();

                    if (nuevaDistancia < distancias.get(vecino)) {
                        distancias.put(vecino, nuevaDistancia);
                        anteriores.put(vecino, actual);
                        cola.add(vecino);
                    }
                }
            }

        }

        // Pintar el camino más corto
        Localidad actual = destino;
        while (anteriores.containsKey(actual)) {
            Localidad anterior = anteriores.get(actual);
            VisualizadorUtils.pintarArista(grafoVisual, anterior.getNombre(), actual.getNombre(), "azul");
            VisualizadorUtils.pintarNodo(grafoVisual, actual.getNombre(), "verde");
            actual = anterior;
            Thread.sleep(400);
        }

        VisualizadorUtils.pintarNodo(grafoVisual, origen.getNombre(), "rojo");
    }
}
