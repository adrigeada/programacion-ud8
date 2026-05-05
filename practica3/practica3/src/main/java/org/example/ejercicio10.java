package org.example;

import java.io.*;
import java.util.*;

public class ejercicio10 {
    static void main() {

        File arch1 = new File("src/main/resources/ejemplo1.txt");
        File arch2 = new File("src/main/resources/prueba_escribir.txt");
        actividad10(arch1,arch2);

    }

    public static void actividad10(File archivo1, File archivo2){

        Queue<String> cola1 = leerPalabras(archivo1);
        Queue<String> cola2 = leerPalabras(archivo2);

        System.out.println(cola1+" "+cola2);

        try {
            PrintWriter writer = new PrintWriter(new FileWriter("src/main/resources/actividad10.txt"));

            while (!cola1.isEmpty() || !cola2.isEmpty()){

                if (!cola1.isEmpty()){
                    writer.write(cola1.poll()+" ");
                }

                if (!cola2.isEmpty()){
                    writer.write(cola2.poll()+" ");
                }

            }

            writer.close();

        }catch (IOException e){
            e.printStackTrace();
        }


    }

    public static Queue<String> leerPalabras(File archivo){
        Queue<String> cola = new LinkedList<>();
        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;

            while ((linea = lector.readLine()) != null){
                for (String palabra : linea.split(" ")){
                    cola.offer(palabra);
                }
            }


        }catch (IOException e){
            e.printStackTrace();
        }
        return cola;
    }
}
