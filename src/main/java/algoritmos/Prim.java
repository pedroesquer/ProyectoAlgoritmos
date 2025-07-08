/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmos;

import base.Carretera;
import base.Grafo;
import base.Localidad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import org.graphstream.graph.Graph;
import resultados.ResultadoMST;
import visualizacion.VisualizadorUtils;

/**
 * Clase que implementa el algoritmo de Prim para encontrar el MST
 * de un grafo, utilizando una cola de prioridad.
 * 
 * Selecciona en cada paso la arista de menor peso que conecta una nueva
 * localidad al árbol en construcción.
 * 
 * @author Pedro, Christopher y Katia
 */
public class Prim {
    
    /**
     * Ejecuta el algoritmo de Prim sobre el grafo dado
     * @param grafo El grafo lógico con localidades y carreteras
     * @param grafoVisual El grafo visual para mostrar los cambios
     * @param inicio Nombre de la ciudad donde inicia el algoritmo
     * @return Un objeto ResultadoMST con las aristas seleccionadas y su peso total
     */
    public static ResultadoMST ejecutar(Grafo grafo, Graph grafoVisual, Localidad inicio) {
        Map<Localidad, Double> key = new HashMap<>();
        Map<Localidad, Carretera> aristaMasBarata = new HashMap<>();
        Set<Localidad> enMST = new HashSet<>();
        PriorityQueue<LocalidadAux> cola = new PriorityQueue<>();

        // Inicializar todos los nodos
        for (Localidad loc : grafo.getLocalidades()) {
            key.put(loc, Double.POSITIVE_INFINITY);
        }

        key.put(inicio, 0.0);
        cola.add(new LocalidadAux(inicio, 0.0));

        List<Carretera> mst = new ArrayList<>();

        while (!cola.isEmpty()) {
            Localidad actual = cola.poll().localidad;

            if (enMST.contains(actual)) continue;
            enMST.add(actual);

            // Si hay una carretera que lo conecta al MST, agregarla
            if (aristaMasBarata.containsKey(actual)) {
                Carretera carretera = aristaMasBarata.get(actual);
                mst.add(carretera);

                VisualizadorUtils.pintarNodo(grafoVisual, carretera.getOrigen().getNombre(), "visitado");
                VisualizadorUtils.pintarNodo(grafoVisual, carretera.getDestino().getNombre(), "visitado");
                VisualizadorUtils.pintarArista(grafoVisual,
                        carretera.getOrigen().getNombre(),
                        carretera.getDestino().getNombre(),
                        "seleccionada");

                System.out.println("Agregando arista: " + carretera.getOrigen().getNombre()
                        + " - " + carretera.getDestino().getNombre()
                        + " (" + carretera.getPeso() + " km)");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            // Revisar vecinos
            for (Carretera c : grafo.getCarreteras()) {
                Localidad vecino = null;

                if (c.getOrigen().equals(actual)) {
                    vecino = c.getDestino();
                } else if (c.getDestino().equals(actual)) {
                    vecino = c.getOrigen();
                }

                if (vecino != null && !enMST.contains(vecino) && c.getPeso() < key.get(vecino)) {
                    key.put(vecino, c.getPeso());
                    aristaMasBarata.put(vecino, c);
                    cola.add(new LocalidadAux(vecino, c.getPeso()));
                }
            }
        }

        return new ResultadoMST(mst);
    }

    /**
     * Clase auxiliar usada para manejar la cola de prioridad
     */
    private static class LocalidadAux implements Comparable<LocalidadAux> {
        Localidad localidad;
        double peso;

        /**
         * Constructor de la clase.
         * @param localidad Localidad asociada.
         * @param peso Peso de la arista más ligera que conecta esta localidad.
         */
        public LocalidadAux(Localidad localidad, double peso) {
            this.localidad = localidad;
            this.peso = peso;
        }

        /**
         * Método que compara este objeto con otro LocalidadAux
         * en función del peso, para determinar su orden en una cola de
         * prioridad.
         * @param otra El otro objeto a comparar.
         * @return -1 si this.peso es menor que otra.peso
         *          0 si son iguales
         *          1 si this.peso es mayor (mayor prioridad).
         */
        @Override
        public int compareTo(LocalidadAux otra) {
            return Double.compare(this.peso, otra.peso);
        }
    }
}
