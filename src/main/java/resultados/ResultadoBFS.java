/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resultados;

import base.Localidad;
import java.util.Map;

/**
 *
 * @author pedro
 */
public class ResultadoBFS {

    private final Map<Localidad, Integer> distancias;
    private final Map<Localidad, Localidad> predecesores;

    public ResultadoBFS(Map<Localidad, Integer> distancias, Map<Localidad, Localidad> predecesores) {
        this.distancias = distancias;
        this.predecesores = predecesores;
    }

    public Map<Localidad, Integer> getDistancias() {
        return distancias;
    }

    public Map<Localidad, Localidad> getPredecesores() {
        return predecesores;
    }
    
    
}
