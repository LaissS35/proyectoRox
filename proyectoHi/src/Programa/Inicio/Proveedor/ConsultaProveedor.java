package Programa.Inicio.Proveedor;

import BD.ProveedoresEntity;
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

public class ConsultaProveedor extends JFrame {
    private JPanel panel;
    private JTextField textoNombre;
    private JTextField textoDire;
    private JPanel ListaDatosProveedor;
    private JButton buscarCodigo;
    private JList listaProveedores;
    private JButton atrasButton;
    private JButton buscarNOmbre;
    private JButton buscarDir;
    private JTextField textoCodigo;
    private JButton limpiarButton;

    public  ConsultaProveedor(){

        setContentPane(panel);
        DefaultListModel<String> modelo = new DefaultListModel<>();
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuProve();
            }

            private void menuProve() {
                JFrame frame = new menuProves();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        buscarCodigo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textoCodigo.getText().length()>=1 && textoCodigo.getText().length()<=6){

                    try {
                        modelo.removeAllElements();

                        HibernateUtil.buildSessionFactory();

                        SessionFactory sesion = HibernateUtil.getCurrentSession().getSessionFactory();
                        Session session = sesion.openSession();

                        Query query = HibernateUtil.getCurrentSession().
                                createQuery("FROM ProveedoresEntity c WHERE c.codigo = :nombre");
                        query.setParameter("nombre",textoCodigo.getText().toUpperCase());
                        ProveedoresEntity pieza = (ProveedoresEntity) query.uniqueResult();

                        listaProveedores.setModel(modelo);
                        try {
                            modelo.addElement("Codigo: " + pieza.getCodigo() + " Nombre: " + pieza.getNombre() + " Apellido: " + pieza.getApellidos() + " Direccion: " + pieza.getDireccionPostal());
                        } catch (Exception ex) {
                            System.out.println("no se pudo encontrar");
                            JOptionPane.showMessageDialog(null, "no se encontro ", "error inesperado", JOptionPane.ERROR_MESSAGE);
                        }


                        session.close();

                        HibernateUtil.closeSessionFactory();
                    } catch (HibernateException ex) {
                        System.out.println("no se pudo encontrar");
                        JOptionPane.showMessageDialog(null, "error al buscar ", "error inesperado", JOptionPane.ERROR_MESSAGE);
                    }}else{
                    JOptionPane.showMessageDialog(null, "debes meter minimo 1 caracter", "error inesperado", JOptionPane.ERROR_MESSAGE);
                }


            }
        });

        buscarNOmbre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textoNombre.getText().length()>=1 && textoNombre.getText().length()<=45){

                    try {
                        modelo.removeAllElements();

                        HibernateUtil.buildSessionFactory();

                        SessionFactory sesion = HibernateUtil.getCurrentSession().getSessionFactory();
                        Session session = sesion.openSession();

                        Query query = HibernateUtil.getCurrentSession().
                                createQuery("FROM ProveedoresEntity c WHERE c.nombre = :nombre");
                        query.setParameter("nombre", textoNombre.getText().toUpperCase());
                        ArrayList<ProveedoresEntity> pieza =(ArrayList<ProveedoresEntity>)query.list();

                        listaProveedores.setModel(modelo);

                        try {
                            for (ProveedoresEntity piezas : pieza) {
                                modelo.addElement("Codigo: " + piezas.getCodigo() + " Nombre: " + piezas.getNombre() + " Apellido: " + piezas.getApellidos() + " Direccion: " + piezas.getDireccionPostal());
                            }
                        } catch (Exception ex) {
                            System.out.println("no se pudo encontrar");
                            JOptionPane.showMessageDialog(null, "no se encontro ", "error inesperado", JOptionPane.ERROR_MESSAGE);
                        }


                        session.close();

                        HibernateUtil.closeSessionFactory();
                    } catch (HibernateException ex) {
                        System.out.println("no se pudo encontrar");
                        JOptionPane.showMessageDialog(null, "error al buscar ", "error inesperado", JOptionPane.ERROR_MESSAGE);
                    }}else{
                    JOptionPane.showMessageDialog(null, "debes meter minimo 1 caracter", "error inesperado", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        buscarDir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textoDire.getText().length()>=1 && textoDire.getText().length()<=455){

                    try {
                        modelo.removeAllElements();

                        HibernateUtil.buildSessionFactory();

                        SessionFactory sesion = HibernateUtil.getCurrentSession().getSessionFactory();
                        Session session = sesion.openSession();

                        Query query = HibernateUtil.getCurrentSession().
                                createQuery("FROM ProveedoresEntity c WHERE c.direccionPostal = :nombre");
                        query.setParameter("nombre", textoDire.getText().toUpperCase());
                        ArrayList<ProveedoresEntity> pieza =(ArrayList<ProveedoresEntity>)query.list();

                        listaProveedores.setModel(modelo);

                        try {
                            for (ProveedoresEntity piezas : pieza) {
                                modelo.addElement("Codigo: " + piezas.getCodigo() + " Nombre: " + piezas.getNombre() + " Apellido: " + piezas.getApellidos() + " Direccion: " + piezas.getDireccionPostal());
                            }

                        } catch (Exception ex) {
                            System.out.println("no se pudo encontrar");
                            JOptionPane.showMessageDialog(null, "no se encontro ", "error inesperado", JOptionPane.ERROR_MESSAGE);
                        }


                        session.close();

                        HibernateUtil.closeSessionFactory();
                    } catch (HibernateException ex) {
                       // ex.printStackTrace();
                        System.out.println("no se pudo encontrar");
                        JOptionPane.showMessageDialog(null, "error al buscar ", "error inesperado", JOptionPane.ERROR_MESSAGE);
                    }}else{
                    JOptionPane.showMessageDialog(null, "debes meter minimo 1 caracter", "error inesperado", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textoCodigo.setText("");
                textoDire.setText("");
                textoNombre.setText("");
            }
        });
    }
}
