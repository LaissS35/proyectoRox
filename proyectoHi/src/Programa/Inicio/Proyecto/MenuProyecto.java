package Programa.Inicio.Proyecto;

import Programa.Inicio.Piezas.MenuPiezas;
import Programa.Inicio.Proveedor.menuProves;
import Programa.Inicio.inicio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuProyecto extends JFrame{
    private JButton listaButton;
    private JButton crearButton;
    private JButton modificarEliminarButton;
    private JButton buscarButton;
    private JPanel panel;
    private JButton menúPiezasButton;
    private JButton menúProveedoresButton;
    private JButton inicioButton;

    public  MenuProyecto(){
        setContentPane(panel);

        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new CrearProy();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        modificarEliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new ModifiEliProy();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new BuscarProyecto();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        listaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new ListaProy();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        menúPiezasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MenuPiezas();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        menúProveedoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new menuProves();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        inicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new inicio();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
    }
}
