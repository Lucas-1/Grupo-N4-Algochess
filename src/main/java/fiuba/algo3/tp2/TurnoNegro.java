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
    public Jugador pasarASiguiente(){

        this.turno = new TurnoBlanco(jugadorBlanco, jugadorNegro);
        return this.turno.getJugadorConTurno();
    }

    @Override
    public void actualizarInformacionJugador(Jugador jugadorConTurno) {

        this.jugadorNegro = jugadorConTurno;
    }

    @Override
    public boolean hayAlgunJugadorMuerto() {
        return (!jugadorBlanco.sigueEnJuego() && jugadorNegro.sigueEnJuego());
    }
}
