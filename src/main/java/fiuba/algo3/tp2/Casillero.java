package fiuba.algo3.tp2;

public class Casillero {

    private int pos_fila;
    private int pos_columna;
    private int color;
    private boolean ocupado = false;
    private Entidad entidad;

    public Casillero(int fila, int columna, int un_color) {

        pos_fila = fila;
        pos_columna = columna;
        color = un_color;
    }

    public void agregarUnidad(Entidad una_entidad) {

        if(ocupado)
            throw new CasilleroEstaOcupadoException();

        if(color != una_entidad.getColor())
            throw new CasilleroDeLadoEnemigoException();

        this.entidad = una_entidad;
        ocupado = true;

    }


    //getter
    public Entidad getEntidad() {
        return entidad;
    }

}
