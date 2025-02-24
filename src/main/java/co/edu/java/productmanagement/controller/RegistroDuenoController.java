package co.edu.java.productmanagement.controller;

import co.edu.java.productmanagement.entities.Dueno;
import co.edu.java.productmanagement.exception.RegistroException;
import co.edu.java.productmanagement.services.RegistroService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class RegistroDuenoController {


    RegistroService registroService = new RegistroService();
    Dueno dueno;
    @FXML
    public TextField idnombre;

    @FXML
    public TextField idapellido;

    @FXML
    public TextField idusername;

    @FXML
    public TextField idcedula;

    @FXML
    public TextField idpassword;

    @FXML
    private void registro() throws SQLException, RegistroException {
        try {
            if (dueno==null){
                dueno = new Dueno();
                registroService.registrarUsuario(idnombre.getText(),idapellido.getText(),idusername.getText(),idcedula.getText(),idpassword.getText(),dueno);
            }
            dueno=null;
            showSuccess("Usuario Creado");
        }catch (Exception e){
            dueno = null;
            e.printStackTrace();
            showError("Registro de Usuario Fallido");
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
