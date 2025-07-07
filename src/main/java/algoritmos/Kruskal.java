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
import resultados.ResultadoKruskal;
import visualizacion.VisualizadorUtils;

/**
 *
 * @author Pedro, Christopher y Katia
 */
public class Kruskal {
    public static ResultadoKruskal ejecutar(Grafo grafo, Graph grafoVisual) {
        List<Carretera> mst = new ArrayList<>();
        List<Carretera> aristas = new ArrayList<>(grafo.getCarreteras());
        aristas.sort(Comparator.comparingDouble(Carretera::getPeso));

        // Inicializar conjuntos disjuntos
        Map<Localidad, Localidad> padre = new HashMap<>();
        for (Localidad loc : grafo.getLocalidades()) {
            padre.put(loc, loc);
        }

        System.out.println("========== Kruskal ==========");
        
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
        
        double total = mst.stream().mapToDouble(Carretera::getPeso).sum();
        System.out.println("========== Kruskal Finalizado ==========");
        System.out.printf("Peso total del MST: ", total);

        return new ResultadoKruskal(mst);
    }

    private static Localidad encontrar(Map<Localidad, Localidad> padre, Localidad x) {
        if (!padre.get(x).equals(x)) {
            padre.put(x, encontrar(padre, padre.get(x))); // Path compression
        }
        return padre.get(x);
    }
}
