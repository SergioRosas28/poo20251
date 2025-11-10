package Bucle_Do_While;

import java.util.Scanner;

public class Bucle_Do_While {
    public static void main(String[] args) {    
    int contador = 1;
    final var valor = 5;
    Scanner entrada = new Scanner(System.in); 
    //do{
        /*System.out.println("Valor: " + contador ++);
    }while(contador<= valor); 
    System.out.println("Fin del bucle");
*/
      int numero = 0;
      do{
        System.out.println("Ingrese el numero 5...");
        numero = entrada.nextInt();
        if(numero!=5);
        System.out.println("No ingresaste el numero 5");
      }while(numero!= 5);
      System.out.println("Gracias, es el fucking numero correcto");
    }
 }