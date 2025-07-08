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

    public static ResultadoCamino ejecutar(Grafo grafo, Localidad origen, Localidad destino, Graph grafoVisual) throws InterruptedException {
        Map<Localidad, Double> distancias = new HashMap<>();
        Map<Localidad, Localidad> anteriores = new HashMap<>();

        for (Localidad l : grafo.getLocalidades()) {
            distancias.put(l, Double.POSITIVE_INFINITY);
        }
        distancias.put(origen, 0.0);

        int V = grafo.getLocalidades().size();

        // Relajar todas las aristas V - 1 veces (ambos sentidos)
        for (int i = 0; i < V - 1; i++) {
            for (Carretera c : grafo.getCarreteras()) {
                Localidad u = c.getOrigen();
                Localidad v = c.getDestino();
                double peso = c.getPeso();

                // Relajar u → v
                if (distancias.get(u) + peso < distancias.get(v)) {
                    distancias.put(v, distancias.get(u) + peso);
                    anteriores.put(v, u);
                }

                // Relajar v → u
                if (distancias.get(v) + peso < distancias.get(u)) {
                    distancias.put(u, distancias.get(v) + peso);
                    anteriores.put(u, v);
                }
            }
        }

        // Verificar ciclos negativos 
        for (Carretera c : grafo.getCarreteras()) {
            Localidad u = c.getOrigen();
            Localidad v = c.getDestino();
            double peso = c.getPeso();

            if (distancias.get(u) + peso < distancias.get(v) || distancias.get(v) + peso < distancias.get(u)) {
                throw new RuntimeException("El grafo contiene un ciclo de peso negativo");
            }
        }

// Construir lista del camino
        List<Localidad> camino = new ArrayList<>();
        Localidad actual = destino;
        while (actual != null) {
            camino.add(0, actual);
            actual = anteriores.get(actual);
        }

// Pintar la ruta en orden (origen → destino)
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
