public class fruta {
    private int numeroVagon;
    private int ciudad;
    private String tipoFruta;
    private int kilos;

    public fruta(int numeroVagon, int ciudad, String tipoFruta, int kilos) {
        this.numeroVagon = numeroVagon;
        this.ciudad = ciudad;
        this.tipoFruta = tipoFruta;
        this.kilos = kilos;
    }

    public int getNumeroVagon() {

        return numeroVagon;
    }

    public void setNumeroVagon(int numeroVagon) {

        this.numeroVagon = numeroVagon;
    }

    public int getCiudad() {

        return ciudad;
    }

    public void setCiudad(Integer ciudad) {

        this.ciudad = ciudad;
    }

    public String getTipoFruta() {

        return tipoFruta;
    }

    public void setTipoFruta(String tipoFruta) {

        this.tipoFruta = tipoFruta;
    }

    public int getKilos() {

        return kilos;
    }

    public void setKilos(int kilos) {

        this.kilos = kilos;
    }
}
