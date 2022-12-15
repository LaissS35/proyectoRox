package Programa.Inicio.Proveedor;

import BD.ProveedoresEntity;
import BD.ProyectosEntity;
import Programa.HibernateUtil;
import Programa.Inicio.Piezas.MenuPiezas;
import Programa.Inicio.Proyecto.MenuProyecto;
import Programa.Inicio.inicio;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionProve extends JFrame {
    private JButton limpiarButton;
    private JButton insertarButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JTextField textoCodigo;
    private JTextField textoNombre;
    private JTextField textoApellido;
    private JTextField textoDireccion;
    private JButton listaProveedoresButton;
    private JButton BotonBuscarProve;
    private JPanel panel;
    private JButton menúPiezasButton;
    private JButton menúProyectosButton;
    private JButton inicioButton;

    public GestionProve() {
        setContentPane(panel);
        BotonBuscarProve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProveedor();
            }


        });
        listaProveedoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaProveedor();
            }


        });
        menúPiezasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MenuPiezas();//la otra ventana tiene extend jframe
                frame.setSize(700, 600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        menúProyectosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MenuProyecto();//la otra ventana tiene extend jframe
                frame.setSize(700, 600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        inicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new inicio();//la otra ventana tiene extend jframe
                frame.setSize(700, 600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textoCodigo.setText("");
                textoNombre.setText("");
                textoApellido.setText("");
                textoDireccion.setText("");
            }
        });
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textoCodigo.getText().length() >= 1 && textoNombre.getText().length() >= 1 && textoApellido.getText().length() >= 1 && textoDireccion.getText().length() >= 1) {

                    try {
                        HibernateUtil.buildSessionFactory();

                        ProveedoresEntity piezasM = new ProveedoresEntity();
                        piezasM.setCodigo(textoCodigo.getText());
                        piezasM.setNombre(textoNombre.getText());
                        piezasM.setApellidos(textoApellido.getText());
                        piezasM.setDireccionPostal(textoDireccion.getText());

                        Session sesion = HibernateUtil.getCurrentSession();
                        sesion.beginTransaction();
                        sesion.save(piezasM);

                        sesion.getTransaction().commit();
                        sesion.close();
                        JOptionPane.showMessageDialog(null, "Se añadio correctamente", "Insercion correcto", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException ex) {
                        System.out.println("no se pudo añadir proveedor");
                        JOptionPane.showMessageDialog(null, "error al añadir nueva proveedor, asegurate de rellenar todos los valores", "error inesperado", JOptionPane.ERROR_MESSAGE);

                    } catch (HibernateException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    System.out.println("no se pudo añadir");
                    JOptionPane.showMessageDialog(null, "¿estan todos los campos llenos?", "error inesperado", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textoNombre.getText().length() >= 1 && textoDireccion.getText().length() >= 1 && textoCodigo.getText().length() >= 1 && textoApellido.getText().length() >= 1) {

                    try {
                        HibernateUtil.buildSessionFactory();

                        Query query = HibernateUtil.getCurrentSession().createQuery("from ProveedoresEntity p where p.codigo = :barra");//los puntos deben ir enfrente del nuevo valoor, si no da error
                        query.setParameter("barra", textoCodigo.getText());
                        ProveedoresEntity piezas = (ProveedoresEntity) query.uniqueResult();

                        piezas.setNombre(textoNombre.getText());
                        piezas.setDireccionPostal(textoDireccion.getText());
                        piezas.setApellidos(textoApellido.getText());

                        Session sesion = HibernateUtil.getCurrentSession();
                        sesion.beginTransaction();
                        sesion.save(piezas);
                        sesion.getTransaction().commit();
                        sesion.close();

                        HibernateUtil.closeSessionFactory();

                        JOptionPane.showMessageDialog(null, "Se modifico correctamente", "Insercion correcto", JOptionPane.INFORMATION_MESSAGE);
                    } catch (HibernateException ex) {
                        System.out.println("no se pudo actualizar");
                        JOptionPane.showMessageDialog(null, "no se pudo actualizar ", "error inesperado", JOptionPane.ERROR_MESSAGE);

                    }

                } else {
                    System.out.println("no se pudo actualizar");
                    JOptionPane.showMessageDialog(null, "¿estan todos los campos llenos?", "error inesperado", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //eliminar

                try {
                    HibernateUtil.buildSessionFactory();


                    Query query = HibernateUtil.getCurrentSession().createQuery("from ProveedoresEntity p where p.codigo = :barra");//los puntos deben ir enfrente del nuevo valoor, si no da error
                    query.setParameter("barra", textoCodigo.getText());
                    ProveedoresEntity piezas = (ProveedoresEntity) query.uniqueResult();


                    Session sesion = HibernateUtil.getCurrentSession();

                        sesion.beginTransaction();

                        sesion.delete(piezas);

                        sesion.getTransaction().commit();
                        sesion.close();


                    HibernateUtil.closeSessionFactory();

                    JOptionPane.showMessageDialog(null, "Se elimino  correctamente", "Eliminación correcto", JOptionPane.INFORMATION_MESSAGE);
                } catch (HibernateException ex) {
                    System.out.println("no se pudo eliminar");
                    JOptionPane.showMessageDialog(null, "error al eliminar", "error inesperado", JOptionPane.ERROR_MESSAGE);

                }

            }
        });
    }

    private void listaProveedor() {
        JFrame frame = new ListaProveedores();//la otra ventana tiene extend jframe
        frame.setSize(700, 600);
        frame.setVisible(true);
        dispose();//para cerrar la ventana principal tras pulsar el boton
    }

    private void buscarProveedor() {
        JFrame frame = new ConsultaProveedor();//la otra ventana tiene extend jframe
        frame.setSize(700, 600);
        frame.setVisible(true);
        dispose();//para cerrar la ventana principal tras pulsar el boton
    }

}
