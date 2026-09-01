import java.util.ArrayList;
import java.util.List;

public class App {
   public static void main(String[] args) {
      //eventos
      EventoUniversitario evento1 = new EventoUniversitario("Evento 1","Titulo1",5000, false);
      EventoUniversitario evento2 = new EventoUniversitario("Evento 2","Titulo2",300, true);
      //copias
      EventoUniversitario copia1 = new EventoUniversitario(evento1);
      EventoUniversitario copia2 = new EventoUniversitario(evento2);
      //mostrar datos
      evento1.mostrarDatos();
      evento2.mostrarDatos();
      copia1.mostrarDatos();
      copia2.mostrarDatos();
      //contador
      System.out.println("Cantidad total de eventos:  " + EventoUniversitario.getCantidadEventos());

      System.out.println();
      System.out.println("==============================");
      System.out.println("          EJERCICIO 2");
      System.out.println("==============================");
      System.out.println();

      //a. construir una lista de estudiantes
      List<Estudiante> estudiantes = new ArrayList<>();
      estudiantes.add(new Estudiante("Juan Perez", "1001"));
      estudiantes.add(new Estudiante("Maria Gomez", "1002"));
      estudiantes.add(new Estudiante("Carlos Lopez", "1003"));

      //construir eventos (reutilizando los del ejercicio 1)

      //asignar una sala a cada evento
      evento1.asignarSala(new Sala("Aula A", 1));
      evento2.asignarSala(new Sala("Aula B", 2));

      //crear actividades propias de cada evento
      evento1.crearActividad("Taller", 1, "Taller de Java", 2, "Juan", true);
      evento1.crearActividad("Taller", 2, "Taller de Git", 1, "Maria", false);
      evento2.crearActividad("Charla", 3, "Charla sobre Ciberseguridad", 2, "Ing. Perez", false);

      //inscribir estudiantes en cada actividad
      evento1.getActividades().get(0).inscribir(estudiantes.get(0));
      evento1.getActividades().get(0).inscribir(estudiantes.get(1));
      evento1.getActividades().get(1).inscribir(estudiantes.get(2));
      evento2.getActividades().get(0).inscribir(estudiantes.get(0));
      evento2.getActividades().get(0).inscribir(estudiantes.get(2));

      //mostrar el resumen de datos por cada evento creado
      evento1.mostrarDatos();
      evento2.mostrarDatos();

      //mostrar el total de eventos creados
      System.out.println("Cantidad total de eventos creados: " + EventoUniversitario.getCantidadEventos());
   }

}
