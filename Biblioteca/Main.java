import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionLibros gestionLibros = new GestionLibros();
        GestionUsuarios gestionUsuarios = new GestionUsuarios();
        GestionPrestamos gestionPrestamos = new GestionPrestamos();

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== GESTIÓN DE BIBLIOTECA ===");
            System.out.println("1. Gestionar Libros");
            System.out.println("2. Gestionar Usuarios");
            System.out.println("3. Realizar Préstamo");
            System.out.println("4. Devolver Libro");
            System.out.println("5. Listar Préstamos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    gestionLibros.menuLibros();
                    break;
                case 2:
                    gestionUsuarios.menuUsuarios();
                    break;
                case 3:
                    gestionPrestamos.realizarPrestamo(gestionUsuarios, gestionLibros);
                    break;
                case 4:
                    gestionPrestamos.devolverLibro();
                    break;
                case 5:
                    gestionPrestamos.listarPrestamos();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
