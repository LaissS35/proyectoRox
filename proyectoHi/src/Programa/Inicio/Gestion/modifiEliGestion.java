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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class modifiEliGestion extends JFrame {
    private JPanel panel;
    private JComboBox comboBoxpieza;
    private JComboBox comboBoxproveedor;
    private JComboBox comboBoxproyecto;
    private JTextField textoCantidad;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JButton atrasButton;

    public modifiEliGestion() {
        setContentPane(panel);
        createUIComponents();

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int posicion =comboBoxpieza.getSelectedIndex();
                int posicion1 = comboBoxproveedor.getSelectedIndex();
                int posicion2 = comboBoxproyecto.getSelectedIndex();


                if(textoCantidad.getText().length()>=1 ){

                    try {
                        HibernateUtil.buildSessionFactory();

                        Query query = HibernateUtil.getCurrentSession().createQuery("from GestionEntity p where p.cpieza = :barra");//los puntos deben ir enfrente del nuevo valoor, si no da error
                        query.setParameter("barra",comboBoxpieza.getItemAt(posicion));
                        GestionEntity gestionG = (GestionEntity) query.uniqueResult();

                        /*

                        piezas.setNombre(textonuevoNombre.getText());
                        piezas.setDescripcion(textonuevaDescripcion.getText());//nuevo valor a meter

                        Session sesion = HibernateUtil.getCurrentSession();
                        sesion.beginTransaction();
                        sesion.save(piezas);
                        sesion.getTransaction().commit();
                        sesion.close();

                        HibernateUtil.closeSessionFactory();*/
                    } catch (HibernateException ex) {
                        System.out.println("no se pudo actualizar");
                        JOptionPane.showMessageDialog(null, "no se pudo actualizar la pieza", "error inesperado", JOptionPane.ERROR_MESSAGE);

                    }

                }else{
                    System.out.println("no se pudo actualizar");
                    JOptionPane.showMessageDialog(null, "¿estan todos los campos llenos?", "error inesperado", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void createUIComponents() {

        //llenar combobox
        //llenar combobox

        HibernateUtil.buildSessionFactory();
        Query query = HibernateUtil.getCurrentSession().createQuery("from PiezasEntity ");
        List<PiezasEntity> piezas = query.list();


        for (PiezasEntity pieza: piezas){
            comboBoxpieza.addItem(pieza.getCodigo());

        }

        Query query2 = HibernateUtil.getCurrentSession().createQuery("from ProveedoresEntity ");
        List<ProveedoresEntity> prove = query2.list();


        for (ProveedoresEntity pieza: prove){
            comboBoxproveedor.addItem(pieza.getCodigo());

        }

        Query query3 = HibernateUtil.getCurrentSession().createQuery("from ProyectosEntity ");
        List<ProyectosEntity> proye = query3.list();


        for (ProyectosEntity pieza: proye){
            comboBoxproyecto.addItem(pieza.getCodigo());

        }
    }
}
