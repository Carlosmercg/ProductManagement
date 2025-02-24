package co.edu.java.productmanagement.services;

import co.edu.java.productmanagement.entities.Dueno;
import co.edu.java.productmanagement.exception.RegistroException;
import co.edu.java.productmanagement.repository.DuenoRepository;

import java.sql.SQLException;

public class RegistroService {
    DuenoRepository duenoRepository = new DuenoRepository();

    public void registrarUsuario (String nombre, String apellido, String username, String cedula, String password,Dueno dueno) throws SQLException, RegistroException {
        if (duenoRepository.buscarDueno(cedula,dueno)!=null){
            throw new RegistroException("Ya existe un usuario con ese cedula");
        }

        dueno.setNombre(nombre);
        dueno.setApellido(apellido);
        dueno.setUsername(username);
        dueno.setCedula(cedula);
        dueno.setPassword(password);

        duenoRepository.agregarDueno(dueno);
    }
}
