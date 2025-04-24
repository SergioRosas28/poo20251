// Nombre del archivo: Pedido.java
public class Cliente {
    private String cedula;
    private String nombre;

    // Constructor de la clase Cliente
    public Cliente(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    // Métodos para obtener los atributos del cliente
    public String getCedula() {
        return cedula;
    }

    // Método para obtener el nombre del cliente
    public String getNombre() {
        return nombre;
    }
}
