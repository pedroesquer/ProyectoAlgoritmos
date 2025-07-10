package algoritmos;

import base.Grafo;
import base.Localidad;
import java.util.*;
import org.graphstream.graph.Graph;
import resultados.ResultadoDFS;
import visualizacion.VisualizadorUtils;

/**
 * Implementación recursiva del algoritmo DFS (Depth-First Search)
 *

 *
 * @author Pedro, Christopher y Katia
 */
public class DFS {

    private static Map<Localidad, Localidad> predecesores;
    private static Set<Localidad> visitados;
    private static Graph grafoVisual;

    /**
     * Ejecuta DFS sobre el grafo y pinta el recorrido.
     *
     * @param grafo Grafo lógico.
     * @param origen Nodo de inicio.
     * @param visual Grafo visual.
     * @return Resultado con predecesores.
     */
    

    public static ResultadoDFS ejecutar(Grafo grafo, Graph visual) {
        visitados = new HashSet<>();
        predecesores = new LinkedHashMap<>();
        grafoVisual = visual;

        // Visita cada componente del grafo
        for (Localidad u : grafo.getLocalidades()) {
            if (!visitados.contains(u)) {
                dfsVisitar(grafo, u);
            }
        }

        return new ResultadoDFS(predecesores);
    }

    private static void dfsVisitar(Grafo grafo, Localidad u) {
        visitados.add(u);
        System.out.println("Procesando: " + u.getNombre());
        VisualizadorUtils.pintarNodo(grafoVisual, u.getNombre(), "visitado");

        for (Localidad v : grafo.obtenerVecinos(u)) {
            if (!visitados.contains(v)) {
                predecesores.put(v, u);
                VisualizadorUtils.pintarArista(grafoVisual, u.getNombre(), v.getNombre(), "seleccionada");

                try {
                    Thread.sleep(500); // animación visual
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                dfsVisitar(grafo, v);
            }
        }
    }
}