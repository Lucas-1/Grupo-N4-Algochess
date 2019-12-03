package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.CasilleroDeLadoEnemigoException;
import fiuba.algo3.tp2.excepciones.CasilleroEstaOcupadoException;
import fiuba.algo3.tp2.excepciones.JugadorQuiereUtilizarMasDineroDelDisponibleException;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.piezas.Catapulta;
import fiuba.algo3.tp2.piezas.Curandero;
import fiuba.algo3.tp2.piezas.SoldadoDeInfanteria;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ColocacionDePiezasTest {


    @Test
    public void test01JugadorPuedeColocarPiezaEnSuTerritorio() {

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);

        jugador.insertarPiezaEnPosicion(soldado, 5,5, tablero);

        assertEquals(true, tablero.casilleroOcupado(5,5));
    }

    @Test
    public void test02JugadorNoPuedeColocarPiezaEnTerritorioEnemigo() {

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        Curandero curandero = new Curandero(blanco);

        jugador.insertarPiezaEnPosicion(curandero, 15,15, tablero);

        assertFalse(tablero.casilleroOcupado(15,15));
    }

    @Test
    public void test03ColocarUnaCatapultaResta5PuntosAlJugador() {

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta(blanco);


        jugador.insertarPiezaEnPosicion(catapulta, 5,5, tablero);

        assertEquals(15, jugador.getPuntosDeCompraDisponibles());

    }

    @Test
    public void test04JugadorSeQuedaSinPuntosYNoPuedeAgregarCatapulta() {

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta(blanco);
        Catapulta catapulta1 = new Catapulta(blanco);
        Catapulta catapulta2 = new Catapulta(blanco);
        Catapulta catapulta3 = new Catapulta(blanco);
        Catapulta catapulta4 = new Catapulta(blanco);

        jugador.insertarPiezaEnPosicion(catapulta, 5,5, tablero);
        jugador.insertarPiezaEnPosicion(catapulta1, 4,5, tablero);
        jugador.insertarPiezaEnPosicion(catapulta2, 3,5, tablero);
        jugador.insertarPiezaEnPosicion(catapulta3, 2,5, tablero);

        // jugador se quedo con 0 puntos despues de gastar 20
        jugador.insertarPiezaEnPosicion(catapulta4, 1,5, tablero);

        assertFalse(tablero.casilleroOcupado(1,5));

    }

}
