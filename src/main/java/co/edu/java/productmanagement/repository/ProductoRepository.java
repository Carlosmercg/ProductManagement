package co.edu.java.productmanagement.repository;

import co.edu.java.productmanagement.config.H2Connection;
import co.edu.java.productmanagement.entities.Producto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoRepository {

    H2Connection dbConnection = new H2Connection();

    public Producto buscarProducto(int id, Producto producto) throws SQLException {
        String sql = "SELECT * FROM Producto WHERE id = ?";
        PreparedStatement ps = dbConnection.GetConnectionDBH2().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            producto.setIdProducto(resultSet.getInt("id"));
            producto.setNombre(resultSet.getString("nombre"));
            producto.setPrecio(resultSet.getInt("precio"));
            producto.setCantidad(resultSet.getInt("cantidad"));
            producto.setEstado(resultSet.getString("estado"));
            producto.setIdEmpresa(resultSet.getInt("id_empresa"));
            return producto;
        }
        return null;
    }

    public Producto buscarProductoPorNombre(String nombre, Producto producto) throws SQLException {
        String sql = "SELECT * FROM Producto WHERE nombre = ?";
        PreparedStatement ps = dbConnection.GetConnectionDBH2().prepareStatement(sql);
        ps.setString(1, nombre);
        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            producto.setIdProducto(resultSet.getInt("id"));
            producto.setNombre(resultSet.getString("nombre"));
            producto.setPrecio(resultSet.getInt("precio"));
            producto.setCantidad(resultSet.getInt("cantidad"));
            producto.setEstado(resultSet.getString("estado"));
            producto.setIdEmpresa(resultSet.getInt("id_empresa"));
            return producto;
        }
        return null;
    }

    public void agregarProducto(Producto producto) throws SQLException {
        if (buscarProductoPorNombre(producto.getNombre(), new Producto()) == null) {
            String sql = "INSERT INTO Producto (nombre, precio, cantidad, estado, id_empresa) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = dbConnection.GetConnectionDBH2().prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setFloat(2, producto.getPrecio()); //
            ps.setInt(3, producto.getCantidad());
            ps.setString(4, producto.getEstado());
            ps.setInt(5, producto.getIdEmpresa());
            ps.executeUpdate();
        }
    }

    public void actualizarProducto(Producto producto) throws SQLException {
        String sql = "UPDATE Producto SET nombre = ?, precio = ?, cantidad = ?, estado = ?, id_empresa = ? WHERE id = ?";
        PreparedStatement ps = dbConnection.GetConnectionDBH2().prepareStatement(sql);
        ps.setString(1, producto.getNombre());
        ps.setFloat(2, producto.getPrecio());
        ps.setInt(3, producto.getCantidad());
        ps.setString(4, producto.getEstado());
        ps.setInt(5, producto.getIdEmpresa());
        ps.setInt(6, producto.getIdProducto());
        ps.executeUpdate();
    }



}
