import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Libro> listaLibros = new ArrayList<>();
    static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    static ArrayList<Prestamo> listaPrestamos = new ArrayList<>();

    static Scanner entrada = new Scanner(System.in);

     public static void main(String[] args) {
        mainMenu();
    }

    static void mainMenu() {
        int opcionMenu;
        do {
            System.out.println(" Menu Principal");
            System.out.println("1: Gestionar libros");
            System.out.println("2: Gestionar usuarios");
            System.out.println("3: Prestamos");
            System.out.println("4: Remover");
            System.out.println("0: Salir");
            System.out.print("Ingrese su opción: ");
            opcionMenu = entrada.nextInt();
            entrada.nextLine();

            switch (opcionMenu) {
                case 1: menuLibros();
                case 2: menuUsuarios();
                case 3: menuPrestamos();
                case 4: menuRemover();
                case 0:System.out.println("Programa cerrado");
            }
        } while (opcionMenu != 0);
    }
    static void menuLibros() {
        int opcionLibro;
        do {
            System.out.println(" Menu Libros");
            System.out.println("1. Agregar libro");
            System.out.println("2: Editar libro");
            System.out.println("3: Lista de libros");
            System.out.println("0: Volver al menú principal");
            System.out.print("Elija una opción: ");
            opcionLibro = entrada.nextInt();
            entrada.nextLine();

            switch (opcionLibro) {
                case 1: agregarLibro();
                case 2: editarLibro();
                case 3: listarLibros();
                case 0: System.out.println("Volviendo al menú principal");
            }
        } while (opcionLibro != 0);
    }

    static void agregarLibro() {
        System.out.println("Nombre del libro:");
        String nombreLibro = entrada.nextLine();

        System.out.println("Nombre del autor:");
        String autorLibro = entrada.nextLine();

        listaLibros.add(new Libro(nombreLibro, autorLibro));
        System.out.println("Libro agregado exitosamente");

        mainMenu();
    }

    static void editarLibro() {
        listarLibros();

        System.out.println("Ingrese el número del libro que desea editar:");
        int numeroLibroSeleccionado = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Nuevo nombre del libro:");
        String nuevoNombreLibro = entrada.nextLine();

        listaLibros.get(numeroLibroSeleccionado).setNombreLibro(nuevoNombreLibro);
        System.out.println("Nuevo nombre del libro editado correctamente");
        mainMenu();

    }

    static void listarLibros() {
        if (listaLibros.isEmpty()) {
            System.out.println("No hay libros en la lista, por favor agregar un libro");
        } else {
            for (int posicion = 0; posicion < listaLibros.size(); posicion++) {
                System.out.println(posicion + ". " + listaLibros.get(posicion));
            }
        }
    }
    static void menuUsuarios() {
        System.out.println("1. Agregar usuario");
        System.out.println("2: Editar usuario");
        System.out.println("3: Lista de usuarios");

        int opcionUsuario = entrada.nextInt();
        entrada.nextLine();

        switch (opcionUsuario) {
            case 1: agregarUsuario();
            case 2: editarUsuario();
            case 3: listarUsuarios();
        }
    }

    static void agregarUsuario() {
        System.out.println("Nombre del usuario:");
        String nombreUsuario = entrada.nextLine();

        System.out.println("Edad del usuario:");
        int edadUsuario = entrada.nextInt();
        entrada.nextLine();

        listaUsuarios.add(new Usuario(nombreUsuario, edadUsuario));
        System.out.println("Usuario agregado exitosamente");
        mainMenu();
    }

    static void editarUsuario() {
        listarUsuarios();
        if(listaUsuarios.isEmpty()){
            System.out.println("No hay usuarios agregados en la lista, por favor agregue un usuario");
            return;
        }

        System.out.println("Ingrese el número del usuario que desea editar:");
        int numeroUsuarioSeleccionado = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Nuevo nombre del usuario:");
        String nuevoNombreUsuario = entrada.nextLine();

        System.out.println("Nueva edad del usuario: ");
        int nuevaEdadUsuario = entrada.nextInt();

        listaUsuarios.get(numeroUsuarioSeleccionado).setNombreUsuario(nuevoNombreUsuario);
        System.out.println("Nuevo nombre y edad de usuario editado correctamente");
        mainMenu();

    }
    static void listarUsuarios() {
        for (int posicion = 0; posicion < listaUsuarios.size(); posicion++) {
            System.out.println(posicion + ": " + listaUsuarios.get(posicion));
        }
    }

    static void menuPrestamos() {
        System.out.println("1: Agregar prestamo");
        System.out.println("2: Lista de préstamos");
        System.out.println("3: Devolver libro");

        int opcionPrestamo = entrada.nextInt();
        entrada.nextLine();

        switch (opcionPrestamo) {
            case 1: AgregarPrestamos(); break;
            case 2: listarPrestamos(); break;
            case 3: devolverLibro(); break;
        }
    }

    static void AgregarPrestamos(){
        if (listaPrestamos.isEmpty()) {
            System.out.println("No hay libros para prestar");
            mainMenu();

        }
        listarLibros();
        System.out.println("Cual es el libro al que desea prestar");
        entrada.nextInt();
        System.out.println("Libro prestado exitosamente");
        mainMenu();
    }
    static void listarPrestamos() {
        if (listaPrestamos.isEmpty()){
            System.out.println("No hay libros prestados");
            mainMenu();
        }

        for (int posicion = 0; posicion < listaPrestamos.size(); posicion++) {
            System.out.println(posicion + ": " + listaPrestamos.get(posicion));
        }

    }

    static void devolverLibro() {
        if (listaPrestamos.isEmpty()) {
            System.out.println("No hay libros prestados pendientes");
            mainMenu();
        }

        menuPrestamos();

        listarPrestamos();

        System.out.println("Ingrese el número del préstamo a devolver:");
        int numeroPrestamoSeleccionado = entrada.nextInt();
        entrada.nextLine();

        listaPrestamos.remove(numeroPrestamoSeleccionado);
    }

        static void menuRemover() {
        System.out.println("1: Remover libro");
        System.out.println("2: Remover usuario");

        int opcionRemover = entrada.nextInt();
        entrada.nextLine();

        if (opcionRemover == 1) removerLibro();
        else if (opcionRemover == 2) removerUsuario();
    }

    static void removerLibro() {
        if(listaLibros.isEmpty()){
            System.out.println("No hay libros para remover");
            return;
    }
        listarLibros();

        System.out.println("Ingrese el número del libro que desea remover:");
        int numeroLibroSeleccionado = entrada.nextInt();
        entrada.nextLine();

        listaLibros.remove(numeroLibroSeleccionado);
        System.out.println("Libro eliminado correctamente");
        mainMenu();
    }

    static void removerUsuario() {
        if (listaUsuarios.isEmpty()){
            System.out.println("No hay usuarios para remover");
            return;
    }
        listarUsuarios();

        System.out.println("Ingrese el número del usuario que desea remover:");
        int numeroUsuarioSeleccionado = entrada.nextInt();
        entrada.nextLine();

        listaUsuarios.remove(numeroUsuarioSeleccionado);
        System.out.println("Usuario eliminado correctamente");
        mainMenu();
    }
}