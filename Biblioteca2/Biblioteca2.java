package Biblioteca2;

public class Biblioteca2 {
    ArrayList<Libro2> libros = new ArrayList<>();
    ArrayList<Usuario2> usuarios = new ArrayList<>();
    ArrayList<Prestamos2> prestamos = new ArrayList<>();
    Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        // Implementar el menú principal similar al de Biblioteca/Main.java
    int opcion;
    do {
        System.out.println("\n=== GESTIÓN DE BIBLIOTECA ===");  
        System.out.println("1. Gestionar Libros");  
        System.out.println("2. Gestionar Usuarios");    
        System.out.println("3. Realizar Préstamo"); 
        System.out.println("4. Devolver (Remover) Préstamo");   
        System.out.println("5. Listar Préstamos");  
        System.out.println("0. Salir");  
        System.out.print("Seleccione una opción: ");  
        opcion = entrada.nextInt();  
        entrada.nextLine();  
        switch (opcion) {
            case 1 -> gestionarLibros();
            case 2 -> gestionarUsuarios();
            case 3 -> realizarPrestamo();
            case 4 -> devolverPrestamo();
            case 5 -> listarPrestamos();
            case 0 -> System.out.println("Saliendo del sistema...");
            default -> System.out.println("Opción no válida.");
        }
      } while (opcion != 0);

    }
}
