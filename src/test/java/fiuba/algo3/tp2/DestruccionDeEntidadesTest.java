package fiuba.algo3.tp2;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DestruccionDeEntidadesTest {


    @Test
    public void test01SeDestuyeUnaEntidadDelJugadorYDesocupaElCasillero() {

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta(blanco);
        Catapulta catapulta2 = new Catapulta(blanco);

        jugador.insertarEntidadEnPosicion(catapulta,5,5,tablero);
        jugador.insertarEntidadEnPosicion(catapulta2,6,5,tablero);
        jugador.borrarUnidad(tablero,5,5);

        assertFalse(tablero.casilleroOcupado(5,5));
    }

    @Test
    public void testo02SeDestruyenTodasLasUnidadesDelJugadorYPierde() {

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta(blanco);

        jugador.insertarEntidadEnPosicion(catapulta,5,5,tablero);
        jugador.borrarUnidad(tablero,5,5);

        /** jugador 1 se queda sin unidades, pierde. */
        assertFalse(jugador.sigueEnJuego());
    }





}
