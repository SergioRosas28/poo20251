import java.util.Scanner;

public class Bucle_While {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        final String usuario = "Hola";
        final String contraseña = "123";
        boolean acceso = false;

        while (!acceso) {
            System.out.println("Ingresar usuario: ");
            String username = entrada.next();

            System.out.println("Ingresar contraseña: ");
            String clave = entrada.next();

            if (usuario.equals(username) && (contraseña.equals(clave))) {
                System.out.println("ACCESO CORRECTO");
                acceso = true;
            } else {
                System.out.println("USUARIO O CONTRASEÑA INCORRECTO" + "\n");

            }
        }
    }
}
