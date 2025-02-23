package co.edu.java.productmanagement.config;

import org.h2.tools.RunScript;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

public class JDBCInitializer {


    private H2Connection dbconnection;

    public JDBCInitializer(H2Connection dbconnection) {
        this.dbconnection = dbconnection;
    }

    public void inicializar(){

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
