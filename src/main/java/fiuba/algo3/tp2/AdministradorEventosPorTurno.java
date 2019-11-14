package fiuba.algo3.tp2;

import java.util.List;

public class AdministradorEventosPorTurno {
    /**esta clase se encarga de avisar al jugador que es su face inicial o turno, tambien de actualizar el tablero despues de cada jugada.*/
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


        // aca faltaria pedirle el nombre a cada jugador

        //el jugador pone piezas iniciales y devuelve su lado actualizado, maybe habria que darle un shop para que las compre.
        tableroJugador1 = jugador1.faseInicial(tableroJugador1);
        tableroJugador2 = jugador2.faseInicial(tableroJugador2);

        //el mapa general se actualiza con las piezas iniciales puestas de ambos lados
        tablero.actualizarLados(tableroJugador1, tableroJugador2);
    }
    public void nuevoTurno() {
        /** cada jugador devuelve una lista con su tablero en index 0 y tablero enemigo en index 1 */
        List<Tablero> tableros = jugador1.realizarTurno(tablero.getLadoJugador1(), tablero.getLadoJugador2()); //el jugador mueve una pieza, necesita ambos tableros por si va a territorio enemigo.
        tablero.actualizarLados(tableros.get(0), tableros.get(1));
        tableros = jugador2.realizarTurno(tablero.getLadoJugador2(), tablero.getLadoJugador1());
        tablero.actualizarLados(tableros.get(1), tableros.get(0));
        //aca irian los ataques porque ya tenemos los tableros actualizados, o podrian estar en el turno de cada jugador.

    }

    public boolean juegoContinua() {
        return !perdioAlgunJugador();
    }

    private boolean perdioAlgunJugador() {
        //perdio alguien? hay que verificarlo aca
        return false;
    }

}
