package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Escribir {
    static void main() {

        File archivo = new File("src/main/resources/ejemplo1.txt");

//        try {
//
//            BufferedWriter escritor = new BufferedWriter(new FileWriter("src/main/resources/prueba_escribir.txt"));
//            escritor.write("Hola, mundo!");
//            escritor.newLine();
//            escritor.write("Esto se guarda en el archivo.");
//
//            escritor.close();
//
//        } catch (IOException e) {
//            System.out.println("Ha habido algún problema.");
//            e.printStackTrace();
//        }
//        ejercicio8();
        ejercicio9(archivo);

    }

    public static void ejercicio8(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Número de archivos: ");

        int num = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Carpeta en la que crearlo?");
        String carpeta = teclado.nextLine();

        for (int i = 1; i <= num; i++) {
            File archivo = new File("src/main/resources/"+carpeta+"/nombre"+i+".txt");
            BufferedWriter escritor = null;

            try{

                if (archivo.createNewFile()){
                    escritor = new BufferedWriter(new FileWriter("src/main/resources/"+carpeta+"/nombre"+i+".txt"));
                    System.out.println("Creando archivo "+archivo.getName()+" en "+archivo.getPath());
                    escritor.write("Este el fichero nombre"+i+".txt");
//                    escritor.flush();

                }else {
                    System.out.println("Archivo ya existe");
                }

                if (escritor != null){
                    escritor.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void ejercicio9(File archivo){

        File archivoTemp = new File("src/main/resources/archivoTempEj9.txt");

        try{
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemp));
            String linea;

            while ((linea = lector.readLine()) != null) {

                for (String palabras : linea.split(" ")){//Cojo cada palabra de la línea

                    String[] palabra= palabras.split("");//Esas palabras la separo en letras
                    palabra[0] = palabra[0].toUpperCase();//La primera letra de cada palabra la pongo mayuscula

                    String palabraEscribir = "";
                    for (String letras : palabra){ //Concateno todas las letras en un String nuevo
                        palabraEscribir += letras;
                    }

                    escritor.write(palabraEscribir+" ");//El escritor escribe la nueva palabra con un espacio detrás
                }

            }
            lector.close();
            escritor.close();

            if (archivo.delete()) {
                archivoTemp.renameTo(archivo);
                System.out.println("Archivo modificado correctamente.");
            } else {
                System.out.println("No se ha podido reemplazar el archivo original.");
            }



        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
