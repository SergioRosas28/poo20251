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