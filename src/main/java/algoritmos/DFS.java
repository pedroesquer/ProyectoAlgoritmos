package algoritmos;

import base.Grafo;
import base.Localidad;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import org.graphstream.graph.Graph;
import resultados.ResultadoDFS;
import visualizacion.VisualizadorUtils;

/**
 * Implementa el algoritmo DFS (Depth-First Search) sobre un grafo lógico,
 * iniciando desde una localidad, y visualiza el recorrido en un grafo visual.
 *
 * @author Pedro
 */
public class DFS {

    /**
     * Ejecuta DFS sobre un grafo lógico y lo representa visualmente.
     *
     * @param grafo Grafo lógico con localidades y carreteras.
     * @param origen Localidad inicial desde donde parte el DFS.
     * @param grafoVisual Grafo de GraphStream para mostrar el recorrido.
     * @return ResultadoDFS con predecesores y orden de visita.
     */
    public static ResultadoDFS ejecutar(Grafo grafo, Localidad origen, Graph grafoVisual) {
        Map<Localidad, Localidad> predecesores = new HashMap<>();
        Set<Localidad> visitados = new HashSet<>();
        Stack<Localidad> pila = new Stack<>();

        pila.push(origen);
        visitados.add(origen);

        System.out.println("Inicio en: " + origen.getNombre());
        VisualizadorUtils.pintarNodo(grafoVisual, origen.getNombre(), "visitado");

        while (!pila.isEmpty()) {
            Localidad actual = pila.pop();
            System.out.println("Procesando: " + actual.getNombre());

            for (Localidad vecino : grafo.obtenerVecinos(actual)) {
                if (!visitados.contains(vecino)) {
                    predecesores.put(vecino, actual);
                    visitados.add(vecino);
                    pila.push(vecino);

                    System.out.println("Descubierto: " + vecino.getNombre() + " desde " + actual.getNombre());
                    VisualizadorUtils.pintarNodo(grafoVisual, vecino.getNombre(), "visitado");
                    VisualizadorUtils.pintarArista(grafoVisual, actual.getNombre(), vecino.getNombre(), "seleccionada");

                    try {
                        Thread.sleep(500); // Pausa para animación
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        return new ResultadoDFS(predecesores);
    }
}
