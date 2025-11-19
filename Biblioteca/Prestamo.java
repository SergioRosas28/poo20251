public class Prestamo {
    private Usuario usuarioPrestamo;
    private Libro libroPrestado;

    public Prestamo(Usuario usuarioPrestamo, Libro libroPrestado) {
        this.usuarioPrestamo = usuarioPrestamo;
        this.libroPrestado = libroPrestado;
    }

    public String toString() {
        return usuarioPrestamo.getNombreUsuario() + " tiene prestado: " + libroPrestado.getNombreLibro();
    }
}