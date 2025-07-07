package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Pedro, Chistopher y Katia
 */
public class Grafo {

    private final List<Localidad> localidades;
    private final List<Carretera> carreteras;
    private final Map<Localidad, List<Localidad>> adyacencias;

    public Grafo() {
        localidades = new ArrayList<>();
        carreteras = new ArrayList<>();
        adyacencias = new HashMap<>();
    }

    public void agregarLocalidad(Localidad loc) {
        if (!localidades.contains(loc)) {
            localidades.add(loc);
            adyacencias.put(loc, new ArrayList<>());
        }
    }

    public void agregarCarretera(Carretera c) {
        if (!carreteras.contains(c)) {
            carreteras.add(c);
            adyacencias.get(c.getOrigen()).add(c.getDestino());
            adyacencias.get(c.getDestino()).add(c.getOrigen()); // No dirigido
        }
    }

    public List<Localidad> getLocalidades() {
        return localidades;
    }

    public List<Carretera> getCarreteras() {
        return carreteras;
    }

    public List<Localidad> obtenerVecinos(Localidad loc) {
        return adyacencias.getOrDefault(loc, Collections.emptyList());
    }
    
    
}
