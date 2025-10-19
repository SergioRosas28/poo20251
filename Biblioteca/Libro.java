public class Libro {
    private int id;
    private String titulo;
    private boolean prestado;

    public Libro(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.prestado = false;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - Título: " + titulo + (prestado ? " (Prestado)" : "");
    }
}
