//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
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


   }

}