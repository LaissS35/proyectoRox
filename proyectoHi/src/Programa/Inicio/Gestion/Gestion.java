package Programa.Inicio.Gestion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gestion extends JFrame {
    private JButton piezasProveedoresYProyectosButton;
    private JButton estadisticasButton;
    private JButton suministroPorPiezasButton;
    private JButton suministroPorProveedorButton;
    private JPanel panel;

    public Gestion(){
        setContentPane(panel);
        piezasProveedoresYProyectosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new GestionAnyadir();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        suministroPorProveedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new GestionSuministroProvedor();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        suministroPorPiezasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new GestionPiezaSuministrada();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        estadisticasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new GestionEstadisticas();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
    }
}
