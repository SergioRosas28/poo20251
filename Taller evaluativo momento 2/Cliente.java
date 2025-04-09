public class Cliente {

    // Atributos
    private string cedula;
    private string nombre;

    // Metodos
    public Cliente(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String toString(){
        return "Cliente { Cedula: " + cedula + "Nombre: " + nombre"}";
    }
}
