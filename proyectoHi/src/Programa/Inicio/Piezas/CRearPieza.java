package Programa.Inicio.Piezas;

import BD.PiezasEntity;
import Programa.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CRearPieza extends JFrame{
    private JTextField textocodigo;
    private JTextField textonombre;
    private JTextField textoprecio;
    private JTextField textodescripcion;
    private JButton añadirButton;
    private JPanel panel;
    private JButton atrasButton;
    private JButton limpiarButton;

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

                if((textocodigo.getText().length()>=1 && textocodigo.getText().length()<=6) && (textonombre.getText().length()>=1 && textonombre.getText().length()<=45) && (textodescripcion.getText().length()>=1 && textonombre.getText().length()<=445)){

                try {
                    HibernateUtil.buildSessionFactory();
                    Float precio = Float.valueOf(textoprecio.getText());//si mete un texto salta error

                    PiezasEntity piezasM = new PiezasEntity();
                    piezasM.setCodigo(textocodigo.getText().toUpperCase());
                    piezasM.setNombre(textonombre.getText().toUpperCase());
                    piezasM.setDescripcion(textodescripcion.getText().toUpperCase());
                    piezasM.setPrecio(precio);//ojo

                    Session sesion = HibernateUtil.getCurrentSession();
                    sesion.beginTransaction();
                    sesion.save(piezasM);

                    sesion.getTransaction().commit();
                    sesion.close();
                    JOptionPane.showMessageDialog(null, "añadido con exito", " inesperado", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    System.out.println("no se pudo añadir pieza");
                    JOptionPane.showMessageDialog(null, "error al añadir nueva pieza, asegurate de meter correctamente todos los valores", "error inesperado", JOptionPane.ERROR_MESSAGE);

                } catch (HibernateException ex) {
                   // throw new RuntimeException(ex);
                }}else{
                    System.out.println("no se pudo añadir");
                    JOptionPane.showMessageDialog(null, "no debes dejar ningun caracter vacio ni exceder su limite", "error inesperado", JOptionPane.ERROR_MESSAGE);

                }

            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textocodigo.setText("");
                textonombre.setText("");
                textodescripcion.setText("");
                textoprecio.setText("");
            }
        });
    }


}
