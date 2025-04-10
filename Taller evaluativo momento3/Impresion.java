import java.util.Arrays;

public class Impresion {

    // Atributos
    private String color;
    private Foto[] foto;

    // Constructor
    public Impresion(String color, Foto[] foto) {
        this.color = color;
        this.foto = foto;
    }

    // Método toString
    @Override
    public String toString() {
        return "Impresion { Color: " + color + ", Fotos: " + Arrays.toString(foto) + " }";
    }

    // Método main para probar la clase
    public static void main(String[] args) {
        // Crear algunas fotos
        Foto[] fotos = {
            new Foto("familia.jpg"),
            new Foto("vacaciones.jpg"),
            new Foto("mascota.png")
        };

        // Crear impresión
        Impresion impresion = new Impresion("Color", fotos);

        // Imprimir el resultado
        System.out.println(impresion);
    }
}
