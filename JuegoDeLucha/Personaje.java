// Clase abstracta base para todos los personajes del juego de lucha
// Define atributos y métodos comunes
package JuagoDeLucha;

import java.util.Random;

public abstract class Personaje {
    // Nombre del personaje
    protected String nombre;
    // Puntos de vida actuales
    protected int PuntosDeVida;
    // Constantes para el rango de poder de ataque
    protected final int MAX_PODER = 30;
    protected final int MIN_PODER = 10;
    // Arma del personaje
    protected Arma arma;

    // Constructor: inicializa el nombre y los puntos de vida
    public Personaje(String nombre) {
        this.nombre = nombre;
        this.PuntosDeVida = 100;
        this.arma = null; // Por defecto sin arma
    }

    // Permite asignar un arma al personaje
    public void setArma(Arma arma) {
        this.arma = arma;
    }

    // Devuelve el arma actual
    public Arma getArma() {
        return arma;
    }

    // Método para atacar a otro personaje con un daño aleatorio
    public void atacar(Personaje enemigo) {
        Random random = new Random();
        int poderDeAtaque = random.nextInt(MAX_PODER - MIN_PODER + 1) + MIN_PODER;
        if (arma != null) {
            poderDeAtaque += arma.getPoder();
            System.out.println(this.nombre + " ataca con " + arma.getNombre() + "!");
        }
        enemigo.recibirAtaque(poderDeAtaque);
        System.out.println(this.nombre + " ataca a " + enemigo.getNombre() + " con " + poderDeAtaque + " puntos de daño.");
    }

    // Método para recibir un ataque y reducir los puntos de vida
    public void recibirAtaque(int poderDeAtaque) {
        this.PuntosDeVida -= poderDeAtaque;
        if (this.PuntosDeVida < 0) {
            this.PuntosDeVida = 0;
        }
    }

    // Indica si el personaje sigue vivo
    public boolean estaVivo() {
        return this.PuntosDeVida > 0;
    }

    // Devuelve el nombre del personaje
    public String getNombre() {
        return nombre;
    }

    // Devuelve los puntos de vida actuales
    public int getPuntosDeVida() {
        return PuntosDeVida;
    }

    // Método abstracto para la habilidad especial (debe implementarse en subclases)
    public abstract void usarHabilidadEspecial(Personaje enemigo);

    // Muestra el estado actual del personaje
    public void mostrarEstado() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Puntos de Vida: " + PuntosDeVida);
        if (arma != null) {
            System.out.println("Arma: " + arma);
        } else {
            System.out.println("Arma: Sin arma");
        }
    }

    // Representación en texto del personaje
    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", PuntosDeVida=" + PuntosDeVida +
                '}';
    }
}