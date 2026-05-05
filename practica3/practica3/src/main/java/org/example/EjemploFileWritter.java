package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EjemploFileWritter {
    static void main() {


        try {
            PrintWriter writer = new PrintWriter(new FileWriter("src/main/resources/salida.txt"));

            writer.println("Primera línea con println()");
            writer.flush();  // fuerza la escritura inmediata
            System.out.println("Primera línea escrita y guardada (flush).");

            writer.printf("Número: %.2f\n", 3.1416);
            writer.println("Otra línea más.");

            writer.close();  // flush() también ocurre automáticamente aquí
            System.out.println("Archivo cerrado.");

        } catch (IOException e) {
            System.out.println("Ha habido algún problema.");
            e.printStackTrace();

        }

    }
}
