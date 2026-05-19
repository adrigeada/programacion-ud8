package org.example.Serializacion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializarPersona {
    static void main() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/persona.ser"));
            Persona p = (Persona) in.readObject();
            in.close();
            System.out.println("Objeto persona leído: " + p);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Algo ha ido mal.");
            e.printStackTrace();
        }
    }
}
