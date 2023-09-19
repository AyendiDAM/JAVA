/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_1;

import java.io.IOException;

/**
 *
 * @author ayend
 */
public class Ejercicio_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
/*
        PROGRAMACIÓN:
1. Escribe el código necesario para mostrar por pantalla el contenido del siguiente array
Int numeros={5,3,1,0,7}
        int num[]={5,3,1,0,7};
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]);
            
        }
2. Crea una clase “Cliente” que tenga las propiedades :
a. id_cliente: entero
b. nombre: cadena de caracteres
c. dirección: cadena de caracteres
d. teléfono: cadena de caracteres
3. En la clase “Cliente”, añade un método para visualizar la información de un cliente
4. En la clase cliente, crea un método void pedirDatos() que pida por pantalla todos los
datos de un cliente. No hay que hacer control de excepciones.
5. En la clase cliente, crea un método void guardarDatos() que escriba los datos de un
cliente en un archivo misclientes.txt.

        */
Cliente cliente=new Cliente();
//cliente.pedirDatos(cliente);
//cliente.guardarDatos();
//cliente.leerDatos();
//
//cliente.verClientes();
//        System.out.println("");
//cliente.nombresClientes();
//        System.out.println("");
//      int total=   cliente.totalSaldo();
//        if (total==-1) {
//                        System.out.println("se ha producido un error");
//            
//        }
//        System.out.println("");
//        cliente.clientesSinSeguro();
//cliente.clientesVip();
//cliente.buscaCliente();
cliente.clientesActual();

    }
}
