package co.edu.java.productmanagement.repository;

import co.edu.java.productmanagement.config.H2Connection;
import co.edu.java.productmanagement.entities.Ventas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Ventas> obtenerTodasLasVentas() throws SQLException {
        List<Ventas> ventas = new ArrayList<>();
        String sql = "SELECT id, id_producto, cantidad, id_empresa,valor FROM Ventas";


        PreparedStatement ps = dbConnection.GetConnectionDBH2().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ventas venta = new Ventas();
                venta.setId(rs.getInt("id"));
                venta.setId_producto(rs.getInt("id_producto"));
                venta.setCantidad(rs.getInt("cantidad"));
                venta.setId_empresa(rs.getInt("id_empresa"));
                venta.setValor(rs.getFloat("valor"));

                ventas.add(venta);
            }

        return ventas;
    }


}
