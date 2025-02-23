package co.edu.java.productmanagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Objects;

public class HelloController {

    @FXML
    public BorderPane contenedor;

    @FXML
    private void Menu() {
        try {
            Parent pane ;
            pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
            if (pane != null) {
                contenedor.setCenter(pane);
            } else {
                showError("No se pudo determinar el tipo de sesión.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            showError("Error al cargar la vista de registro.");
        }
    }

    private void menuBar(String Ruta) {
        try {
            // Cargar Registro_View.fxml usando Parent en lugar de AnchorPane
            Parent registroView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Ruta)));
            contenedor.setCenter(registroView); // Establecer en el centro del BorderPane
        } catch (IOException e) {
            e.printStackTrace();
            showError("Error al cargar la vista de registro.");
        }
    }
    @FXML
    private void registroUsuario(){
        menuBar("RegistroDueno.fxml");
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showSuccess(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}