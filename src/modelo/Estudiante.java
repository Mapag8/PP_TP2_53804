package modelo;

import java.io.Serializable;

public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;

    //zona de atributos
    private String legajo;
    private String nombre;

    //zona de constructores
    public Estudiante(String legajo, String nombre) {
        this.legajo = legajo;
        this.nombre = nombre;
    }

    //zona de metodos
    @Override
    public String toString() {
        return nombre + " (legajo " + legajo + ")";
    }

    //zona de getter and setters
    public String getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
