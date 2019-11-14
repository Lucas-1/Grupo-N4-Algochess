package fiuba.algo3.tp2;

public class Casillero {

    private Color color;
    private EstadoCasillero estado;
    private Entidad entidad;

    public Casillero(Color color) {

        this.color = color;
        estado = new Liberado();
    }

    public boolean esValida(Color unColor) {

        if(estado.estaOcupado())
            throw new CasilleroEstaOcupadoException();

        if(!color.esDelMismoColor(unColor)) {
            throw new CasilleroDeLadoEnemigoException();
        }

        return true;
    }

    public void agregarUnidad(Entidad entidad, Color color) {

       if(this.esValida(color)) {

           this.setearUnidad(entidad);
       }
    }

    public void setearUnidad(Entidad entidad) {

        if(this.estaOcupado())
            throw new CasilleroEstaOcupadoException();

        this. entidad = entidad;
        estado = new Ocupado();
    }

    public void borrarUnidad() {

        estado = new Liberado();
    }

    public Entidad getEntidad() {

        return entidad;
    }

    public boolean estaOcupado() {

        return estado.estaOcupado();
    }

}
