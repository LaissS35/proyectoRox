package Programa.Inicio.Gestion;

import BD.GestionEntity;
import BD.PiezasEntity;
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
import java.util.List;
import java.util.Objects;

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
    private JButton atrasButton;

    private JList listaGestion;

    public GestionAnyadir(){

        setContentPane(panel);
        DefaultListModel<String> modelo = new DefaultListModel<>();
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


                if(!verificarE(proveIndex,proyeInderx,piezaIndex)){
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

                        Float precio = Float.valueOf(textoCantidad.getText());

                        GestionM.setCantidad(precio);



                        Session sesion = HibernateUtil.getCurrentSession();
                        sesion.beginTransaction();
                        sesion.save(GestionM);

                        sesion.getTransaction().commit();
                        sesion.close();
                    } catch (NumberFormatException ex) {
                       // ex.printStackTrace();
                        System.out.println("no se pudo añadir una nueva gestioon");
                        JOptionPane.showMessageDialog(null, "error al añadir nueva pieza, asegurate de rellenar todos los valores", "error inesperado", JOptionPane.ERROR_MESSAGE);

                    } catch (HibernateException ex) {
                        throw new RuntimeException(ex);
                    }
                }else{
                    System.out.println("no se pudo añadir");
                    JOptionPane.showMessageDialog(null, "¿estan todos los campos llenos?", "error inesperado", JOptionPane.ERROR_MESSAGE);

                }}else{
                    System.out.println("ya existe");
                }
            }

            private boolean verificarE(String proveIndex, String proyeInderx, String piezaIndex) {
                HibernateUtil.buildSessionFactory();

                SessionFactory sesion = HibernateUtil.getCurrentSession().getSessionFactory();
                Session session = sesion.openSession();


                GestionEntity gestionComparacion = new GestionEntity();

                Query query = HibernateUtil.getCurrentSession().
                        createQuery("FROM ProveedoresEntity c WHERE c.codigo = :nombre1");
                query.setParameter("nombre1",proveIndex);
                ProveedoresEntity proveedor = (ProveedoresEntity) query.uniqueResult();

                gestionComparacion.setProveedor(proveedor);//se le pasa el objeto entero

                query = HibernateUtil.getCurrentSession().
                        createQuery("FROM ProyectosEntity c WHERE c.codigo = :nombre2");
                query.setParameter("nombre2",proyeInderx);
                ProyectosEntity proyecto = (ProyectosEntity) query.uniqueResult();

                gestionComparacion.setProyecto(proyecto);

                query = HibernateUtil.getCurrentSession().
                        createQuery("FROM PiezasEntity c WHERE c.codigo = :nombre3");
                query.setParameter("nombre3",piezaIndex);
                PiezasEntity pieza = (PiezasEntity) query.uniqueResult();


                gestionComparacion.setPieza(pieza);
                gestionComparacion.setCantidad((float) 0);

                //crear una lista de gestiones ya existentes
                HibernateUtil.buildSessionFactory();
                 query = HibernateUtil.getCurrentSession().createQuery("from GestionEntity ");
                List<GestionEntity> g = query.list();


               // listaGestion.setModel(modelo);//nulo

                for (GestionEntity gesReal : g) {
                   if(Objects.equals(gesReal.getProveedor().getCodigo(), gestionComparacion.getProveedor().getCodigo()) && Objects.equals(gesReal.getProyecto().getCodigo(), gestionComparacion.getProyecto().getCodigo()) && Objects.equals(gesReal.getPieza().getCodigo(), gestionComparacion.getPieza().getCodigo())){
                       return true;

                   }

                }



                return false;

            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new Gestion();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();
            }
        });
    }
}
