import java.util.List;

public class Impresion extends Producto {
    private String color;
    private List<Foto> fotos;

    public Impresion(int numero, String color, List<Foto> fotos) {
        super(numero);
        this.color = color;
        this.fotos = fotos;
    }

    public String getColor() {
        return color;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void imprimirFotos() {
        for (Foto foto : fotos) {
            foto.print();
        }
    }
}
