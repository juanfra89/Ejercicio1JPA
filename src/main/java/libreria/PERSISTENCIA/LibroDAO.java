package libreria.PERSISTENCIA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

public class LibroDAO {

    private EntityManager em;

    public LibroDAO(EntityManager em) {
        this.em = em;
    }

    public void guardarLibro(Libro libro) {
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }

    public void actualizarLibro(Libro libro) {
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
    }

    public List<Libro> buscarLibrosPorTitulo(String titulo) {
        Query query = em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo");
        query.setParameter("titulo", "%" + titulo + "%");
        return query.getResultList();
    }

    public List<Libro> buscarLibrosPorNombreAutor(String nombre) {
        Query query = em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE :nombre");
        query.setParameter("nombre", "%" + nombre + "%");
        return query.getResultList();
    }

    public List<Libro> buscarLibrosPorNombreEditorial(String nombre) {
        Query query = em.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre LIKE :nombre");
        query.setParameter("nombre", "%" + nombre + "%");
        return query.getResultList();
    }

    public Libro buscarLibroPorISBN(String isbn) {
        return em.find(Libro.class, isbn);
    }

}