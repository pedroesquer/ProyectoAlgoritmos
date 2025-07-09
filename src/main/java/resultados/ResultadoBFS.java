package resultados;

import base.Localidad;
import java.util.Map;

/**
 * Clase que representa el resultado de ejecutar el algoritmo BFS (Breadth-First Search)
 * sobre un grafo. Contiene la distancia mínima desde el nodo origen a cada localidad
 * y el predecesor de cada localidad en el camino más corto encontrado.
 * 
 * Esta clase es útil para análisis posterior del recorrido y reconstrucción de rutas.
 * 
 * Autores: Pedro, Christopher y Katia
 */
public class ResultadoBFS {

    /**
     * Mapa que almacena la distancia (en número de aristas) desde el nodo origen
     * a cada localidad alcanzada durante la ejecución del algoritmo.
     */
    private final Map<Localidad, Integer> distancias;

    /**
     * Mapa que almacena el predecesor inmediato de cada localidad durante el recorrido.
     * Se utiliza para reconstruir el camino desde cualquier nodo hasta el origen.
     */
    private final Map<Localidad, Localidad> predecesores;

    /**
     * Constructor para inicializar el resultado del BFS con las distancias y predecesores calculados.
     *
     * @param distancias Mapa de distancias desde el origen a cada localidad.
     * @param predecesores Mapa de predecesores de cada localidad en el recorrido.
     */
    public ResultadoBFS(Map<Localidad, Integer> distancias, Map<Localidad, Localidad> predecesores) {
        this.distancias = distancias;
        this.predecesores = predecesores;
    }

    /**
     * Obtiene el mapa de distancias desde el nodo origen a cada localidad.
     *
     * @return Mapa con las distancias calculadas.
     */
    public Map<Localidad, Integer> getDistancias() {
        return distancias;
    }

    /**
     * Obtiene el mapa de predecesores de cada localidad.
     *
     * @return Mapa con los predecesores para reconstrucción de caminos.
     */
    public Map<Localidad, Localidad> getPredecesores() {
        return predecesores;
    }
}