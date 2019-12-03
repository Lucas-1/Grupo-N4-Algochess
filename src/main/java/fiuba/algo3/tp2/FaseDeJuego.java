package fiuba.algo3.tp2;

import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.piezas.Danina;
import fiuba.algo3.tp2.piezas.Pieza;
import fiuba.algo3.tp2.piezas.Saludable;
import javafx.scene.control.Tab;

public abstract class FaseDeJuego {

    protected AdministradorEventosPorTurno administradorEventosPorTurno;

    public void actualizarInformacionJugador(){
        administradorEventosPorTurno.actualizarInformacionJugador();
    }

    public void jugadorComprarPieza(Pieza pieza, int fila, int columna, Tablero tablero) {
        administradorEventosPorTurno.jugadorComprarPieza(pieza, fila, columna, tablero);
    }

    public void pasarASiguienteTurno(){
        administradorEventosPorTurno.pasarASiguienteTurno();
    }

    public abstract FaseDeJuego cambiarDeFaseSiEsNecesario();

    public abstract void moverPieza(Pieza pieza, Direccion direccion, Tablero tablero);

    public abstract void atacarCon(Danina pieza, int fila, int columna, Tablero tablero);

    public abstract void curarCon(Saludable pieza, int fila, int columna, Tablero tablero);
}
