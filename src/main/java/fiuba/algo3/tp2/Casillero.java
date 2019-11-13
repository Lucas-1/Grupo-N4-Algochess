package fiuba.algo3.tp2;

public class Casillero {

    private Color color;
    private boolean ocupado;
    private Entidad entidad;

    public Casillero(Color color) {

        this.color = color;
        ocupado = false;
    }

    public void agregarUnidad(Entidad entidad) {

        if(ocupado)
            throw new CasilleroEstaOcupadoException();

        if(!(color.esDelMismoColor(entidad.getColor())))
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
