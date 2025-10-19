import java.util.ArrayList;
import java.util.Scanner;

public class GestionLibros {
    private ArrayList<Libro> libros = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void menuLibros() {
        int op;
        do {
            System.out.println("--- Gestión de Libros ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Eliminar libro");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
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
        } while (op != 0);
    }

    public void agregarLibro() {
        System.out.print("Título: ");
        String titulo = sc.nextLine();
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
        int id = sc.nextInt();
        libros.removeIf(l -> l.getId() == id);
        System.out.println("Libro eliminado correctamente.");
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }
}

