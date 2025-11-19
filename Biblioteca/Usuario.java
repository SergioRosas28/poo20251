public class Usuario {
    private String nombreUsuario;
    private int edadUsuario;

    public Usuario(String nombreUsuario, int edadUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.edadUsuario = edadUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String toString() {
        return nombreUsuario + " - Edad: " + edadUsuario;
    }
}