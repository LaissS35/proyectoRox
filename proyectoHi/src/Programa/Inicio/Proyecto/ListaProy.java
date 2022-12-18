package Programa.Inicio.Proyecto;

import BD.PiezasEntity;
import BD.ProyectosEntity;
import Programa.HibernateUtil;
import org.hibernate.Query;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListaProy extends JFrame{
    private JList listaProyecto;
    private JPanel panel;
    private JButton atrasButton;

    public ListaProy() {
        setContentPane(panel);


        //--LISTA--
        DefaultListModel<String> modelo = new DefaultListModel<>();
        try {
            HibernateUtil.buildSessionFactory();
            Query query = HibernateUtil.getCurrentSession().createQuery("from ProyectosEntity ");
            List<ProyectosEntity> piezas = query.list();


            listaProyecto.setModel(modelo);

            for (ProyectosEntity pieza : piezas) {
                modelo.addElement("Codigo: " + pieza.getCodigo() + " Nombre: " + pieza.getNombre() + " Descripcion: " + pieza.getDescripcion() + " Ubicacion: " + pieza.getUbicacion());

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "error al ver la lista ", "error inesperado", JOptionPane.ERROR_MESSAGE);

        }

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
    }
}
