package fiuba.algo3.tp2.flujoDelJuego.fasesDeJuego;

import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.excepciones.ElJuegoYaTerminoException;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Danina;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Saludable;

public class FaseFinalDeJuego extends FaseDeJuego{

    public FaseFinalDeJuego() {
    }

    @Override
    public void jugadorComprarPieza(Pieza pieza, int fila, int columna, Tablero tablero){
        throw new ElJuegoYaTerminoException("El juego ya termino");
    }

    @Override
    public void pasarASiguienteTurno(){

    }

    @Override
    public FaseDeJuego cambiarDeFaseSiEsNecesario() {
        return this;
    }

    @Override
    public void moverPieza(Pieza pieza, Direccion direccion, Tablero tablero) {
        throw new ElJuegoYaTerminoException("El juego ya termino");
    }

    @Override
    public void atacarCon(Danina pieza, int fila, int columna, Tablero tablero) {
        throw new ElJuegoYaTerminoException("El juego ya termino");
    }

    @Override
    public void curarCon(Saludable pieza, int fila, int columna, Tablero tablero) {
        throw new ElJuegoYaTerminoException("El juego ya termino");
    }
}
