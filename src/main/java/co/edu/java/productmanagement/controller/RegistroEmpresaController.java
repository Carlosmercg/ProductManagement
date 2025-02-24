package co.edu.java.productmanagement.controller;

import co.edu.java.productmanagement.entities.Dueno;
import co.edu.java.productmanagement.entities.Empresa;
import co.edu.java.productmanagement.exception.RegistroException;
import co.edu.java.productmanagement.repository.EmpresaRepository;
import co.edu.java.productmanagement.services.RegistroService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class RegistroEmpresaController {
    @FXML
    public TextField ReNombre;
    @FXML
    public ComboBox <String>ReSector;

    Empresa empresa;
    EmpresaRepository empresaRepository = new EmpresaRepository();
    RegistroService registroService = new RegistroService();

    @FXML
    public void initialize(){
        ReSector.getItems().addAll("Tecnologia","Gubernamental","Entretenimiento","Salud","Comercio","Telecomunicaciones","Agricultura","Automotriz","Consultoria");
    }

    @FXML
    public void registro(){
        try {
            if (empresa==null){
                empresa = new Empresa();
                registroService.registrarEmpresa(ReNombre.getText(),ReSector.getValue(),empresa);
            }
            empresa=null;
            showSuccess("Empresa Creada");
        }catch (Exception | RegistroException e){
            empresa = null;
            e.printStackTrace();
            showError("Registro de Empresa Fallido");
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
