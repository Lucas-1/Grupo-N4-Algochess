package fiuba.algo3.tp2.flujoDelJuego;

import fiuba.algo3.tp2.entidadesPrincipales.Jugador;

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
    public Jugador pasarASiguiente(){

        this.turno = new TurnoNegro(jugadorBlanco, jugadorNegro);
        return this.turno.getJugadorConTurno();
    }

    @Override
    public void actualizarInformacionJugador(Jugador jugadorConTurno) {

        this.jugadorBlanco = jugadorConTurno;
    }

    @Override
    public boolean hayAlgunJugadorMuerto() {
        return (!(jugadorBlanco.sigueEnJuego() && jugadorNegro.sigueEnJuego()));
    }
}
