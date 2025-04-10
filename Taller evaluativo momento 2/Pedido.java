import java.util.Arrays;
import java.util.Date;

public class Pedido {

    // Atributos
    private Cliente cliente;
    private Producto[] producto;
    private Date fecha;
    private int numeroTarjetaCredito;

    // Constructor
    public Pedido(Cliente cliente, Producto[] producto, Date fecha, int numeroTarjetaCredito) {
        this.cliente = cliente;
        this.producto = producto;
        this.fecha = fecha;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
    }

    // Método toString
    public String toString() {
        return "Pedido { Cliente: " + cliente +
               ", Productos: " + Arrays.toString(producto) +
               ", Fecha: " + fecha +
               ", Tarjeta: " + numeroTarjetaCredito + " }";
    }
}
