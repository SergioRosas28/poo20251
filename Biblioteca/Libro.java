public class Libro {
    private String nombreLibro;
    private String autorLibro;

    public Libro(String nombreLibro, String autorLibro) {
        this.nombreLibro = nombreLibro;
        this.autorLibro = autorLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }
    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getAutorLibro() {
        return autorLibro;
    }
    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }
    public String toString() {
        return nombreLibro + " - " + autorLibro;
    }
}