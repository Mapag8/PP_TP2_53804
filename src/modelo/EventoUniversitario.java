package modelo;

import actividades.*;
import java.util.*;
import java.io.*;

public class EventoUniversitario implements Serializable {

    private static final long serialVersionUID = 1L;

    //zona de Atributos
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos = 0;

    //relaciones
    private Sala sala;
    private List<Actividad> actividades = new ArrayList<>();

    //zona de constructores
    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        cantidadEventos++;
    }

    public EventoUniversitario(EventoUniversitario otro) {
        this.id = otro.id;
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        this.sala = otro.sala;
        this.actividades = new ArrayList<>(otro.actividades);
    }

    //zona de metodos
    public double calcularCostoEstimado() {
        return costoBase + calcularCostoMateriales(actividades);
    }

    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    public void crearActividad(int id, String titulo, String tipo) {
        switch (tipo.toLowerCase()) {
            case "charla":
                actividades.add(new Charla(id, titulo, 30, "Por definir"));
                break;
            case "taller":
                actividades.add(new Taller(id, titulo, 20, false));
                break;
            case "curso":
                actividades.add(new Curso(id, titulo, 25, 3));
                break;
            default:
                System.out.println("Tipo de actividad inválido: " + tipo);
        }
    }

    public <T extends Actividad> List<T> filtrarActividadesPorTipo(Class<T> tipo) {
        List<T> resultado = new ArrayList<>();
        for (Actividad a : actividades) {
            if (tipo.isInstance(a)) resultado.add(tipo.cast(a));
        }
        return resultado;
    }

    public double calcularCostoMateriales(List<? extends Actividad> actividades) {
        double total = 0.0;
        for (Actividad a : actividades) total += a.calcularCostoMateriales();
        return total;
    }

    public void mostrarDatos() {
        System.out.println("--- Evento: " + id + " - " + titulo + " ---"); //para separar luego al imprimir
        System.out.println("Sala: " + (sala != null ? sala.getNombre() : "Sin sala"));
        System.out.println("Costo estimado: $" + calcularCostoEstimado());
        System.out.println("Actividades:");
        for (Actividad a : actividades) {
            a.mostrarIdentificacion();
        }
    }

    public boolean persistirEvento() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("evento_" + id + ".dat"))) {
            oos.writeObject(this);
            return true;
        } catch (IOException e) {
            System.out.println("[ERROR persistencia] " + e.getMessage());
            return false;
        }
    }

    public static EventoUniversitario recuperarEvento(String id) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("evento_" + id + ".dat"))) {
            return (EventoUniversitario) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("[ERROR recuperación] " + e.getMessage());
            return null;
        }
    }

    public static int getCantidadEventos() {
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
}
