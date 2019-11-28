package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.NoSePuedeComprarPiezasEnFaseDeBatallaException;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.piezas.Pieza;

public class FaseDeBatalla extends FaseDeJuego{


    public FaseDeBatalla(AdministradorEventosPorTurno administradorEventosPorTurno) {
        this.administradorEventosPorTurno = administradorEventosPorTurno;
    }
    @Override
    public void jugadorComprarPieza(Pieza pieza){
        throw new NoSePuedeComprarPiezasEnFaseDeBatallaException();
    }

    @Override
    public FaseDeJuego pasarASiguiente() {
        return new FaseFinalDeJuego();
    }

    @Override
    public FaseDeJuego cambiarDeFaseSiEsNecesario() {
        if(this.administradorEventosPorTurno.terminoLaFase(this))
            return this.pasarASiguiente();
        return this;
    }

    @Override
    public void moverPieza(Pieza pieza, Direccion direccion, Tablero tablero) {

        this.administradorEventosPorTurno.moverPieza(pieza,direccion,tablero);
    }
}
