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
        Jugador jugador = new Jugador(blanco, "benito");
        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete(blanco);

        jugador.insertarPiezaEnPosicion(jinete, ,3, tablero);
        jugador.moverPieza(jinete,new Derecha(),tablero);

        assertTrue(tablero.casilleroOcupado(3));
    }


    @Test
    public void test02UnidadSeMueveALaIzquierda(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco, "benito");
        Tablero tablero = new Tablero();
        Curandero curandero = new Curandero(blanco);

        jugador.insertarPiezaEnPosicion(curandero, ,3, tablero);
        jugador.moverPieza(curandero,new Izquierda(),tablero);

        assertTrue(tablero.casilleroOcupado(3));
    }

    @Test
    public void test03UnidadSeMueveHaciaArriba(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco, "benito");
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);

        jugador.insertarPiezaEnPosicion(soldado, ,8, tablero);
        jugador.moverPieza(soldado,new Arriba(),tablero);

        assertTrue(tablero.casilleroOcupado(7));
    }

    @Test
    public void test04UnidadSeMueveHaciaAbajo(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco, "benito");
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);

        jugador.insertarPiezaEnPosicion(soldado, ,9, tablero);
        jugador.moverPieza(soldado,new Abajo(),tablero);

        assertTrue(tablero.casilleroOcupado(10));
    }

    @Test
    public void test05UnidadSeMueveAUnaPosicionOcupada(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco, "benito");
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Jinete jinete = new Jinete(blanco);

        jugador.insertarPiezaEnPosicion(soldado, ,9, tablero);
        jugador.insertarPiezaEnPosicion(jinete, ,9, tablero);

        assertThrows(CasilleroEstaOcupadoException.class,
                ()->{
                    jugador.moverPieza(jinete,new Derecha(), tablero);
                });


    }

}
