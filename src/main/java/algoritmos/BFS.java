package algoritmos;

/**
 *
 * @author Pedro, Chistopher y Katia
 */
import base.Grafo;
import base.Localidad;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.graphstream.graph.Graph;
import resultados.ResultadoBFS;
import visualizacion.VisualizadorUtils;

public class BFS {

    /**
     * Ejecuta el algoritmo BFS sobre un grafo lógico, desde una localidad
     * inicial, y visualiza el árbol de expansión sobre el grafo visual.
     *
     * @param grafo El grafo lógico con las localidades y aristas.
     * @param origen La localidad desde donde se inicia el recorrido.
     * @param grafoVisual El grafo visual de GraphStream para pintar nodos y
     * aristas.
     * @return Objeto con las distancias y predecesores para reconstruir rutas.
     */
    public static ResultadoBFS ejecutar(Grafo grafo, Localidad origen, Graph grafoVisual) {
        Map<Localidad, Integer> distancias = new LinkedHashMap<>();
        Map<Localidad, Localidad> predecesores = new LinkedHashMap<>();
        Queue<Localidad> cola = new LinkedList<>();
        Set<Localidad> visitados = new HashSet<>();

        distancias.put(origen, 0);
        cola.add(origen);
        visitados.add(origen);

        System.out.println("Inicio en: " + origen.getNombre());
        VisualizadorUtils.pintarNodo(grafoVisual, origen.getNombre(), "visitado");

        while (!cola.isEmpty()) {
            Localidad actual = cola.poll();
            System.out.println("Procesando: " + actual.getNombre());

            for (Localidad vecino : grafo.obtenerVecinos(actual)) {
                if (!visitados.contains(vecino)) {
                    distancias.put(vecino, distancias.get(actual) + 1);
                    predecesores.put(vecino, actual);
                    cola.add(vecino);
                    visitados.add(vecino);

                    System.out.println("Descubierto: " + vecino.getNombre() + " desde " + actual.getNombre());
                    VisualizadorUtils.pintarNodo(grafoVisual, vecino.getNombre(), "visitado");
                    VisualizadorUtils.pintarArista(grafoVisual, actual.getNombre(), vecino.getNombre(), "seleccionada");

                    try {
                        Thread.sleep(500); // Animación
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        return new ResultadoBFS(distancias, predecesores);
    }
}
