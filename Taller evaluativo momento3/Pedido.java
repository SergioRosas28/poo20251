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
    @Override
    public String toString() {
        return "Pedido { Cliente: " + cliente +
               ", Productos: " + Arrays.toString(producto) +
               ", Fecha: " + fecha +
               ", Tarjeta: " + numeroTarjetaCredito + " }";
    }

    // Método main para probar
    public static void main(String[] args) {
        Cliente cliente = new Cliente("10005658", "Julian");

        Producto[] productos = {
            new Camara("Canon", "4000D"),
            new Impresion("Color", new Foto[] {
                new Foto("familia.jpg"),
                new Foto("vacaciones.jpg")
            })
        };

        Pedido pedido = new Pedido(cliente, productos, new Date(), 12345678);
        System.out.println(pedido);
    }
}

