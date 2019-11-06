package fiuba.algo3.tp2;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DestruccionDeEntidadesTest {


    @Test
    public void test01SeDestuyeUnaEntidadDelJugadorYDesocupaElCasillero() {

        Jugador jugador = new Jugador(1);
        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta(1);
        Catapulta catapulta_2 = new Catapulta(1);

        jugador.insertarEntidadEnPosicion(catapulta,5,5,tablero);
        jugador.insertarEntidadEnPosicion(catapulta_2,6,5,tablero);
        jugador.borrarUnidad(tablero,5,5);

        assertFalse(tablero.casilleroOcupado(5,5));
    }

    @Test
    public void testo02SeDestruyenTodasLasUnidadesDelJugadorYPierde() {

        Jugador jugador = new Jugador(1);
        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta(1);

        jugador.insertarEntidadEnPosicion(catapulta,5,5,tablero);
        jugador.borrarUnidad(tablero,5,5);

        // jugador 1 se queda sin unidades, pierde.
        assertFalse(jugador.sigue_en_juego());
    }





}
