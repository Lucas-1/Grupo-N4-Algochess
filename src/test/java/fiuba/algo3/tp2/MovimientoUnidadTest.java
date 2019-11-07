package fiuba.algo3.tp2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovimientoUnidadTest {

    @Test
    public void test01UnidadSeMueveALaDerecha(){
        Jugador jugador = new Jugador(1);
        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete(1);

        jugador.insertarEntidadEnPosicion(jinete,5,5,tablero);
        jugador.moverEntidad(jinete,new Derecha(),tablero);

        assertTrue(tablero.casilleroOcupado(6,5));
    }

    @Test
    public void test02UnidadSeMueveALaIzquierda(){
        Jugador jugador = new Jugador(1);
        Tablero tablero = new Tablero();
        Curandero curandero = new Curandero(1);

        jugador.insertarEntidadEnPosicion(curandero,4,3,tablero);
        jugador.moverEntidad(curandero,new Izquierda(),tablero);

        assertTrue(tablero.casilleroOcupado(3,3));
    }

    @Test
    public void test03UnidadSeMueveHaciaArriba(){
        Jugador jugador = new Jugador(1);
        Tablero tablero = new Tablero();
        Soldado_Infanteria soldado = new Soldado_Infanteria(1);

        jugador.insertarEntidadEnPosicion(soldado,8,10,tablero);
        jugador.moverEntidad(soldado,new Arriba(),tablero);

        assertTrue(tablero.casilleroOcupado(8,11));
    }

    @Test
    public void test04UnidadSeMueveHaciaAbajo(){
        Jugador jugador = new Jugador(1);
        Tablero tablero = new Tablero();
        Soldado_Infanteria soldado = new Soldado_Infanteria(1);

        jugador.insertarEntidadEnPosicion(soldado,9,6,tablero);
        jugador.moverEntidad(soldado,new Abajo(),tablero);

        assertTrue(tablero.casilleroOcupado(9,5));
    }

    @Test
    public void test05UnidadSeMueveAUnaPosicionOcupada(){
        Jugador jugador = new Jugador(1);
        Tablero tablero = new Tablero();
        Soldado_Infanteria soldado = new Soldado_Infanteria(1);
        Jinete jinete = new Jinete(1);

        jugador.insertarEntidadEnPosicion(soldado,9,6,tablero);
        jugador.insertarEntidadEnPosicion(jinete,8,6,tablero);

        assertThrows(CasilleroEstaOcupadoException.class,
                ()->{
                    jugador.moverEntidad(jinete,new Derecha(), tablero);
                });


    }

}
