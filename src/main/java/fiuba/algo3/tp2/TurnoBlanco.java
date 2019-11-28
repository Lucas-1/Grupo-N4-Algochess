package fiuba.algo3.tp2;

public class TurnoBlanco extends Turno{

    public TurnoBlanco(Jugador jugadorBlanco, Jugador jugadorNegro) {
        this.jugadorBlanco = jugadorBlanco;
        this.jugadorNegro = jugadorNegro;
    }

    @Override
    public Jugador getJugadorConTurno(){
        return this.jugadorBlanco;
    }

    @Override
    public void pasarASiguiente(){
        this.turno = new TurnoNegro(jugadorBlanco, jugadorNegro);
    }

    @Override
    public void actualizarInformacionJugador(Jugador jugadorConTurno) {
        this.jugadorBlanco = jugadorConTurno;
    }
}
