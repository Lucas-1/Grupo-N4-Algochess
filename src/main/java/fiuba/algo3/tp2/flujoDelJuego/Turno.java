package fiuba.algo3.tp2.flujoDelJuego;

import fiuba.algo3.tp2.entidadesPrincipales.Jugador;

public class Turno{

    protected Jugador jugadorBlanco;
    protected Jugador jugadorNegro;
    protected Turno turno;
    protected int cantidadDeTurnosJugados;
    private final static int TURNOS_DE_FASE_INICIAL = 2;


    Turno(){

    }

    Turno(Jugador jugadorBlanco, Jugador jugadorNegro){
        turno = new TurnoBlanco(jugadorBlanco, jugadorNegro);
        this.cantidadDeTurnosJugados = 0;
    }

    public Jugador getJugadorConTurno() {

        return turno.getJugadorConTurno();
    }

    public Jugador pasarASiguiente(){

        this.cantidadDeTurnosJugados++;
        return turno.pasarASiguiente();
    }

    public void actualizarInformacionJugador(Jugador jugadorConTurno){

        turno.actualizarInformacionJugador(jugadorConTurno);
    }

    public boolean turnosInicialesCumplidos() {

        return (this.cantidadDeTurnosJugados >= TURNOS_DE_FASE_INICIAL);
    }

    public boolean hayAlgunJugadorMuerto() {
        return this.turno.hayAlgunJugadorMuerto();
    }
}
