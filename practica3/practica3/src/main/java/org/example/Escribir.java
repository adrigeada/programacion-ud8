package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Escribir {
    static void main() {

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
        ejercicio8();

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
}
