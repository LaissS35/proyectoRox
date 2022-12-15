package Programa;

import BD.GestionEntity;
import BD.PiezasEntity;
import BD.ProveedoresEntity;
import BD.ProyectosEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

   // static Configuration cfg = new Configuration().configure();
   // private static final SessionFactory sessionFactory = buildSessionFactory();

  //  private static  SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build() );

    private static SessionFactory sessionFactory;
    private static Session session;

    /*
    public static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
    public static SessionFactory getSessionFactory() {

        return sessionFactory;
    }*/

    public static void buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();

        //tener en cuenta las clases mapeadas
         configuration.addAnnotatedClass(GestionEntity.class);
        configuration.addAnnotatedClass(PiezasEntity.class);
        configuration.addAnnotatedClass(ProveedoresEntity.class);
        configuration.addAnnotatedClass(ProyectosEntity.class);


        StandardServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory( serviceRegistry);
    }
    public static Session getCurrentSession(){
        if((session ==null)|| (!session.isOpen()))
            openSession();

        return session;

    }

    public static void openSession(){
        session= sessionFactory.openSession();
    }

    public static void closeSessionFactory(){
        if(session !=null)
            session.close();
        if(sessionFactory !=null)
            sessionFactory.close();
    }


}
