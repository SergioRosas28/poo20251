
public class EjecutarVehiculo {
    public static void main(String[] args) {
        //Creacion de los objetos de la clase Vehiculo
        //Forma1
        Vehiculo objVehiculo1 = new Vehiculo("Toyota" , "Blanco", 4500.0, "TS3456ME", 2.3, "150HP");

        //Forma2
        Vehiculo objVehiculo2;
        objVehiculo2 = new Vehiculo("Ferrari", "Rojo", 5000.0, "SEWR567UY", 1.8, "450");


        //Mostrar la marca del objeto vehiculo
        System.out.println(objVehiculo1.getmarca());

        //Se va a modificar la marca del vehiculo del objeto objVehiculo1
        objVehiculo1.setMarca("Chevrolet");

        //Mostrar todo objeto
        System.out.println(objVehiculo1.toString);
        System.out.println(objVehiculo2);
        
        }
    }

