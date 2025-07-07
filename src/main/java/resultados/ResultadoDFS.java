package resultados;

import base.Localidad;
import java.util.Map;

/**
 * Guarda los resultados del algoritmo DFS: - Predecesores para reconstruir el
 * árbol DFS
 *
 * @author Pedro
 */
public class ResultadoDFS {

    private final Map<Localidad, Localidad> predecesores;

    public ResultadoDFS(Map<Localidad, Localidad> predecesores) {
        this.predecesores = predecesores;
    }

    public Map<Localidad, Localidad> getPredecesores() {
        return predecesores;
    }
}
