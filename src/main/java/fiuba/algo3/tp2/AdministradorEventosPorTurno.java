package fiuba.algo3.tp2;

import java.util.List;

public class AdministradorEventosPorTurno {

    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;

    public AdministradorEventosPorTurno(){
        jugador1 = new Jugador(new Blanco());
        jugador2 = new Jugador(new Negro());
        tablero = new Tablero();
    }

    public void faseInicial() {
        Tablero tableroJugador1 = tablero.getLadoJugador1();
        Tablero tableroJugador2 = tablero.getLadoJugador2();
        tableroJugador1 = jugador1.faseInicial(tableroJugador1);
        tableroJugador2 = jugador2.faseInicial(tableroJugador2);
        tablero.actualizarLados(tableroJugador1, tableroJugador2);
    }
    public void nuevoTurno() {
        /** cada jugador devuelve una lista con su tablero en index 0 y tablero enemigo en index 1 */
        List<Tablero> tableros = jugador1.realizarTurno(tablero.getLadoJugador1(), tablero.getLadoJugador2());
        tablero.actualizarLados(tableros.get(0), tableros.get(1));
        tableros = jugador2.realizarTurno(tablero.getLadoJugador2(), tablero.getLadoJugador1());
        tablero.actualizarLados(tableros.get(1), tableros.get(0));
        //aca irian los ataques, o podrian estar en el turno de cada jugador.

    }

    public boolean juegoContinua() {
        return !perdioAlgunJugador();
    }

    private boolean perdioAlgunJugador() {
        //perdio alguien?
        return false;
    }

}
