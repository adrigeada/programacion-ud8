package org.example.practica1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class App {
    static Scanner teclado = new Scanner(System.in);
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    static List<Videojuego> listaVideojuegos = new ArrayList<>();
    static void main(String[] args) {

        //Creo una lista de videojuegos por teclado. Creo el Json de esa lista y lo leo con un reader.
        //Saco los objetos del json, los meto en una lista, añado un nuevo juego a la lista, y lo vuelvo a pasar a JSON

        listaVideojuegos = crearLista();
        crearJson(listaVideojuegos);
        anyadirVideojuego();
        menor30();
        crearJson(listaVideojuegos);

    }

    static void menor30(){

        System.out.println("\nVideojuegos con precio menor a 30€");
        for (Videojuego videojuego : listaVideojuegos){
            if (videojuego.getPrecio() < 30){
                System.out.println(videojuego.getNombre());
            }
        }
    }

    static void anyadirVideojuego(){

        try {
            FileReader reader = new FileReader("src/main/java/org/example/practica1/archivos/videojuegos.json");
            Videojuego[] videojuegos = gson.fromJson(reader,Videojuego[].class);
            listaVideojuegos = new ArrayList<>(Arrays.asList(videojuegos));

            Videojuego videojuego = new Videojuego("Pokemon","Nintendo",29,true,new ArrayList<>(Arrays.asList("Aventura","Turnos")));
            listaVideojuegos.add(videojuego);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * Recibe la lista de videojuegos, crea el json con el writer y luego lo lee con el buffered reader
     * @param listaVideojuegos
     */
    static void crearJson(List<Videojuego> listaVideojuegos){

        String json = gson.toJson(listaVideojuegos);
//        System.out.println(json);

        try (FileWriter writer = new FileWriter("src/main/java/org/example/practica1/archivos/videojuegos.json")){
            gson.toJson(listaVideojuegos,writer);
            System.out.println("Bien");

        } catch (Exception e) {
            System.out.println("Mal");
            e.printStackTrace();
        }

        try {
            BufferedReader lector = new BufferedReader (new FileReader("src/main/java/org/example/practica1/archivos/videojuegos.json"));
            String linea;

            while ((linea = lector.readLine()) != null){
                System.out.println(linea);
            }
            lector.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("mal leyendo");
        }

    }

    static ArrayList<Videojuego> crearLista(){

        String nombre;
        String plataforma;
        double precio;
        boolean disponible;
        ArrayList<String> lista;
        String sino;
        int vueltasGenero;
        ArrayList<Videojuego> listaVideojuegos = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("\nDatos del juego número "+(i+1));
            System.out.print("\nNombre:");
            nombre = teclado.nextLine();
            System.out.print("Plataforma:");
            plataforma = teclado.nextLine();
            System.out.print("Precio:");
            precio = teclado.nextDouble();
            teclado.nextLine();
            System.out.print("Disponibilidad (S/N):");
            sino = teclado.nextLine().toUpperCase();

            if (sino.equals("S")) disponible = true; else disponible=false;

            lista = new ArrayList<>();
            System.out.print("Cuantos géneros? ");
            vueltasGenero = teclado.nextInt();
            teclado.nextLine();

            for (int j = 0; j < vueltasGenero; j++) {
                System.out.print((j+1)+": ");
                lista.add(teclado.nextLine());
            }

            Videojuego videojuego = new Videojuego(nombre,plataforma,precio,disponible,lista);
            listaVideojuegos.add(videojuego);
        }

        return listaVideojuegos;
    }
}
