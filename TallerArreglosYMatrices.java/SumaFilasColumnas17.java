import javax.sound.sampled.SourceDataLine;

public class SumaFilasColumnas17 {
    public static void main(String[] args) {
        int [][] matriz = { 
            {1,2,3},
            {4,5,6},
            {7,8,9},


    };
    int filas = matriz.length;
    int columnas = matriz[0].length;

    //Sumar los elementos de cada fila
    System.out.println("Suma de cada fila:");
    for (int i = 0; i < filas; i++){
        int sumaFila = 0;
        for (int j =0;j <columnas; j++){
            sumaFila +=matriz [i][j];
        }
        System.out.println("Fila " + (i + 1) + ":" + sumaFila);
    }
       //Sumar los elementos de cada columna
      System.out.println("Suma de cada columna");
      for (int j =   0; j < columnas; j++){
        int sumaColumna = 0;
        for (int i = 0; i < filas; i++){

        }
        System.out.println("Columna" + (j +1 ) + ":" + sumaColumna);
    }
}

}