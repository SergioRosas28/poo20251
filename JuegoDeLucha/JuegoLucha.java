// Clase principal que gestiona el flujo del juego de lucha entre dos personajes
package JuegoDeLucha;

import java.util.Scanner;

public class JuegoLucha {
    // Referencias a los dos personajes que lucharán
    private Personaje jugador1;
    private Personaje jugador2;
    // Scanner para entrada de usuario
    private Scanner scanner = new Scanner(System.in);

    // Método main para iniciar el juego
    public static void main(String[] args) {
        // Crear una instancia del juego y comenzar
        JuegoLucha juego = new JuegoLucha();
        juego.iniciarJuego();
    }

    // Método para iniciar el juego y seleccionar personajes
    public void iniciarJuego() {
        System.out.println("=====Bienvenido al juego de lucha!=====");
        System.out.print("Selecciona el personaje del Jugador 1: ");
        jugador1 = seleccionarPersonaje();

        System.out.print("Selecciona el personaje del Jugador 2: ");
        jugador2 = seleccionarPersonaje();

        iniciarBatalla();
    }
    // Permite al usuario elegir el tipo de personaje y su nombre
    private Personaje seleccionarPersonaje() {
        System.out.println("\n1. Guerrero: ");
        System.out.println("2. Mago: ");
        System.out.println("3. Ninja: ");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingresa el nombre del personaje: ");
        String nombre = scanner.nextLine();
        Personaje personaje;
        switch (opcion) {
            case 1:
                personaje = new Guerrero(nombre);
                break;
            case 2:
                personaje = new Mago(nombre);
                break;
            case 3:
                personaje = new Ninja(nombre);
                break;
            default:
                System.out.println("Opción inválida. Seleccionando Guerrero por defecto.");
                personaje = new Guerrero(nombre);
        }
        // Selección de arma
        personaje.setArma(seleccionarArma());
        return personaje;
    }

    // Permite al usuario seleccionar un arma para el personaje
    private Arma seleccionarArma() {
        System.out.println("Selecciona un arma:");
        System.out.println("1. Espada (Poder: 10)");
        System.out.println("2. Bastón mágico (Poder: 12)");
        System.out.println("3. Shuriken (Poder: 8)");
        System.out.println("4. Sin arma");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        switch (opcion) {
            case 1:
                return new Arma("Espada", 10);
            case 2:
                return new Arma("Bastón mágico", 12);
            case 3:
                return new Arma("Shuriken", 8);
            default:
                System.out.println("Sin arma seleccionada.");
                return null;
        }
    }
    // Lógica principal de la batalla por turnos entre los dos personajes
    private void iniciarBatalla() {
        System.out.println("!Comienza la batalla entre " + jugador1.getNombre() + " y " + jugador2.getNombre() + "!");
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            // Turno del jugador 1
            System.out.println("\nTurno de " + jugador1.getNombre());
            jugador1.mostrarEstado();
            jugador2.mostrarEstado();
            System.out.print("¿Quieres atacar (A), atacar con arma (W), usar habilidad especial (H) o rematar (M)? ");
            String accion = scanner.nextLine().toUpperCase();

            if (accion.equals("A")) {
                // Ataque normal sin arma
                Arma armaTemporal = jugador1.getArma();
                jugador1.setArma(null);
                jugador1.atacar(jugador2);
                jugador1.setArma(armaTemporal);
            } else if (accion.equals("W")) {
                // Ataque con arma (si tiene)
                if (jugador1.getArma() != null) {
                    jugador1.atacar(jugador2);
                } else {
                    System.out.println(jugador1.getNombre() + " no tiene arma equipada. Turno perdido.");
                }
            } else if (accion.equals("H")) {
                jugador1.usarHabilidadEspecial(jugador2);
            } else if (accion.equals("M")) {
                if (jugador2.getPuntosDeVida() < 10) {
                    System.out.println(jugador1.getNombre() + " ejecuta un remate mortal sobre " + jugador2.getNombre() + "!");
                    jugador2.recibirAtaque(jugador2.getPuntosDeVida());
                } else {
                    System.out.println("Solo puedes usar el remate mortal si el oponente tiene menos de 10 puntos de vida.");
                }
            } else {
                System.out.println("Acción inválida. Turno perdido.");
            }

            // Turno del jugador 2 (si sigue vivo)
            if (jugador2.estaVivo()) {
                System.out.println("\nTurno de " + jugador2.getNombre());
                jugador2.mostrarEstado();
                jugador1.mostrarEstado();
                System.out.print("¿Quieres atacar (A), atacar con arma (W), usar habilidad especial (H) o rematar (M)? ");
                accion = scanner.nextLine().toUpperCase();

                if (accion.equals("A")) {
                    Arma armaTemporal = jugador2.getArma();
                    jugador2.setArma(null);
                    jugador2.atacar(jugador1);
                    jugador2.setArma(armaTemporal);
                } else if (accion.equals("W")) {
                    if (jugador2.getArma() != null) {
                        jugador2.atacar(jugador1);
                    } else {
                        System.out.println(jugador2.getNombre() + " no tiene arma equipada. Turno perdido.");
                    }
                } else if (accion.equals("H")) {
                    jugador2.usarHabilidadEspecial(jugador1);
                } else if (accion.equals("M")) {
                    if (jugador1.getPuntosDeVida() < 10) {
                        System.out.println(jugador2.getNombre() + " ejecuta un remate mortal sobre " + jugador1.getNombre() + "!");
                        jugador1.recibirAtaque(jugador1.getPuntosDeVida());
                    } else {
                        System.out.println("Solo puedes usar el remate mortal si el oponente tiene menos de 10 puntos de vida.");
                    }
                } else {
                    System.out.println("Acción inválida. Turno perdido.");
                }
            }
        }

        // Mensaje final indicando quién fue derrotado
        if (!jugador1.estaVivo()) {
            System.out.println(jugador1.getNombre() + " ha sido derrotado!");
        } else {
            System.out.println(jugador2.getNombre() + " ha sido derrotado!");
        }
    }
}