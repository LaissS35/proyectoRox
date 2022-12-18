package Programa;


import BD.GestionEntity;
import BD.PiezasEntity;

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

        JFrame frame = new inicio();
        frame.setSize(700,600);
        frame.setLocationRelativeTo(null);//ventana sale centrada
        frame.setVisible(true);




    }

}