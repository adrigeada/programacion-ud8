package org.example.pruebafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatosPersona {

    private static ObservableList<Persona> listaPersonas = FXCollections.observableArrayList();

    public static void insertarPersona(Persona persona){
        listaPersonas.add(persona);
    }

    public static ObservableList<Persona> getListaPersonas(){
        return listaPersonas;
    }

}
