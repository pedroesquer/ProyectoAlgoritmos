/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import algoritmos.BellmanFord;
import algoritmos.Dijkstra;
import base.Grafo;
import base.Localidad;
import negocio.ControladorGrafo;
import org.graphstream.graph.Graph;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;
import visualizacion.VisualizadorGrafo;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Comparator;
import javax.swing.BoxLayout;
import javax.swing.SwingUtilities;
import negocio.ControladorVisual;
import resultados.ResultadoCamino;
import visualizacion.VisualizadorUtils;

/**
 *
 * @author Pedro, Christopher y Katia
 */
public class MenuRutaCorta extends javax.swing.JFrame {

    /**
     * Creates new form MenuMST
     */
    private final Grafo grafoLogico = ControladorGrafo.getGrafo();
    private final Graph grafoVisual = VisualizadorGrafo.crearGrafoVisual(grafoLogico);

    private javax.swing.JTable tablaRuta;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.table.DefaultTableModel modeloTabla;

    public MenuRutaCorta() {
        initComponents();

        setLocationRelativeTo(null);
        setResizable(false);
        setSize(1300, 800); // Aumentamos tamaño para que quepa todo

        // Llenar ComboBoxes
        llenarComboBoxes();

        // Cambiar layout de jPanel1
        // Layout horizontal para jPanel1
        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.X_AXIS));
        jPanel1.setPreferredSize(new Dimension(1200, 500));
        jPanel1.setMinimumSize(new Dimension(1220, 500));

        // Crear grafo visual
        Viewer viewer = new Viewer(grafoVisual, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.enableAutoLayout();
        View view = viewer.addDefaultView(false);
        Component graphComponent = (Component) view;
        graphComponent.setPreferredSize(new Dimension(950, 500));  // Aumentamos el tamaño
        jPanel1.add(graphComponent);

        // Crear tabla más compacta
        String[] columnas = {"Origen", "Destino", "Distancia (km)"};
        modeloTabla = new javax.swing.table.DefaultTableModel(columnas, 0);
        tablaRuta = new javax.swing.JTable(modeloTabla);
        scrollTabla = new javax.swing.JScrollPane(tablaRuta);
        scrollTabla.setPreferredSize(new Dimension(250, 500));  // Más delgada
        jPanel1.add(scrollTabla);

        // Agregar jPanel1 al contentPane (posición ya bien centrada)
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 1200, 500));

        pack();
        setLocationRelativeTo(null); // 🔥 Centra la ventana
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnBellman = new javax.swing.JButton();
        btnDijkstra = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        ComboBoxOrigen = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ComboBoxDestino = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 45)); // NOI18N
        jLabel1.setText("Rutas más cortas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        btnBellman.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 24)); // NOI18N
        btnBellman.setText("Bellman–Ford");
        btnBellman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBellmanActionPerformed(evt);
            }
        });
        getContentPane().add(btnBellman, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 680, 239, -1));

        btnDijkstra.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 24)); // NOI18N
        btnDijkstra.setText("Dijkstra");
        btnDijkstra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDijkstraActionPerformed(evt);
            }
        });
        getContentPane().add(btnDijkstra, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 680, 239, -1));

        btnVolver.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 24)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 680, 239, -1));

        ComboBoxOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxOrigenActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBoxOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 88, 110, 38));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Destino");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 102, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Origen");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 61, 102, -1));

        ComboBoxDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxDestinoActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBoxDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 110, 38));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 347, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBellmanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBellmanActionPerformed
        String origenNombre = (String) ComboBoxOrigen.getSelectedItem();
        String destinoNombre = (String) ComboBoxDestino.getSelectedItem();

        Localidad origen = grafoLogico.getLocalidades().stream()
                .filter(l -> l.getNombre().equals(origenNombre))
                .findFirst().orElse(null);

        Localidad destino = grafoLogico.getLocalidades().stream()
                .filter(l -> l.getNombre().equals(destinoNombre))
                .findFirst().orElse(null);

        if (origen == null || destino == null) {
            return;
        }

        btnDijkstra.setEnabled(false);
        btnBellman.setEnabled(false);
        btnVolver.setEnabled(false);

        new Thread(() -> {
            try {
                VisualizadorUtils.reiniciarGrafo(grafoVisual);
                ResultadoCamino resultado = BellmanFord.ejecutar(grafoLogico, origen, destino, grafoVisual);

                SwingUtilities.invokeLater(() -> {
                    modeloTabla.setRowCount(0);
                    java.util.List<Localidad> camino = resultado.getCamino();

                    for (int i = 0; i < camino.size() - 1; i++) {
                        Localidad origenPaso = camino.get(i);
                        Localidad destinoPaso = camino.get(i + 1);

                        double peso = grafoLogico.getCarreteras().stream()
                                .filter(c
                                        -> (c.getOrigen().equals(origenPaso) && c.getDestino().equals(destinoPaso))
                                || (c.getOrigen().equals(destinoPaso) && c.getDestino().equals(origenPaso))
                                )
                                .mapToDouble(c -> c.getPeso())
                                .findFirst().orElse(0.0);

                        modeloTabla.addRow(new Object[]{
                            origenPaso.getNombre(),
                            destinoPaso.getNombre(),
                            String.format("%.2f", peso)
                        });
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                SwingUtilities.invokeLater(() -> {
                    btnDijkstra.setEnabled(true);
                    btnBellman.setEnabled(true);
                    btnVolver.setEnabled(true);
                });
            }
        }).start();
    }//GEN-LAST:event_btnBellmanActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        ControladorVisual.getInstancia().menuPrincipalVisible();
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnDijkstraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDijkstraActionPerformed
        //Obtenemos el origen y el destino seleccionado
        String origenNombre = (String) ComboBoxOrigen.getSelectedItem();
        String destinoNombre = (String) ComboBoxDestino.getSelectedItem();

        //Convertimos a objectos "Localidad"
        Localidad origen = grafoLogico.getLocalidades().stream()
                .filter(l -> l.getNombre().equals(origenNombre))
                .sorted(Comparator.comparing(Localidad::getNombre))
                .findFirst().orElse(null);

        Localidad destino = grafoLogico.getLocalidades().stream()
                .filter(l -> l.getNombre().equals(destinoNombre))
                .sorted(Comparator.comparing(Localidad::getNombre))
                .findFirst().orElse(null);

        if (origen == null || destino == null) {
            return; // o mostrar alerta
        }

        //Deshabilitamos los botones
        btnDijkstra.setEnabled(false);
        btnBellman.setEnabled(false);
        btnVolver.setEnabled(false);

        //Lanzamos el hilo
        new Thread(() -> {
            try {
                VisualizadorUtils.reiniciarGrafo(grafoVisual);
                ResultadoCamino resultado = Dijkstra.ejecutar(grafoLogico, origen, destino, grafoVisual);

                SwingUtilities.invokeLater(() -> {
                    // Limpiar tabla
                    modeloTabla.setRowCount(0);

                    // Obtener lista de localidades
                    java.util.List<Localidad> camino = resultado.getCamino();

                    // Agregar a la tabla los pares (origen, destino, peso)
                    for (int i = 0; i < camino.size() - 1; i++) {
                        Localidad origenPaso = camino.get(i);
                        Localidad destinoPaso = camino.get(i + 1);

                        // Buscar la carretera entre esos dos nodos
                        double peso = grafoLogico.getCarreteras().stream()
                                .filter(c
                                        -> (c.getOrigen().equals(origenPaso) && c.getDestino().equals(destinoPaso))
                                || (c.getOrigen().equals(destinoPaso) && c.getDestino().equals(origenPaso))
                                )
                                .mapToDouble(c -> c.getPeso())
                                .findFirst().orElse(0.0);

                        modeloTabla.addRow(new Object[]{
                            origenPaso.getNombre(),
                            destinoPaso.getNombre(),
                            String.format("%.2f", peso)
                        });
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //Hanilitamos otra vez los botones
                SwingUtilities.invokeLater(() -> {
                    btnDijkstra.setEnabled(true);
                    btnBellman.setEnabled(true);
                    btnVolver.setEnabled(true);
                });
            }
        }).start();


    }//GEN-LAST:event_btnDijkstraActionPerformed

    private void ComboBoxOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxOrigenActionPerformed
        String origenSeleccionado = (String) ComboBoxOrigen.getSelectedItem();

        ComboBoxDestino.removeAllItems();

        for (Localidad loc : grafoLogico.getLocalidades()) {
            if (!loc.getNombre().equals(origenSeleccionado)) {
                ComboBoxDestino.addItem(loc.getNombre());
            }
        }
    }//GEN-LAST:event_ComboBoxOrigenActionPerformed

    private void ComboBoxDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxDestinoActionPerformed

    private void llenarComboBoxes() {
        ComboBoxOrigen.removeAllItems();
        ComboBoxDestino.removeAllItems();

        for (Localidad loc : grafoLogico.getLocalidades()) {
            ComboBoxOrigen.addItem(loc.getNombre());
            ComboBoxDestino.addItem(loc.getNombre());
        }
    }

//    private void mostrarGrafo() {
//        jPanel1.setLayout(new BorderLayout());
//        Viewer viewer = new Viewer(grafoVisual, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
//        viewer.enableAutoLayout();
//        View view = viewer.addDefaultView(false);
//        jPanel1.add((Component) view, BorderLayout.CENTER);
//        jPanel1.revalidate();
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxDestino;
    private javax.swing.JComboBox<String> ComboBoxOrigen;
    private javax.swing.JButton btnBellman;
    private javax.swing.JButton btnDijkstra;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
