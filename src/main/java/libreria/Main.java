package libreria;

import java.util.Scanner;

import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final LibroServicio libroServicio = new LibroServicio();
    private static final AutorServicio autorServicio = new AutorServicio();
    private static final EditorialServicio editorialService = new EditorialServicio();

    public static void main(String[] args) {

        while (true) {
            System.out.println("Ingrese una opción:");
            System.out.println("1. Agregar libro");
            System.out.println("2. Editar libro");
            System.out.println("3. Dar de alta/baja un libro");
            System.out.println("4. Salir");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    editarLibro();
                    break;
                case 3:
                    darDeAltaBajaLibro();
                    break;
                case 4:
                    System.out.println("Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }

    private static void agregarLibro() {
        System.out.println("Ingrese el título del libro:");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese el ISBN del libro:");
        String isbn = scanner.nextLine();
        System.out.println("Ingrese el año de publicación del libro:");
        int anio = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese el nombre del autor:");
        String nombreAutor = scanner.nextLine();
        Autor autor = autorServicio.buscarAutorPorNombre(nombreAutor);
        if (autor == null) {
            System.out.println("Autor no encontrado");
            return;
        }

        System.out.println("Ingrese el nombre de la editorial:");
        String nombreEditorial = scanner.nextLine();
        Editorial editorial = editorialService.buscarEditorialPorNombre(nombreEditorial);
        if (editorial == null) {
            System.out.println("Editorial no encontrada");
            return;
        }

        libroServicio.agregarLibro(titulo, isbn, anio, autor, editorial);
        System.out.println("Libro agregado con éxito");
    }

    private static void editarLibro() {
        // Aquí iría el código para editar un libro
        System.out.println("Editar libro");
    }

    private static void darDeAltaBajaLibro() {
        // Aquí iría el código para dar de alta o baja un libro
        System.out.println("Dar de alta/baja un libro");
    }
}