import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {
    //zona de Atributos
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int contador =0;



    //relaciones

    private Sala sala;
    private List<Actividad> actividades;

    //zona de constructores
    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        contador ++;
    }
    public EventoUniversitario(EventoUniversitario otro){
    this.id=otro.id + " copia";
    this.titulo= otro.titulo;
    this.costoBase = otro.costoBase;
    this.gratuito= otro.gratuito;
    contador ++;
    }

    //zona de metodos
    public double calcularCostoEstimado(){
        if (this.gratuito){
            return 0;
        }else{
            return this.costoBase;
        }
    }
    public void asignarSala(Sala sala){

this.sala=sala;
    }

    public void crearActividad(int id, String titulo, int cupo) {
        Actividad nuevaActividad = new Actividad(id,titulo,cupo);
        this.actividades.add(nuevaActividad);
    }

    public void mostrarDatos(){
        System.out.println("----- INFORMACIÓN DEL EVENTO -----"); //para separar luego al imprimir
        System.out.println("ID: " + this.id);
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Costo Base: " + this.costoBase);
        System.out.println("Gratuito: " + this.gratuito);
        System.out.println("Costo Estimado: "+ this.calcularCostoEstimado());
        System.out.println("-----------------------------------");
    }

    public static int getCantidadEventos(){
        return contador;
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
