package Programa.Inicio.Piezas;

import Programa.Inicio.Proveedor.GestionProve;
import Programa.Inicio.Proyecto.MenuProyecto;
import Programa.Inicio.inicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPiezas extends JFrame{
    private JButton modificarEliminarButton;
    private JButton añadirButton;
    private JButton listaButton;
    private JButton buscarPiezaButton;
    private JLabel ImagenPieza;
    private JPanel panel;
    private JButton menúProveedoresButton;
    private JButton menúProyectosButton;
    private JButton inicioButton;

    public MenuPiezas(){
        setContentPane(panel);
        //para mostrar imagen, dentro de un panel y label
        ImagenPieza.setSize(500,500);
        ImageIcon picture = new ImageIcon("src/Programa/Inicio/imagen/694-6942289_engranajes-dibujo-png.jpg");
        Icon icon= new ImageIcon(picture.getImage().getScaledInstance(ImagenPieza.getWidth(),ImagenPieza.getHeight(), Image.SCALE_DEFAULT));
        ImagenPieza.setIcon(icon);
        //fin de la imagen
        menúProveedoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new GestionProve();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        menúProyectosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MenuProyecto();//la otra ventana tiene extend jframe
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
        modificarEliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new EliminarModificarPieza();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new CRearPieza();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        listaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new ListaPiezas();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        buscarPiezaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new BuscarPieza();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
    }

    public static void main(String[] args) {

    }
}
