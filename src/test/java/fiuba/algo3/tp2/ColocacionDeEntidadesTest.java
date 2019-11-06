package fiuba.algo3.tp2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ColocacionDeEntidadesTest {


    @Test
    public void test01JugadorPuedeColocarPiezaEnSuTerritorio() {

        Jugador jugador = new Jugador(1);
        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta(1);

        jugador.insertarEntidadEnPosicion(catapulta,5,5,tablero);

        assertEquals(catapulta, tablero.getCasillero(5,5).getEntidad());
    }

    @Test
    public void test02JugadorNoPuedeColocarPiezaEnTerritorioEnemigo() {

        Jugador jugador = new Jugador(1);
        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta(1);

        assertThrows(CasilleroDeLadoEnemigoException.class,
            ()->{
             jugador.insertarEntidadEnPosicion(catapulta, 15, 15, tablero);
         });
    }

    @Test
    public void test03JugadorNoPuedeColocarPiezaEnCasilleroOcupado() {

        Jugador jugador = new Jugador(1);
        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta(1);

        jugador.insertarEntidadEnPosicion(catapulta,5,5,tablero);

        assertThrows(CasilleroEstaOcupadoException.class,
                ()->{
                    jugador.insertarEntidadEnPosicion(catapulta, 5, 5, tablero);
                });
    }

    @Test
    public void test04ColocarUnaCatapultaResta5PuntosAlJugador() {

        Jugador jugador = new Jugador(1);
        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta(1);

        jugador.insertarEntidadEnPosicion(catapulta,5,5,tablero);

        assertEquals(jugador.getPuntosDisponibles(), 15);

    }

    @Test
    public void test05JugadorSeQuedaSinPuntosYNoPuedeAgregarCatapulta() {

        Jugador jugador = new Jugador(1);
        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta(1);
        Catapulta catapulta_2 = new Catapulta(1);
        Catapulta catapulta_3 = new Catapulta(1);
        Catapulta catapulta_4 = new Catapulta(1);
        Catapulta catapulta_5 = new Catapulta(1);


        jugador.insertarEntidadEnPosicion(catapulta,5,5,tablero); // gasta 5 puntos
        jugador.insertarEntidadEnPosicion(catapulta_2,4,5,tablero); // gasta 5 puntos
        jugador.insertarEntidadEnPosicion(catapulta_3,3,5,tablero); // gasta 5 puntos
        jugador.insertarEntidadEnPosicion(catapulta_4,2,5,tablero); // gasta 5 puntos

        // jugador se quedo con 0 puntos despues de gastar 20

        assertThrows(JugadorNoLeAlcanzaParaEntidadException.class,
                ()->{
                    jugador.insertarEntidadEnPosicion(catapulta, 1, 5, tablero);
                });

    }

}
