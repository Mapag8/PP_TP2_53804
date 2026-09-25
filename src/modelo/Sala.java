package modelo;

import java.io.Serializable;

public class Sala implements Serializable {

    private static final long serialVersionUID = 1L;

    //zona de atributos
    private int id;
    private String nombre;

    //zona de constructores
    public Sala(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    //zona de metodos
    @Override
    public String toString() {
        return "Sala{id=" + id + ", nombre='" + nombre + "'}";
    }

    //zona de getter and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
