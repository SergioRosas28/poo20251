public class EjecutarComposicionAgegacion {

    public static void main (String [] args){

        //Creacion de los objetos para validar el modelo
        Cuenta [] c = new Cuenta [2]; //Creacion de una estructura de arreglos para las cuentas
        c[0] = new Cuenta new Cuenta (numero:10203456, tipo:"Ahorros", saldo: 2000.0);
        c[1] = new Cuenta new Cuenta (numero:20250106, tipo:"Corriente", saldo: 5000.0);

        /*
        Cuenta objCuenta1 = new Cuenta (numero: 10203456, tipo: "Ahorros", saldo: 2000.0);
        Cuenta objCuenta2 = new Cuenta (numero: 20250106, tipo: "Corriente", saldo: 5000.0);
        */
        Cliente objCliente1 = new Cliente (cedula:10113456789, nombre:"Byron Cano");
        Cliente objCliente2 = new Cliente (cedula:31789087, nombre :"Natalia Hurtado");

        Banco objBanco1 = new Banco(nombre:"Bancarota", direccion:"Calle 5ta", objCuenta1);
        System.out.println(objBanco1);
        objBanco1.consultarCliente(objCliente2);
    }
}