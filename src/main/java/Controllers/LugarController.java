/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DAO.LugarDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author Classroom
 */
public class LugarController {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Configurar la fábrica de sesiones de Hibernate
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(LugarDAO.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para crear una nueva ciudad en la base de datos
    public String crearLugar(int idLugar, int idCiudad, String nombre, String descripcion, String imagen) {
        Session session = sessionFactory.openSession();

        try {
            LugarDAO ciudad = new LugarDAO(idLugar, idCiudad, nombre, descripcion, imagen);

            session.beginTransaction();
            session.save(ciudad);
            session.getTransaction().commit();

            return "Ciudad creada";

        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return "Error al crear ciudad";

        } finally {
            session.close();
        }
    }

    // Método para actualizar una ciudad existente en la base de datos
    public String actualizarLugar(int idLugar, int idCiudad, String nombre, String descripcion, String imagen) {
        Session session = sessionFactory.openSession();

        try {
            LugarDAO ciudad = new LugarDAO( idLugar,  idCiudad,  nombre,  descripcion,  imagen);

            session.beginTransaction();
            session.update(ciudad);
            session.getTransaction().commit();

            return "Ciudad actualizada";

        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return "Error al actualizar ciudad";

        } finally {
            session.close();
        }
    }

    // Método para eliminar una ciudad en la base de datos
    public String eliminarCiudad(int idLugar) {
        Session session = sessionFactory.openSession();

        try {
            LugarDAO lugar = session.get(LugarDAO.class, idLugar);

            if (lugar != null) {
                session.beginTransaction();
                session.delete(lugar);
                session.getTransaction().commit();
                return "Ciudad eliminada";
            } else {
                return "Ciudad no encontrada";
            }

        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return "Error al eliminar ciudad";

        } finally {
            session.close();
        }
    }

    // Método para obtener todas las ciudades
    public List<LugarDAO> obtenerTodasLasCiudades() {
        Session session = sessionFactory.openSession();
        List<LugarDAO> listaLugares = null;

        try {
            session.beginTransaction();
            String hql = "FROM LugarDAO";
            listaLugares = session.createQuery(hql, LugarDAO.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listaLugares;
    }

    // Método para buscar una ciudad por su ID
    public LugarDAO buscarLugarPorId(int idLugar) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            LugarDAO lugar = session.get(LugarDAO.class, idLugar);
            session.getTransaction().commit();
            return lugar;

        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }
    }

    // Método para cerrar la SessionFactory cuando la aplicación termina
    public static void cerrarSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
    public String obtenerDescripcionLugar1(int idCiudad) {
        List<String> descripcion=null;
        Session session = sessionFactory.openSession();

         try {
            session.beginTransaction();
            String hql = "SELECT l.descripcion FROM LUGAR l WHERE l.idCiudad = :idCiudad";
            @SuppressWarnings("deprecation")
            Query query = session.createQuery(hql);
            query.setParameter("idCiudad", idCiudad);
            descripcion = query.list();
            session.getTransaction().commit();
            return descripcion.get(0);
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }
    }

    public String obtenerDescripcionLugar2(int idCiudad) {
        List<String> descripcion=null;
        Session session = sessionFactory.openSession();

         try {
            session.beginTransaction();
            String hql = "SELECT l.descripcion FROM LUGAR l WHERE l.idCiudad = :idCiudad";
            @SuppressWarnings("deprecation")
            Query query = session.createQuery(hql);
            query.setParameter("idCiudad", idCiudad);
            descripcion = query.list();
            session.getTransaction().commit();
            return descripcion.get(1);
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }
    }
    
}
