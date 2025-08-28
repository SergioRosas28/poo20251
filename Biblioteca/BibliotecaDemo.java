package Biblioteca;

import java.util.List;

public class BibliotecaDemo {
    public static void main(String[] args) {
        BibliotecaService svc = new BibliotecaService();
        System.out.println("=== Libros iniciales ===");
        svc.listarLibros();

        System.out.println("\n=== Buscar 'Cien' ===");
        List<Libro> r = svc.buscarPorTitulo("Cien");
        r.forEach(System.out::println);

        System.out.println("\n=== Agregar nuevo libro ===");
        Libro nuevo = new Libro(null, "El Aleph", "Jorge Luis Borges", "978-8491050273");
        nuevo.setAnio(1949);
        svc.agregarLibro(nuevo);
        svc.listarLibros();
    }
}
