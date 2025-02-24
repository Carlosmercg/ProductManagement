package co.edu.java.productmanagement.exception;

public class IniciodeSesionException  extends Throwable {

        private String detalle;

        public IniciodeSesionException (String a){
            detalle = a;
        }
        public String toString(){
            return "Excepción de Inicio de Sesion["  + detalle + "]";
        }


}
