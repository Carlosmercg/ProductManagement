package co.edu.java.productmanagement.services;

import co.edu.java.productmanagement.entities.*;
import co.edu.java.productmanagement.exception.RegistroException;
import co.edu.java.productmanagement.repository.DuenoRepository;
import co.edu.java.productmanagement.repository.EmpresaRepository;
import co.edu.java.productmanagement.repository.ProductoRepository;
import co.edu.java.productmanagement.repository.VentasRepository;

import java.sql.SQLException;

public class RegistroService {
    DuenoRepository duenoRepository = new DuenoRepository();
    EmpresaRepository empresaRepository = new EmpresaRepository();
    ProductoRepository productoRepository = new ProductoRepository();
    VentasRepository ventasRepository = new VentasRepository();

    public void registrarUsuario (String nombre, String apellido, String username, String cedula, String password,Dueno dueno) throws SQLException, RegistroException {
        if (duenoRepository.buscarDueno(cedula,dueno)!=null){
            throw new RegistroException("Ya existe un usuario con ese cedula");
        }

        dueno.setNombre(nombre);
        dueno.setApellido(apellido);
        dueno.setUsername(username);
        dueno.setCedula(cedula);
        dueno.setPassword(password);

        duenoRepository.agregarDueno(dueno);
    }

    public void registrarEmpresa(String Nombre, String Sector, Empresa empresa) throws RegistroException, SQLException {
        if(empresaRepository.buscarEmpresaPorNombre(Nombre,empresa)!=null){
            throw new RegistroException("Ya existe una Empresa con este nombre");
        }
        Dueno dueno = new Dueno();
        duenoRepository.buscarDueno(Sesion.getCedula(),dueno);

        empresa.setSector(Sector);
        empresa.setIdDueno(dueno.getIdDueno());
        empresa.setNombre(Nombre);

        empresaRepository.agregarEmpresa(empresa);
    }

    public void registrarProductos(String nombre, float Precio, int Cantidad, String Estado, String Empresa, Producto producto) throws SQLException, RegistroException {
        if(productoRepository.buscarProductoPorNombre(nombre,producto)!=null){
            throw new RegistroException("Ya existe un producto con este nombre");
        }
        Empresa empresa =new Empresa();
        Dueno dueno = new Dueno();
        duenoRepository.buscarDueno(Sesion.getCedula(),dueno);
        if(empresaRepository.buscarEmpresaPorNombre(Empresa,empresa)==null){
            throw new RegistroException("No existe esta empresa");
        } else if (empresa.getIdDueno()==dueno.getIdDueno()){
            producto.setNombre(nombre);
            producto.setPrecio(Precio);
            producto.setCantidad(Cantidad);
            producto.setEstado(Estado);
            producto.setIdEmpresa(empresa.getIdEmpresa());
            productoRepository.agregarProducto(producto);
        }else throw new RegistroException("No eres dueño de esta empresa");
    }

    public void registrarVentas(String Nameproducto, int cantidad, String Nameempresa, Ventas venta) throws SQLException, RegistroException {

        Empresa empresa = new Empresa();
        Producto producto = new Producto();
        Dueno dueno = new Dueno();

        duenoRepository.buscarDueno(Sesion.getCedula(),dueno);
        if(empresaRepository.buscarEmpresaPorNombre(Nameempresa,empresa)==null){
            throw new RegistroException("No existe esta empresa");
        }else if (empresa.getIdDueno()==dueno.getIdDueno()){
            if (productoRepository.buscarProductoPorNombre(Nameproducto,producto)!=null){
                if(producto.getIdEmpresa()==empresa.getIdEmpresa()){
                    if(producto.getCantidad()-cantidad>0){
                        venta.setId_producto(producto.getIdProducto());
                        venta.setId_empresa(empresa.getIdEmpresa());
                        venta.setCantidad(cantidad);
                        venta.setValor(cantidad*producto.getPrecio());

                        ventasRepository.agregarVenta(venta);

                        producto.setCantidad(producto.getCantidad()-cantidad);
                        productoRepository.actualizarProducto(producto);
                    } else throw new RegistroException("No hay suficiente stock");
                }else throw new RegistroException("El producto no es de la empresa");
            }else throw new RegistroException("Este producto no esta registrado");
        }

    }
}
