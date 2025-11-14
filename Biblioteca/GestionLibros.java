import java.util.ArrayList;
import java.util.Scanner;

public class GestionLibros {
    private ArrayList<Libro> libros = new ArrayList<>();
    private Scanner menu_libro = new Scanner(System.in);

    public void menuLibros() {
        int options;
        do {
            System.out.println("--- Gestión de Libros ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Eliminar libro");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            options = menu_libro.nextInt();
            menu_libro.nextLine();

            switch (options) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    eliminarLibro();
                    break;
            }
        } while (options != 0);
    }

    public void agregarLibro() {
        System.out.print("Título: ");
        String titulo = menu_libro.nextLine();
        libros.add(new Libro(libros.size() + 1, titulo));
        System.out.println("Libro agregado correctamente.");
    }

    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        libros.forEach(System.out::println);
    }

    public void eliminarLibro() {
        listarLibros();
        System.out.print("ID del libro a eliminar: ");
        int id = menu_libro.nextInt();
        libros.removeIf(l -> l.getId() == id);
        System.out.println("Libro eliminado correctamente.");
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }
}

