public class MenuInteractivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            // Menú principal
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Opción 1");
            System.out.println("2. Opción 2");
            System.out.println("3. Opción 3");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Elegiste la Opción 1.");
                    // Aquí podrías poner un submenú o lógica
                    break;
                case 2:
                    System.out.println("Elegiste la Opción 2.");
                    break;
                case 3:
                    System.out.println("Elegiste la Opción 3.");
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida, intenta nuevamente.");
                      }
        } while (opcion != 0);

        sc.close();
    }
}
import java.util.ArrayList;            // Importa la clase ArrayList (lista dinámica).
import java.util.Scanner;              // Importa Scanner para leer desde teclado.

public class MenuLista {               // Declara la clase pública MenuLista.
    public static void main(String[] args) {   // Punto de entrada del programa.
        Scanner sc = new Scanner(System.in);   // Crea un Scanner para leer entradas del usuario.
        ArrayList<String> lista = new ArrayList<>(); // Crea una lista dinámica de Strings vacía.
        int opcion;                             // Variable para almacenar la opción del menú.

        do {                                    // Comienza un bucle que se repetirá hasta elegir salir.
            System.out.println("\n--- MENÚ LISTA ---");                     // Muestra el título del menú (con salto de línea previo).
            System.out.println("1. Agregar elemento al final");             // Opción 1: add al final.
            System.out.println("2. Insertar elemento en posición (add)");   // Opción 2: add en índice específico.
            System.out.println("3. Modificar elemento (set)");              // Opción 3: set en un índice.
            System.out.println("4. Buscar elemento (contains)");            // Opción 4: contains.
            System.out.println("5. Obtener índice de elemento (indexOf)");  // Opción 5: indexOf.
            System.out.println("6. Mostrar lista");                         // Opción 6: imprimir lista.
            System.out.println("7. Limpiar lista (clear)");                 // Opción 7: clear.
            System.out.println("0. Salir");                                 // Opción 0: salir del programa.
            System.out.print("Elige una opción: ");                         // Pide al usuario ingresar una opción.
            opcion = sc.nextInt();                                          // Lee un entero (la opción elegida).
            sc.nextLine();                                                  // Consume el salto de línea pendiente en el buffer.

            switch (opcion) {                                               // Evalúa la opción elegida.
                case 1:                                                     // Caso 1: agregar al final.
                    System.out.print("Ingrese elemento: ");                 // Pide el elemento.
                    String elem = sc.nextLine();                            // Lee la línea completa como String.
                    lista.add(elem);                                        // Agrega el elemento al final de la lista.
                    break;                                                  // Sale del caso 1.

                    
                case 2:                                                     // Caso 2: insertar por posición.
                    System.out.print("Ingrese posición: ");                 // Pide el índice donde insertar.
                    int posAdd = sc.nextInt();                              // Lee el índice (entero).
                    sc.nextLine();                                          // Limpia el salto de línea pendiente.
                    System.out.print("Ingrese elemento: ");                 // Pide el elemento a insertar.
                    String elemAdd = sc.nextLine();                         // Lee el elemento como String.
                    if (posAdd >= 0 && posAdd <= lista.size()) {            // Valida que el índice esté entre 0 y size (inclusivo).
                        lista.add(posAdd, elemAdd);                         // Inserta el elemento en la posición dada.
                    } else {                                                // Si el índice no es válido...
                        System.out.println("Posición inválida.");           // Informa del error.
                    }
                    break;                                                  // Sale del caso 2.

                case 3:                                                     // Caso 3: modificar (set).
                    System.out.print("Ingrese posición a modificar: ");     // Pide el índice a modificar.
                    int posSet = sc.nextInt();                              // Lee el índice.
                    sc.nextLine();                                          // Limpia el salto de línea pendiente.
                    if (posSet >= 0 && posSet < lista.size()) {             // Valida que el índice exista (0 a size-1).
                        System.out.print("Nuevo elemento: ");               // Pide el nuevo valor.
                        String nuevo = sc.nextLine();                        // Lee el nuevo valor.
                        lista.set(posSet, nuevo);                            // Reemplaza el valor en ese índice.
                    } else {                                                // Si el índice no existe...
                        System.out.println("Posición inválida.");           // Informa del error.
                    }
                    break;                                                  // Sale del caso 3.

                case 4:                                                     // Caso 4: buscar con contains.
                    System.out.print("Ingrese elemento a buscar: ");        // Pide el elemento a buscar.
                    String buscar = sc.nextLine();                          // Lee el elemento.
                    if (lista.contains(buscar)) {                           // Verifica si la lista contiene el elemento.
                        System.out.println("El elemento está en la lista."); // Mensaje si lo encontró.
                    } else {                                                // Si no está...
                        System.out.println("El elemento NO está en la lista."); // Mensaje si no lo encontró.
                    }
                    break;                                                  // Sale del caso 4.

                case 5:                                                     // Caso 5: obtener índice (indexOf).
                    System.out.print("Ingrese elemento para obtener índice: "); // Pide el elemento.
                    String buscarIdx = sc.nextLine();                       // Lee el elemento.
                    int idx = lista.indexOf(buscarIdx);                     // Obtiene el primer índice donde aparece (o -1 si no está).
                    if (idx != -1) {                                        // Si lo encontró...
                        System.out.println("El índice es: " + idx);         // Muestra el índice.
                    } else {                                                // Si no lo encontró...
                        System.out.println("Elemento no encontrado.");       // Informa que no existe.
                    }
                    break;                                                  // Sale del caso 5.

                case 6:                                                     // Caso 6: mostrar lista completa.
                    System.out.println("Lista actual: " + lista);           // Imprime la lista en formato [a, b, c].
                    break;                                                  // Sale del caso 6.

                case 7:                                                     // Caso 7: limpiar lista.
                    lista.clear();                                          // Elimina todos los elementos de la lista.
                    System.out.println("Lista limpiada.");                  // Confirma la limpieza.
                    break;                                                  // Sale del caso 7.

                case 0:                                                     // Caso 0: salir.
                    System.out.println("Saliendo...");                      // Mensaje de salida.
                    break;                                                  // Termina el switch para que el do-while evalúe la condición.

                default:                                                    // Cualquier otra opción no válida.
                    System.out.println("Opción inválida.");                 // Mensaje de error.
            }                                                               // Fin del switch.
        } while (opcion != 0);                                             // Repite mientras no se elija 0 (salir).

        sc.close();                                                         // Cierra el Scanner y libera recursos.
    }                                                                       // Fin del método main.
}                                                                           // Fin de la clase MenuLista.