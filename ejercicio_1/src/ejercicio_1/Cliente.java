/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author ayend
 */
public class Cliente {
//creamaos las propiedades del cliente

    private int id_cliente;
    private String nombre;
    private String direccion;
    private int telefono;

    //este es un metodo constructor para que se pueda crear un cliente sin propiedades
    public Cliente() {
    }

    //este es un metodo contrutor el cual ya creamos a un cliente con sus propiedades
    public Cliente(int id, String nom, String dir, int tel) {
        this.id_cliente = id;
        this.nombre = nom;
        this.direccion = dir;
        this.telefono = tel;
    }

    public Cliente pedirDatos(Cliente cl) {//le pasamos al metodo un objeto cliente
        Scanner tc = new Scanner(System.in);
        System.out.print("Introduce tu Id: ");
        this.id_cliente = tc.nextInt();//introducimos id del cliente
         tc.nextLine(); // para limpiar el bufer
        System.out.print("Introduce el Nombre: ");
        this.nombre = tc.nextLine();
        System.out.print("introduce la Direccion:");
        this.direccion = tc.nextLine();
        System.out.print("introduce el numero del Telefono: ");
        this.telefono = tc.nextInt();
        Cliente cliente = new Cliente(this.id_cliente, this.nombre, this.direccion, this.telefono);//aquí le pasamos todos los datos antes introducido al cliente
        System.out.println(" ya está creado el cliente" + this.nombre);
        return cliente;
    }

    public void guardarDatos() throws IOException {
        try {
            FileWriter fw = new FileWriter("nombre.txt");//creamos un archivo el true es para no machacar la informacion
            BufferedWriter bw = new BufferedWriter(fw);//permite escribir en el fichero objetos
            PrintWriter salida = new PrintWriter(bw);//nos permite escribir en el fichero igual que la salida de pantalla
            salida.print("\nID: " + this.id_cliente + "\nNOMBRE: " + this.nombre + "\nDIRECCION: " + this.direccion + "\nTELEFONO: " + this.telefono);
            salida.close();
            bw.close();
            fw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    //LEER EN UN FICHERO DE TEXTO
    public void leerDatos() throws FileNotFoundException {
        try {
            FileReader fr = new FileReader("nombre.txt");//para leer lo que este en el fichero nombre
            BufferedReader br = new BufferedReader(fr);//para lo que este escrito en el fichero
            String linea;
            while ((linea = br.readLine()) != null) {//para que lea hasta la ultima linea que hay en el br.readLine contiene todo el contenido
                System.out.print(linea+" ");//muestra lo que hay en el documento de etxto
            }
            br.close();
            fr.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void verClientes() {
        try {
            Scanner sc = new Scanner(new FileReader("cliente.csv"));
            while (sc.hasNext()) {//si hay mas linea por leer el metodo devuelve true 
                System.out.println(sc.nextLine());//lee una linea completa 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void nombresClientes() {
        //esto es para leer
        try {
            Scanner sc = new Scanner(new FileReader("cliente.csv"));//para abrir y leer el fichero cliente
            String linea;
            String datos[];
            int guardarDatos = 0;

            while (sc.hasNext()) {
                //leer las lineas y extraer el nombre para ello necesitamos split
                linea = sc.nextLine();
                datos = linea.split(":");//separa los caracteres en este caso con dos puntos
                guardarDatos += Integer.parseInt(datos[2]);
                System.out.println(datos[1]);
            }
            System.out.println(guardarDatos);
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int totalSaldo() {
        //esto es para leer
        try {
            Scanner sc = new Scanner(new FileReader("cliente.csv"));//para abrir y leer el fichero cliente
            String linea;
            String datos[];
            int guardarDatos = 0;
            while (sc.hasNext()) {
                //leer las lineas y extraer el nombre para ello necesitamos split
                linea = sc.nextLine();
                datos = linea.split(":");
                guardarDatos += Integer.parseInt(datos[2]);
                //  System.out.println(datos[1]);
            }
            System.out.println("El total de saldos es: " + guardarDatos);
            return guardarDatos;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;// en caso de fallo
        }
    }

    public void clientesSinSeguro() {
        //esto es para leer
        try {
            Scanner sc = new Scanner(new FileReader("cliente.csv"));
            String linea;
            String datos[];
            FileWriter fw = new FileWriter("clientesSinSeguro.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            while (sc.hasNext()) {
                //leer las lineas y extraer el nombre para ello necesitamos split
                linea = sc.nextLine();
                datos = linea.split(":");
//            if (datos[4].equals("false")) {
//                System.out.println("No tiene seguro: "+datos[1]+" saldo: "+datos[2]);            
//            }
                if (!Boolean.parseBoolean(datos[4])) {
                    System.out.println("No tiene seguro: " + datos[1] + "su saldo es: " + datos[2]);
                    salida.println("" + datos[1] + ":" + datos[2]);
                }
            }
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clientesVip() {
        //esto es para leer
        try {
            Scanner sc = new Scanner(new FileReader("cliente.csv"));
            String linea;
            String datos[];
            FileWriter fw = new FileWriter("clientesMas30000.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            int saldo = 0;

            while (sc.hasNext()) {
                //leer las lineas y extraer el nombre para ello necesitamos split
                linea = sc.nextLine();
                datos = linea.split(":");
//            if (datos[4].equals("false")) {
//                System.out.println("No tiene seguro: "+datos[1]+" saldo: "+datos[2]);
//                
//            }
                saldo = Integer.parseInt(datos[2]);
                if (saldo >= 30000) {
                    System.out.println("Cliente VIP : " + datos[1] + " su saldo es: " + datos[2]);
                    salida.println(datos[0] + "" + datos[1] + ":" + datos[2] + ":" + datos[3] + ":" + datos[4]);
                }
            }
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clientesActual() {
        //esto es para leer
        try {
            Scanner sc = new Scanner(new FileReader("cliente.csv"));

            FileWriter fw = new FileWriter("clientesActual.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            String linea;
            String datos[];
            int cantidad = 0;
            int porcentaje = 0;
            while (sc.hasNext()) {
                //leer las lineas y extraer el nombre para ello necesitamos split
                linea = sc.nextLine();
                datos = linea.split(":");
//            if (datos[4].equals("false")) {
//                System.out.println("No tiene seguro: "+datos[1]+" saldo: "+datos[2]);
//                
//            }
                cantidad = Integer.parseInt(datos[2]);
                porcentaje = (cantidad / 100);
                System.out.println("El interes de: " + datos[1] + " es igual: " + porcentaje);
                salida.println(datos[0] + "" + datos[1] + ":" + porcentaje + ":" + datos[3] + ":" + datos[4]);
            }
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buscaCliente() {
        //esto es para leer
        try {
            Scanner sc = new Scanner(new FileReader("cliente.csv"));
            Scanner tc = new Scanner(System.in);//es necesario para escribir
            String linea;
            String datos[];
            System.out.print("Introduce el nombre que quieres buscar: ");
            String nombre = tc.nextLine();

            boolean clienteExiste = true;
            while (sc.hasNext()) {
                //leer las lineas y extraer el nombre para ello necesitamos split
                linea = sc.nextLine();
                datos = linea.split(":");
//            if (datos[4].equals("false")) {
//                System.out.println("No tiene seguro: "+datos[1]+" saldo: "+datos[2]);
//                
//            }
                if (datos[1].equalsIgnoreCase(nombre)) {
                    System.out.println(datos[0] + " " + datos[1] + " " + datos[2] + " " + datos[3] + " " + datos[4]);
                } else {
                    clienteExiste = false;
                }
            }
            if (clienteExiste) {
            } else {
                System.out.println("No existe " + nombre + ", como cliente");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return "\nID: " + this.id_cliente + "\nNOMBRE: " + this.nombre + "\nDIRECCION: " + this.direccion + "\nTELEFONO: " + this.telefono;
    }
}
