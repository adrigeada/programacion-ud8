package org.example.jsones;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class GsonEjemplo {
    static void main() {
        Gson gson = new Gson();

        PersonaJSON persona = new PersonaJSON("Luis",25, Arrays.asList("Java","Python"));
        PersonaJSON persona2 = new PersonaJSON("Marina",24,Arrays.asList("Español","Inglés"));
        PersonaJSON persona3 = new PersonaJSON("Adri",28,Arrays.asList("Java","SQL"));
        ArrayList<PersonaJSON> listaPersonas = new ArrayList<>(Arrays.asList(persona,persona2,persona3));

        String json = gson.toJson(persona);
        System.out.println("JSON:" + json);

        json = gson.toJson(listaPersonas);
        System.out.println("Lista personas JSON: "+json);


        //-------------------------------

        Gson gsonBuild = new GsonBuilder().setPrettyPrinting().create();

        json = gsonBuild.toJson(listaPersonas);
        System.out.println("JSON limpio: "+json );

        try (FileWriter writer = new FileWriter("src/main/resources/personas.json")) {
            gsonBuild.toJson(listaPersonas, writer);
            System.out.println("JSON guardado en persona.json");
        } catch (Exception e) {
            System.out.println("Algo ha ido mal.");
            e.printStackTrace();
        }

        json = gson.toJson(persona2);
        System.out.println(json);

        try (FileWriter escribir = new FileWriter("src/main/resources/persona.json")){;
            gsonBuild.toJson(persona,escribir);
            System.out.println("JSON guardado en persona.json");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Algo mal");
        }


        try {
            FileReader reader = new FileReader("src/main/resources/persona.json");
            PersonaJSON personaJSON = gson.fromJson(reader,PersonaJSON.class);
            System.out.println("Nombre: "+ personaJSON.getNombre());
            System.out.println("Edad: "+ personaJSON.getEdad());
            System.out.println("Lenguajes: "+personaJSON.getLenguajes());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
