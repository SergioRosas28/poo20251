public class Camara {

    // Atributos
    private String marca;
    private String modelo;

    // Metodos
    public Camara(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String toString(){
        return "Camara { marca: " + marca + "modelo: " + modelo + "}";
    }
}