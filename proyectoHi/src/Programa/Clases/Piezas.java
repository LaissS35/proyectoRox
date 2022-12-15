package Programa.Clases;

import BD.PiezasEntity;
import Programa.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.List;

public class Piezas  {

    public static void listaPiezas(){
        HibernateUtil.buildSessionFactory();
        Query query = HibernateUtil.getCurrentSession().createQuery("from PiezasEntity ");
        List<PiezasEntity> piezas = query.list();


        for (PiezasEntity pieza: piezas){
            System.out.println("Nombre: "+pieza.getNombre()+"\nCodigo: "+pieza.getCodigo()+"\nDescripción: "+pieza.getDescripcion());
        }

    }//funciona
    public static void meterPiezas(){
        HibernateUtil.buildSessionFactory();

        String codigo="susu0";
        String nombre ="pieza prueba 2";
        String descripción ="...";
        int precio=10;


        // Piezas piezas = new Piezas();
        PiezasEntity piezasM = new PiezasEntity();
        piezasM.setCodigo(codigo);
        piezasM.setNombre(nombre);
        piezasM.setDescripcion(descripción);
        piezasM.setPrecio(BigInteger.valueOf(precio));

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(piezasM);//no detecta piezas
        System.out.println("llega");
        sesion.getTransaction().commit();
        sesion.close();
        System.out.println("fin");


    } //funciona otra vez
    public static void modificarPiezas(){
        HibernateUtil.buildSessionFactory();

        String codigo="susu0";//seleccionar el codigo que se quiere editar
        Query query = HibernateUtil.getCurrentSession().createQuery("from PiezasEntity p where p.codigo = :barra");//los puntos deben ir enfrente del nuevo valoor, si no da error
        query.setParameter("barra",codigo);
        PiezasEntity piezas = (PiezasEntity) query.uniqueResult();

        piezas.setDescripcion("nueva descripción, hola?");//nuevo valor a meter

        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.save(piezas);
        sesion.getTransaction().commit();
        sesion.close();

        HibernateUtil.closeSessionFactory();


    }//funciona
    public static void eliminarPiezas(){
        HibernateUtil.buildSessionFactory();

        String codigo="susu0";//seleccionar el codigo que se quiere editar
        Query query = HibernateUtil.getCurrentSession().createQuery("from PiezasEntity p where p.codigo = :barra");//los puntos deben ir enfrente del nuevo valoor, si no da error
        query.setParameter("barra",codigo);
        PiezasEntity piezas = (PiezasEntity) query.uniqueResult();


        Session sesion = HibernateUtil.getCurrentSession();
        sesion.beginTransaction();
        sesion.delete(piezas);
        sesion.getTransaction().commit();
        sesion.close();

        HibernateUtil.closeSessionFactory();

    }//probar
    public static void buscarPiezas(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //coger texto escrito

        //pedir la pieza que se quiere buscar por codigo
        SessionFactory sesion = HibernateUtil.getCurrentSession().getSessionFactory();
        Session session = sesion.openSession();
        System.out.println("===========================");
        System.out.println("DATOS DE LA PIEZA QUE BUSCAS");
        PiezasEntity dep = new PiezasEntity();
        dep = (PiezasEntity) session.load(PiezasEntity.class, (String)"susu0" );//meter aquí el codigo de lo que busques
        System.out.println("Codigo de la Pieza:"+dep.getCodigo());
        System.out.println("Nombre :" + dep.getNombre());
        System.out.println("Precio:" + dep.getPrecio());
        System.out.println("Descripción:"+dep.getDescripcion());
        System.out.println("==============================");

        session.close();
        System.exit(0);


    } //funciona

}
