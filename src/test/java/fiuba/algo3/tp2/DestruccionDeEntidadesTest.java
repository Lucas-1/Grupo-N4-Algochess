package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.piezas.Jinete;
import fiuba.algo3.tp2.piezas.SoldadoDeInfanteria;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DestruccionDeEntidadesTest {


    @Test
    public void test01SeDestuyeUnaEntidadDelJugadorYDesocupaElCasillero() {

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);

        jugador.insertarEntidadEnPosicion(soldado,5,5,tablero);
        jugador.insertarEntidadEnPosicion(soldado,6,5,tablero);
        jugador.borrarUnidad(tablero,5,5);

        assertFalse(tablero.casilleroOcupado(5,5));
    }

    @Test
    public void testo02SeDestruyenTodasLasUnidadesDelJugadorYPierde() {

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete(blanco);

        jugador.insertarEntidadEnPosicion(jinete,5,5,tablero);
        jugador.borrarUnidad(tablero,5,5);

        /** jugador 1 se queda sin unidades, pierde. */
        assertFalse(jugador.sigueEnJuego());
    }





}
