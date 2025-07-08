/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resultados;

import base.Localidad;
import java.util.List;

/**
 *
 * @author chris
 */
public class ResultadoCamino {

    private final List<Localidad> camino;
    private final double distanciaTotal;

    public ResultadoCamino(List<Localidad> camino, double distanciaTotal) {
        this.camino = camino;
        this.distanciaTotal = distanciaTotal;
    }

    public List<Localidad> getCamino() {
        return camino;
    }

    public double getDistanciaTotal() {
        return distanciaTotal;
    }
}
