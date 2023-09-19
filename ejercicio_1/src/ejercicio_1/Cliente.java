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

    private int id_cliente;
    private String nombre;
    private String direccion;
    private int telefono;

    public Cliente() {

    }

    public Cliente(int id, String nom, String dir, int tel) {
        this.id_cliente = id;
        this.nombre = nom;
        this.direccion = dir;
        this.telefono = tel;
    }

    public Cliente pedirDatos(Cliente cl) {
        Scanner tc = new Scanner(System.in);
        System.out.print("Id: ");
        this.id_cliente = tc.nextInt();
        System.out.print("Nombre: ");
        this.nombre = tc.next();
        System.out.print("Direccion:");
        this.direccion = tc.next();
        System.out.print("Telefono: ");
        this.telefono = tc.nextInt();
        Cliente cli = new Cliente(this.id_cliente, this.nombre, this.direccion, this.telefono);
        System.out.println(this.nombre + " CREATED");
        return cli;
    }

    public void guardarDatos() throws IOException {
        try {
            FileWriter fw = new FileWriter("nombre.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
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
            FileReader fr = new FileReader("nombre.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
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
            while (sc.hasNext()) {
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void nombresClientes() {
        //esto es para leer
        try {
            Scanner sc = new Scanner(new FileReader("cliente.csv"));
            String linea;
            String datos[];
            int guardarDatos = 0;

            while (sc.hasNext()) {
                //leer las lineas y extraer el nombre para ello necesitamos split
                linea = sc.nextLine();
                datos = linea.split(":");
                guardarDatos += Integer.parseInt(datos[2]);
                System.out.println(datos[1]);

            }
            System.out.println(guardarDatos);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public int totalSaldo() {
        //esto es para leer
        try {
            Scanner sc = new Scanner(new FileReader("cliente.csv"));
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
//                
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
    public void clientesVip(){
               //esto es para leer
        try {
            Scanner sc = new Scanner(new FileReader("cliente.csv"));
            String linea;
            String datos[];
            FileWriter fw = new FileWriter("clientesMas30000.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            int saldo=0;

            while (sc.hasNext()) {
                //leer las lineas y extraer el nombre para ello necesitamos split
                linea = sc.nextLine();
                datos = linea.split(":");
//            if (datos[4].equals("false")) {
//                System.out.println("No tiene seguro: "+datos[1]+" saldo: "+datos[2]);
//                
//            }
saldo=Integer.parseInt(datos[2]);

                if (saldo>=30000) {
                    System.out.println("Cliente VIP : " + datos[1] + " su saldo es: " + datos[2]);
                    salida.println(datos[0] +"" + datos[1] + ":" + datos[2]+":"+datos[3] +":"+datos[4] );

                }

            }
            salida.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
        
    }//buscaCliente
    public void clientesActual(){
                //esto es para leer
        try {
            Scanner sc = new Scanner(new FileReader("cliente.csv"));
          
 FileWriter fw = new FileWriter("clientesActual.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            String linea;
            String datos[];
            int cantidad=0;
            int porcentaje=0;

      
           

            while (sc.hasNext()) {
                //leer las lineas y extraer el nombre para ello necesitamos split
                linea = sc.nextLine();
                datos = linea.split(":");
//            if (datos[4].equals("false")) {
//                System.out.println("No tiene seguro: "+datos[1]+" saldo: "+datos[2]);
//                
//            }
cantidad=Integer.parseInt(datos[2]);
porcentaje=(cantidad/100);
                System.out.println("El interes de: "+datos[1]+" es igual: "+porcentaje);
 salida.println(datos[0] +"" + datos[1] + ":" + porcentaje+":"+datos[3] +":"+datos[4] );

              

            }
            salida.close();


        } catch (IOException e) {
            e.printStackTrace();

        }
        
    }
    public void buscaCliente(){
               //esto es para leer
        try {
            Scanner sc = new Scanner(new FileReader("cliente.csv"));
            Scanner tc=new Scanner(System.in);//es necesario para escribir
            String linea;
            String datos[];
            System.out.print("Introduce el nombre que quieres buscar: ");
            String nombre=tc.nextLine();
           

            while (sc.hasNext()) {
                //leer las lineas y extraer el nombre para ello necesitamos split
                linea = sc.nextLine();
                datos = linea.split(":");
//            if (datos[4].equals("false")) {
//                System.out.println("No tiene seguro: "+datos[1]+" saldo: "+datos[2]);
//                
//            }


                if (datos[1].equalsIgnoreCase(nombre)) {

                       System.out.println(datos[0] +" " + datos[1] + " " + datos[2]+" "+datos[3] +" "+datos[4] );

                }

            }


        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public String toString() {
        return "\nID: " + this.id_cliente + "\nNOMBRE: " + this.nombre + "\nDIRECCION: " + this.direccion + "\nTELEFONO: " + this.telefono;

    }

}
