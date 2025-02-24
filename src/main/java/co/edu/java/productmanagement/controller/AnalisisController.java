package co.edu.java.productmanagement.controller;

import co.edu.java.productmanagement.entities.Dueno;
import co.edu.java.productmanagement.entities.Empresa;
import co.edu.java.productmanagement.entities.Producto;
import co.edu.java.productmanagement.entities.Sesion;
import co.edu.java.productmanagement.repository.DuenoRepository;
import co.edu.java.productmanagement.repository.EmpresaRepository;
import co.edu.java.productmanagement.repository.ProductoRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnalisisController {

    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private TableColumn<Producto, String> colProducto;

    @FXML
    private TableColumn<Producto, Integer> colEmpresa;

    @FXML
    private TableColumn<Producto, Integer> colCantidad;

   ProductoRepository productoRepository = new ProductoRepository();
   DuenoRepository duenoRepository = new DuenoRepository();
   EmpresaRepository empresaRepository = new EmpresaRepository();

    @FXML
    public void initialize() {
        configurarColumnas();
        cargarDatos();
    }

    private void configurarColumnas() {
        colProducto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEmpresa.setCellValueFactory(new PropertyValueFactory<>("idEmpresa"));  // Mostrar ID de empresa
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
    }

    private void cargarDatos() {
        try {
            Dueno dueno = new Dueno();
            Empresa empresa = new Empresa();
            duenoRepository.buscarDueno(Sesion.getCedula(),dueno);
            List<Producto> productos = productoRepository.obtenerTodosLosProductos();

            List<Producto> productosFiltrados = new ArrayList<>();

            for (Producto producto : productos) {
                empresaRepository.buscarEmpresa(producto.getIdEmpresa(),empresa);
                if (empresa.getIdDueno()==dueno.getIdDueno()) {
                    productosFiltrados.add(producto);
                }
            }

            ObservableList<Producto> listaProductos = FXCollections.observableArrayList(productosFiltrados);
            tablaProductos.setItems(listaProductos);
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de error en la carga de datos
        }
    }

    @FXML
    private void actualizarInformacion() {
        cargarDatos(); // Refresca la tabla con nuevos datos de la BD
    }
}

