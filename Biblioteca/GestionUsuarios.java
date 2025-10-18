import java.util.ArrayList;
import java.util.Scanner;

public class GestionUsuarios {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void menuUsuarios() {
        int op;
        do {
            System.out.println("\n--- Gestión de Usuarios ---");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Eliminar usuario");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1: agregarUsuario();
                case 2: listarUsuarios();
                case 3: eliminarUsuario();
            }
        } while (op != 0);
    }

    public void agregarUsuario() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        usuarios.add(new Usuario(usuarios.size() + 1, nombre));
        System.out.println("Usuario agregado correctamente.");
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        usuarios.forEach(System.out::println);
    }

    public void eliminarUsuario() {
        listarUsuarios();
        System.out.print("ID del usuario a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine(); //
        usuarios.removeIf(u -> u.getId() == id);
        System.out.println("Usuario eliminado.");
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
