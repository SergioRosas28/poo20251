import java.util.*;

public class Pedido {

    // Atributos
    private Cliente cliente;
    private Product[] producto;
    private Date fecha;
    private int numeroTarjetaCredito;

    // Metodos
    public Pedido(String cliente, Product[] product, Date fecha, int numeroTarjetaCredito) {
        this.cliente = cliente;
        this.producto = producto;
        this.fecha = fecha;
        this. numeroTarjetaCredito = numeroTarjetaCredito;

    }

}