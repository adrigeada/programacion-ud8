package org.example.pruebafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    private Button pruebaPulsaButton;

    @FXML
    private Label contadorLabel;

    @FXML
    public void initialize(){
        Contador contador = new Contador();
        pruebaPulsaButton.setOnAction( e -> {
            contador.contar();
            contadorLabel.setText(Integer.toString(contador.getContar()));

        });
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void siguienteClickButton() throws IOException {
        HelloApplication.setRoot("segunda-view");
    }
}
