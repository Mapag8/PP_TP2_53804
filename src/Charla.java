public class Charla extends Actividad {

    private String disertante;

    public Charla(String titulo, int id, int cupoMaximo, String disertante) {
        super(titulo, id, cupoMaximo);
        this.disertante = disertante;
    }

    @Override
    public double calcularCostoMateriales() {
        return 0;
    }

    @Override
    public String getTipo() {
        return "Charla";
    }

    public String getDisertante() {
        return disertante;
    }

    public void setDisertante(String disertante) {
        this.disertante = disertante;
    }
}
