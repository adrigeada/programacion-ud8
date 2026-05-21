package org.example.practica2;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class AppPokemon {
    static void main(String[] args) {

        try{

            Scanner teclado = new Scanner(System.in);
            System.out.println("Nombre de pokemon: ");
            String nombre = teclado.nextLine();

            String apiUrl = "https://pokeapi.co/api/v2/pokemon/"+nombre;

            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            Gson gson = new Gson();
            Pokemon pokemon = gson.fromJson(response.toString(),Pokemon.class);

            System.out.println("Datos del pokemon elegido");
            System.out.println("Nombre: "+pokemon.name);
            System.out.println("Altura: "+pokemon.height);
            System.out.println("Peso: "+pokemon.weight);

            System.out.println("Estadísticas: ");
            for (Pokemon.Stat estadistica : pokemon.stats){
                System.out.println("- "+estadistica.stat.name + ": "+estadistica.base_stat);
            }

            System.out.println("Tipos: ");
            for (Pokemon.Type tipo : pokemon.types){
                System.out.println("- "+tipo.type.name);
            }

        }catch (Exception e){
            System.out.println("Algo salió mal");
            e.printStackTrace();
        }
    }
}
