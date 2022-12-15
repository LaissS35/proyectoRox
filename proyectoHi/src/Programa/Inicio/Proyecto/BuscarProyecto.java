package Programa.Inicio.Proyecto;

import BD.PiezasEntity;
import BD.ProyectosEntity;
import Programa.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarProyecto extends JFrame {
    private JTextField textoCodigo;
    private JTextField textoNombre;
    private JTextField textoCiudad;
    private JButton buscarCodigo;
    private JPanel panel;
    private JButton atrasButton;
    private JButton BuscarNombre;
    private JButton buscarCiudad;
    private JList listaProyecto;

    public BuscarProyecto(){
        DefaultListModel<String> modelo = new DefaultListModel<>();
        setContentPane(panel);
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MenuProyecto();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        buscarCodigo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textoCodigo.getText().length()>=1){

                    try {
                        modelo.removeAllElements();

                        HibernateUtil.buildSessionFactory();

                        SessionFactory sesion = HibernateUtil.getCurrentSession().getSessionFactory();
                        Session session = sesion.openSession();

                        Query query = HibernateUtil.getCurrentSession().
                                createQuery("FROM ProyectosEntity c WHERE c.codigo = :nombre");
                        query.setParameter("nombre",textoCodigo.getText());
                        ProyectosEntity pieza = (ProyectosEntity) query.uniqueResult();

                        listaProyecto.setModel(modelo);
                        try {
                            modelo.addElement("Codigo: " + pieza.getCodigo() + " Nombre: " + pieza.getNombre() + " Ubicación: " + pieza.getUbicacion() + " Descripción: " + pieza.getDescripcion());
                        } catch (Exception ex) {
                            System.out.println("no se pudo encontrar");
                            JOptionPane.showMessageDialog(null, "no se encontro el proyectos", "error inesperado", JOptionPane.ERROR_MESSAGE);
                        }


                        session.close();

                        HibernateUtil.closeSessionFactory();
                    } catch (HibernateException ex) {
                        System.out.println("no se pudo encontrar");
                        JOptionPane.showMessageDialog(null, "error al buscar proyecto", "error inesperado", JOptionPane.ERROR_MESSAGE);
                    }}else{
                    JOptionPane.showMessageDialog(null, "debes meter minimo 1 caracter", "error inesperado", JOptionPane.ERROR_MESSAGE);
                }


            }
        });
        BuscarNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textoNombre.getText().length()>=1){

                    try {
                        modelo.removeAllElements();

                        HibernateUtil.buildSessionFactory();

                        SessionFactory sesion = HibernateUtil.getCurrentSession().getSessionFactory();
                        Session session = sesion.openSession();

                        Query query = HibernateUtil.getCurrentSession().
                                createQuery("FROM ProyectosEntity c WHERE c.nombre = :nombre");
                        query.setParameter("nombre",textoNombre.getText());
                        ProyectosEntity pieza = (ProyectosEntity) query.uniqueResult();

                        listaProyecto.setModel(modelo);
                        try {
                            modelo.addElement("Codigo: " + pieza.getCodigo() + " Nombre: " + pieza.getNombre() + " Ubicación: " + pieza.getUbicacion() + " Descripción: " + pieza.getDescripcion());
                        } catch (Exception ex) {
                            System.out.println("no se pudo encontrar");
                            JOptionPane.showMessageDialog(null, "no se encontro el proyectos", "error inesperado", JOptionPane.ERROR_MESSAGE);
                        }


                        session.close();

                        HibernateUtil.closeSessionFactory();
                    } catch (HibernateException ex) {
                        System.out.println("no se pudo encontrar");
                        JOptionPane.showMessageDialog(null, "error al buscar un proyecto", "error inesperado", JOptionPane.ERROR_MESSAGE);
                    }}else{
                    JOptionPane.showMessageDialog(null, "debes meter minimo 1 caracter", "error inesperado", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        buscarCiudad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textoCiudad.getText().length()>=1){

                    try {
                        modelo.removeAllElements();

                        HibernateUtil.buildSessionFactory();

                        SessionFactory sesion = HibernateUtil.getCurrentSession().getSessionFactory();
                        Session session = sesion.openSession();

                        Query query = HibernateUtil.getCurrentSession().
                                createQuery("FROM ProyectosEntity c WHERE c.ubicacion = :nombre");
                        query.setParameter("nombre",textoCiudad.getText());
                        ProyectosEntity pieza = (ProyectosEntity) query.uniqueResult();

                        listaProyecto.setModel(modelo);
                        try {
                            modelo.addElement("Codigo: " + pieza.getCodigo() + " Nombre: " + pieza.getNombre() + " Ubicación: " + pieza.getUbicacion() + " Descripción: " + pieza.getDescripcion());
                        } catch (Exception ex) {
                            System.out.println("no se pudo encontrar");
                            JOptionPane.showMessageDialog(null, "no se encontro nada", "error inesperado", JOptionPane.ERROR_MESSAGE);
                        }


                        session.close();

                        HibernateUtil.closeSessionFactory();
                    } catch (HibernateException ex) {
                        System.out.println("no se pudo encontrar");
                        JOptionPane.showMessageDialog(null, "error al buscar proyecto", "error inesperado", JOptionPane.ERROR_MESSAGE);
                    }}else{
                    JOptionPane.showMessageDialog(null, "debes meter minimo 1 caracter", "error inesperado", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
}
