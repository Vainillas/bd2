package ar.unrn.tp.jpa.servicios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.function.Consumer;

public class ServiceJPAImpl {
    private EntityManagerFactory entityManager;

    public ServiceJPAImpl(){
        setUp();
    }
    public void setUp(){
        entityManager = Persistence.createEntityManagerFactory("objectdb:persistenciabd2.tmp");
    }

    static void setUpEntityManager(Consumer<EntityManager> bloqueDeCodigo, EntityManagerFactory entityManager) {
        EntityManager em = entityManager.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            bloqueDeCodigo.accept(em);

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            if (em != null && em.isOpen())
                em.close();
        }
    }
    public void inTransactionExecute(Consumer<EntityManager> bloqueDeCodigo) {
        setUpEntityManager(bloqueDeCodigo, entityManager);
    }
}
