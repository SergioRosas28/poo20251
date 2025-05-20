// Clase que representa un arma que puede usar un personaje
package JuegoDeLucha;

public class Arma {
    private String nombre;
    private int poder;

    public Arma(String nombre, int poder) {
        this.nombre = nombre;
        this.poder = poder;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPoder() {
        return poder;
    }

    @Override
    public String toString() {
        return nombre + " (Poder: " + poder + ")";
    }
}