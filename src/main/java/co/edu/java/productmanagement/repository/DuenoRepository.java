package co.edu.java.productmanagement.repository;

import co.edu.java.productmanagement.config.H2Connection;
import co.edu.java.productmanagement.entities.Dueno;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DuenoRepository {

    H2Connection dbConnection = new H2Connection();

    public Dueno buscarDueno(String cedula, Dueno dueno) throws SQLException {
        String sql = "SELECT * FROM Dueno WHERE cedula = ?";
        PreparedStatement ps = dbConnection.GetConnectionDBH2().prepareStatement(sql);
        ps.setString(1, cedula);
        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            dueno.setIdDueno(resultSet.getInt("id"));
            dueno.setNombre(resultSet.getString("nombre"));
            dueno.setApellido(resultSet.getString("apellido"));
            dueno.setCedula(resultSet.getString("cedula"));
            dueno.setPassword(resultSet.getString("password"));
            return dueno;
        }
        return null;
    }

    public Dueno buscarDuenoPorId(int id, Dueno dueno) throws SQLException {
        String sql = "SELECT * FROM Dueno WHERE id = ?";
        PreparedStatement ps = dbConnection.GetConnectionDBH2().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            dueno.setIdDueno(resultSet.getInt("id"));
            dueno.setNombre(resultSet.getString("nombre"));
            dueno.setApellido(resultSet.getString("apellido"));
            dueno.setCedula(resultSet.getString("cedula"));
            dueno.setPassword(resultSet.getString("password"));
            return dueno;
        }
        return null;
    }

    public void agregarDueno(Dueno dueno) throws SQLException{
        if(buscarDueno(dueno.getCedula(),new Dueno())==null){
            String sql= "INSERT INTO dueno (nombre,apellido,username,password,cedula) VALUES (?,?,?,?,?)";
            PreparedStatement ps = dbConnection.GetConnectionDBH2().prepareStatement(sql);
            ps.setString(1,dueno.getNombre());
            ps.setString(2,dueno.getApellido());
            ps.setString(3,dueno.getUsername());
            ps.setString(4,dueno.getPassword());
            ps.setString(5,dueno.getCedula());
            ps.executeUpdate();
        }
    }


}
