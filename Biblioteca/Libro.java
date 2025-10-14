 public class Libro {
    int id;
    String titulo;
    String autor;
    boolean prestado;

    public Libro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.prestado = false;
    }

    @Override
    public String toString() {
        return id + ". " + titulo + " - " + autor + (prestado ? " (Prestado)" : "");
    }
}

