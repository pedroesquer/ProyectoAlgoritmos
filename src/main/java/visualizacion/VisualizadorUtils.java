package visualizacion;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

/**
 *
 * @author Pedro, Chistopher y Katia
 */
public class VisualizadorUtils {

    /**
     * Pinta visualmente un nodo del grafo con un estilo definido en el
     * stylesheet.
     *
     * @param graph El grafo visual (GraphStream).
     * @param nombreNodo El ID del nodo a pintar (normalmente es el nombre de la
     * localidad).
     * @param estilo El nombre de clase CSS definida en el stylesheet (ej:
     * "visitado", "origen", etc.).
     */
    public static void pintarNodo(Graph graph, String nombreNodo, String estilo) {
        if (graph.getNode(nombreNodo) != null) {
            graph.getNode(nombreNodo).setAttribute("ui.class", estilo);
        }
    }

    /**
     * Pinta una arista entre dos nodos en el grafo, buscando en ambos sentidos.
     * Útil para grafos no dirigidos.
     *
     * @param graph El grafo visual.
     * @param nodo1 Nombre del nodo 1.
     * @param nodo2 Nombre del nodo 2.
     * @param estilo Clase visual a aplicar (definida en el stylesheet).
     */
    public static void pintarArista(Graph graph, String nodo1, String nodo2, String estilo) {
        String id1 = nodo1 + "-" + nodo2;
        String id2 = nodo2 + "-" + nodo1;

        if (graph.getEdge(id1) != null) {
            graph.getEdge(id1).setAttribute("ui.class", estilo);
        } else if (graph.getEdge(id2) != null) {
            graph.getEdge(id2).setAttribute("ui.class", estilo);
        }
    }

    public static void reiniciarGrafo(Graph graph) {
        for (org.graphstream.graph.Node n : graph.getNodeSet()) {
            n.setAttribute("ui.class", "");
        }

        for (org.graphstream.graph.Edge e : graph.getEdgeSet()) {
            e.setAttribute("ui.class", "");
        }
    }
    

    public static String getEstilosDefault() {
        return """
        node {
            fill-color: #66ccff;
            size: 20px;
            text-size: 14px;
            text-color: black;
        }
        node.visitado {
            fill-color: #00cc66;
        }
        node.origen {
            fill-color: orange;
        }
        edge {
            fill-color: gray;
            size: 1px;
            text-size: 12px;
        }
        edge.seleccionada {
            fill-color: red;
            size: 3px;
        }
    """;
    }

}
