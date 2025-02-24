package co.edu.java.productmanagement.controller;

import co.edu.java.productmanagement.entities.Producto;
import co.edu.java.productmanagement.entities.Ventas;
import co.edu.java.productmanagement.exception.RegistroException;
import co.edu.java.productmanagement.repository.VentasRepository;
import co.edu.java.productmanagement.services.RegistroService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AgregarVentasController {
    @FXML
    public TextField idNombrePr;

    @FXML
    public TextField idCantidad;

    @FXML
    public TextField idNombreEmpre;

    Ventas venta ;
    RegistroService registroService = new RegistroService();
    VentasRepository ventasRepository = new VentasRepository();

    @FXML
    public void registro(){
        try{
            if(venta== null){
                venta= new Ventas();
                registroService.registrarVentas(idNombrePr.getText(),Integer.parseInt(idCantidad.getText()),idNombreEmpre.getText(),venta);
            }
            venta = null;
            showSuccess("Registro de ventas exitoso");
        }catch (Exception | RegistroException e){
            venta = null;
            e.printStackTrace();
            showError("Registro de ventas Fallido");
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
