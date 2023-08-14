package ar.unrn.tp.test;

import ar.unrn.tp.modelo.Cliente;
import ar.unrn.tp.modelo.TarjetaCredito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPersistencia {
    private EntityManagerFactory entityManager;

    @BeforeEach
    public void setUp(){
        entityManager = Persistence.createEntityManagerFactory("objectdb:myDbTestFile.tmp;drop");
    }
    @Test
    public void persistirCliente(){
        inTransactionExecute((em) -> {
            Cliente yo = new Cliente(1L, "Mateo", "Aliberti", "mateoaliberti1@gmail.com");
            TarjetaCredito tarjeta = new TarjetaCredito(true, 1000);
            yo.agregarTarjeta(tarjeta);
            em.persist(yo);
        });

        inTransactionExecute((em) -> {
            Cliente yo = em.find(Cliente.class, 1L);
            assertTrue(yo.seLlama("Mateo"));
            assertTrue(yo.seApellida("Aliberti"));
            assertTrue(yo.tieneEmail("mateoaliberti1@gmail.com"));
        });
    }
    public void inTransactionExecute(Consumer<EntityManager> bloqueDeCodigo) {
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

}
