package co.edu.java.productmanagement.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AgregarProductsController {
    @FXML
    public TextField PrPrecio;
    @FXML
    public TextField PrEmpresa;
    @FXML
    public TextField PrNombre;
    @FXML
    public TextField PrCantidad;
    @FXML
    public ComboBox <String>PrEstado;

    @FXML
    public void initialize() {
        PrEstado.getItems().addAll("Activo", "Inactivo");
    }
}
