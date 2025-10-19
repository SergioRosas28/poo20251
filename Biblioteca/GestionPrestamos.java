import java.util.LinkedList;
import java.util.Scanner;

public class GestionPrestamos {
    private LinkedList<Prestamo> prestamos = new LinkedList<>();
    private Scanner sc = new Scanner(System.in);

    public void realizarPrestamo(GestionUsuarios gestionUsuarios, GestionLibros gestionLibros) {
        if (gestionUsuarios.getUsuarios().isEmpty() || gestionLibros.getLibros().isEmpty()) {
            System.out.println("Debe haber al menos un usuario y un libro registrados.");
            return;
        }

        gestionUsuarios.listarUsuarios();
        System.out.print("ID del usuario: ");
        int idU = sc.nextInt();
        sc.nextLine();

        gestionLibros.listarLibros();
        System.out.print("ID del libro: ");
        int idL = sc.nextInt();
        sc.nextLine();

        Usuario usuario = gestionUsuarios.getUsuarios().stream()
                .filter(u -> u.getId() == idU)
                .findFirst().orElse(null);
        Libro libro = gestionLibros.getLibros().stream()
                .filter(l -> l.getId() == idL)
                .findFirst().orElse(null);

        if (usuario == null || libro == null || libro.isPrestado()) {
            System.out.println("Error: usuario o libro inválido, o libro ya prestado.");
            return;
        }

        libro.setPrestado(true);
        prestamos.add(new Prestamo(usuario, libro));
        System.out.println("Préstamo realizado correctamente.");
    }

    public void listarPrestamos() {
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
            return;
        }
        prestamos.forEach(System.out::println);
    }

    public void devolverLibro() {
        listarPrestamos();
        System.out.print("ID del libro a devolver: ");
        int idL = sc.nextInt();
        sc.nextLine();

        Prestamo p = prestamos.stream()
                .filter(pr -> pr.getLibro().getId() == idL)
                .findFirst().orElse(null);

        if (p == null) {
            System.out.println("No se encontró ese préstamo.");
            return;
        }

        p.getLibro().setPrestado(false);
        prestamos.remove(p);
        System.out.println("Libro devuelto correctamente.");
    }
}

