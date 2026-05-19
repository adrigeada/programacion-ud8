package org.example.Serializacion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializarPersona {
    static void main() {
        Persona p = new Persona("Carlos", 30);

        try {

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/persona.ser"));

            out.writeObject(p);

            out.close();

        } catch (IOException e) {
            System.out.println("Algo ha ido mal.");
            e.printStackTrace();
        }

        System.out.println("Objeto serializado en persona.ser");


    }
}
