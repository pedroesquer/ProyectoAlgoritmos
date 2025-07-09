package resultados;

import base.Localidad;
import java.util.Map;

/**
 * Clase que encapsula los resultados del algoritmo DFS (Depth-First Search).
 * Almacena el mapa de predecesores generado durante el recorrido,
 * lo cual permite reconstruir el árbol DFS desde cualquier localidad.
 * 
 * Esta clase es útil para visualizar o analizar el orden de visita y las conexiones
 * generadas por el algoritmo DFS.
 * 
 * Autores: Pedro, Christopher y Katia
 */
public class ResultadoDFS {

    /**
     * Mapa que indica el predecesor de cada localidad visitada durante el recorrido DFS.
     * Este mapa permite reconstruir el árbol DFS.
     */
    private final Map<Localidad, Localidad> predecesores;

    /**
     * Constructor que inicializa el resultado del DFS con el mapa de predecesores.
     *
     * @param predecesores Mapa de predecesores generado por el recorrido DFS.
     */
    public ResultadoDFS(Map<Localidad, Localidad> predecesores) {
        this.predecesores = predecesores;
    }

    /**
     * Obtiene el mapa de predecesores del recorrido DFS.
     *
     * @return Mapa de predecesores, donde cada entrada representa la localidad actual y su predecesora.
     */
    public Map<Localidad, Localidad> getPredecesores() {
        return predecesores;
    }
}
