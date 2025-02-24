package co.edu.java.productmanagement.entities;

public class Empresa {

    private int id;
    private String nombre;
    private String Sector;
    private int idDueno;

    public int getIdEmpresa() {
        return id;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.id = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdDueno() {
        return idDueno;
    }

    public void setIdDueno(int idDueno) {
        this.idDueno = idDueno;
    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String sector) {
        Sector = sector;
    }
}
