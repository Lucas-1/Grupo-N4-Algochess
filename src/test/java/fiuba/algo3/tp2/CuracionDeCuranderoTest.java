package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.excepciones.PiezaEstaMuertaException;
import fiuba.algo3.tp2.excepciones.NoPuedeCurarPiezaDelOtroEquipo;
import fiuba.algo3.tp2.piezas.Catapulta;
import fiuba.algo3.tp2.piezas.Curandero;
import fiuba.algo3.tp2.piezas.Jinete;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CuracionDeCuranderoTest {

    @Test
    public void test01CuranderoCuraJineteAliadoAtacadoPorCatapulta() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Curandero curandero = new Curandero(blanco);
        Jinete jineteAliado = new Jinete(blanco);
        Catapulta catapultaEnemiga = new Catapulta(negro);

        jugadorBlanco.insertarPiezaEnPosicion(jineteAliado,1,1,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(curandero,2,2,tablero);
        jugadorNegro.insertarPiezaEnPosicion(catapultaEnemiga,19,19,tablero);

        jugadorNegro.atacarCon(catapultaEnemiga,1,1,tablero);

        jugadorBlanco.curarCon(curandero, 1, 1, tablero);
        assertEquals(jineteAliado.getPuntosDeVida(), 95);
    }

    @Test
    public void test02CuranderoNoPuedeCurarUnidadEnemiga() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Curandero curandero = new Curandero(blanco);
        Jinete jineteEnemigo = new Jinete(negro);

        jugadorBlanco.insertarPiezaEnPosicion(curandero,9,9,tablero);
        jugadorNegro.insertarPiezaEnPosicion(jineteEnemigo,10,9,tablero);


        assertThrows(NoPuedeCurarPiezaDelOtroEquipo.class,
                ()->{
                    jugadorBlanco.curarCon(curandero, 10, 9, tablero);
                });
    }

    @Test
    public void test03CuranderoNoPuedeCurarUnidadMuerta() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Curandero curandero = new Curandero(blanco);
        Jinete jineteAliado = new Jinete(blanco);
        Catapulta catapultaEnemiga = new Catapulta(negro);

        jugadorBlanco.insertarPiezaEnPosicion(jineteAliado,1,1,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(curandero,2,2,tablero);
        jugadorNegro.insertarPiezaEnPosicion(catapultaEnemiga,19,19,tablero);

        jugadorNegro.atacarCon(catapultaEnemiga,1,1,tablero);
        jugadorNegro.atacarCon(catapultaEnemiga,1,1,tablero);
        jugadorNegro.atacarCon(catapultaEnemiga,1,1,tablero);
        jugadorNegro.atacarCon(catapultaEnemiga,1,1,tablero);
        jugadorNegro.atacarCon(catapultaEnemiga,1,1,tablero);


        assertThrows(PiezaEstaMuertaException.class,
                ()->{
                    jugadorBlanco.curarCon(curandero, 1, 1, tablero);
                });
    }

    @Test
    public void test04CuranderoNoPuedeCurarCatapulta() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Curandero curandero = new Curandero(blanco);
        Catapulta catapultaAliada = new Catapulta(blanco);
        Catapulta catapultaEnemiga = new Catapulta(negro);

        jugadorBlanco.insertarPiezaEnPosicion(catapultaAliada,1,1,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(curandero,5,5,tablero);
        jugadorNegro.insertarPiezaEnPosicion(catapultaEnemiga,19,19,tablero);

        jugadorNegro.atacarCon(catapultaEnemiga,1,1,tablero);


        /** Los puntos de vida de la catapulta no cambian */
        jugadorBlanco.curarCon(curandero, 1, 1, tablero);


        assertEquals(30, catapultaAliada.getPuntosDeVida());
    }
}