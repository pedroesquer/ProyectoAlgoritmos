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
import resultados.ResultadoCamino;
import visualizacion.VisualizadorUtils;

/**
 *
 * @author Chris
 */
public class Dijkstra {

    public static ResultadoCamino ejecutar(Grafo grafo, Localidad origen, Localidad destino, Graph grafoVisual) throws InterruptedException {
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

            VisualizadorUtils.pintarNodo(grafoVisual, actual.getNombre(), "visitado");
            Thread.sleep(300);

            if (actual.equals(destino)) {
                break;
            }

            for (Carretera carretera : grafo.getCarreteras()) {
                Localidad vecino = null;
                if (carretera.getOrigen().equals(actual)) {
                    vecino = carretera.getDestino();
                } else if (carretera.getDestino().equals(actual)) {
                    vecino = carretera.getOrigen();
                }

                if (vecino != null && !visitados.contains(vecino)) {
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
            VisualizadorUtils.pintarArista(grafoVisual, anterior.getNombre(), actual.getNombre(), "seleccionada");
            VisualizadorUtils.pintarNodo(grafoVisual, actual.getNombre(), "destino");
            actual = anterior;
            Thread.sleep(400);
        }

        VisualizadorUtils.pintarNodo(grafoVisual, origen.getNombre(), "origen");

        // Armar el camino en orden
        List<Localidad> camino = new ArrayList<>();
        actual = destino;
        while (actual != null) {
            camino.add(0, actual);
            actual = anteriores.get(actual);
        }

        System.out.println("Distancia total del camino más corto: " + distancias.get(destino) + " km");
        return new ResultadoCamino(camino, distancias.get(destino));
    }

}
