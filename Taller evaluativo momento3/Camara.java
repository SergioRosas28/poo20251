public class Camara {

    // Atributos
    private String marca;
    private String modelo;

    public Camara(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    // Método toString
    @Override
    public String toString() {
        return "Camara { Marca: " + marca + ", Modelo: " + modelo + " }";
    }

    // Método main para probar la clase
    public static void main(String[] args) {
        Camara cam = new Camara("Canon", "4000D");
        System.out.println(cam);
    }
}
