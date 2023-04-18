package libreria.PERSISTENCIA;

import libreria.entidades.Editorial;
import javax.persistence.EntityManager;
import java.util.List;

public class EditorialDAO {

    private EntityManager em;

    public EditorialDAO(EntityManager em) {
        this.em = em;
    }

    public void crearEditorial(Editorial editorial) {
        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();
    }

    public Editorial buscarEditorialPorId(Long id) {
        return em.find(Editorial.class, id);
    }

    public List<Editorial> buscarTodasLasEditoriales() {
        return em.createQuery("FROM Editorial", Editorial.class).getResultList();
    }

    public void actualizarEditorial(Editorial editorial) {
        em.getTransaction().begin();
        em.merge(editorial);
        em.getTransaction().commit();
    }

    public void eliminarEditorial(Editorial editorial) {
        em.getTransaction().begin();
        em.remove(em.merge(editorial));
        em.getTransaction().commit();
    }
}
