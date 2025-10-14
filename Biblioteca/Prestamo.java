class Prestamo {
    Usuario usuario;
    Libro libro;

    public Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "Libro: " + libro.titulo + " → Usuario: " + usuario.nombre;
    }
}