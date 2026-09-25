package certification;

import certification.Certificable;
import modelo.Estudiante;

public class Certificado implements Certificable {

    public static final String ENTIDAD_EMISORA = "Universidad Nacional";

    @Override
    public String generarCertificadoEstudiante(Estudiante e) {
        return "Certificado emitido por " + ENTIDAD_EMISORA + " para " + e.getNombre() + " (legajo " + e.getLegajo() + ")";
    }
}
