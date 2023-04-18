package libreria.servicios;

import java.util.ArrayList;
import java.util.List;

import libreria.entidades.Editorial;

public class EditorialServicio {

    private List<Editorial> editoriales = new ArrayList<>();

    public void agregarEditorial(Editorial editorial) {
        editoriales.add(editorial);
    }

    public void editarEditorial(Editorial editorial) {
        // No es necesario hacer nada ya que la editorial ya está en la lista y se actualiza automáticamente
    }

    public void darDeAltaBajaEditorial(Editorial editorial) {
        // No es necesario hacer nada ya que la editorial ya está en la lista y se actualiza automáticamente
    }

    public Editorial buscarEditorialPorNombre(String nombre) {
        for (Editorial editorial : editoriales) {
            if (editorial.getNombre().equalsIgnoreCase(nombre)) {
                return editorial;
            }
        }
        return null;
    }

    public List<Editorial> listarEditoriales() {
        return editoriales;
    }
}
