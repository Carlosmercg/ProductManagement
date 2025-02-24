package co.edu.java.productmanagement.exception;

public class RegistroException extends Throwable {

    private String detalle;

    public RegistroException (String a){
        detalle = a;
    }
    public String toString(){
        return "Excepción de Registro["  + detalle + "]";
    }
}
