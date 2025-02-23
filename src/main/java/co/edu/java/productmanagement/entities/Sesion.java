package co.edu.java.productmanagement.entities;

public class Sesion {

    private static Sesion sesion = new Sesion();
    private char estado;
    private String cedula;//Contiene la cedula delusuario que inició sesión.

    private Sesion() {
        estado = 'n';
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
