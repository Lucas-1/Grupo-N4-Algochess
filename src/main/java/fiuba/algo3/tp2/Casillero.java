package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.CasilleroDeLadoEnemigoException;
import fiuba.algo3.tp2.excepciones.CasilleroEstaOcupadoException;
import fiuba.algo3.tp2.excepciones.CasilleroNoTienePiezaException;
import fiuba.algo3.tp2.movimiento.EstadoCasillero;
import fiuba.algo3.tp2.movimiento.Liberado;
import fiuba.algo3.tp2.movimiento.Ocupado;
import fiuba.algo3.tp2.piezas.Pieza;

public class Casillero {

    private Color color;
    private EstadoCasillero estado;
    private Pieza pieza;

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

    public void agregarUnidad(Pieza pieza) {

       if(this.esValida(pieza.getColor())) {

           this.setearUnidad(pieza);
       }
    }

    public void setearUnidad(Pieza pieza) {

        if(this.estaOcupado())
            throw new CasilleroEstaOcupadoException();

        this.pieza = pieza;
        estado = new Ocupado();
    }

    public void borrarUnidad() {

        estado = new Liberado();
    }

    public Pieza getPieza() {

        if(!this.estaOcupado())
            throw new CasilleroNoTienePiezaException();

        return pieza;
    }

    public boolean estaOcupado() {

        return estado.estaOcupado();
    }

}
