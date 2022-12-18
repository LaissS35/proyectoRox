package Programa.Inicio;

import Programa.Inicio.Gestion.Gestion;
import Programa.Inicio.Piezas.MenuPiezas;
import Programa.Inicio.Proveedor.menuProves;
import Programa.Inicio.Proyecto.MenuProyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inicio extends JFrame {
    //botones

    private JButton proveedoresButton;
    private JButton piezasButton;
    private JButton proyectosButton;
    private JButton gestionGlobalButton;
    private JButton ayudaButton;
    //panel
    private JPanel inicio;
    private JLabel Imagen;

    //funciones de los botones
    public inicio(){
        setContentPane(inicio);//nombre del Jpanel, si no esta no se muestra la ventana

        //para mostrar imagen, dentro de un panel y label
        Imagen.setSize(500,500);
        ImageIcon picture = new ImageIcon("src/Programa/Inicio/imagen/istockphoto-1154145687-612x612.jpg");
        Icon icon= new ImageIcon(picture.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
        Imagen.setIcon(icon);
        //fin de la imagen

        proveedoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaProve();//abre ventana con las opciones de gestionar proveedores o verlos(integrado)
            }


        });
        piezasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPiezas();

            }
        });
        proyectosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaProy();

            }


        });
        gestionGlobalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaGestion();

            }


        });

        ayudaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new ayuda();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();
            }
        });
    }
    private void ventanaProy() {
        JFrame frame = new MenuProyecto();//la otra ventana tiene extend jframe
        frame.setSize(700,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        dispose();//para cerrar la ventana principal tras pulsar el boton
    }
    private void ventanaPiezas() {
        JFrame frame = new MenuPiezas();//la otra ventana tiene extend jframe
        frame.setSize(700,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        dispose();//para cerrar la ventana principal tras pulsar el boton
    }


    private void ventanaGestion() {
        JFrame frame = new Gestion();//la otra ventana tiene extend jframe
        frame.setSize(700,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        dispose();//para cerrar la ventana principal tras pulsar el boton

    }
    private void ventanaProve() {
        JFrame frame = new menuProves();//la otra ventana tiene extend jframe
        frame.setSize(700,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        dispose();//para cerrar la ventana principal tras pulsar el boton

    }
    //funciones



}
