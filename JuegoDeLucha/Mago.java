// Clase Mago: personaje que utiliza magia para atacar
package JuagoDeLucha;

public class Mago extends Personaje {
    // Constructor: inicializa el nombre usando la superclase
    public Mago(String nombre) {
        super(nombre);
    }

    // Implementación de la habilidad especial: hechizo mágico
    @Override
    public void usarHabilidadEspecial(Personaje enemigo) {
        System.out.println(this.nombre + " lanza un hechizo mágico!");
        int poderDeAtaque = 25; // Daño fijo de la habilidad especial
        enemigo.recibirAtaque(poderDeAtaque);
    }
}