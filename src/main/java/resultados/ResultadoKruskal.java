/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resultados;

import base.Carretera;
import java.util.List;

/**
 * Clase que contiene el resultado del algoritmo Kruskal
 * Aristas seleccionadas y peso total del MST
 * @author Pedro, Christopher y Katia
 */
public class ResultadoKruskal {
    private final List<Carretera> aristasSeleccionadas;
    private final double pesoTotal;

    public ResultadoKruskal(List<Carretera> aristasSeleccionadas) {
        this.aristasSeleccionadas = aristasSeleccionadas;
        this.pesoTotal = calcularPesoTotal(aristasSeleccionadas);
    }

    private double calcularPesoTotal(List<Carretera> aristas) {
        return aristas.stream()
                      .mapToDouble(Carretera::getPeso)
                      .sum();
    }

    public List<Carretera> getAristasSeleccionadas() {
        return aristasSeleccionadas;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }
}
