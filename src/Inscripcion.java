import java.time.LocalDate;

public class Inscripcion {
    //zona de atributos
    private LocalDate fecha;
    private String estado;
    private Estudiante estudiante;//a quien le pertenece esta inscripcion



    //zona de constructores

    public Inscripcion(LocalDate fecha, String estado, Estudiante estudiante) {
        this.fecha = fecha;
        this.estado = estado;
        this.estudiante = estudiante;
    }


    //zona de metodos





    //zona de getter and setters


    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
