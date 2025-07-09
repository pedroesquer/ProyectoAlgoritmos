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
import resultados.ResultadoCamino;
import visualizacion.VisualizadorUtils;

/**
 *
 * @author Pedro, Christopher y Katia
 */
public class BellmanFord {

    /**
     * Ejecuta el algoritmo de Bellman-Ford para encontrar el camino más corto entre dos localidades,
     * 
     * @param grafo Grafo lógico con localidades y carreteras
     * @param origen Localidad de inicio
     * @param destino Localidad destino
     * @param grafoVisual Grafo visual para la animación
     * @return ResultadoCamino con la ruta y la distancia total
     */
    public static ResultadoCamino ejecutar(Grafo grafo, Localidad origen, Localidad destino, Graph grafoVisual) throws InterruptedException {
        Map<Localidad, Double> distancias = new HashMap<>();
        Map<Localidad, Localidad> anteriores = new HashMap<>();

        //Inicializamos todas las distancias a infinito menos el origen
        for (Localidad l : grafo.getLocalidades()) {
            distancias.put(l, Double.POSITIVE_INFINITY);
        }
        distancias.put(origen, 0.0);

        int V = grafo.getLocalidades().size();


        //Relajamos todas las aristas menos 1 (se relaja dos veces por ser no dirigido)
        
        for (int i = 0; i < V - 1; i++) {
            for (Carretera c : grafo.getCarreteras()) {
                Localidad u = c.getOrigen();
                Localidad v = c.getDestino();
                double peso = c.getPeso();

                // Primera relajacion u → v
                if (distancias.get(u) + peso < distancias.get(v)) {
                    distancias.put(v, distancias.get(u) + peso);
                    anteriores.put(v, u);
                }

                // Segunda relajacio v → u 
                if (distancias.get(v) + peso < distancias.get(u)) {
                    distancias.put(u, distancias.get(v) + peso);
                    anteriores.put(u, v);
                }
            }
        }

        // Verificamos si existen ciclos negativos 
        for (Carretera c : grafo.getCarreteras()) {
            Localidad u = c.getOrigen();
            Localidad v = c.getDestino();
            double peso = c.getPeso();

            //Si si encuentra un cilco negativo arrojamos exception
            if (distancias.get(u) + peso < distancias.get(v) || distancias.get(v) + peso < distancias.get(u)) {
                throw new RuntimeException("El grafo contiene un ciclo de peso negativo");
            }
        }

        // Reconstruir el camino más corto desde el destino hacia el origen
        List<Localidad> camino = new ArrayList<>();
        Localidad actual = destino;

        // Se recorre hacia atrás desde el destino, siguiendo el mapa de "anteriores"
        // hasta llegar al origen. Se inserta cada localidad al inicio de la lista.
        while (actual != null) {
            camino.add(0, actual); // Insertamos al inicio para mantener el orden origen → destino
            actual = anteriores.get(actual); // Saltamos al nodo anterior en el camino
        }

        //Visualizar el camino encontrado paso a paso
        for (int i = 0; i < camino.size() - 1; i++) {
            Localidad u = camino.get(i);
            Localidad v = camino.get(i + 1);
            VisualizadorUtils.pintarArista(grafoVisual, u.getNombre(), v.getNombre(), "seleccionada");
            VisualizadorUtils.pintarNodo(grafoVisual, v.getNombre(), "destino");
            Thread.sleep(400);
        }
        VisualizadorUtils.pintarNodo(grafoVisual, origen.getNombre(), "origen");

        return new ResultadoCamino(camino, distancias.get(destino));
    }
}

