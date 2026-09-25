package modelo;

import actividades.Actividad;

import java.time.LocalDate;
import java.io.Serializable;

public class Inscripcion implements Serializable {

    private static final long serialVersionUID = 1L;

    //zona de atributos
    private LocalDate fecha;
    private String estado;
    private Estudiante estudiante;//a quien le pertenece esta inscripcion
    private Actividad actividad;

    //zona de constructores
    public Inscripcion(Estudiante e, Actividad a) {
        this.fecha = LocalDate.now();
        this.estado = "PENDIENTE";
        this.estudiante = e;
        this.actividad = a;
    }

    //zona de metodos
    public void confirmar() {
        this.estado = "CONFIRMADA";
    }

    public boolean estaConfirmada() {
        return "CONFIRMADA".equalsIgnoreCase(estado);
    }

    @Override
    public String toString() {
        return estudiante + " -> " + actividad.getTitulo() + " (" + estado + ")";
    }

    //zona de getter and setters
    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public class TicketDeAcceso implements Serializable {

        private String numero;
        private LocalDate fechaEmision;
        private String actividad;

        public TicketDeAcceso(String numero, String actividad) {
            this.numero = numero;
            this.actividad = actividad;
            this.fechaEmision = LocalDate.now();
        }

        public void mostrarTicket() {
            System.out.println("Ticket " + numero + " - Actividad: " + actividad + " - Emitido: " + fechaEmision);
        }
    }
}
