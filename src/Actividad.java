import java.util.List;
import java.util.ArrayList;
public class Actividad {
    //zona de atributos
    private int id;
    private String titulo;
    private int cupoMaximo;
    private List<Inscripcion> inscripciones;
    //constantes
    public final int CUPO_MINIMO=5;


    //zona de constructores

    public Actividad(String titulo, int id, int cupoMaximo) {
        this.titulo = titulo;
        this.id = id;
        this.cupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>();
    }


    //zona de metodos




    //zona de getter and setters

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }
}
