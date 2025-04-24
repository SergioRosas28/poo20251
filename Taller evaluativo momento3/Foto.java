public class Foto {
    private String fichero;

    public Foto(String fichero) {
        this.fichero = fichero;
    }

    public String getFichero() {
        return fichero;
    }

    public void print() {
        System.out.println("Imprimiendo foto: " + fichero);
    }
}