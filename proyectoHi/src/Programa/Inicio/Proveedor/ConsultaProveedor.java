package Programa.Inicio.Proveedor;

import BD.ProveedoresEntity;
import Programa.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultaProveedor extends JFrame {
    private JPanel panel;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel ListaDatosProveedor;
    private JButton buscarCodigo;
    private JList listaProveedores;
    private JButton atrasButton;
    private JButton buscarNOmbre;
    private JButton buscarDir;
    private JTextField textoCodigo;

    public  ConsultaProveedor(){
        DefaultListModel<String> modelo = new DefaultListModel<>();
        setContentPane(panel);
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuProve();
            }

            private void menuProve() {
                JFrame frame = new GestionProve();//la otra ventana tiene extend jframe

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
                                createQuery("FROM ProveedoresEntity c WHERE c.codigo = :nombre");
                        query.setParameter("nombre",textoCodigo.getText());
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
                if(textField1.getText().length()>=1){

                    try {
                        modelo.removeAllElements();

                        HibernateUtil.buildSessionFactory();

                        SessionFactory sesion = HibernateUtil.getCurrentSession().getSessionFactory();
                        Session session = sesion.openSession();

                        Query query = HibernateUtil.getCurrentSession().
                                createQuery("FROM ProveedoresEntity c WHERE c.nombre = :nombre");
                        query.setParameter("nombre",textField1.getText());
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
        buscarDir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField2.getText().length()>=1){

                    try {
                        modelo.removeAllElements();

                        HibernateUtil.buildSessionFactory();

                        SessionFactory sesion = HibernateUtil.getCurrentSession().getSessionFactory();
                        Session session = sesion.openSession();

                        Query query = HibernateUtil.getCurrentSession().
                                createQuery("FROM ProveedoresEntity c WHERE c.direccionPostal = :nombre");
                        query.setParameter("nombre",textField2.getText());
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
    }
}
