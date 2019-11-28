package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.ElJuegoYaTerminoException;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.piezas.Pieza;

public class FaseFinalDeJuego extends FaseDeJuego{

    public FaseFinalDeJuego() {
    }

    @Override
    public void jugadorComprarPieza(Pieza pieza){
        throw new ElJuegoYaTerminoException();
    }

    @Override
    public FaseDeJuego pasarASiguiente() {
        throw new ElJuegoYaTerminoException();
    }

    @Override
    public void pasarASiguienteTurno(){
        throw new ElJuegoYaTerminoException();
    }

    @Override
    public FaseDeJuego cambiarDeFaseSiEsNecesario() {
        throw new ElJuegoYaTerminoException();
    }

    @Override
    public void moverPieza(Pieza pieza, Direccion direccion, Tablero tablero) {
        throw new ElJuegoYaTerminoException();
    }
}
