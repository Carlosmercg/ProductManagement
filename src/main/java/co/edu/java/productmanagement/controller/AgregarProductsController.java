package co.edu.java.productmanagement.controller;

import co.edu.java.productmanagement.entities.Producto;
import co.edu.java.productmanagement.exception.RegistroException;
import co.edu.java.productmanagement.repository.ProductoRepository;
import co.edu.java.productmanagement.services.RegistroService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

    Producto producto;
    RegistroService registroService = new RegistroService();

    @FXML
    public void initialize() {
        PrEstado.getItems().addAll("Activo", "Inactivo");
    }

    @FXML public void registro(){
        try{
            if(producto== null){
                producto= new Producto();
                registroService.registrarProductos(PrNombre.getText(),Float.parseFloat(PrPrecio.getText()),Integer.parseInt(PrCantidad.getText()),PrEstado.getValue(),PrEmpresa.getText(),producto);
            }
            producto = null;
            showSuccess("Registro de producto exitoso");
        }catch (Exception | RegistroException e){
            producto = null;
            e.printStackTrace();
            showError("Registro de producto Fallido");
        }
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
