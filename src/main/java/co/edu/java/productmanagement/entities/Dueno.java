package co.edu.java.productmanagement.entities;

public class Dueno {

    private int id;
    private String nombre;
    private String apellido;
    private String username;
    private String password;
    private String cedula;

    public int getIdDueno() {
        return id;
    }

    public void setIdDueno(int idDueno) {
        this.id = idDueno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
