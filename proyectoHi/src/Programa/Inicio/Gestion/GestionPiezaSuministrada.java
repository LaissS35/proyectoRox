package Programa.Inicio.Gestion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionPiezaSuministrada extends JFrame {
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JList list1;
    private JTextField textField4;
    private JPanel panel;
    private JButton atrasButton;
    private JButton verDatosButton;

    public GestionPiezaSuministrada(){
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
