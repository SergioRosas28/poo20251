// Nombre del archivo: Pedido.java
public class Camara extends Producto {
    private String marca;
    private String modelo;

    // Constructor de la clase Camara
    public Camara(int numero, String marca, String modelo) {
        super(numero);
        this.marca = marca;
        this.modelo = modelo;
    }

    // Métodos para obtener los atributos de la cámara
    public String getMarca() {
        return marca;
    }

    // Método para obtener el modelo de la cámara
    public String getModelo() {
        return modelo;
    }
}
