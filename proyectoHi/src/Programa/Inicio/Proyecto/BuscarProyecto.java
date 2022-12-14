package Programa.Inicio.Proyecto;

import BD.ProyectosEntity;
import Programa.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private JButton limpiarButton;

    public BuscarProyecto(){
        DefaultListModel<String> modelo = new DefaultListModel<>();
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
                        query.setParameter("nombre",textoCodigo.getText().toUpperCase());
                        ProyectosEntity pieza = (ProyectosEntity) query.uniqueResult();

                        listaProyecto.setModel(modelo);
                        try {
                            modelo.addElement("Codigo: " + pieza.getCodigo() + " Nombre: " + pieza.getNombre() + " Ubicaci??n: " + pieza.getUbicacion() + " Descripci??n: " + pieza.getDescripcion());
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
                        query.setParameter("nombre",textoNombre.getText().toUpperCase());
                        ProyectosEntity pieza = (ProyectosEntity) query.uniqueResult();

                        listaProyecto.setModel(modelo);
                        try {
                            modelo.addElement("Codigo: " + pieza.getCodigo() + " Nombre: " + pieza.getNombre() + " Ubicaci??n: " + pieza.getUbicacion() + " Descripci??n: " + pieza.getDescripcion());
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
                        query.setParameter("nombre",textoCiudad.getText().toUpperCase());
                        //ProyectosEntity pieza = (ProyectosEntity) query.uniqueResult();
                        ArrayList<ProyectosEntity>pieza =(ArrayList<ProyectosEntity>)query.list();

                        listaProyecto.setModel(modelo);

                        try {
                            for (ProyectosEntity piezas : pieza) {
                                modelo.addElement("Codigo: " + piezas.getCodigo() + " Nombre: " + piezas.getNombre() + " Ubicaci??n: " + piezas.getUbicacion() + " Descripci??n: " + piezas.getDescripcion());
                            }
                           // modelo.addElement("Codigo: " + pieza.getCodigo() + " Nombre: " + pieza.getNombre() + " Ubicaci??n: " + pieza.getUbicacion() + " Descripci??n: " + pieza.getDescripcion());
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
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textoNombre.setText("");
                textoCodigo.setText("");
                textoCiudad.setText("");
            }
        });
    }
}
