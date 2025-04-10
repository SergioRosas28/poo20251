import java.util.Arrays;
public class Impresion {

    // Atributos
    private String color;
    private Foto[] foto; // [] Arreglo de foto

    // Metodos

    public Impresion (String color, Foto[] foto){
        this.color = color;
        this.foto = foto;
    }

    public String toString() {
        return "Impresion { : "+ color + "Foto: " + Arrays.toString(foto) + "}";
    }
}