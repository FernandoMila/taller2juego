/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

/**
 *
 * @author grabe
 */

import DAO.LugarDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


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

    /**
     * Método para crear un nuevo criminal en la base de datos.
     *
     * @param idLugar           ID del lugar
     * @param idCiudad          ID de la ciudad
     * @param nombre            Nombre del lugar
     * @param descripcion       Descripcion del lugar
     * @param imagen            Imagen del lugar
     * @return                Mensaje indicando si el lugar fue creado
     */
    public String crearLugar(int idLugar, int idCiudad, String nombre, String descripcion, String imagen) {

        // Abrir una nueva sesión de Hibernate
        Session session = sessionFactory.openSession();

        try {
            // Crear una nueva instancia de LugarDAO
            LugarDAO lugar = new LugarDAO(idLugar, idCiudad, nombre, descripcion, imagen);

            // Iniciar una transacción de Hibernate
            session.beginTransaction();

            // Guardar el objeto lugar en la base de datos
            session.save(lugar);

            // Confirmar la transacción
            session.getTransaction().commit();

            return "Lugar creado";

        } catch (Exception e) {
            // Manejar cualquier excepción que ocurra y hacer rollback de la transacción
            if (session.getTransaction() != null) {
                // Rollback significa deshacer la transacción para dejar la base de datos en el estado anterior
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return "Error al crear criminal";

        } finally {
            // Cerrar la sesión de Hibernate
            session.close();
        }
    }

    // Método para obtener todos los lugares
    public List<LugarDAO> obtenerTodosLosLugares() {
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

    // Método para filtrar lugares por todos los atributos
    public List<LugarDAO> filtrarLugares(Integer idLugar, Integer idCiudad, String nombre, String descripcion, String imagen) {
        Session session = sessionFactory.openSession();
        try {
            String hql = "from LugarDAO where 1=1";
            if (idLugar != null) {
                hql += " and idLugar = :idLugar";
            }
            if (idCiudad != null) {
                hql += " and idCiudad = :idCiudad";
            }
            if (nombre != null && !nombre.isEmpty()) {
                hql += " and nombre like :nombre";
            }
            if (descripcion != null && !descripcion.isEmpty()) {
                hql += " and descripcion = :descripcion";
            }
            if (imagen != null && !imagen.isEmpty()) {
                hql += " and imagen like :imagen";
            }
            

            var query = session.createQuery(hql, LugarDAO.class);
            if (idLugar != null) {
                query.setParameter("idLugar", idLugar);
            }
            if (idCiudad != null) {
                query.setParameter("idCiudad", idCiudad);
            }
            if (nombre != null && !nombre.isEmpty()) {
                query.setParameter("nombre", "%" + nombre + "%");
            }
            if (descripcion != null && !descripcion.isEmpty()) {
                query.setParameter("descripcion", descripcion);
            }
            if (imagen != null && !imagen.isEmpty()) {
                query.setParameter("imagen", "%" + imagen + "%");
            }


            return query.list();
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
}
