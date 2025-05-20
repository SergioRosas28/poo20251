// Clase Guerrero: personaje especializado en ataques físicos
package JuagoDeLucha;

public class Guerrero extends Personaje {
  // Constructor: inicializa el nombre usando la superclase
  public Guerrero(String nombre) {
    super(nombre);
  }
  // Implementación de la habilidad especial: golpe de espada
  @Override
  public void usarHabilidadEspecial(Personaje enemigo) {
    System.out.println(this.nombre + " Usar golpe de espada");
    int poderDeAtaque = 20; // Daño fijo de la habilidad especial
    enemigo.recibirAtaque(poderDeAtaque);
  }
}