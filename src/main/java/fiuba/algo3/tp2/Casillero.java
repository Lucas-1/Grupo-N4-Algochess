package fiuba.algo3.tp2;

public class Casillero {

    private int posicionFila;
    private int posicionColumna;
    private int color;
    private boolean ocupado;
    private Entidad entidad;

    public Casillero(int posicionFila, int posicionColumna, int color) {

        this.posicionFila = posicionFila;
        this.posicionColumna = posicionColumna;
        this.color = color;
        ocupado = false;
    }

    public void agregarUnidad(Entidad entidad) {

        if(ocupado)
            throw new CasilleroEstaOcupadoException();

        if(color != entidad.getColor())
            throw new CasilleroDeLadoEnemigoException();

        this.entidad = entidad;
        ocupado = true;

    }

    public void borrarUnidad() {
        ocupado = false;
    }


    public Entidad getEntidad() {
        return entidad;
    }

    public boolean estaOcupado() {
        return ocupado;
    }

}
