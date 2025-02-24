package co.edu.java.productmanagement.entities;

public class Sesion {

    private static Sesion sesion = new Sesion();
    private char estado;
    private String cedula;//Contiene la cedula del usuario que inició sesión.

    private Sesion() {
        estado = 'n';
    }

    public static char getEstado() {
        if (sesion == null) {
            sesion = new Sesion();
        }
        return sesion.estado;
    }

    public static void setEstado(char estado) {
        sesion.estado = estado;
    }

    public static String getCedula() {
        if (sesion == null) {
            sesion = new Sesion();
        }
        return sesion.cedula;
    }

    public static void setCedula(String cedula) {
        sesion.cedula = cedula;
    }
}
