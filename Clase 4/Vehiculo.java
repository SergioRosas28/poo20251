package Clase 4;

public class Vehiculo {
    
    //Atributos de la case
    private String marca;
    private String color;
    private double cilindraje;
    private String chasis;
    private double peso;
    private String potencia;

    /*
    *Constructor de la clase -> permite inicializar el objeto
    *El contructor de la clase se reconoce porque tiene el mismo
    *Nombre de la clase
    */

    public Vehiculo (String marca, String color, double cilindraje, String chasis, double peso, String potencia){
        this.marca = marca;
        this.color = color;
        this.cilindraje = cilindraje;
        this.chasis = chasis;
        this.peso = peso;
        this.potencia = potencia;
        
    }
    //Metodos getter / setter
    public String getMarca(){
        return marca;
    } 

    public void setMarca (String marca){
        this.marca = marca;
    }

    public String toString (){
        return "Vehiculo {Marca: "+ marca + "Color: "+ color + 
        " Cilindraje:" + cilindraje + "Chasis: "+ chasis + "Peso:"
        + peso + "Potencia: "+ potencia +"}";
    }
}
