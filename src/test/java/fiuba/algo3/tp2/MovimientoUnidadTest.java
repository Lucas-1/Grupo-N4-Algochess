package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.CasilleroEstaOcupadoException;
import fiuba.algo3.tp2.movimiento.*;
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
        Jugador jugador = new Jugador(blanco, "benito");
        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete(blanco);
        Posicion posicion = new Posicion(5,5);

        jugador.insertarPiezaEnPosicion(jinete, posicion, tablero);
        jugador.moverPieza(jinete,new Derecha(),tablero);

        assertTrue(tablero.casilleroOcupado(new Posicion(5,6)));
    }


    @Test
    public void test02UnidadSeMueveALaIzquierda(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco, "benito");
        Tablero tablero = new Tablero();
        Curandero curandero = new Curandero(blanco);
        Posicion posicion = new Posicion(5,5);

        jugador.insertarPiezaEnPosicion(curandero, posicion, tablero);
        jugador.moverPieza(curandero,new Izquierda(),tablero);

        assertTrue(tablero.casilleroOcupado(new Posicion(5,4)));
    }

    @Test
    public void test03UnidadSeMueveHaciaArriba(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco, "benito");
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Posicion posicion = new Posicion(5,5);

        jugador.insertarPiezaEnPosicion(soldado, posicion, tablero);
        jugador.moverPieza(soldado,new Arriba(),tablero);

        assertTrue(tablero.casilleroOcupado(new Posicion(4,5)));
    }

    @Test
    public void test04UnidadSeMueveHaciaAbajo(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco, "benito");
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Posicion posicion = new Posicion(5,5);

        jugador.insertarPiezaEnPosicion(soldado, posicion, tablero);
        jugador.moverPieza(soldado,new Abajo(),tablero);

        assertTrue(tablero.casilleroOcupado(new Posicion(6,5)));
    }

    @Test
    public void test05UnidadSeMueveAUnaPosicionOcupada(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco, "benito");
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Jinete jinete = new Jinete(blanco);

        jugador.insertarPiezaEnPosicion(soldado, new Posicion(5,6), tablero);
        jugador.insertarPiezaEnPosicion(jinete, new Posicion(5,5), tablero);

        assertThrows(CasilleroEstaOcupadoException.class,
                ()->{
                    jugador.moverPieza(jinete,new Derecha(), tablero);
                });


    }

}
