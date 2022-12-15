package Programa.Inicio.Piezas;

import BD.PiezasEntity;
import Programa.Clases.Piezas;
import Programa.HibernateUtil;
import org.hibernate.Query;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListaPiezas extends JFrame {
    private JList listaPiezas;
    private JPanel panel;
    private JButton atrasButton;

    public ListaPiezas() {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        setContentPane(panel);

        try {
            HibernateUtil.buildSessionFactory();
            Query query = HibernateUtil.getCurrentSession().createQuery("from PiezasEntity ");
            List<PiezasEntity> piezas = query.list();


            listaPiezas.setModel(modelo);

            for (PiezasEntity pieza : piezas) {
                modelo.addElement("Codigo: " + pieza.getCodigo() + " Nombre: " + pieza.getNombre() + " Precio: " + pieza.getPrecio() + " Descripción: " + pieza.getDescripcion());

            }
        } catch (Exception ex) {
            System.out.println("no se pudo actualizar");
            JOptionPane.showMessageDialog(null, "error al ver la lista de piezas", "error inesperado", JOptionPane.ERROR_MESSAGE);



        }
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MenuPiezas();//la otra ventana tiene extend jframe
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });

    }
}
