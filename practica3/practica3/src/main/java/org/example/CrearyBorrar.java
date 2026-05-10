package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CrearyBorrar {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Número de archivos: ");

        int num = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Carpeta en la que crearlo?");
        String carpeta = teclado.nextLine();

        for (int i = 1; i <= num; i++) {
            File archivo = new File("src/main/resources/"+carpeta+"/nombre"+i+".txt");

            try{
             if (archivo.createNewFile()){
                 System.out.println("Creando archivo "+archivo.getName()+" en "+archivo.getPath());
             }else {
                 System.out.println("Archivo ya existe");
             }


            } catch (IOException e) {
                e.printStackTrace();
            }

        }

//        File archivo = new File("src/main/resources/archivoParaEliminar.txt");
//        try {
//            if (archivo.createNewFile())  System.out.println("Archivo creado");
//            else  System.out.println("El archivo ya existe");
//        } catch (
//                IOException e) {     e.printStackTrace();   }
//
//        File directorio = new File("src/main/resources/nuevoDirectorio");
//        if (directorio.mkdir())  System.out.println("Directorio creado");
//        else  System.out.println("No se pudo crear el directorio");
//
//        File archivoBorrar = new File("src/main/resources/archivoParaEliminar.txt");
//        if (archivoBorrar.delete())  System.out.println("Archivo eliminado");
//        else  System.out.println("No se pudo eliminar el archivo");


    }


}


