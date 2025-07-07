/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visualizacion;

import base.Carretera;
import base.Grafo;
import base.Localidad;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author pedro
 */
public class VisualizadorGrafo {

    /**
     * Convierte un grafo lógico en un grafo visual de GraphStream.
     *
     * @param grafo El grafo lógico (localidades y aristas).
     * @return El grafo visual listo para usarse en un JPanel.
     */
    public static Graph crearGrafoVisual(Grafo grafo) {
        Graph graph = new SingleGraph("Guanajuato");

        // Estilos visuales
        graph.setAttribute("ui.stylesheet", getEstilosDefault());

        // Nodos
        for (Localidad loc : grafo.getLocalidades()) {
            if (graph.getNode(loc.getNombre()) == null) {
                Node nodo = graph.addNode(loc.getNombre());
                nodo.setAttribute("ui.label", loc.getNombre());

            }
        }
        // Aristas
        for (Carretera arista : grafo.getCarreteras()) {
            String origen = arista.getOrigen().getNombre();
            String destino = arista.getDestino().getNombre();
            String id = origen + "-" + destino;
            String idInv = destino + "-" + origen;

            if (graph.getEdge(id) == null && graph.getEdge(idInv) == null) {
                graph.addEdge(id, origen, destino, false)
                        .setAttribute("ui.label", arista.getPeso() + " km");
            }
        }

        return graph;
    }

    /**
     * Devuelve el stylesheet para aplicar estilos visuales a nodos y aristas.
     *
     * @return String de estilo GraphStream tipo CSS.
     */
    public static String getEstilosDefault() {
        return """
    node {
        fill-color: #66ccff;
        size: 20px;
        text-size: 13px;
        text-color: black;
        text-alignment: under;
    }
    node.visitado {
        fill-color: #00cc66;
    }
    node.origen {
        fill-color: orange;
    }
    node.destino {
        fill-color: yellow;
    }
    edge {
        fill-color: gray;
        text-size: 10px;
        size: 4px;
    }
    edge.seleccionada {
        fill-color: red;
        size: 5px;
    }
""";

    }
}
