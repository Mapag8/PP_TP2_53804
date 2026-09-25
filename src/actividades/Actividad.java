package actividades;

import modelo.Estudiante;
import modelo.Inscripcion;
import excepciones.CupoExcedidoException;

import java.util.*;
import java.io.Serializable;

public abstract class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;

    //zona de atributos
    private int id;
    private String titulo;
    private int cupoMaximo;
    private List<Inscripcion> inscripciones = new ArrayList<>();

    //constantes
    public static final int CUPO_MINIMO = 1;

    //zona de constructores
    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
    }

    //zona de metodos
    public Inscripcion inscribirEstudiante(Estudiante e) throws CupoExcedidoException {
        if (inscripciones.size() >= cupoMaximo) {
            throw new CupoExcedidoException("Cupo excedido en actividad '" + titulo + "'. Cupo máximo: " + cupoMaximo);
        }
        Inscripcion nueva = new Inscripcion(e, this);
        inscripciones.add(nueva);
        return nueva;
    }

    public void mostrarInscripciones() {
        for (Inscripcion ins : inscripciones) {
            System.out.println("  " + ins);
        }
    }

    public final void mostrarIdentificacion() {
        System.out.println("[" + getTipo() + "] " + titulo);
    }

    public abstract double calcularCostoMateriales();

    public abstract String getTipo();

    //zona de getter and setters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }
}
