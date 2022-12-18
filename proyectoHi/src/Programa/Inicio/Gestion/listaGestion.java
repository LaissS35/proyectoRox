package Programa.Inicio.Gestion;

import BD.GestionEntity;
import BD.PiezasEntity;
import Programa.HibernateUtil;
import org.hibernate.Query;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class listaGestion extends JFrame {
    private JList listagestion;
    private JPanel panel;
    private JButton atrasB;

    public listaGestion() {
        setContentPane(panel);
        DefaultListModel<String> modelo = new DefaultListModel<>();


        try {
            HibernateUtil.buildSessionFactory();
            Query query = HibernateUtil.getCurrentSession().createQuery("from GestionEntity ");
            List<GestionEntity> piezas = query.list();


            listagestion.setModel(modelo);

            for (GestionEntity pieza : piezas) {
                modelo.addElement("Codigo proveedor: " + pieza.getProveedor().getCodigo() + " Codigo pieza: " + pieza.getPieza().getCodigo() + " Codigo proyecto: " + pieza.getProyecto().getCodigo() + " Cantidad: " + pieza.getCantidad());

            }
        } catch (Exception ex) {
            System.out.println("no se pudo actualizar");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "error al ver la lista de gestion", "error inesperado", JOptionPane.ERROR_MESSAGE);



        }

        atrasB.addActionListener(new ActionListener() {
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
