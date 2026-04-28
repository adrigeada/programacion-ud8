package org.example;

import java.io.File;


public class ListarArchivos {
    static void main() {

        File directorio2 = new File("src/main/resources/nuevoDirectorio");

//        String[] archivos = directorio2.list();
//
//        if (archivos != null && archivos.length > 0){
//            for (String a : archivos){
//                System.out.println(a);
//            }
//        }else{
//            System.out.println("No hay archivos en la carpeta");
//        }

        listaCarpeta(directorio2);
        System.out.println("\n");
        listaCarpeta(directorio2,".jpg");



        //ACTIVIDAD 5. Crea un método que reciba una carpeta y liste el contenido de dicha carpeta de aquellos archivos cuya extensión sea .txt.
        // Crea una sobrecarga para que el método pueda recibir también el tipo de archivo a listar (.pdf, .jpg, etc,...).






    }

    public static void listaCarpeta(File carpeta){

        if (carpeta.isDirectory()){

            String[] archivos = carpeta.list();

            if (archivos != null && archivos.length > 0){
                for (String a : archivos){
                    if (a.contains(".txt")){
                        System.out.println(a);
                    }

                }

            }
        }else {
            System.out.println("Parámetro pasado no es una carpeta");
        }
    }

    public static void listaCarpeta(File carpeta, String formato){

        if (carpeta.isDirectory()){

            String[] archivos = carpeta.list();

            if (archivos != null && archivos.length > 0){
                for (String a : archivos){
                    if (a.contains(formato)){
                        System.out.println(a);
                    }

                }

            }
        }else {
            System.out.println("Parámetro pasado no es una carpeta");
        }


    }

}
