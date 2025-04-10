public class Foto {
    // Atributos
    private String fichero;

    // Constructor
    public Foto(String fichero) {
        this.fichero = fichero;
    }

    // Método toString
    @Override
    public String toString() {
        return "Foto { Fichero: " + fichero + " }";
    }

    // Método print opcional (puede imprimir la info de la foto)
    public void print() {
        System.out.println(this.toString());
    }
}
