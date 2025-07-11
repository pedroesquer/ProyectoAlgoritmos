/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import base.Grafo;
import negocio.ControladorGrafo;
import negocio.ControladorVisual;

/**
 *
 * @author katia
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private final Grafo grafoLogico = ControladorGrafo.getGrafo();

    /**
     * Creates new form menu
     */
    public MenuPrincipal() {
        initComponents();
        setTitle("Guanajuato");
        setSize(1080, 720);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnVisualizacion = new javax.swing.JButton();
        btnRecorridos = new javax.swing.JButton();
        btnArboles = new javax.swing.JButton();
        btnRutas = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Times New Roman", 0, 110)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Guanajuato");
        lblTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(40, 1, 1, 1));
        getContentPane().add(lblTitulo, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(80, 80, 80, 80));
        jPanel1.setLayout(new java.awt.GridLayout(3, 2, 40, 30));

        btnVisualizacion.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        btnVisualizacion.setText("1. Visualización del grafo");
        btnVisualizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizacionActionPerformed(evt);
            }
        });
        jPanel1.add(btnVisualizacion);

        btnRecorridos.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        btnRecorridos.setText("2. Recorridos");
        btnRecorridos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecorridosActionPerformed(evt);
            }
        });
        jPanel1.add(btnRecorridos);

        btnArboles.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        btnArboles.setText("3. Árbol de Expansión Mínima");
        btnArboles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArbolesActionPerformed(evt);
            }
        });
        jPanel1.add(btnArboles);

        btnRutas.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        btnRutas.setText("4. Rutas más cortas");
        btnRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRutasActionPerformed(evt);
            }
        });
        jPanel1.add(btnRutas);

        btnReportes.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        btnReportes.setText("5. Reportes de complejidad");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });
        jPanel1.add(btnReportes);

        btnSalir.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        btnSalir.setText("6. Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVisualizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizacionActionPerformed
        ControladorVisual.getInstancia().abrirTablaGrafo(grafoLogico);    }//GEN-LAST:event_btnVisualizacionActionPerformed

    private void btnRecorridosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecorridosActionPerformed
        ControladorVisual.getInstancia().abrirPantallaRecorridos();
        this.setVisible(false);
    }//GEN-LAST:event_btnRecorridosActionPerformed

    private void btnArbolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArbolesActionPerformed
        ControladorVisual.getInstancia().abrirPantallaMenuMST();
        this.setVisible(false);
    }//GEN-LAST:event_btnArbolesActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRutasActionPerformed
        ControladorVisual.getInstancia().abrirRutaMasCorta();
        this.dispose();
    }//GEN-LAST:event_btnRutasActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        ControladorVisual.getInstancia().abrirReportes();
    }//GEN-LAST:event_btnReportesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArboles;
    private javax.swing.JButton btnRecorridos;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnRutas;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVisualizacion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
