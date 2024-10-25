package Controllers;

import DAO.CiudadDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CiudadController {

    // SessionFactory es costosa de crear y debería ser una instancia única
    private static SessionFactory sessionFactory;

    static {
        try {
            // Configurar la fábrica de sesiones de Hibernate
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(CiudadDAO.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para crear una nueva ciudad en la base de datos
    public String crearCiudad(int idCiudad, String nombreCiudad, String descripcionCiudad, String imagenCiudad) {
        Session session = sessionFactory.openSession();

        try {
            CiudadDAO ciudad = new CiudadDAO(idCiudad, nombreCiudad, descripcionCiudad, imagenCiudad);

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
    public String actualizarCiudad(int idCiudad, String nombreCiudad, String descripcionCiudad, String imagenCiudad) {
        Session session = sessionFactory.openSession();

        try {
            CiudadDAO ciudad = new CiudadDAO(idCiudad, nombreCiudad, descripcionCiudad, imagenCiudad);

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
    public String eliminarCiudad(int idCiudad) {
        Session session = sessionFactory.openSession();

        try {
            CiudadDAO ciudad = session.get(CiudadDAO.class, idCiudad);

            if (ciudad != null) {
                session.beginTransaction();
                session.delete(ciudad);
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
    public List<CiudadDAO> obtenerTodasLasCiudades() {
        Session session = sessionFactory.openSession();
        List<CiudadDAO> listaCiudades = null;

        try {
            session.beginTransaction();
            String hql = "FROM CiudadDAO";
            listaCiudades = session.createQuery(hql, CiudadDAO.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listaCiudades;
    }

    // Método para buscar una ciudad por su ID
    public CiudadDAO buscarCiudadPorId(int idCiudad) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            CiudadDAO ciudad = session.get(CiudadDAO.class, idCiudad);
            session.getTransaction().commit();
            return ciudad;

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
