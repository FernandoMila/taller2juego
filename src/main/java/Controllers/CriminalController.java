package Controllers;

import DAO.CriminalDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

/**
 * Controlador para manejar las operaciones relacionadas con los criminales.
 */
public class CriminalController {

    // SessionFactory es costosa de crear y debería ser una instancia única
    private static SessionFactory sessionFactory;

    static {
        try {
            // Configurar la fábrica de sesiones de Hibernate
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(CriminalDAO.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para crear un nuevo criminal en la base de datos.
     *
     * @param idCriminal      ID del criminal
     * @param nombreCriminal  Nombre del criminal
     * @param hobbie           Hobby del criminal
     * @param sexo            Sexo del criminal
     * @param colorPelo       Color de pelo del criminal
     * @param ocupacion       Ocupación del criminal
     * @param vehiculo        Vehículo del criminal
     * @param caracteristica  Característica distintiva del criminal
     * @return                Mensaje indicando si el criminal fue creado
     */
    public String crearCriminal(int idCriminal, String nombreCriminal, String hobbie, String sexo, String colorPelo, String ocupacion,
                                String vehiculo, String caracteristica) {

        // Abrir una nueva sesión de Hibernate
        Session session = sessionFactory.openSession();

        try {
            // Crear una nueva instancia de CriminalDAO
            CriminalDAO criminal = new CriminalDAO(idCriminal, nombreCriminal, sexo, ocupacion, colorPelo, vehiculo, hobbie, caracteristica);

            // Iniciar una transacción de Hibernate
            session.beginTransaction();

            // Guardar el objeto criminal en la base de datos
            session.save(criminal);

            // Confirmar la transacción
            session.getTransaction().commit();

            return "Criminal creado";

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

    // Método para obtener todos los criminales
    public List<CriminalDAO> obtenerTodosLosCriminales() {
        Session session = sessionFactory.openSession();
        List<CriminalDAO> listaCriminales = null;

        try {
            session.beginTransaction();
            String hql = "FROM CriminalDAO";
            listaCriminales = session.createQuery(hql, CriminalDAO.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listaCriminales;
    }

    // Método para filtrar criminales por todos los atributos
    public List<CriminalDAO> filtrarCriminales(Integer idCriminal, String nombre, String hobbie, String sexo, String colorPelo, String ocupacion, String vehiculo, String caracteristicas) {
        Session session = sessionFactory.openSession();
        try {
            String hql = "from CriminalDAO where 1=1";
            if (idCriminal != null) {
                hql += " and idCriminal = :idCriminal";
            }
            if (nombre != null && !nombre.isEmpty()) {
                hql += " and nombreCriminal like :nombre";
            }
            if (hobbie != null && !hobbie.isEmpty()) {
                hql += " and hobbie like :hobbie";
            }
            if (sexo != null && !sexo.isEmpty()) {
                hql += " and sexo = :sexo";
            }
            if (colorPelo != null && !colorPelo.isEmpty()) {
                hql += " and colorPelo like :colorPelo";
            }
            if (ocupacion != null && !ocupacion.isEmpty()) {
                hql += " and ocupacion like :ocupacion";
            }
            if (vehiculo != null && !vehiculo.isEmpty()) {
                hql += " and vehiculo like :vehiculo";
            }
            if (caracteristicas != null && !caracteristicas.isEmpty()) {
                hql += " and caracteristicas like :caracteristicas";
            }

            var query = session.createQuery(hql, CriminalDAO.class);
            if (idCriminal != null) {
                query.setParameter("idCriminal", idCriminal);
            }
            if (nombre != null && !nombre.isEmpty()) {
                query.setParameter("nombre", "%" + nombre + "%");
            }
            if (hobbie != null && !hobbie.isEmpty()) {
                query.setParameter("hobbie", "%" + hobbie + "%");
            }
            if (sexo != null && !sexo.isEmpty()) {
                query.setParameter("sexo", sexo);
            }
            if (colorPelo != null && !colorPelo.isEmpty()) {
                query.setParameter("colorPelo", "%" + colorPelo + "%");
            }
            if (ocupacion != null && !ocupacion.isEmpty()) {
                query.setParameter("ocupacion", "%" + ocupacion + "%");
            }
            if (vehiculo != null && !vehiculo.isEmpty()) {
                query.setParameter("vehiculo", "%" + vehiculo + "%");
            }
            if (caracteristicas != null && !caracteristicas.isEmpty()) {
                query.setParameter("caracteristicas", "%" + caracteristicas + "%");
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
