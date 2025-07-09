/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmos;

import base.Carretera;
import base.Grafo;
import base.Localidad;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.graphstream.graph.Graph;
import resultados.ResultadoMST;
import visualizacion.VisualizadorUtils;

/**
 * Clase que implementa el algoritmo de Kruskal para encontrar el Árbol de Expansión
 * Mínimo de un grafo ponderado.
 * 
 * @author Pedro, Christopher y Katia
 * hola
 */
public class Kruskal {
    /**
     * Ejecuta el algoritmo de Kruskal sobre el grafo dado.
     * @param grafo Grafo lógico que contiene las localidades y carreteras.
     * @param grafoVisual Grafo visual de GraphStream para mostrar el proceso.
     * @return Objeto ResultadoMST que contiene las aristas seleccionadas.
     */
    public static ResultadoMST ejecutar(Grafo grafo, Graph grafoVisual) {
        List<Carretera> mst = new ArrayList<>();
        List<Carretera> aristas = new ArrayList<>(grafo.getCarreteras());
        aristas.sort(Comparator.comparingDouble(Carretera::getPeso));

        // Inicializar conjuntos disjuntos
        Map<Localidad, Localidad> padre = new HashMap<>();
        for (Localidad loc : grafo.getLocalidades()) {
            padre.put(loc, loc);
        }
        
        for (Carretera c : aristas) {
            Localidad a = c.getOrigen();
            Localidad b = c.getDestino();

            Localidad raizA = encontrar(padre, a);
            Localidad raizB = encontrar(padre, b);
            
            System.out.printf("Evaluando arista: %s - %s (%.2f km)%n", a.getNombre(), b.getNombre(), c.getPeso());

            if (!raizA.equals(raizB)) {
                padre.put(raizA, raizB);
                mst.add(c);
                
                System.out.printf("Arista agregada al MST: %s - %s%n", a.getNombre(), b.getNombre());

                VisualizadorUtils.pintarNodo(grafoVisual, a.getNombre(), "visitado");
                VisualizadorUtils.pintarNodo(grafoVisual, b.getNombre(), "visitado");
                VisualizadorUtils.pintarArista(grafoVisual, a.getNombre(), b.getNombre(), "seleccionada");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                if (mst.size() == grafo.getLocalidades().size() - 1) {
                    break;
                }
            } else {
                System.out.printf("Arista descartada: %s - %s (formaría ciclo)%n", a.getNombre(), b.getNombre());
            }
        }
        return new ResultadoMST(mst);
    }

    /**
     * Encuentra la raíz del conjunto al que pertenece una localidad.
     * @param padre Mapa que representa los conjuntos disjuntos.
     * @param x Localidad de la que se desea encontrar la raíz de su conjunto.
     * @return La raíz del conjunto al que pertenece la localidad.
     */
    private static Localidad encontrar(Map<Localidad, Localidad> padre, Localidad x) {
        if (!padre.get(x).equals(x)) {
            padre.put(x, encontrar(padre, padre.get(x)));
        }
        return padre.get(x);
    }
}
