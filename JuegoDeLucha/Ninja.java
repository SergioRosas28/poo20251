// Clase Ninja: personaje ágil con ataques especiales aleatorios
package JuegoDeLucha;

import java.util.Random;

public class Ninja extends Personaje {
    // Constructor: inicializa el nombre usando la superclase
    public Ninja(String nombre) {
        super(nombre);
    }

    // Implementación de la habilidad especial: ataque sigiloso con daño aleatorio
    @Override
    public void usarHabilidadEspecial(Personaje enemigo) {
        System.out.println(this.nombre + " lanza un ataque sigiloso!");
        Random random = new Random();
        int poderDeAtaque = random.nextInt(15) + 20; // Daño aleatorio entre 20 y 34
        enemigo.recibirAtaque(poderDeAtaque);
    }    
}