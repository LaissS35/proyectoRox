package Programa.Inicio.Proveedor;

import BD.ProveedoresEntity;
import BD.ProyectosEntity;
import Programa.HibernateUtil;
import org.hibernate.Query;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListaProveedores extends JFrame {
    private JList listaProveedores;
    private JPanel panel;
    private JButton atrasButton;

    public  ListaProveedores(){
        setContentPane(panel);

        //--LISTA--
        DefaultListModel<String> modelo = new DefaultListModel<>();
        try {
            HibernateUtil.buildSessionFactory();
            Query query = HibernateUtil.getCurrentSession().createQuery("from ProveedoresEntity ");
            List<ProveedoresEntity> piezas = query.list();


            listaProveedores.setModel(modelo);

            for (ProveedoresEntity pieza : piezas) {
                modelo.addElement("Codigo: " + pieza.getCodigo() + " Nombre: " + pieza.getNombre() + " Apellido: " + pieza.getApellidos() + " Ubicacion: " + pieza.getDireccionPostal());

            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "error al ver la lista ", "error inesperado", JOptionPane.ERROR_MESSAGE);

        }

        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuProve();
            }

            private void menuProve() {
                JFrame frame = new menuProves();//la otra ventana tiene extend jframe
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();//coger el tamañno de la pantalla
                frame.setSize(700,600);
                frame.setVisible(true);
                dispose();//para cerrar la ventana principal tras pulsar el boton
            }
        });
    }
}
