package Programa.Inicio.Proyecto;

import BD.PiezasEntity;
import BD.ProyectosEntity;
import Programa.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ModifiEliProy extends JFrame {
    private JComboBox comboBox1;
    private JButton eliminarButton;
    private JButton modificarButton;
    private JTextField textoNombre;
    private JTextField textoUbi;
    private JPanel panel;
    private JButton atrasButton;

    public ModifiEliProy(){
        setContentPane(panel);
        //guardar todos los codigos en el combo box
        HibernateUtil.buildSessionFactory();
        Query query = HibernateUtil.getCurrentSession().createQuery("from ProyectosEntity ");
        List<ProyectosEntity> piezas = query.list();


        for (ProyectosEntity pieza: piezas){
            comboBox1.addItem(pieza.getCodigo());

        }
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MenuProyecto();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int posicion = comboBox1.getSelectedIndex();

                //eliminar

                try {
                    HibernateUtil.buildSessionFactory();


                    Query query = HibernateUtil.getCurrentSession().createQuery("from ProyectosEntity p where p.codigo = :barra");//los puntos deben ir enfrente del nuevo valoor, si no da error
                    query.setParameter("barra",comboBox1.getItemAt(posicion));
                    ProyectosEntity piezas = (ProyectosEntity) query.uniqueResult();


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
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int posicion =comboBox1.getSelectedIndex();


                if(textoNombre.getText().length()>=1 || textoUbi.getText().length()>=1){

                    try {
                        HibernateUtil.buildSessionFactory();

                        Query query = HibernateUtil.getCurrentSession().createQuery("from ProyectosEntity p where p.codigo = :barra");//los puntos deben ir enfrente del nuevo valoor, si no da error
                        query.setParameter("barra",comboBox1.getItemAt(posicion));
                        ProyectosEntity piezas = (ProyectosEntity) query.uniqueResult();

                        piezas.setNombre(textoNombre.getText());
                        piezas.setUbicacion(textoUbi.getText());//nuevo valor a meter

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

                }else{
                    System.out.println("no se pudo actualizar");
                    JOptionPane.showMessageDialog(null, "¿estan todos los campos llenos?", "error inesperado", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
    }
}
