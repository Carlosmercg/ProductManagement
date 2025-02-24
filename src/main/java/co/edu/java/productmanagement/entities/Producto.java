package co.edu.java.productmanagement.entities;

public class Producto {

    private int id;
    private String nombre;
    private int precio;
    private int cantidad;
    private String estado;
    private int idEmpresa;

    public int getIdProducto() {
        return id;
    }

    public void setIdProducto(int idProducto) {
        this.id = idProducto;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
