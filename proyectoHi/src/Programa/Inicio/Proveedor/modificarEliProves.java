package Programa.Inicio.Proveedor;

import BD.ProveedoresEntity;
import Programa.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class modificarEliProves extends JFrame {
    private JPanel panel;
    private JComboBox comboBox1;
    private JTextField textoNombre;
    private JTextField textoDireccion;

    private JButton BotonEliminar;

    private JButton atrasButton;
    private JButton modificarButton;
    private JButton limpiarButton;

    public modificarEliProves() {
        setContentPane(panel);

        //llenar combobox
        HibernateUtil.buildSessionFactory();
        Query query = HibernateUtil.getCurrentSession().createQuery("from ProveedoresEntity ");
        List<ProveedoresEntity> piezas = query.list();


        for (ProveedoresEntity pieza: piezas){
            comboBox1.addItem(pieza.getCodigo());

        }




        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new menuProves();
                frame.setSize(700, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();

            }
        });
        BotonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int posicion = comboBox1.getSelectedIndex();

                //eliminar

                try {
                    HibernateUtil.buildSessionFactory();


                    Query query = HibernateUtil.getCurrentSession().createQuery("from ProveedoresEntity p where p.codigo = :barra");//los puntos deben ir enfrente del nuevo valoor, si no da error
                    query.setParameter("barra",comboBox1.getItemAt(posicion));
                    ProveedoresEntity piezas = (ProveedoresEntity) query.uniqueResult();


                    try {
                        Session sesion = HibernateUtil.getCurrentSession();

                        sesion.beginTransaction();

                        sesion.delete(piezas);

                        sesion.getTransaction().commit();
                        sesion.close();
                    } catch (HibernateException ex) {
                        System.out.println("reinicia");
                    }


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


                if((textoDireccion.getText().length()>=1 && textoDireccion.getText().length()<=445) && (textoNombre.getText().length()>=1 && textoNombre.getText().length()<=45)){
                    System.out.println(textoNombre.getText().length()+"<-tamaño de nombre");
                    try {
                        HibernateUtil.buildSessionFactory();

                        Query query = HibernateUtil.getCurrentSession().createQuery("from ProveedoresEntity p where p.codigo = :barra");//los puntos deben ir enfrente del nuevo valoor, si no da error
                        query.setParameter("barra",comboBox1.getItemAt(posicion));
                        ProveedoresEntity piezas = (ProveedoresEntity) query.uniqueResult();

                        piezas.setNombre(textoNombre.getText().toUpperCase());
                        piezas.setDireccionPostal(textoDireccion.getText().toUpperCase());//nuevo valor a meter

                        Session sesion = HibernateUtil.getCurrentSession();
                        sesion.beginTransaction();
                        sesion.save(piezas);
                        sesion.getTransaction().commit();
                        sesion.close();

                        HibernateUtil.closeSessionFactory();
                        JOptionPane.showMessageDialog(null, "modificado con exito", "todo correcto", JOptionPane.INFORMATION_MESSAGE);
                    } catch (HibernateException ex) {
                        System.out.println("error,no se pudo actualizar");
                        JOptionPane.showMessageDialog(null, "erro,no se pudo actualizar el proveedor", "error inesperado", JOptionPane.ERROR_MESSAGE);

                    }

                }else{
                    System.out.println("no se pudo actualizar");
                    JOptionPane.showMessageDialog(null, "no debes dejar campos vacios ni exceder su maximo", "error inesperado", JOptionPane.ERROR_MESSAGE);

                }

            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textoDireccion.setText("");
                textoNombre.setText("");
            }
        });
    }
}
