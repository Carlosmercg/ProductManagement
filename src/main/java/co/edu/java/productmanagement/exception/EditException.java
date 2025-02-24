package co.edu.java.productmanagement.exception;

public class EditException extends Throwable {

    private String detalle;

    public EditException (String a){
        detalle = a;
    }
    public String toString(){
        return "Excepción de Edicion["  + detalle + "]";
    }
}
