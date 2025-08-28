package Biblioteca;


// Servicio que gestiona la colección de libros en memoria.
// Proporciona operaciones para agregar, listar, buscar, editar y eliminar libros.
import java.time.LocalDate;
import java.util.*;

public class BibliotecaService {

    // Colecciones internas
    private Map<String, Libro> libros = new LinkedHashMap<>();
    private Map<String, Usuario> usuarios = new LinkedHashMap<>();
    private Map<String, Prestamo> prestamos = new LinkedHashMap<>();

    // Constructor: crear servicio con datos de ejemplo
    public BibliotecaService() {
        // Agregar algunos libros de ejemplo
        Libro l1 = new Libro("1", "Cien años de soledad", "Gabriel García Márquez", "978-0307474728");
        l1.setAnio(1967);
        Libro l2 = new Libro("2", "Don Quijote de la Mancha", "Miguel de Cervantes", "978-8491050266");
        l2.setAnio(1605);
        Libro l3 = new Libro("3", "La ciudad y los perros", "Mario Vargas Llosa", "978-8437604946");
        l3.setAnio(1963);
        libros.put(l1.getId(), l1);
        libros.put(l2.getId(), l2);
        libros.put(l3.getId(), l3);

        // Agregar algunos usuarios de ejemplo
        Usuario u1 = new Usuario("u1", "Ana Pérez", true);
        Usuario u2 = new Usuario("u2", "Luis Gómez", false);
        usuarios.put(u1.getId(), u1);
        usuarios.put(u2.getId(), u2);
    }

    // Método programático para agregar libro (genera id si falta)
    public void agregarLibro(Libro libro) {
        String id = libro.getId();
        if (id == null || id.isBlank()) {
            id = UUID.randomUUID().toString();
            libro.setId(id);
        }
        if (libros.containsKey(id)) {
            throw new IllegalArgumentException("ID de libro ya existe: " + id);
        }
        libros.put(id, libro);
    }

    // Buscar por título (devuelve lista)
    public List<Libro> buscarPorTitulo(String texto) {
        List<Libro> resultados = new ArrayList<>();
        if (texto == null) return resultados;
        String q = texto.trim().toLowerCase();
        if (q.isEmpty()) {
            resultados.addAll(libros.values());
            return resultados;
        }
        for (Libro l : libros.values()) {
            if (l.getTitulo() != null && l.getTitulo().toLowerCase().contains(q))
                resultados.add(l);
        }
        return resultados;
    }

    // Obtener lista de libros
    public List<Libro> obtenerLibrosList() {
        return new ArrayList<>(libros.values());
    }

    // Configuración simple
    private double tarifaBasePorDia = 1.5;
    private double multaPorDia = 0.75;
    private double descuentoSocio = 0.15;
    private int maxDiasPrestamo = 30;

    // --- Operaciones libros / UI helpers ---
    public void listarLibros() {
        System.out.println("\nLista de libros:");
        libros.values().forEach(System.out::println);
    }

    public void buscarYMostrarLibro(String q) {
    Optional<Libro> opt = libros.values().stream()
        .filter(l -> (l.getId() != null && l.getId().equalsIgnoreCase(q))
            || (l.getIsbn() != null && l.getIsbn().equalsIgnoreCase(q))
            || (l.getTitulo() != null && l.getTitulo().toLowerCase().contains(q.toLowerCase())))
        .findFirst();
        if (opt.isPresent())
            System.out.println(opt.get());
        else
            System.out.println("No se encontró el libro.");
    }

    public void agregarLibroInteractive(Scanner scanner) {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
    Libro l = new Libro(id, titulo, autor, isbn);
    libros.put(id, l);
        System.out.println("Libro agregado.");
    }

    public void editarLibroInteractive(Scanner scanner) {
        System.out.print("ID libro a editar: ");
        String id = scanner.nextLine();
        Libro l = libros.get(id);
        if (l == null) {
            System.out.println("No existe.");
            return;
        }
        System.out.print("Nuevo título (enter = mantener): ");
        String t = scanner.nextLine();
        if (!t.isBlank())
            l.setTitulo(t);
        System.out.print("Nuevo autor (enter = mantener): ");
        String a = scanner.nextLine();
        if (!a.isBlank())
            l.setAutor(a);
        System.out.println("Libro actualizado.");
    }

    public void eliminarLibro(String id) {
        Libro removed = libros.remove(id);
        System.out.println(removed != null ? "Libro eliminado." : "ID no encontrado.");
    }

    // --- Gestión usuarios (helpers interactivos) ---
    public void listarUsuarios() {
        System.out.println("\nLista de usuarios:");
        usuarios.values().forEach(System.out::println);
    }

    public void agregarUsuarioInteractive(Scanner scanner) {
        System.out.print("ID usuario: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Tipo (NORMAL/SOCIO): ");
        String tipo = scanner.nextLine().toUpperCase();
        Usuario u = new Usuario(id, nombre, tipo.equals("SOCIO"));
        usuarios.put(id, u);
        System.out.println("Usuario agregado.");
    }

    public void editarUsuarioInteractive(Scanner scanner) {
        System.out.print("ID usuario a editar: ");
        String id = scanner.nextLine();
        Usuario u = usuarios.get(id);
        if (u == null) {
            System.out.println("No existe.");
            return;
        }
        System.out.print("Nuevo nombre (enter = mantener): ");
        String n = scanner.nextLine();
        if (!n.isBlank())
            u.setNombre(n);
        System.out.println("Usuario actualizado.");
    }

    public void eliminarUsuario(String id) {
        Usuario removed = usuarios.remove(id);
        System.out.println(removed != null ? "Usuario eliminado." : "ID no encontrado.");
    }

    public void mostrarPrestamosUsuario(String idUsuario) {
        usuarios.containsKey(idUsuario);
        System.out.println("Préstamos de usuario " + idUsuario + ":");
        prestamos.values().stream()
                .filter(p -> p.getUsuarioId().equals(idUsuario))
                .forEach(System.out::println);
    }

    // --- Préstamos: prestar y devolver ---
    public void prestarLibroInteractive(String idLibro, String idUsuario, int dias, Scanner scanner) {
        if (dias <= 0 || dias > maxDiasPrestamo) {
            System.out.println("Días inválidos. Máx: " + maxDiasPrestamo);
            return;
        }
        Libro libro = libros.get(idLibro);
        Usuario usuario = usuarios.get(idUsuario);
        if (libro == null) {
            System.out.println("Libro no existe.");
            return;
        }
        if (usuario == null) {
            System.out.println("Usuario no existe.");
            return;
        }
        if (!libro.isDisponible()) {
            System.out.println("Libro no disponible.");
            return;
        }
        if (usuario.getDeuda() > 50.0) { // ejemplo de bloqueo
            System.out.println("Usuario tiene deuda mayor al permitido. Pagar antes de prestar.");
            return;
        }

        double costo = calcularCostoAlquiler(usuario, dias);
        System.out.printf("Costo calculado: $%.2f. Confirmar préstamo? (S/N): ", costo);
        String c = scanner.nextLine();
        if (!c.equalsIgnoreCase("S")) {
            System.out.println("Operación cancelada.");
            return;
        }

        String idPrestamo = UUID.randomUUID().toString();
        LocalDate inicio = LocalDate.now();
        LocalDate vencimiento = inicio.plusDays(dias);
        Prestamo p = new Prestamo(idPrestamo, idLibro, idUsuario, inicio, vencimiento, costo);
        prestamos.put(idPrestamo, p);
        libro.setDisponible(false);
        System.out.println("Préstamo registrado. ID préstamo: " + idPrestamo);
    }

    public void devolverLibroInteractive(String idPrestamo, Scanner scanner) {
        Prestamo p = prestamos.get(idPrestamo);
        if (p == null) {
            System.out.println("Préstamo no encontrado.");
            return;
        }
        if (p.getFechaDevolucion() != null) {
            System.out.println("Préstamo ya devuelto.");
            return;
        }

        LocalDate hoy = LocalDate.now();
        p.setFechaDevolucion(hoy);
        long diasRetraso = java.time.temporal.ChronoUnit.DAYS.between(p.getFechaVencimiento(), hoy);
        double multa = diasRetraso > 0 ? diasRetraso * multaPorDia : 0.0;
        p.setMulta(multa);

        // Actualizar libro como disponible
        Libro libro = libros.get(p.getLibroId());
        if (libro != null)
            libro.setDisponible(true);

        // Acumular deuda al usuario si hay multa
        if (multa > 0) {
            Usuario u = usuarios.get(p.getUsuarioId());
            if (u != null)
                u.setDeuda(u.getDeuda() + multa);
        }

        System.out.printf("Devolución procesada. Multa: $%.2f%n", multa);
    }

    // --- Helpers y reportes ---
    private double calcularCostoAlquiler(Usuario u, int dias) {
        double costo = tarifaBasePorDia * dias;
        if (u.isSocio())
            costo *= (1 - descuentoSocio);
        return Math.round(costo * 100.0) / 100.0;
    }

    public void listarPrestamosActivos() {
        System.out.println("Préstamos activos:");
        prestamos.values().stream()
                .filter(p -> p.getFechaDevolucion() == null)
                .forEach(System.out::println);
    }

    public void listarHistorialPrestamos() {
        System.out.println("Historial de préstamos:");
        prestamos.values().forEach(System.out::println);
    }

    public void extenderPrestamo(String idPrestamo, int diasExtra) {
        Prestamo p = prestamos.get(idPrestamo);
        if (p == null) {
            System.out.println("No encontrado.");
            return;
        }
        if (p.getFechaDevolucion() != null) {
            System.out.println("Préstamo ya finalizado.");
            return;
        }
        p.setFechaVencimiento(p.getFechaVencimiento().plusDays(diasExtra));
        System.out.println("Plazo extendido. Nueva fecha vencimiento: " + p.getFechaVencimiento());
    }

    public void mostrarReportes() {
        System.out.println("Reportes básicos:");
        // Ejemplo: libros prestados más veces — simplificado
        Map<String, Long> conteo = new HashMap<>();
        prestamos.values().forEach(p -> conteo.put(p.getLibroId(), conteo.getOrDefault(p.getLibroId(), 0L) + 1));
        conteo.entrySet().stream().sorted((a, b) -> Long.compare(b.getValue(), a.getValue())).limit(5)
                .forEach(e -> System.out.println("LibroID: " + e.getKey() + " -> " + e.getValue() + " préstamos"));
    }

    public void configuracionMenu(Scanner scanner) {
        System.out.println("Configuración actual: tarifaPorDia=" + tarifaBasePorDia + ", multaPorDia=" + multaPorDia
                + ", descuentoSocio=" + descuentoSocio);
        System.out.print("Nueva tarifa por día (enter = sin cambio): ");
        String s = scanner.nextLine();
        if (!s.isBlank())
            tarifaBasePorDia = Double.parseDouble(s);
        System.out.print("Nueva multa por día (enter = sin cambio): ");
        s = scanner.nextLine();
        if (!s.isBlank())
            multaPorDia = Double.parseDouble(s);
        System.out.print("Nuevo descuento socio (0.15 = 15%) (enter = sin cambio): ");
        s = scanner.nextLine();
        if (!s.isBlank())
            descuentoSocio = Double.parseDouble(s);
        System.out.println("Configuración actualizada.");
    }
}