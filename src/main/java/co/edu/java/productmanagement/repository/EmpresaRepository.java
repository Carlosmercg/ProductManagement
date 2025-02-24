package co.edu.java.productmanagement.repository;

import co.edu.java.productmanagement.config.H2Connection;
import co.edu.java.productmanagement.entities.Empresa;
import co.edu.java.productmanagement.entities.Sesion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpresaRepository {

    H2Connection dbConnection = new H2Connection();

    public Empresa buscarEmpresa(int id, Empresa empresa) throws SQLException {
        String sql = "SELECT * FROM Empresa WHERE id = ?";
        PreparedStatement ps = dbConnection.GetConnectionDBH2().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            empresa.setIdEmpresa(resultSet.getInt("id"));
            empresa.setNombre(resultSet.getString("nombre"));
            empresa.setSector(resultSet.getString("sector"));
            empresa.setIdDueno(resultSet.getInt("id_dueño"));
            return empresa;
        }
        return null;
    }

    public Empresa buscarEmpresaPorNombre(String nombre, Empresa empresa) throws SQLException {
        String sql = "SELECT * FROM Empresa WHERE nombre = ?";
        PreparedStatement ps = dbConnection.GetConnectionDBH2().prepareStatement(sql);
        ps.setString(1, nombre);
        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            empresa.setIdEmpresa(resultSet.getInt("id"));
            empresa.setNombre(resultSet.getString("nombre"));
            empresa.setSector(resultSet.getString("sector"));
            empresa.setIdDueno(resultSet.getInt("id_dueño"));
            return empresa;
        }
        return null;
    }

}
