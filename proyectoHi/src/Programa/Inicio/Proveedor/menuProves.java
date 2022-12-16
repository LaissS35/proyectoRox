package Programa.Inicio.Proveedor;

import Programa.Inicio.Gestion.Gestion;
import Programa.Inicio.Piezas.MenuPiezas;
import Programa.Inicio.Proyecto.MenuProyecto;
import Programa.Inicio.inicio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuProves extends JFrame {
    private JPanel panel;
    private JPanel panelimagen;
    private JButton botonAñadir;
    private JButton buscarButton;
    private JButton listaButton;
    private JButton modificarEliminarButton;
    private JButton inicioButton;
    private JButton menuGestionButton;
    private JButton menuProyectosButton;
    private JButton menuPiezasButton;

    public menuProves() {
        setContentPane(panel);

        botonAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new anyadirProves();//la otra ventana tiene extend jframe
                frame.setSize(700, 600);
                frame.setVisible(true);
                dispose();

            }
        });
        listaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new ListaProveedores();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new ConsultaProveedor();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();

            }
        });
        modificarEliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new modificarEliProves();//la otra ventana tiene extend jframe
                frame.setSize(700, 600);
                frame.setVisible(true);
                dispose();
            }
        });
        inicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new inicio();//la otra ventana tiene extend jframe
                frame.setSize(700, 600);
                frame.setVisible(true);
                dispose();

            }
        });
        menuGestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new Gestion();//la otra ventana tiene extend jframe
                frame.setSize(700, 600);
                frame.setVisible(true);
                dispose();
            }
        });
        menuProyectosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MenuProyecto();//la otra ventana tiene extend jframe
                frame.setSize(700, 600);
                frame.setVisible(true);
                dispose();

            }
        });
        menuPiezasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MenuPiezas();//la otra ventana tiene extend jframe
                frame.setSize(700, 600);
                frame.setVisible(true);
                dispose();
            }
        });
    }
}
