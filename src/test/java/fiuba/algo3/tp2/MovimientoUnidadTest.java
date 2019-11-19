package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.CasilleroEstaOcupadoException;
import fiuba.algo3.tp2.piezas.Curandero;
import fiuba.algo3.tp2.piezas.Jinete;
import fiuba.algo3.tp2.piezas.SoldadoDeInfanteria;
import fiuba.algo3.tp2.movimiento.Direccion;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovimientoUnidadTest {


    @Test
    public void test01UnidadSeMueveALaDerecha(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete(blanco);

        jugador.insertarPiezaEnPosicion(jinete,3,5,tablero);
        jugador.moverPieza(jinete,Direccion.derecha(),tablero);

        assertTrue(tablero.casilleroOcupado(3,6));
    }


    @Test
    public void test02UnidadSeMueveALaIzquierda(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        Curandero curandero = new Curandero(blanco);

        jugador.insertarPiezaEnPosicion(curandero,3,5,tablero);
        jugador.moverPieza(curandero,Direccion.izquierda(),tablero);

        assertTrue(tablero.casilleroOcupado(3,4));
    }

    @Test
    public void test03UnidadSeMueveHaciaArriba(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);

        jugador.insertarPiezaEnPosicion(soldado,8,10,tablero);
        jugador.moverPieza(soldado,Direccion.arriba(),tablero);

        assertTrue(tablero.casilleroOcupado(7,10));
    }

    @Test
    public void test04UnidadSeMueveHaciaAbajo(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);

        jugador.insertarPiezaEnPosicion(soldado,9,6,tablero);
        jugador.moverPieza(soldado,Direccion.abajo(),tablero);

        assertTrue(tablero.casilleroOcupado(10,6));
    }

    @Test
    public void test05UnidadNoSePuedeMoverAUnaPosicionOcupada(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Jinete jinete = new Jinete(blanco);

        jugador.insertarPiezaEnPosicion(soldado,9,6,tablero);
        jugador.insertarPiezaEnPosicion(jinete,9,5,tablero);

        assertThrows(CasilleroEstaOcupadoException.class,
                ()->{
                    jugador.moverPieza(jinete,Direccion.derecha(), tablero);
                });


    }

}
