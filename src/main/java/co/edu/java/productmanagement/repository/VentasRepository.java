package co.edu.java.productmanagement.repository;

import co.edu.java.productmanagement.config.H2Connection;
import co.edu.java.productmanagement.entities.Ventas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VentasRepository {

    H2Connection dbConnection = new H2Connection();

    public Ventas buscarVentaPorId(int id, Ventas venta) throws SQLException {
        String sql = "SELECT * FROM Ventas WHERE id = ?";
        PreparedStatement ps = dbConnection.GetConnectionDBH2().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            venta.setId(resultSet.getInt("id"));
            venta.setId_producto(resultSet.getInt("id_producto"));
            venta.setCantidad(resultSet.getInt("cantidad"));
            venta.setValor(resultSet.getInt("valor"));
            venta.setId_empresa(resultSet.getInt("id_empresa"));
            return venta;
        }
        return null;
    }

    public void agregarVenta(Ventas venta) throws SQLException {
        String sql = "INSERT INTO Ventas (id_producto, cantidad, valor, id_empresa) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = dbConnection.GetConnectionDBH2().prepareStatement(sql);
        ps.setInt(1, venta.getId_producto());
        ps.setInt(2, venta.getCantidad());
        ps.setFloat(3, venta.getValor());
        ps.setInt(4, venta.getId_empresa());
        ps.executeUpdate();
    }

        public int contarVentasPorProducto(int idProducto) throws SQLException {
        String sql = "SELECT COUNT(*) AS total FROM Ventas WHERE id_producto = ?";
        PreparedStatement ps = dbConnection.GetConnectionDBH2().prepareStatement(sql);
        ps.setInt(1, idProducto);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt("total");
        }
        return 0;
    }



}
