package Programa.Inicio.Piezas;

import BD.PiezasEntity;
import Programa.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BuscarPieza extends JFrame{
    private JTextField textocodigo;
    private JTextField textonombre;
    private JButton buscarButton;
    private JPanel panel;
    private JButton atrasButton;
    private JButton buscar2;
    private JList listaPiezas;

    public BuscarPieza(){
        DefaultListModel<String> modelo = new DefaultListModel<>();
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
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    modelo.removeAllElements();

                    HibernateUtil.buildSessionFactory();

                    SessionFactory sesion = HibernateUtil.getCurrentSession().getSessionFactory();
                    Session session = sesion.openSession();

                    Query query = HibernateUtil.getCurrentSession().
                            createQuery("FROM PiezasEntity c WHERE c.nombre = :nombre");
                    query.setParameter("nombre",textonombre.getText());
                    PiezasEntity pieza = (PiezasEntity) query.uniqueResult();

                    listaPiezas.setModel(modelo);
                    try {
                        modelo.addElement("Codigo: " + pieza.getCodigo() + " Nombre: " + pieza.getNombre() + " Precio: " + pieza.getPrecio() + " Descripción: " + pieza.getDescripcion());
                    } catch (Exception ex) {
                        System.out.println("no se pudo actualizar");
                        JOptionPane.showMessageDialog(null, "error al ver la lista de piezas, asegurate de meter un valor valido", "error inesperado", JOptionPane.ERROR_MESSAGE);
                    }


                    session.close();

                    HibernateUtil.closeSessionFactory();
                } catch (HibernateException ex) {
                    System.out.println("no se pudo actualizar");
                    JOptionPane.showMessageDialog(null, "error al buscar piezas", "error inesperado", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        buscar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    modelo.removeAllElements();


                    HibernateUtil.buildSessionFactory();

                    SessionFactory sesion = HibernateUtil.getCurrentSession().getSessionFactory();
                    Session session = sesion.openSession();

                    Query query = HibernateUtil.getCurrentSession().
                            createQuery("FROM PiezasEntity c WHERE c.codigo = :nombre");
                    query.setParameter("nombre",textocodigo.getText());
                    PiezasEntity pieza = (PiezasEntity) query.uniqueResult();

                    listaPiezas.setModel(modelo);
                    try {
                        modelo.addElement("Codigo: " + pieza.getCodigo() + " Nombre: " + pieza.getNombre() + " Precio: " + pieza.getPrecio() + " Descripción: " + pieza.getDescripcion());
                    } catch (Exception ex) {
                        System.out.println("no se pudo actualizar");
                        JOptionPane.showMessageDialog(null, "error al ver la lista de piezas,asegurate de meter un valor valido", "error inesperado", JOptionPane.ERROR_MESSAGE);
                    }


                    session.close();

                    HibernateUtil.closeSessionFactory();
                } catch (HibernateException ex) {
                    System.out.println("no se pudo actualizar");
                    JOptionPane.showMessageDialog(null, "error al buscar piezas", "error inesperado", JOptionPane.ERROR_MESSAGE);
                } catch (HeadlessException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
    }
}
