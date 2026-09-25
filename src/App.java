import modelo.*;
import actividades.*;
import excepciones.*;
import certification.*;

import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class App {

   public static void main(String[] args) {
      ejercicio1();

      System.out.println();

      //construir eventos (reutilizando los del ejercicio 1)
      EventoUniversitario evento1 = new EventoUniversitario("EV001", "Congreso de Tecnología", 5000, false);
      EventoUniversitario evento2 = new EventoUniversitario("EV002", "Jornadas de Robótica", 4000, false);
      ejercicio2(evento1, evento2);
      System.out.println();
      ejercicio3(evento1, evento2);

      System.out.println();
      //contador
      //mostrar el total de eventos creados
      System.out.println("Cantidad total de eventos creados: " + EventoUniversitario.getCantidadEventos());
   }

   private static void ejercicio1() {
      System.out.println("=== EJERCICIO 1: Excepciones y persistencia ===");

      //eventos
      EventoUniversitario evento = new EventoUniversitario("EV001", "Congreso de Tecnología", 5000, false);
      System.out.println("Evento creado: " + evento.getId() + " - " + evento.getTitulo());

      Sala sala = new Sala(1, "Aula Magna");
      evento.asignarSala(sala);
      System.out.println("Sala asignada: " + sala.getNombre());

      Taller taller = new Taller(1, "Taller de Java", 1, true);
      evento.getActividades().add(taller);
      System.out.println("Actividad creada: " + taller.getTitulo() + " (cupo máx: " + taller.getCupoMaximo() + ")");

      Estudiante estudiante1 = new Estudiante("1001", "Juan Pérez");
      Estudiante estudiante2 = new Estudiante("1002", "María López");

      System.out.println();
      try {
         taller.inscribirEstudiante(estudiante1);
         System.out.println("Inscribiendo a " + estudiante1.getNombre() + "... OK");
         taller.inscribirEstudiante(estudiante2);
         System.out.println("Inscribiendo a " + estudiante2.getNombre() + "... OK");
      } catch (CupoExcedidoException e) {
         System.out.println("Inscribiendo a " + estudiante2.getNombre() + "...");
         System.out.println("ERROR: " + e.getMessage());
      }

      System.out.println();
      try {
         System.out.println("Persistiendo evento EV001...");
         boolean persistido = evento.persistirEvento();
         if (persistido) {
            System.out.println("Evento persistido correctamente en evento_EV001.dat");
         }

         System.out.println();
         System.out.println("Recuperando evento EV001...");
         EventoUniversitario recuperado = EventoUniversitario.recuperarEvento("EV001");
         if (recuperado != null) {
            System.out.println("Evento recuperado: " + recuperado.getId() + " - " + recuperado.getTitulo());
         }

         System.out.println();
         System.out.println("Recuperando evento inexistente EV999 (caso fallido controlado)...");
         EventoUniversitario noExiste = EventoUniversitario.recuperarEvento("EV999");
         if (noExiste == null) {
            System.out.println("El evento EV999 no existe: el flujo continuó correctamente.");
         }
      } catch (FileNotFoundException e) {
         System.out.println("[catch FileNotFoundException] No se encontró el archivo del evento.");
      } catch (IOException e) {
         System.out.println("[catch IOException] Error de entrada/salida al persistir/recuperar.");
      } catch (ClassNotFoundException e) {
         System.out.println("[catch ClassNotFoundException] No se pudo deserializar la clase del evento.");
      } finally {
         System.out.println();
         System.out.println("[finally] Bloque finally ejecutado: fin del flujo de persistencia.");
      }
   }

   private static void ejercicio2(EventoUniversitario evento1, EventoUniversitario evento2) {
      System.out.println("=== EJERCICIO 2: Certificados ===");

      //a. construir una lista de estudiantes
      Estudiante estudiante1 = new Estudiante("1001", "Juan Pérez");
      Estudiante estudiante2 = new Estudiante("1002", "María López");

      //asignar una sala a cada evento
      evento1.asignarSala(new Sala(1, "Aula Magna"));
      evento2.asignarSala(new Sala(2, "Laboratorio 3"));

      //crear actividades propias de cada evento
      evento1.getActividades().add(new Charla(1, "IA aplicada", 30, "Dr. Gómez"));
      evento1.getActividades().add(new Taller(2, "Taller de Java", 20, true));
      evento1.getActividades().add(new Curso(3, "Curso de Spring", 25, 3));

      evento2.getActividades().add(new Charla(4, "Robots del futuro", 30, "Ing. Fernández"));
      evento2.getActividades().add(new Taller(5, "Taller de Arduino", 20, false));
      evento2.getActividades().add(new Curso(6, "Curso de ROS", 25, 4));

      //inscribir estudiantes en cada actividad
      inscribirYConfirmar(evento1.getActividades().get(1), estudiante1);
      inscribirYConfirmar(evento1.getActividades().get(2), estudiante2);
      inscribir(evento1.getActividades().get(0), estudiante1);

      inscribirYConfirmar(evento2.getActividades().get(1), estudiante2);
      inscribirYConfirmar(evento2.getActividades().get(2), estudiante1);

      //mostrar datos
      //mostrar el resumen de datos por cada evento creado
      evento1.mostrarDatos();
      System.out.println("Inscripciones:");
      mostrarInscripciones(evento1);
      System.out.println();
      System.out.println("Certificados emitidos:");
      emitirCertificados(evento1);
      System.out.println("Nota: La Charla '" + evento1.getActividades().get(0).getTitulo() + "' NO es certificable.");

      System.out.println();
      evento2.mostrarDatos();
      System.out.println("Inscripciones:");
      mostrarInscripciones(evento2);
      System.out.println();
      System.out.println("Certificados emitidos:");
      emitirCertificados(evento2);
   }

   private static void ejercicio3(EventoUniversitario evento1, EventoUniversitario evento2) {
      System.out.println("=== EJERCICIO 3: Filtrado por tipo y cálculo de costos ===");
      procesarEvento(evento1);
      procesarEvento(evento2);

      System.out.println();
      System.out.println("Tipos de listas verificados:");
      System.out.println("  List<Charla> OK");
      System.out.println("  List<Taller> OK");
      System.out.println("  List<Curso> OK");
   }

   private static void procesarEvento(EventoUniversitario evento) {
      System.out.println();
      System.out.println("--- Evento: " + evento.getId() + " - " + evento.getTitulo() + " ---");

      List<Charla> charlas = evento.filtrarActividadesPorTipo(Charla.class);
      List<Taller> talleres = evento.filtrarActividadesPorTipo(Taller.class);
      List<Curso> cursos = evento.filtrarActividadesPorTipo(Curso.class);

      mostrarFiltro("Charla", charlas);
      System.out.println("  Costo materiales Charlas: $" + evento.calcularCostoMateriales(charlas));

      mostrarFiltro("Taller", talleres);
      System.out.println("  Costo materiales Talleres: $" + evento.calcularCostoMateriales(talleres));

      mostrarFiltro("Curso", cursos);
      System.out.println("  Costo materiales Cursos: $" + evento.calcularCostoMateriales(cursos));

      System.out.println();
      System.out.println("Costo materiales TOTAL del evento " + evento.getId() + ": $" + evento.calcularCostoMateriales(evento.getActividades()));
   }

   private static <T extends Actividad> void mostrarFiltro(String nombre, List<T> lista) {
      System.out.println("Filtrado por " + nombre + ": " + lista.size() + " actividad(es)");
      for (T actividad : lista) {
         actividad.mostrarIdentificacion();
      }
   }

   private static void inscribir(Actividad actividad, Estudiante estudiante) {
      try {
         actividad.inscribirEstudiante(estudiante);
      } catch (CupoExcedidoException e) {
         System.out.println("ERROR: " + e.getMessage());
      }
   }

   private static void inscribirYConfirmar(Actividad actividad, Estudiante estudiante) {
      try {
         Inscripcion inscripcion = actividad.inscribirEstudiante(estudiante);
         inscripcion.confirmar();
      } catch (CupoExcedidoException e) {
         System.out.println("ERROR: " + e.getMessage());
      }
   }

   private static void mostrarInscripciones(EventoUniversitario evento) {
      for (Actividad actividad : evento.getActividades()) {
         for (Inscripcion inscripcion : actividad.getInscripciones()) {
            System.out.println("  " + inscripcion);
         }
      }
   }

   private static void emitirCertificados(EventoUniversitario evento) {
      for (Actividad actividad : evento.getActividades()) {
         if (actividad instanceof Certificable) {
            Certificable certificable = (Certificable) actividad;
            for (Inscripcion inscripcion : actividad.getInscripciones()) {
               if (inscripcion.estaConfirmada()) {
                  System.out.println("  " + certificable.generarCertificadoEstudiante(inscripcion.getEstudiante()));
               }
            }
         }
      }
   }
}
