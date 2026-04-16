package org.example.pruebafx;

import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;


public class SegundaController {



    @FXML
    private TableView<Persona> personasTableView;

    @FXML
    private TableColumn<Persona,String> nombreTableColumn;

    @FXML
    private TableColumn<Persona,Integer> edadTableColumn;

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField edadTextField;

    @FXML
    public void initialize(){

        nombreTableColumn.setCellValueFactory(datos -> new SimpleStringProperty(datos.getValue().getNombre()));
        edadTableColumn.setCellValueFactory(datos -> new SimpleIntegerProperty(datos.getValue().getEdad()).asObject());

        personasTableView.setItems(DatosPersona.getListaPersonas());
    }


    public void retrocesoClickButton() throws IOException {
        HelloApplication.setRoot("hello-view");
    }

    public void guardarButton() {
        String nombre = nombreTextField.getText();
        Integer edad;

        try {
            edad = Integer.parseInt(edadTextField.getText());
        }catch (NumberFormatException e){
            System.out.println("Edad inválida");
            return;
        }


        Persona persona = new Persona(nombre,edad);
        DatosPersona.insertarPersona(persona);

        System.out.println("Persona creada: "+nombre+" - "+edad);
        System.out.println(DatosPersona.getListaPersonas());

        nombreTextField.clear();
        edadTextField.clear();

    }
}
