package presentacion;

import base.Carretera;
import base.Grafo;
import base.Localidad;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class Matriz extends JFrame {

    public Matriz(Grafo grafo) {
        setTitle("Tabla de Adyacencias");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTable tabla = construirTabla(grafo);
        JScrollPane scrollPane = new JScrollPane(tabla);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private JTable construirTabla(Grafo grafo) {
        List<Localidad> localidades = grafo.getLocalidades();
        List<Carretera> carreteras = grafo.getCarreteras();
        int n = localidades.size();

        double[][] matriz = new double[n][n];

        
        for (Carretera c : carreteras) {
            int i = localidades.indexOf(c.getOrigen());
            int j = localidades.indexOf(c.getDestino());
            matriz[i][j] = c.getPeso();
            matriz[j][i] = c.getPeso(); 
        }

        String[] columnas = new String[n + 1];
        columnas[0] = "";
        for (int i = 0; i < n; i++) {
            columnas[i + 1] = localidades.get(i).getNombre();
        }

        String[][] datos = new String[n][n + 1];
        for (int i = 0; i < n; i++) {
            datos[i][0] = localidades.get(i).getNombre();
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] == 0) {
                    datos[i][j + 1] = "-";
                } else {
                    datos[i][j + 1] = String.valueOf(matriz[i][j]);
                }
            }
        }

        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        JTable tabla = new JTable(modelo);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        return tabla;

    }
}
