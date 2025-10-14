static void realizarPrestamo() {
        if (libros.isEmpty() || usuarios.isEmpty()) {
            System.out.println("Debe haber al menos un libro y un usuario registrados.");
            return;
        }

        listarUsuarios();
        System.out.print("ID del usuario: ");
        int idU = sc.nextInt();
        sc.nextLine();
        Usuario usuario = usuarios.stream().filter(u -> u.id == idU).findFirst().orElse(null);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        listarLibros();
        System.out.print("ID del libro: ");
        int idL = sc.nextInt();
        sc.nextLine();
        Libro libro = libros.stream().filter(l -> l.id == idL).findFirst().orElse(null);
        if (libro == null || libro.prestado) {
            System.out.println("Libro no disponible.");
            return;
        }

        libro.prestado = true;
        prestamos.add(new Prestamo(usuario, libro));
        System.out.println("Préstamo realizado correctamente.");
    }

    static void listarPrestamos() {
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
            return;
        }
        for (Prestamo p : prestamos)
            System.out.println(p);
    }

    static void devolverPrestamo() {
        listarPrestamos();
        System.out.print("Título del libro a devolver: ");
        String titulo = sc.nextLine();

        Prestamo p = prestamos.stream()
                .filter(pr -> pr.libro.titulo.equalsIgnoreCase(titulo))
                .findFirst().orElse(null);

        if (p == null) {
            System.out.println("No se encontró ese préstamo.");
            return;
        }

        p.libro.prestado = false;
        prestamos.remove(p);
        System.out.println("Préstamo eliminado (libro devuelto).");
    }
 }

