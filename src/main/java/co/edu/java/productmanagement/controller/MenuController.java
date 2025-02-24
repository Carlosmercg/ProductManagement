package co.edu.java.productmanagement.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuController {
    @FXML
    public AnchorPane contenedor;

    private static final Logger LOGGER = Logger.getLogger(MenuController.class.getName());

    private void cargarVista(String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            AnchorPane pane = loader.load();

            if (contenedor != null) {
                contenedor.getChildren().setAll(pane); // Reemplaza directamente los hijos existentes
                AnchorPane.setTopAnchor(pane, 0.0);
                AnchorPane.setBottomAnchor(pane, 0.0);
                AnchorPane.setLeftAnchor(pane, 0.0);
                AnchorPane.setRightAnchor(pane, 0.0);
            } else {
                LOGGER.log(Level.SEVERE, "El contenedor principal es null.");
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error al cargar la vista: " + rutaFXML, e);
        }
    }

    @FXML
    private void agregarproductos() {
        cargarVista("/co/edu/java/productmanagement/AgregarProducts.fxml");
    }

    @FXML
    private void registrarempresa() {
        cargarVista("/co/edu/java/productmanagement/RegistroEmpresa.fxml");
    }

    @FXML
    private void Ventas() {
        cargarVista("/co/edu/java/productmanagement/AgregarVentas.fxml");
    }

    @FXML
    private  void analisis(){
        cargarVista("/co/edu/java/productmanagement/Analisis.fxml");

    }

    @FXML
    private void editar(){
        cargarVista("/co/edu/java/productmanagement/EditarProductos.fxml");

    }
}
