package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.CasilleroEstaOcupadoException;
import fiuba.algo3.tp2.movimiento.Abajo;
import fiuba.algo3.tp2.movimiento.Arriba;
import fiuba.algo3.tp2.movimiento.Derecha;
import fiuba.algo3.tp2.movimiento.Izquierda;
import fiuba.algo3.tp2.piezas.Curandero;
import fiuba.algo3.tp2.piezas.Jinete;
import fiuba.algo3.tp2.piezas.SoldadoDeInfanteria;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovimientoUnidadTest {

    @Test
    public void test01UnidadSeMueveALaDerecha(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete(blanco);

        jugador.insertarEntidadEnPosicion(jinete,3,5,tablero);
        jugador.moverEntidad(jinete,new Derecha(),tablero);

        assertTrue(tablero.casilleroOcupado(3,6));
    }


    @Test
    public void test02UnidadSeMueveALaIzquierda(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        Curandero curandero = new Curandero(blanco);

        jugador.insertarEntidadEnPosicion(curandero,3,5,tablero);
        jugador.moverEntidad(curandero,new Izquierda(),tablero);

        assertTrue(tablero.casilleroOcupado(3,4));
    }

    @Test
    public void test03UnidadSeMueveHaciaArriba(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);

        jugador.insertarEntidadEnPosicion(soldado,8,10,tablero);
        jugador.moverEntidad(soldado,new Arriba(),tablero);

        assertTrue(tablero.casilleroOcupado(7,10));
    }

    @Test
    public void test04UnidadSeMueveHaciaAbajo(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);

        jugador.insertarEntidadEnPosicion(soldado,9,6,tablero);
        jugador.moverEntidad(soldado,new Abajo(),tablero);

        assertTrue(tablero.casilleroOcupado(10,6));
    }

    @Test
    public void test05UnidadSeMueveAUnaPosicionOcupada(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Jinete jinete = new Jinete(blanco);

        jugador.insertarEntidadEnPosicion(soldado,9,6,tablero);
        jugador.insertarEntidadEnPosicion(jinete,9,5,tablero);

        assertThrows(CasilleroEstaOcupadoException.class,
                ()->{
                    jugador.moverEntidad(jinete,new Derecha(), tablero);
                });


    }

}
