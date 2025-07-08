/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resultados;

import base.Carretera;
import java.util.List;

/**
 * Clase que representa el resultado de un MST (Árbol de Expansión
 * Mínima).
 * Contiene las aristas seleccionadas y el peso total del MST.
 * @author Pedro, Christopher y Katia
 */
public class ResultadoMST {
    private final List<Carretera> aristasSeleccionadas;
    private final double pesoTotal;

    /**
     * Constructor de la clase.
     * Inicializa el resltado con la lista de aristas seleccionadas.
     * @param aristasSeleccionadas Carreteras seleccionadas como parte del MST
     */
    public ResultadoMST(List<Carretera> aristasSeleccionadas) {
        this.aristasSeleccionadas = aristasSeleccionadas;
        this.pesoTotal = calcularPesoTotal(aristasSeleccionadas);
    }

    /**
     * Método que calcula el peso total.
     * Se obtiene sumando los pesos de cada arista del MST.
     * @param aristas Lista con las carreteras seleccionadas.
     * @return Peso total
     */
    private double calcularPesoTotal(List<Carretera> aristas) {
        return aristas.stream()
                      .mapToDouble(Carretera::getPeso)
                      .sum();
    }

    /**
     * Método que devuelve la lista de carreteras seleccionadas en el MST
     * @return lista con las carreteras del MST
     */
    public List<Carretera> getAristasSeleccionadas() {
        return aristasSeleccionadas;
    }

    /**
     * Método que retorna el peso total del MST
     * @return peso total
     */
    public double getPesoTotal() {
        return pesoTotal;
    }
}
