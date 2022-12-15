package Programa.Inicio.Gestion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionSuministroProvedor extends JFrame {
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton verDatosButton;
    private JPanel panel;
    private JButton atrasButton;

    public GestionSuministroProvedor(){
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
    }

}
