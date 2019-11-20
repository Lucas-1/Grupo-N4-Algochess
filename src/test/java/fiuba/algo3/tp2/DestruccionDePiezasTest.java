package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.piezas.Jinete;
import fiuba.algo3.tp2.piezas.SoldadoDeInfanteria;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DestruccionDePiezasTest {


    @Test
    public void test01SeDestuyeUnaPiezaDelJugadorYDesocupaElCasillero() {

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco, "benito");
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Posicion posicion = new Posicion(5,5);

        jugador.insertarPiezaEnPosicion(soldado, posicion, tablero);
        jugador.insertarPiezaEnPosicion(soldado, new Posicion(6,5), tablero);
        jugador.borrarUnidad(tablero, posicion);

        assertFalse(tablero.casilleroOcupado(posicion));
    }

    @Test
    public void testo02SeDestruyenTodasLasUnidadesDelJugadorYPierde() {

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco, "benito");
        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete(blanco);
        Posicion posicion = new Posicion(5,5);

        jugador.insertarPiezaEnPosicion(jinete, posicion, tablero);
        jugador.borrarUnidad(tablero, posicion);

        /** jugador 1 se queda sin unidades, pierde. */
        assertFalse(jugador.sigueEnJuego());
    }





}
