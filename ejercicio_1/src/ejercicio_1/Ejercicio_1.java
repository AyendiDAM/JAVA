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
        Cliente cliente = new Cliente();
        cliente.pedirDatos(cliente);
        cliente.guardarDatos();
        System.out.println("Cliente creado: ");
        cliente.leerDatos();
        System.out.println("");
        cliente.verClientes();
        System.out.println("");
        cliente.nombresClientes();
        System.out.println("");
        int total = cliente.totalSaldo();
        if (total == -1) {
            System.out.println("se ha producido un error");
        }
        System.out.println("");
        cliente.clientesSinSeguro();
        cliente.clientesVip();
        cliente.buscaCliente();
        cliente.clientesActual();

    }
}
