public class Ejercicio3 {
    public static void main(String[] args) {
        /*
         * 3. Dado un arreglo lineal de números,sumar separadamente
         * los números pares y los numeros impares
         * 
         * Análisis: declarar un arreglo, en dos variables ir guardando
         * la suma de los numeros pares y números impares, lo anterior
         * debe iterar en un "for" con la condicion de validar si el
         * numero es par o impar (n%2 == 0 -> par)
         */
        int[] arreglo = { 5, 2, 6, 5, 9, 90, 1, 8, 15, 4 };
        int sumaPares = 0, sumaImpares = 0;

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] % 2 == 0) {
                sumaPares += arreglo[i];
            } else {
                sumaImpares += arreglo[i];
            }
        }
        System.out.println("La suma de los numeros pares es: " + sumaPares);
        System.out.println("La suma de los numeros impares es: " + sumaImpares);
    }
}
