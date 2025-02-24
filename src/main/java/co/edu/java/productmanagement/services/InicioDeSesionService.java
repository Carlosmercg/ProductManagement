package co.edu.java.productmanagement.services;

import co.edu.java.productmanagement.entities.Dueno;
import co.edu.java.productmanagement.entities.Sesion;
import co.edu.java.productmanagement.exception.IniciodeSesionException;
import co.edu.java.productmanagement.repository.DuenoRepository;

import java.sql.SQLException;

public class InicioDeSesionService {


    private DuenoRepository duenoRepository = new DuenoRepository();
    private Dueno dueno = new Dueno();

    public void InicioDeSesion(String cedula, String password) throws SQLException, IniciodeSesionException {
        if(Sesion.getEstado() != 'n'){
            throw new IniciodeSesionException("Ya hay una sesión iniciada. Por favor cierre la sesión antes de comenzar otra.");
        }
        else if((duenoRepository.buscarDueno(cedula,dueno))!=null){

            if(password.equals(dueno.getPassword())){
                Sesion.setEstado('a');
                Sesion.setCedula(dueno.getCedula());
            }
            else throw new IniciodeSesionException("contraseña incorrecta");
        }
        else throw new IniciodeSesionException("No se encuentra el usuario solicitado");
    }
    public void CerrarSesion(){
        Sesion.setEstado('n');
    }
}
