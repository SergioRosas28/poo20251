package Biblioteca;

// Clase que representa un libro con campos: id, título, autor, año y ISBN
public class Libro {
    private String id;
    private String titulo;
    private String autor;
    private int anio;
    private String isbn;
    private boolean disponible = true;

    // Constructor principal con id e isbn
    public Libro(String id, String titulo, String autor, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    // Constructor auxiliar (sin id/isbn) para usos rápidos
    public Libro(String titulo, String autor, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    // getters / setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        String idPart = (id != null ? "ID:" + id + " | " : "");
        String isbnPart = (isbn != null ? " | ISBN:" + isbn : "");
        String anioPart = (anio != 0 ? " | Año:" + anio : "");
        return idPart + "Título: " + titulo + " | Autor: " + autor + anioPart + isbnPart + " | " + (disponible ? "DISPONIBLE" : "PRESTADO");
    }
}
