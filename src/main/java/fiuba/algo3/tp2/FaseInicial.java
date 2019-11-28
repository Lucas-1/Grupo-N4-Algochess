package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.NoSePuedenMoverPiezasEnLaFaseInicialException;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.piezas.Pieza;

public class FaseInicial extends FaseDeJuego{


    public FaseInicial(Jugador jugadorBlanco, Jugador jugadorNegro){
        this.administradorEventosPorTurno = new AdministradorEventosPorTurno(jugadorBlanco, jugadorNegro);
    }

    @Override
    public FaseDeJuego pasarASiguiente() {
        return new FaseDeBatalla(this.administradorEventosPorTurno);
    }

    @Override
    public FaseDeJuego cambiarDeFaseSiEsNecesario() {
        if(this.administradorEventosPorTurno.terminoLaFase(this))
            return this.pasarASiguiente();
        return this;
    }

    @Override
    public void moverPieza(Pieza pieza, Direccion direccion, Tablero tablero) {
        throw new NoSePuedenMoverPiezasEnLaFaseInicialException();
    }


}
