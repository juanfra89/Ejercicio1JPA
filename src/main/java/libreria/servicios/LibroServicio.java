package libreria.servicios;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import libreria.PERSISTENCIA.EntityManagerFactorySingleton;
import libreria.PERSISTENCIA.LibroDAO;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

public class LibroServicio {

    private final LibroDAO libroDAO;

    public LibroServicio() {
        EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        libroDAO = new LibroDAO(em);
    }

    public void agregarLibro(String titulo, String isbn, Integer anio, Autor autor, Editorial editorial) {
        EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        try {
            Libro libro = new Libro(titulo, isbn, anio, autor, editorial);
            LibroDAO libroDAO = new LibroDAO(em);
            libroDAO.guardarLibro(libro);
        } finally {
            em.close();
        }
    }

    public void editarLibro(Libro libro, String titulo, Integer anio, Autor autor, Editorial editorial) {
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        libroDAO.actualizarLibro(libro);
    }

    public void darDeAltaBajaLibro(Libro libro) {
        boolean estadoAnterior = libro.isAlta();
        libro.setAlta(!estadoAnterior);
        libroDAO.actualizarLibro(libro);
    }

    public List<Libro> buscarLibrosPorTitulo(String titulo) {
        return libroDAO.buscarLibrosPorTitulo(titulo);
    }

    public List<Libro> buscarLibrosPorNombreAutor(String nombre) {
        return libroDAO.buscarLibrosPorNombreAutor(nombre);
    }

    public List<Libro> buscarLibrosPorNombreEditorial(String nombre) {
        return libroDAO.buscarLibrosPorNombreEditorial(nombre);
    }

    public Libro buscarLibroPorISBN(String isbn) {
        return libroDAO.buscarLibroPorISBN(isbn);
    }

}