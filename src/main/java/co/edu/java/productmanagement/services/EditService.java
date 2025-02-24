package co.edu.java.productmanagement.services;

import co.edu.java.productmanagement.entities.Dueno;
import co.edu.java.productmanagement.entities.Empresa;
import co.edu.java.productmanagement.entities.Producto;
import co.edu.java.productmanagement.entities.Sesion;
import co.edu.java.productmanagement.exception.EditException;
import co.edu.java.productmanagement.exception.RegistroException;
import co.edu.java.productmanagement.repository.DuenoRepository;
import co.edu.java.productmanagement.repository.EmpresaRepository;
import co.edu.java.productmanagement.repository.ProductoRepository;

import java.sql.SQLException;

public class EditService {

    ProductoRepository productoRepository = new ProductoRepository();
    DuenoRepository duenoRepository = new DuenoRepository();
    EmpresaRepository empresaRepository = new EmpresaRepository();

    public void anadir(String Nombre,int Cantidad, Producto Producto) throws EditException, SQLException {
        Dueno dueno = new Dueno();
        Empresa empresa= new Empresa();
        if(productoRepository.buscarProductoPorNombre(Nombre,Producto)==null){
            throw new EditException("No existe un producto con este nombre");
        }

        empresaRepository.buscarEmpresa(Producto.getIdEmpresa(),empresa);
        duenoRepository.buscarDueno(Sesion.getCedula(),dueno);
        if(dueno.getIdDueno()==empresa.getIdDueno()){
            Producto.setCantidad(Producto.getCantidad()+Cantidad);
            productoRepository.actualizarProducto(Producto);
        } else throw new EditException("Este producto no es de tu empresa");


    }

    public void eliminar(String Nombre) throws SQLException, EditException {
        Producto Producto = new Producto();
        Dueno dueno = new Dueno();
        Empresa empresa= new Empresa();
        if(productoRepository.buscarProductoPorNombre(Nombre,Producto)==null){
            throw new EditException("No existe un producto con este nombre");
        }
        empresaRepository.buscarEmpresa(Producto.getIdEmpresa(),empresa);
        duenoRepository.buscarDueno(Sesion.getCedula(),dueno);

        if(dueno.getIdDueno()==empresa.getIdDueno()){
            productoRepository.eliminarProducto(Producto.getIdProducto());
        } else throw new EditException("Este producto no es de tu empresa");


    }

    public void desactivar (String Nombre,Producto Producto) throws EditException, SQLException {
        Dueno dueno = new Dueno();
        Empresa empresa= new Empresa();
        if(productoRepository.buscarProductoPorNombre(Nombre,Producto)==null){
            throw new EditException("No existe un producto con este nombre");
        }

        empresaRepository.buscarEmpresa(Producto.getIdEmpresa(),empresa);
        duenoRepository.buscarDueno(Sesion.getCedula(),dueno);
        if(dueno.getIdDueno()==empresa.getIdDueno()){
            Producto.setEstado("Inactivo");
            productoRepository.actualizarProducto(Producto);
        } else throw new EditException("Este producto no es de tu empresa");


    }

}
