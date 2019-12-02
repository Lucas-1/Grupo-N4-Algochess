package fiuba.algo3.tp2;

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

    public void pasarASiguiente(){

        turno.pasarASiguiente();
        this.cantidadDeTurnosJugados++;
    }

    public void actualizarInformacionJugador(Jugador jugadorConTurno){

        turno.actualizarInformacionJugador(jugadorConTurno);
    }

    public boolean turnosInicialesCumplidos() {

        return (this.cantidadDeTurnosJugados >= TURNOS_DE_FASE_INICIAL);
    }
}
