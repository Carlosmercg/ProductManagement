package co.edu.java.productmanagement.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {


    private String username = "sa";
    private String password = "";
    private String Url = "jdbc:h2:file:./database/mydb";
    private String Drive = "org.h2.Driver";


    public Connection GetConnectionDBH2() {

        Connection connection = null;
        try {
            Class.forName(Drive);
            connection = DriverManager.getConnection(Url,username,password);

        }catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la conexion de la base de datos");
        }


        return connection;
    }


}
