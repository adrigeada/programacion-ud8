package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Leer {
    static void main() {

//        try {
//            BufferedReader lector = new BufferedReader(new FileReader("src/main/resources/datos.txt"));
//            String linea;
//
//            while ((linea = lector.readLine()) != null) {
//                System.out.println(linea);
//            }
//
//            lector.close();
//
//        }catch (IOException e){
//            System.out.println(e.getStackTrace());
//            throw new RuntimeException(e);
//        }

        contarPalabras("type");
        contarPalabrasSC("type");


    }

    public static void contarPalabras(String palabra){

        HashMap<String,Integer> mapa = new HashMap<>();

        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/main/resources/datos.txt"));
            String linea;

            while ((linea = lector.readLine()) != null) {

                for (String palabrita : linea.split(" ")){

                    if (mapa.containsKey(palabrita)){
                        mapa.put(palabrita, mapa.get(palabrita)+1);
                    }else {
                        mapa.put(palabrita,1);
                    }


                }


            }

            System.out.println(mapa.get(palabra));

            lector.close();

        }catch (IOException e){
            System.out.println(e.getStackTrace());
            throw new RuntimeException(e);
        }

    }

    public static void contarPalabrasSC(String palabra){

        HashMap<String,Integer> mapa = new HashMap<>();

        try {
            File archivo = new File("src/main/resources/datos.txt");
            Scanner lector = new Scanner(archivo);

            while (lector.hasNextLine()) {

                String linea = lector.nextLine();

                for (String palabrita : linea.split(" ")){

                    if (mapa.containsKey(palabrita)){
                        mapa.put(palabrita, mapa.get(palabrita)+1);
                    }else {
                        mapa.put(palabrita,1);
                    }

                }

            }

            System.out.println(mapa.get(palabra));

            lector.close();

        }catch (IOException e){
            System.out.println(e.getStackTrace());
            throw new RuntimeException(e);
        }


    }
}
