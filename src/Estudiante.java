public class Estudiante {
    //zona de atributos
    private int legajo;
    private String nombre;


    //zona de constructores

    public Estudiante(String nombre, int legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
    }


    //zona de metodos





    //zona de getter and setters

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
