package co.edu.java.productmanagement.config;

import org.h2.tools.RunScript;

import java.io.*;
import java.sql.*;
import java.util.stream.Collectors;

public class JDBCInitializer {


    private H2Connection dbconnection;

    public JDBCInitializer(H2Connection dbconnection) {
        this.dbconnection = dbconnection;
    }

    public void inicializar() {
        try (Connection conn = dbconnection.GetConnectionDBH2()) {

            if (!estaBaseDeDatosVacia(conn)) {
                System.out.println("La base de datos ya contiene datos. No se requiere inicialización.");
                return; // Salimos del método si la BD no está vacía
            }

            try (InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream("/ProductM.sql"))) {
                if (reader == null) {
                    throw new RuntimeException("No se pudo encontrar el archivo SQL en resources.");
                }

                RunScript.execute(conn, reader);
                System.out.println("Base de datos inicializada correctamente ✅");

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifica si la base de datos está vacía.
     * Se considera vacía si no tiene ninguna tabla con datos.
     */
    private boolean estaBaseDeDatosVacia(Connection conn) throws SQLException {
        String sql = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='PUBLIC'";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) == 0; // Si el conteo de tablas es 0, la BD está vacía
            }
        }
        return true; // Por defecto, si hay algún error, asumimos que está vacía
    }

    public void resetear(){

        try (Connection conn = dbconnection.GetConnectionDBH2();
             InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream("/ProductM.sql"))) {

            if (reader== null) {
                throw new RuntimeException("No se pudo encontrar el archivo SQL en resources.");
            }

            RunScript.execute(conn, reader);

            System.out.println("Base de datos inicializada correctamente ✅");

        }catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }

}
