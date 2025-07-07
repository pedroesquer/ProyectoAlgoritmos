/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

import javax.swing.*;
import java.awt.*;

public class GraphStreamTestFrame extends JFrame {

    public GraphStreamTestFrame() {
        setTitle("GraphStream Viewer");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelGrafo = new JPanel(new BorderLayout());
        add(panelGrafo);

        Graph graph = new SingleGraph("Guanajuato");
        graph.setAttribute("ui.stylesheet", """
            node {
                fill-color: #66ccff;
                size: 20px;
                text-size: 14px;
                text-color: black;
            }
            edge {
                text-size: 12px;
                size: 1px;
                fill-color: gray;
            }
        """);

        graph.addNode("León").setAttribute("ui.label", "León");
        graph.addNode("Irapuato").setAttribute("ui.label", "Irapuato");
        graph.addEdge("León-Irapuato", "León", "Irapuato", false).setAttribute("ui.label", "65 km");

        Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.enableAutoLayout();
        View view = viewer.addDefaultView(false); // <-- false para Swing

        panelGrafo.add((Component) view, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GraphStreamTestFrame frame = new GraphStreamTestFrame();
            frame.setVisible(true);
        });
    }
}
