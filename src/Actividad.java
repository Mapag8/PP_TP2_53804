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

    public Actividad(int titulo, String id, int cupoMaximo) {
        this.titulo = titulo;
        this.id = id;
        this.cupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>();
    }


    //zona de metodos
 public Inscripcion inscribir (Estudiante estudiante){
if(this.inscripciones.size() < this.cupoMaximo){
    Inscripcion nuevaInscripcion = new Inscripcion(estudiante);
    this.inscripciones.add(nuevaInscripcion);
    return nuevaInscripcion;
} else{
    System.out.println("Cupos Llenos");
    return null;
}
 }


 public void mostrarInscripciones(){
        System.out.println("Inscripciones para: " + this.titulo);
        if (this.inscripciones.isEmpty()) {  //vemos si esta vacio
            System.out.println("  (Sin inscriptos)");
            return;
        }
        for (Inscripcion ins : this.inscripciones) {
            System.out.println(ins.getEstudiante().getNombre() +
                    " Legajo: " + ins.getEstudiante().getLegajo() +
                    " Fecha: " + ins.getFecha() +
                    " Estado: " + ins.getEstado());
        }
    }



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
