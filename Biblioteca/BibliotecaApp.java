package Biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BibliotecaService service = new BibliotecaService();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            int sel = showMainMenu();
            switch (sel) {
                case 1:
                    gestionLibrosMenu();
                    break;
                case 2:
                    gestionUsuariosMenu();
                    break;
                case 3:
                    gestionPrestamosMenu();
                    break;
                case 4:
                    service.mostrarReportes();
                    break;
                case 5:
                    service.configuracionMenu(scanner);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        System.out.println("Saliendo. ¡Hasta luego!");
        scanner.close();
    }

    private static int showMainMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1) Gestión de libros");
        System.out.println("2) Gestión de usuarios");
        System.out.println("3) Gestión de préstamos");
        System.out.println("4) Reportes");
        System.out.println("5) Configuración");
        System.out.println("0) Salir");
        System.out.print("Selecciona una opción: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void gestionLibrosMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- GESTIÓN DE LIBROS ---");
            System.out.println("1) Listar libros");
            System.out.println("2) Buscar libro");
            System.out.println("3) Agregar libro");
            System.out.println("4) Editar libro");
            System.out.println("5) Eliminar libro");
            System.out.println("6) Alquilar/Prestar libro");
            System.out.println("7) Devolver libro");
            System.out.println("0) Volver");
            System.out.print("Opción: ");
            int opt;
            try {
                opt = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opt = -1;
            }
            switch (opt) {
                case 1:
                    service.listarLibros();
                    break;
                case 2: {
                    System.out.print("Ingrese ID o ISBN: ");
                    String q = scanner.nextLine();
                    service.buscarYMostrarLibro(q);
                }
                    break;
                case 3:
                    service.agregarLibroInteractive(scanner);
                    break;
                case 4:
                    service.editarLibroInteractive(scanner);
                    break;
                case 5: {
                    System.out.print("ID a eliminar: ");
                    String id = scanner.nextLine();
                    service.eliminarLibro(id);
                }
                    break;
                case 6: {
                    System.out.print("ID libro: ");
                    String idLibro = scanner.nextLine();
                    System.out.print("ID usuario: ");
                    String idUsuario = scanner.nextLine();
                    System.out.print("Días a prestar: ");
                    int dias = Integer.parseInt(scanner.nextLine());
                    service.prestarLibroInteractive(idLibro, idUsuario, dias, scanner);
                }
                    break;
                case 7: {
                    System.out.print("ID préstamo: ");
                    String idPrestamo = scanner.nextLine();
                    service.devolverLibroInteractive(idPrestamo, scanner);
                }
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void gestionUsuariosMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- GESTIÓN DE USUARIOS ---");
            System.out.println("1) Listar usuarios");
            System.out.println("2) Agregar usuario");
            System.out.println("3) Editar usuario");
            System.out.println("4) Eliminar usuario");
            System.out.println("5) Ver préstamos de usuario");
            System.out.println("0) Volver");
            System.out.print("Opción: ");
            int opt;
            try {
                opt = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opt = -1;
            }
            switch (opt) {
                case 1:
                    service.listarUsuarios();
                    break;
                case 2:
                    service.agregarUsuarioInteractive(scanner);
                    break;
                case 3:
                    service.editarUsuarioInteractive(scanner);
                    break;
                case 4: {
                    System.out.print("ID usuario a eliminar: ");
                    String id = scanner.nextLine();
                    service.eliminarUsuario(id);
                }
                    break;
                case 5: {
                    System.out.print("ID usuario: ");
                    String id = scanner.nextLine();
                    service.mostrarPrestamosUsuario(id);
                }
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void gestionPrestamosMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- GESTIÓN DE PRÉSTAMOS ---");
            System.out.println("1) Listar préstamos activos");
            System.out.println("2) Historial de préstamos");
            System.out.println("3) Extender préstamo");
            System.out.println("0) Volver");
            System.out.print("Opción: ");
            int opt;
            try {
                opt = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opt = -1;
            }
            switch (opt) {
                case 1:
                    service.listarPrestamosActivos();
                    break;
                case 2:
                    service.listarHistorialPrestamos();
                    break;
                case 3: {
                    System.out.print("ID préstamo a extender: ");
                    String id = scanner.nextLine();
                    System.out.print("Días a extender: ");
                    int dias = Integer.parseInt(scanner.nextLine());
                    service.extenderPrestamo(id, dias);
                }
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}