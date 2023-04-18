package libreria.PERSISTENCIA;

import libreria.entidades.Autor;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AutorDAO {

    private EntityManager em;

    public AutorDAO(EntityManager em) {
        this.em = em;
    }
    public void guardar(Autor a){
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
    }

    public void crearAutor(Autor autor) {
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
    }

    public Autor buscarAutorPorId(Long id) {
        return em.find(Autor.class, id);
    }

    public List<Autor> buscarTodosLosAutores(boolean alta) {
        String jpql = "SELECT a FROM Autor a WHERE a.alta = :alta";
        TypedQuery<Autor> consulta = em.createQuery(jpql, Autor.class);
        consulta.setParameter("alta", alta);
        return consulta.getResultList();
    }




    public void actualizarAutor(Autor autor) {
        em.getTransaction().begin();
        em.merge(autor);
        em.getTransaction().commit();
    }

    public void eliminarAutor(Autor autor) {
        em.getTransaction().begin();
        em.remove(em.merge(autor));
        em.getTransaction().commit();
    }
}