package Programa.Inicio.Piezas;

import BD.PiezasEntity;
import Programa.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EliminarModificarPieza extends JFrame {
    private JComboBox comboBoxPiezas;
    private JTextField textonuevoNombre;
    private JTextField textonuevaDescripcion;
    private JButton eliminarButton;
    private JButton modificarButton;
    private JPanel panel;
    private JButton atrasButton;
    private JButton limpiarButton;

    public EliminarModificarPieza (){
        //guardar todos los codigos en el combo box
        HibernateUtil.buildSessionFactory();
        Query query = HibernateUtil.getCurrentSession().createQuery("from PiezasEntity ");
        List<PiezasEntity> piezas = query.list();


        for (PiezasEntity pieza: piezas){
            comboBoxPiezas.addItem(pieza.getCodigo());

        }

        //---------------------------------------------------------




        setContentPane(panel);
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MenuPiezas();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int posicion = comboBoxPiezas.getSelectedIndex();

                //eliminar

                try {
                    HibernateUtil.buildSessionFactory();

                    String codigo="susu0";//seleccionar el codigo que se quiere editar
                    Query query = HibernateUtil.getCurrentSession().createQuery("from PiezasEntity p where p.codigo = :barra");//los puntos deben ir enfrente del nuevo valoor, si no da error
                    query.setParameter("barra",comboBoxPiezas.getItemAt(posicion));
                    PiezasEntity piezas = (PiezasEntity) query.uniqueResult();


                    Session sesion = HibernateUtil.getCurrentSession();
                    sesion.beginTransaction();
                    sesion.delete(piezas);
                    sesion.getTransaction().commit();
                    sesion.close();

                    HibernateUtil.closeSessionFactory();
                    JOptionPane.showMessageDialog(null, "se elimino correctamente", "todo correcto", JOptionPane.INFORMATION_MESSAGE);
                } catch (HibernateException ex) {
                    System.out.println("no se pudo eliminar");
                    JOptionPane.showMessageDialog(null, "error al eliminar una pieza", "error inesperado", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int posicion =comboBoxPiezas.getSelectedIndex();


                if((textonuevaDescripcion.getText().length()>=1 && textonuevaDescripcion.getText().length()<=445) && (textonuevoNombre.getText().length()>=1 && textonuevoNombre.getText().length()<=45)){

                    try {
                        HibernateUtil.buildSessionFactory();

                        Query query = HibernateUtil.getCurrentSession().createQuery("from PiezasEntity p where p.codigo = :barra");//los puntos deben ir enfrente del nuevo valoor, si no da error
                        query.setParameter("barra",comboBoxPiezas.getItemAt(posicion));
                        PiezasEntity piezas = (PiezasEntity) query.uniqueResult();

                        piezas.setNombre(textonuevoNombre.getText().toUpperCase());
                        piezas.setDescripcion(textonuevaDescripcion.getText().toUpperCase());//nuevo valor a meter

                        Session sesion = HibernateUtil.getCurrentSession();
                        sesion.beginTransaction();
                        sesion.save(piezas);
                        sesion.getTransaction().commit();
                        sesion.close();

                        HibernateUtil.closeSessionFactory();
                        JOptionPane.showMessageDialog(null, "modificado con exito", "todo correctoo", JOptionPane.INFORMATION_MESSAGE);
                    } catch (HibernateException ex) {
                        System.out.println("error,no se pudo actualizar");
                        JOptionPane.showMessageDialog(null, "erro,no se pudo actualizar la pieza", "error inesperado", JOptionPane.ERROR_MESSAGE);

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
                textonuevoNombre.setText("");
                textonuevaDescripcion.setText("");
            }
        });
    }
}
