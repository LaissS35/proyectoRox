package Programa.Inicio.Gestion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionEstadisticas  extends JFrame{
    private JButton nºDePiezasYButton;
    private JButton nºDePiezasYButton1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JPanel panel;
    private JButton atrasButton;

    public  GestionEstadisticas(){
        setContentPane(panel);
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new Gestion();//la otra ventana tiene extend jframe
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();//coger el tamañno de la pantalla
                int H = pantalla.height;
                int W = pantalla.width;
                frame.setSize(H,W);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        nºDePiezasYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                JFrame frame = new TablaPiezasProveProyec();//la otra ventana tiene extend jframe
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();//coger el tamañno de la pantalla
                int H = pantalla.height;
                int W = pantalla.width;
                frame.setSize(H,W);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton*/
            }
        });
        nºDePiezasYButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                JFrame frame = new TablaPiezasporProve();//la otra ventana tiene extend jframe
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();//coger el tamañno de la pantalla
                int H = pantalla.height;
                int W = pantalla.width;
                frame.setSize(H,W);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton*/
            }
        });
    }
}
