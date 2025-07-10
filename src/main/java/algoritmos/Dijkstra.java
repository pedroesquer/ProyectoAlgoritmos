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

    /**
     * Ejecuta el algoritmo de Dijkstra para encontrar la ruta más corta entre  
     *
     * @param grafo Grafo lógico con las localidades y carreteras
     * @param origen Localidad de inicio
     * @param destino Localidad de destino
     * @param grafoVisual Grafo visual para pintar el recorrido
     * @return ResultadoCamino con la lista de localidades recorridas y la
     * distancia total
     */
    public static ResultadoCamino ejecutar(Grafo grafo, Localidad origen, Localidad destino, Graph grafoVisual) throws InterruptedException {
        Map<Localidad, Double> distancias = new HashMap<>();
        Map<Localidad, Localidad> anteriores = new HashMap<>();
        Set<Localidad> visitados = new HashSet<>();

        // Cola de prioridad que ordena por distancia mínima (menor primero)
        PriorityQueue<Localidad> cola = new PriorityQueue<>(Comparator.comparingDouble(distancias::get));

        
        for (Localidad l : grafo.getLocalidades()) {
            distancias.put(l, Double.POSITIVE_INFINITY);
        }
        distancias.put(origen, 0.0);
        cola.add(origen);
        

        
        while (!cola.isEmpty()) {
            Localidad actual = cola.poll(); // Se toma la localidad con menor distancia estimada

            if (!visitados.add(actual)) {
                continue;
            }

            // Pintar el nodo actual como "visitado"
            VisualizadorUtils.pintarNodo(grafoVisual, actual.getNombre(), "visitado");
            Thread.sleep(300);

            // Si llegamos al destino, terminamos el algoritmo
            if (actual.equals(destino)) {
                break;
            }

            // Evaluar vecinos del nodo actual
            for (Carretera carretera : grafo.getCarreteras()) {
                Localidad vecino = null;

                //buscamos en ambos sentidos por ser un grafo no dirigido
                if (carretera.getOrigen().equals(actual)) {
                    vecino = carretera.getDestino();
                } else if (carretera.getDestino().equals(actual)) {
                    vecino = carretera.getOrigen();
                }

                // Si encontramos un vecino no visitado
                if (vecino != null && !visitados.contains(vecino)) {
                    double nuevaDistancia = distancias.get(actual) + carretera.getPeso();

                    // Si encontramos una mejor distancia, actualizamos
                    if (nuevaDistancia < distancias.get(vecino)) {
                        distancias.put(vecino, nuevaDistancia);
                        anteriores.put(vecino, actual);
                        // Lo agregamos a la cola para evaluar después
                        cola.add(vecino);
                    }
                }
            }
        }

        //Pintar la ruta más corta desde destino hasta origen
        Localidad actual = destino;
        while (anteriores.containsKey(actual)) {
            Localidad anterior = anteriores.get(actual);

            VisualizadorUtils.pintarArista(grafoVisual, anterior.getNombre(), actual.getNombre(), "seleccionada");
            VisualizadorUtils.pintarNodo(grafoVisual, actual.getNombre(), "destino");

            actual = anterior;
            Thread.sleep(400);
        }

        // Pintamos el nodo de origen
        VisualizadorUtils.pintarNodo(grafoVisual, origen.getNombre(), "origen");

        // origen → destino
        List<Localidad> camino = new ArrayList<>();
        actual = destino;

        // Se reconstruye el camino usando el mapa de "anteriores"
        while (actual != null) {
            camino.add(0, actual); // Insertar al inicio para mantener el orden correcto
            actual = anteriores.get(actual);
        }

        System.out.println("Distancia total del camino más corto: " + distancias.get(destino) + " km");
        return new ResultadoCamino(camino, distancias.get(destino));
    }
}
