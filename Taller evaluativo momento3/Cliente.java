public class Cliente {

    // Atributos
    private String cedula;
    private String nombre;

    // Constructor
    public Cliente(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    // Método toString
    @Override
    public String toString() {
        return "Cliente { Cedula: " + cedula + ", Nombre: " + nombre + " }";
    }

    // Método main para probar
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("10005658", "Julian");
        System.out.println(cliente1);
    }
}

