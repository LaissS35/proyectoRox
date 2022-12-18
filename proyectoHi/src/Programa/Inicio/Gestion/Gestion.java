package Programa.Inicio.Gestion;

import Programa.Inicio.Piezas.MenuPiezas;
import Programa.Inicio.Proveedor.menuProves;
import Programa.Inicio.Proyecto.MenuProyecto;
import Programa.Inicio.inicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gestion extends JFrame {
    private JButton piezasProveedoresYProyectosButton;
    private JButton estadisticasButton;
    private JButton suministroPorPiezasButton;
    private JButton suministroPorProveedorButton;
    private JPanel panel;
    private JLabel Imagen;
    private JButton inicioButton;
    private JButton piezasButton;
    private JButton proveedoresButton;
    private JButton proyectosButton;

    public Gestion(){
        setContentPane(panel);
        Imagen.setSize(500,500);
        ImageIcon picture = new ImageIcon("src/Programa/Inicio/imagen/84323852-icono-de-esbozo-de-vector-de-enlace-aislado-en-el-fondo-dibujado-a-mano-icono-de-enlace-enlace-icono.jpg");
        Icon icon= new ImageIcon(picture.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_DEFAULT));
        Imagen.setIcon(icon);

        inicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new inicio();
                frame.setSize(700,600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();
            }
        });
        piezasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MenuPiezas();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();
            }
        });
        proveedoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new menuProves();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();
            }
        });
        proyectosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MenuProyecto();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();
            }
        });
        suministroPorProveedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new listaGestion();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();

            }
        });
    }
}
