package actividades;

import actividades.Actividad;
import certification.Certificable;
import modelo.Estudiante;

public class Curso extends Actividad implements Certificable {

    private static final long serialVersionUID = 1L;

    private int creditos;

    public Curso(int id, String titulo, int cupoMaximo, int creditos) {
        super(id, titulo, cupoMaximo);
        this.creditos = creditos;
    }

    @Override
    public double calcularCostoMateriales() {
        return creditos * 1000.0;
    }

    @Override
    public String getTipo() {
        return "Curso";
    }

    @Override
    public String generarCertificadoEstudiante(Estudiante e) {
        return "Certificado de Curso '" + getTitulo() + "' otorgado a " + e.getNombre() + " (legajo " + e.getLegajo() + ")";
    }

    public int getCreditos() {
        return creditos;
    }
}
