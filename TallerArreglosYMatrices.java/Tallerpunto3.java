public class  Tallerpunto3 {
    public static void main(String[] args) {
        int[] arreglo = {1,2,3,4,5,6,7,8,9,10};
        int sumaPares = 0;
        int sumaImpares = 0;

        for (int num : arreglo ) {
            if (num % 2 == 0) {
                sumaPares += num;
            }else{
               sumaImpares += num;
            }
        }
        System.out.println("Suma de pares: " + sumaPares);
        System.out.println("Suma de Impares" + sumaImpares);    
    }
}