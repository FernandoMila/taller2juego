package Controllers;

import biblioteca.Ciudad;
import DAO.CiudadDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CiudadController {

    private static final int[][] COORDENADAS = {
            {158, 480}, {360, 515}, {198, 474}, {509, 522}, {512, 511},
            {349, 501}, {114, 257}, {305, 55}, {293, 468}, {359, 183},
            {351, 434}, {310, 360}, {598, 250}, {674, 422}, {582, 341},
            {470, 465}, {128, 160}, {85, 350}, {118, 357}, {425, 105},
            {266, 379}
    };

    private SessionFactory sessionFactory;

    public CiudadController() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(CiudadDAO.class)
                .buildSessionFactory();
    }

    public List<Ciudad> obtenerCiudadesConCoordenadas() {
        List<Ciudad> ciudades = new ArrayList<>();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            List<CiudadDAO> ciudadDAOs = session.createQuery("FROM CiudadDAO", CiudadDAO.class).list();
            session.getTransaction().commit();

            for (int i = 0; i < ciudadDAOs.size(); i++) {
                CiudadDAO ciudadDAO = ciudadDAOs.get(i);
                int[] coords = COORDENADAS[i % COORDENADAS.length];
                Ciudad ciudad = new Ciudad(ciudadDAO.getIdCiudad(), ciudadDAO.getNombre(),
                        ciudadDAO.getDescripcion(), ciudadDAO.getRutaImagen(), coords[0], coords[1]);
                ciudades.add(ciudad);
            }
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return ciudades;
    }

    public void cerrarSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
