package co.edu.java.productmanagement.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class RegistroEmpresaController {
    @FXML
    public TextField ReNombre;
    @FXML
    public ComboBox ReSector;

    @FXML
    public void initialize(){
        ReSector.getItems().addAll("Tecnologia","Gubernamental","Entretenimiento","Salud","Comercio","Telecomunicaciones","Agricultura","Automotriz");
    }
}
