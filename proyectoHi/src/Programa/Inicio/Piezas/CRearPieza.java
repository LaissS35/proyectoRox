package Programa.Inicio.Piezas;

import BD.PiezasEntity;
import Programa.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class CRearPieza extends JFrame{
    private JTextField textocodigo;
    private JTextField textonombre;
    private JTextField textoprecio;
    private JTextField textodescripcion;
    private JButton añadirButton;
    private JPanel panel;
    private JButton atrasButton;

    public CRearPieza(){
        setContentPane(panel);
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MenuPiezas();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(textocodigo.getText().length()>=1 && textonombre.getText().length()>=1 && textodescripcion.getText().length()>=1){

                try {
                    HibernateUtil.buildSessionFactory();

                    PiezasEntity piezasM = new PiezasEntity();
                    piezasM.setCodigo(textocodigo.getText());
                    piezasM.setNombre(textonombre.getText());
                    piezasM.setDescripcion(textodescripcion.getText());
                    piezasM.setPrecio(BigInteger.valueOf(Long.parseLong(textoprecio.getText())));//ojo

                    Session sesion = HibernateUtil.getCurrentSession();
                    sesion.beginTransaction();
                    sesion.save(piezasM);

                    sesion.getTransaction().commit();
                    sesion.close();
                } catch (NumberFormatException ex) {
                    System.out.println("no se pudo añadir pieza");
                    JOptionPane.showMessageDialog(null, "error al añadir nueva pieza, asegurate de rellenar todos los valores", "error inesperado", JOptionPane.ERROR_MESSAGE);

                } catch (HibernateException ex) {
                    throw new RuntimeException(ex);
                }}else{
                    System.out.println("no se pudo añadir");
                    JOptionPane.showMessageDialog(null, "¿estan todos los campos llenos?", "error inesperado", JOptionPane.ERROR_MESSAGE);

                }

            }
        });
    }


}
