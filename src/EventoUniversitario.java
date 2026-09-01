import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {
    //zona de Atributos
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos =0;



    //relaciones

    private Sala sala;
    private List<Actividad> actividades;

    //zona de constructores
    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        this.actividades = new ArrayList<>();
        cantidadEventos ++;
    }
    public EventoUniversitario(EventoUniversitario otro){
    this.id=otro.id + " copia";
    this.titulo= otro.titulo;
    this.costoBase = otro.costoBase;
    this.gratuito= otro.gratuito;
    this.actividades = new ArrayList<>();
    cantidadEventos ++;
    }

    //zona de metodos
    public double calcularCostoEstimado(){
        if (this.gratuito){
            return 0;
        }
        double costoActividades = 0;
        for (Actividad actividad : this.actividades) {
            costoActividades += actividad.calcularCostoMateriales();
        }
        return (this.costoBase + costoActividades) * 1.21;
    }
    public void asignarSala(Sala sala){

this.sala=sala;
    }

    public void crearActividad(String tipo, int id, String titulo, int cupo, String disertante, boolean requiereNotebook) {
        Actividad nuevaActividad;
        if (tipo.equals("Charla")) {
            nuevaActividad = new Charla(titulo, id, cupo, disertante);
        } else if (tipo.equals("Taller")) {
            nuevaActividad = new Taller(titulo, id, cupo, requiereNotebook);
        } else {
            System.out.println("Tipo de actividad inválido: " + tipo);
            return;
        }
        this.actividades.add(nuevaActividad);
    }

    public void mostrarDatos(){
        System.out.println("----- INFORMACIÓN DEL EVENTO -----"); //para separar luego al imprimir
        System.out.println("ID: " + this.id);
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Costo Base: " + this.costoBase);
        System.out.println("Gratuito: " + this.gratuito);
        System.out.println("Costo Estimado: "+ this.calcularCostoEstimado());
        System.out.println("Sala: " + (this.sala != null ? this.sala.getNombre() + " (ID " + this.sala.getId() + ")" : "Sin sala asignada"));
        System.out.println("Actividades:");
        if (this.actividades.isEmpty()) {
            System.out.println("  (Sin actividades)");
        } else {
            for (Actividad actividad : this.actividades) {
                actividad.mostrarIdentificacion();
                actividad.mostrarInscripciones();
            }
        }
        System.out.println("-----------------------------------");
    }

    public static int getCantidadEventos(){
        return cantidadEventos;
    }


    //zona de getters setters


    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public boolean isGratuito() {
        return gratuito;
    }

    public Sala getSala() {
        return sala;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }





    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
