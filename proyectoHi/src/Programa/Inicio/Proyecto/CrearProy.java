package Programa.Inicio.Proyecto;

import BD.ProyectosEntity;
import Programa.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearProy extends JFrame {
    private JTextField textoNombre;
    private JTextField textoUbi;
    private JTextField textoDescri;
    private JTextField textoCodigo;
    private JPanel panel;
    private JButton crearButton;
    private JButton atrasButton;
    private JButton limpiarButton;

    public CrearProy(){
        setContentPane(panel);
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MenuProyecto();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(textoCodigo.getText().length()>=1 && textoNombre.getText().length()>=1 && textoDescri.getText().length()>=1 && textoUbi.getText().length()>=1){

                    try {
                        HibernateUtil.buildSessionFactory();

                        ProyectosEntity piezasM = new ProyectosEntity();
                        piezasM.setCodigo(textoCodigo.getText().toUpperCase());
                        piezasM.setNombre(textoNombre.getText().toUpperCase());
                        piezasM.setDescripcion(textoDescri.getText().toUpperCase());
                        piezasM.setUbicacion(textoUbi.getText().toUpperCase());

                        Session sesion = HibernateUtil.getCurrentSession();
                        sesion.beginTransaction();
                        sesion.save(piezasM);

                        sesion.getTransaction().commit();
                        sesion.close();
                        JOptionPane.showMessageDialog(null, "Se añadio correctamente", "Insercion correcto", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException ex) {
                        System.out.println("no se pudo añadir proyecto");
                        JOptionPane.showMessageDialog(null, "error al añadir nueva pieza, asegurate de rellenar todos los valores", "error inesperado", JOptionPane.ERROR_MESSAGE);

                    } catch (HibernateException ex) {
                        throw new RuntimeException(ex);
                    }}else{
                    System.out.println("no se pudo añadir");
                    JOptionPane.showMessageDialog(null, "¿estan todos los campos llenos?", "error inesperado", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textoCodigo.setText("");
                textoNombre.setText("");
                textoUbi.setText("");
                textoDescri.setText("");
            }
        });
    }
}
