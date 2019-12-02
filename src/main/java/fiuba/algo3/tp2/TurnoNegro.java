package fiuba.algo3.tp2;

public class TurnoNegro extends Turno {

    public TurnoNegro(Jugador jugadorBlanco, Jugador jugadorNegro) {
        this.jugadorBlanco = jugadorBlanco;
        this.jugadorNegro = jugadorNegro;
    }

    @Override
    public Jugador getJugadorConTurno(){

        return this.jugadorNegro;
    }
    @Override
    public void pasarASiguiente(){

        this.turno = new TurnoBlanco(jugadorBlanco, jugadorNegro);
    }

    @Override
    public void actualizarInformacionJugador(Jugador jugadorConTurno) {

        this.jugadorNegro = jugadorConTurno;
    }
}
