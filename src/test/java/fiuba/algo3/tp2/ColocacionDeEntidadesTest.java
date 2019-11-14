package fiuba.algo3.tp2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ColocacionDeEntidadesTest {


    @Test
    public void test01JugadorPuedeColocarPiezaEnSuTerritorio() {

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();

        jugador.agregarCatapulta(tablero, 5,5);

        assertEquals(true, tablero.casilleroOcupado(5,5));
    }

    @Test
    public void test02JugadorNoPuedeColocarPiezaEnTerritorioEnemigo() {

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();


        assertThrows(CasilleroDeLadoEnemigoException.class,
            ()->{
             jugador.agregarCatapulta(tablero,15, 15);
         });
    }

    @Test
    public void test03JugadorNoPuedeColocarPiezaEnCasilleroOcupado() {

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();


        jugador.agregarCatapulta(tablero,5,5);

        assertThrows(CasilleroEstaOcupadoException.class,
                ()->{
                    jugador.agregarCatapulta(tablero,5,5);
                });
    }

    @Test
    public void test04ColocarUnaCatapultaResta5PuntosAlJugador() {

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();


        jugador.agregarCatapulta(tablero,5,5);

        assertEquals(15, jugador.getPuntosDisponibles());

    }

    @Test
    public void test05JugadorSeQuedaSinPuntosYNoPuedeAgregarCatapulta() {

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();

        jugador.agregarCatapulta(tablero,5,5);
        jugador.agregarCatapulta(tablero,4,5);
        jugador.agregarCatapulta(tablero,3,5);
        jugador.agregarCatapulta(tablero,2,5);

        // jugador se quedo con 0 puntos despues de gastar 20

        assertThrows(JugadorNoLeAlcanzaParaEntidadException.class,
                ()->{
                    jugador.agregarCatapulta(tablero,1,5);
                });

    }

}
