package fiuba.algo3.tp2;

import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.piezas.Pieza;

public abstract class FaseDeJuego {

    protected AdministradorEventosPorTurno administradorEventosPorTurno;

    public void actualizarInformacionJugador(){
        administradorEventosPorTurno.actualizarInformacionJugador();
    }

    public void jugadorComprarPieza(Pieza pieza) {
        administradorEventosPorTurno.jugadorComprarPieza(pieza);
    }

    protected abstract FaseDeJuego pasarASiguiente();

    public void pasarASiguienteTurno(){
        administradorEventosPorTurno.pasarASiguienteTurno();
    }

    public abstract FaseDeJuego cambiarDeFaseSiEsNecesario();

    public abstract void moverPieza(Pieza pieza, Direccion direccion, Tablero tablero);
}
