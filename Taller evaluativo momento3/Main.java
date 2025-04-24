import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear cliente
        Cliente cliente = new Cliente("123456789", "Juan Pérez");

        // Crear fotos
        Foto foto1 = new Foto("foto1.jpg");
        Foto foto2 = new Foto("foto2.jpg");
        List<Foto> fotos = new ArrayList<>();
        fotos.add(foto1);
        fotos.add(foto2);

        // Crear productos
        Impresion impresion = new Impresion(1, "Color", fotos);
        Camara camara = new Camara(2, "Canon", "EOS 90D");

        List<Producto> productos = new ArrayList<>();
        productos.add(impresion);
        productos.add(camara);

        // Crear pedido
        Pedido pedido = new Pedido(cliente, productos, new Date(), 12345678);

        // Imprimir detalles del pedido
        System.out.println("Cliente: " + pedido.getCliente().getNombre());
        System.out.println("Productos en el pedido:");
        for (Producto producto : pedido.getProductos()) {
            if (producto instanceof Impresion) {
                Impresion imp = (Impresion) producto;
                System.out.println("Impresión - Color: " + imp.getColor());
                imp.imprimirFotos();
            } else if (producto instanceof Camara) {
                Camara cam = (Camara) producto;
                System.out.println("Cámara - Marca: " + cam.getMarca() + ", Modelo: " + cam.getModelo());
            }
        }
    }
}