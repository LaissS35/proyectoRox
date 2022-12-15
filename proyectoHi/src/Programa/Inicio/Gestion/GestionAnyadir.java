package Programa.Inicio.Gestion;

import BD.GestionEntity;
import BD.PiezasEntity;
import BD.ProveedoresEntity;
import BD.ProyectosEntity;
import Programa.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.List;

public class GestionAnyadir extends JFrame {
    private JButton listadoButton;
    private JComboBox comboBoxProve;
    private JComboBox comboBoxPieza;
    private JComboBox comboBoxPro;
    private JPanel panel;
    private JButton menúGestionButton;
    private JButton añadirButton;
    private JTextField textoCantidad;
    private JLabel labelcanti;
    private JTextField textField1;
    private JLabel labelid;

    public GestionAnyadir(){

        setContentPane(panel);
        //llenar combobox

        HibernateUtil.buildSessionFactory();
        Query query = HibernateUtil.getCurrentSession().createQuery("from PiezasEntity ");
        List<PiezasEntity> piezas = query.list();


        for (PiezasEntity pieza: piezas){
            comboBoxPieza.addItem(pieza.getCodigo());

        }

        Query query2 = HibernateUtil.getCurrentSession().createQuery("from ProveedoresEntity ");
        List<ProveedoresEntity> prove = query2.list();


        for (ProveedoresEntity pieza: prove){
            comboBoxProve.addItem(pieza.getCodigo());

        }

        Query query3 = HibernateUtil.getCurrentSession().createQuery("from ProyectosEntity ");
        List<ProyectosEntity> proye = query3.list();


        for (ProyectosEntity pieza: proye){
            comboBoxPro.addItem(pieza.getCodigo());

        }





        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //FUNCIONA
                int posici1 = comboBoxPieza.getSelectedIndex();
                int posici2 = comboBoxPro.getSelectedIndex();
                int posici3 =comboBoxProve.getSelectedIndex();

                String proveIndex=comboBoxProve.getItemAt(posici3).toString();//valor del id
                String proyeInderx = comboBoxPro.getItemAt(posici2).toString();
                String piezaIndex = comboBoxPieza.getItemAt(posici1).toString();



                if(textoCantidad.getText().length()>=1 ){

                    try {
                        HibernateUtil.buildSessionFactory();

                        GestionEntity GestionM = new GestionEntity();

                        //coger los objetos en concreto
                        Query query = HibernateUtil.getCurrentSession().
                                createQuery("FROM ProveedoresEntity c WHERE c.codigo = :nombre1");
                        query.setParameter("nombre1",proveIndex);
                        ProveedoresEntity proveedor = (ProveedoresEntity) query.uniqueResult();

                        GestionM.setProveedor(proveedor);//se le pasa el objeto entero

                         query = HibernateUtil.getCurrentSession().
                                createQuery("FROM ProyectosEntity c WHERE c.codigo = :nombre2");
                        query.setParameter("nombre2",proyeInderx);
                        ProyectosEntity proyecto = (ProyectosEntity) query.uniqueResult();

                        GestionM.setProyecto(proyecto);

                         query = HibernateUtil.getCurrentSession().
                                createQuery("FROM PiezasEntity c WHERE c.codigo = :nombre3");
                        query.setParameter("nombre3",piezaIndex);
                        PiezasEntity pieza = (PiezasEntity) query.uniqueResult();


                        //id automatico

                        GestionM.setPieza(pieza);

                        GestionM.setCantidad(Integer.parseInt(textoCantidad.getText()));



                        Session sesion = HibernateUtil.getCurrentSession();
                        sesion.beginTransaction();
                        sesion.save(GestionM);

                        sesion.getTransaction().commit();
                        sesion.close();
                    } catch (NumberFormatException ex) {
                        System.out.println("no se pudo añadir una nueva gestioon");
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
