package co.edu.java.productmanagement.controller;

import co.edu.java.productmanagement.entities.Dueno;
import co.edu.java.productmanagement.entities.Empresa;
import co.edu.java.productmanagement.entities.Sesion;
import co.edu.java.productmanagement.entities.Ventas;
import co.edu.java.productmanagement.repository.DuenoRepository;
import co.edu.java.productmanagement.repository.EmpresaRepository;
import co.edu.java.productmanagement.repository.VentasRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentasController {


    @FXML
    private TableView<Ventas> tablaVentas;

    @FXML
    private TableColumn<Ventas, Integer> colVentaId;

    @FXML
    private TableColumn<Ventas, Integer> colProducto;

    @FXML
    private TableColumn<Ventas, Integer> colCantidad;

    @FXML
    private TableColumn<Ventas, Integer> colEmpresa;

    @FXML
    private TableColumn <Ventas, Integer> colvalor;

     VentasRepository ventaRepository = new VentasRepository();
     DuenoRepository duenoRepository = new DuenoRepository();
     EmpresaRepository empresaRepository = new EmpresaRepository();

    @FXML
    public void initialize() {
        configurarColumnas();
        cargarDatos();
    }

    private void configurarColumnas() {
        colVentaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colProducto.setCellValueFactory(new PropertyValueFactory<>("id_producto"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colEmpresa.setCellValueFactory(new PropertyValueFactory<>("id_empresa"));
        colvalor.setCellValueFactory(new PropertyValueFactory<>("valor"));
    }

    private void cargarDatos() {
        try {
            Dueno dueno = new Dueno();
            Empresa empresa = new Empresa();
            duenoRepository.buscarDueno(Sesion.getCedula(), dueno);
            List<Ventas> ventas = ventaRepository.obtenerTodasLasVentas();

            List<Ventas> ventasFiltradas = new ArrayList<>();

            for (Ventas venta : ventas) {
                empresaRepository.buscarEmpresa(venta.getId_empresa(), empresa);
                if (empresa.getIdDueno() == dueno.getIdDueno()) {
                    ventasFiltradas.add(venta);
                }
            }

            ObservableList<Ventas> listaVentas = FXCollections.observableArrayList(ventasFiltradas);
            tablaVentas.setItems(listaVentas);
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de error en la carga de datos
        }
    }

    @FXML
    private void actualizarInformacion() {
        cargarDatos(); // Refresca la tabla con los datos más recientes de la BD
    }
}

