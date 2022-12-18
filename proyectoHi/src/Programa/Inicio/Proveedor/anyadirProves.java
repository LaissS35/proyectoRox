package Programa.Inicio.Proveedor;

import BD.ProveedoresEntity;
import Programa.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class anyadirProves extends JFrame {
    private JPanel panel1;
    private JTextField textoCodigo;
    private JTextField textoNombre;
    private JTextField textoApellidos;
    private JTextField textoDireccion;
    private JButton añadirButton;
    private JButton atrasButton;
    private JButton limpiarButton;

    public anyadirProves() {
        setContentPane(panel1);
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((textoCodigo.getText().length() >= 1 && textoCodigo.getText().length()<=6) && (textoNombre.getText().length() >= 1 && textoNombre.getText().length()<=45) && (textoApellidos.getText().length() >= 1 && textoApellidos.getText().length()<=45) && (textoDireccion.getText().length() >= 1 && textoDireccion.getText().length()<=445)) {

                    try {
                        HibernateUtil.buildSessionFactory();

                        ProveedoresEntity piezasM = new ProveedoresEntity();
                        piezasM.setCodigo(textoCodigo.getText().toUpperCase());
                        piezasM.setNombre(textoNombre.getText().toUpperCase());
                        piezasM.setApellidos(textoApellidos.getText().toUpperCase());
                        piezasM.setDireccionPostal(textoDireccion.getText().toUpperCase());


                            Session sesion = HibernateUtil.getCurrentSession();
                            sesion.beginTransaction();
                            sesion.save(piezasM);

                            sesion.getTransaction().commit();


                             sesion.close();

                        JOptionPane.showMessageDialog(null, "Se añadio correctamente", "Insercion correcto", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException ex) {
                        System.out.println("no se pudo añadir proveedor");
                        JOptionPane.showMessageDialog(null, "error al añadir nueva proveedor", "error inesperado", JOptionPane.ERROR_MESSAGE);

                    } catch (HibernateException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    System.out.println("no se pudo añadir");
                    JOptionPane.showMessageDialog(null, "debes rellenar todos los campos y no exceder su limite", "error inesperado", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new menuProves();//la otra ventana tiene extend jframe
                frame.setSize(700, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textoCodigo.setText("");
                textoDireccion.setText("");
                textoNombre.setText("");
                textoApellidos.setText("");
            }
        });
    }
}
