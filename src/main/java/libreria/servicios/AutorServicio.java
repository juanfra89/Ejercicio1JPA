package libreria.servicios;

import java.util.ArrayList;
import java.util.List;

import libreria.entidades.Autor;

public class AutorServicio {

    private List<Autor> autores = new ArrayList<>();

    public void agregarAutor(Autor autor) {
        autores.add(autor);
    }

    public void editarAutor(Autor autor) {
        // No es necesario hacer nada ya que el autor ya está en la lista y se actualiza automáticamente
    }

    public void darDeAltaBajaAutor(Autor autor) {
        // No es necesario hacer nada ya que el autor ya está en la lista y se actualiza automáticamente
    }

    public Autor buscarAutorPorNombre(String nombre) {
        for (Autor autor : autores) {
            if (autor.getNombre().equalsIgnoreCase(nombre)) {
                return autor;
            }
        }
        return null;
    }

    public List<Autor> listarAutores() {
        return autores;
    }
}