package Programa;


import BD.GestionEntity;
import BD.PiezasEntity;
import Programa.Clases.Piezas;
import Programa.Inicio.Gestion.GestionAnyadir;
import Programa.Inicio.Piezas.EliminarModificarPieza;
import Programa.Inicio.Piezas.ListaPiezas;
import Programa.Inicio.Piezas.MenuPiezas;
import Programa.Inicio.inicio;
import org.hibernate.*;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //FALTA CONTROL DE ERRORES
        //MENU PIEZAS FUNCIONA


        JFrame frame = new GestionAnyadir();
        frame.setSize(700,600);
        frame.setVisible(true);




    }
   



    public static void listaGestion(){
        HibernateUtil.buildSessionFactory();
        Query query = HibernateUtil.getCurrentSession().createQuery("from GestionEntity ");
        List<GestionEntity> gestion = query.list();


        for (GestionEntity gestions: gestion){

            System.out.println("Nº proyecto: "+gestions.getProyecto().getCodigo()+"\nNº proveedor: "+gestions.getProveedor().getCodigo()+"\nNº pieza: "+gestions.getPieza().getCodigo()+"\n cantidad: "+gestions.getCantidad()+"\n Id: "+gestions.getId());//en piezas,provedor y proyecto podemos sacar todos los valores de ese en concreto que tenemos registrado en la tabla, hay que especificar el dato
        }
    } //enlace con gestión correcta

}