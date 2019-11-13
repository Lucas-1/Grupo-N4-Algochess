package fiuba.algo3.tp2;

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
        Jinete jinete = new Jinete(blanco, 5,5);

        jugador.insertarEntidad(jinete,5,5,tablero);
        jugador.moverEntidad(jinete,new Derecha(),tablero);

        assertTrue(tablero.casilleroOcupado(5,6));
    }

    @Test
    public void test02UnidadSeMueveALaIzquierda(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        Curandero curandero = new Curandero(blanco,4,3);

        jugador.insertarEntidad(curandero,4,3,tablero);
        jugador.moverEntidad(curandero,new Izquierda(),tablero);

        assertTrue(tablero.casilleroOcupado(4,2));
    }

    @Test
    public void test03UnidadSeMueveHaciaArriba(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco,8,10);

        jugador.insertarEntidad(soldado,8,10,tablero);
        jugador.moverEntidad(soldado,new Arriba(),tablero);

        assertTrue(tablero.casilleroOcupado(7,10));
    }

    @Test
    public void test04UnidadSeMueveHaciaAbajo(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco,8,6);

        jugador.insertarEntidad(soldado,8,6,tablero);
        jugador.moverEntidad(soldado,new Abajo(),tablero);

        assertTrue(tablero.casilleroOcupado(9,6));
    }

    @Test
    public void test05UnidadNoSePuedeMoverAUnaPosicionOcupada(){

        Color blanco = new Blanco();
        Jugador jugador = new Jugador(blanco);
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco,9,6);
        Jinete jinete = new Jinete(blanco,9,5);

        jugador.insertarEntidad(soldado,9,6,tablero);
        jugador.insertarEntidad(jinete,9,5,tablero);

        assertThrows(CasilleroEstaOcupadoException.class,
                ()->{
                    jugador.moverEntidad(jinete,new Derecha(), tablero);
                });


    }

}
