package co.edu.java.productmanagement.controller;

import co.edu.java.productmanagement.entities.Dueno;
import co.edu.java.productmanagement.entities.Producto;
import co.edu.java.productmanagement.exception.EditException;
import co.edu.java.productmanagement.repository.ProductoRepository;
import co.edu.java.productmanagement.services.EditService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class EditarProductosController {
    @FXML
    private TextField idProducto;
    @FXML
    private TextField idCantidad;

    EditService editService = new EditService();
    Producto producto;

    @FXML
    private void anadirStock(){
        try {
            if (producto==null){
                producto = new Producto();
                editService.anadir(idProducto.getText(),Integer.parseInt(idCantidad.getText()),producto);
            }
            producto=null;
            showSuccess("Stock actualizado");
        }catch (Exception | EditException e){
            producto = null;
            e.printStackTrace();
            showError("Actualizacion de stock fallida");
        }
    }
    @FXML
    private void eliminarStock(){
        try {
            if (producto==null){
                producto = new Producto();
                editService.eliminar(idProducto.getText());
            }
            producto=null;
            showSuccess("Producto Eliminado");
        }catch (Exception | EditException e){
            producto = null;
            e.printStackTrace();
            showError("Eliminacion fallida");
        }
    }
    @FXML
    private void DesactivarStock(){
        try {
            if (producto==null){
                producto = new Producto();
                editService.desactivar(idProducto.getText(),producto);
            }
            producto=null;
            showSuccess("Producto Desactivado");
        }catch (Exception | EditException e){
            producto = null;
            e.printStackTrace();
            showError("Desactivacion fallida");
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

