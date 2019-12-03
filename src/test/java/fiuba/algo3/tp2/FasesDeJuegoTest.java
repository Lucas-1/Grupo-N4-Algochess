package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.excepciones.*;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.piezas.Catapulta;
import fiuba.algo3.tp2.piezas.Curandero;
import fiuba.algo3.tp2.piezas.SoldadoDeInfanteria;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.*;

public class FasesDeJuegoTest {


    @Test
    public void test01JugadorBlancoPuedeComprarPiezasAlInicio(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.jugadorComprarPieza(soldado, 2, 2);

        assertTrue(jugadorBlanco.sigueEnJuego());
    }
    @Test
    public void test02JugadorNegroPuedeComprarPiezasAlInicio(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(negro);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.terminarTurno();
        juego.jugadorComprarPieza(soldado,15,15);

        assertTrue(jugadorNegro.sigueEnJuego());
    }
    @Test
    public void test03JugadorBlancoNoPuedeComprarPiezasEnElTurnoDelNegro(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(negro);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.terminarTurno();

        juego.jugadorComprarPieza(soldado,2,2);

        assertFalse(juego.casilleroOcupado(2,2));
    }
    @Test
    public void test04JugadorNegroNoPuedeComprarPiezasEnElTurnoDelBlanco(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);

        juego.jugadorComprarPieza(soldado,15,15);

        assertFalse(juego.casilleroOcupado(15,15));
    }
    @Test
    public void test05JugadorBlancoNoPuedeMoverPiezasEnLaFaseInicial(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.jugadorComprarPieza(soldado,2,2);
        juego.moverPieza(soldado, Direccion.derecha());

        assertFalse(juego.casilleroOcupado(2,3));
    }
    @Test
    public void test06JugadorNegroNoPuedeMoverPiezasEnLaFaseInicial(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(negro);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.terminarTurno();
        juego.jugadorComprarPieza(soldado,15,15);
        juego.moverPieza(soldado, Direccion.derecha());

        assertFalse(juego.casilleroOcupado(15,16));
    }
    @Test
    public void test07JugadorBlancoNoPuedeComprarPiezasEnLaFaseDeBatalla(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldadoBlanco = new SoldadoDeInfanteria(blanco);
        SoldadoDeInfanteria soldadoNegro = new SoldadoDeInfanteria(negro);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.jugadorComprarPieza(soldadoBlanco,2,2);
        juego.terminarTurno();
        juego.jugadorComprarPieza(soldadoNegro,12,12);
        juego.terminarTurno();

        juego.jugadorComprarPieza(soldadoBlanco,3,3);

        assertFalse(juego.casilleroOcupado(3,3));
    }
    @Test
    public void test08JugadorNegroNoPuedeComprarPiezasEnLaFaseDeBatalla(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldadoNegro = new SoldadoDeInfanteria(negro);
        SoldadoDeInfanteria soldadoBlanco = new SoldadoDeInfanteria(blanco);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.jugadorComprarPieza(soldadoBlanco,2,2);
        juego.terminarTurno();
        juego.jugadorComprarPieza(soldadoNegro,12,12);
        juego.terminarTurno();
        juego.terminarTurno();

        juego.jugadorComprarPieza(soldadoNegro,15,15);

        assertFalse(juego.casilleroOcupado(15,15));
    }
    /*@Test
    public void test12JuegoTerminaCuandoUnJugadorSeQuedaSinPiezas(){
        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        SoldadoDeInfanteria soldadoNegro = new SoldadoDeInfanteria(negro);
        Catapulta catapultaBlanca = new Catapulta(blanco);
        Algochess juego = new Algochess();

        juego.iniciarJuego(jugadorBlanco,jugadorNegro);
        juego.jugadorComprarPieza(catapultaBlanca,2,2);
        juego.terminarTurno();
        juego.jugadorComprarPieza(soldadoNegro,12,12);
        juego.terminarTurno();
        for(int i = 0; i<4; i++){
            juego.atacarCon(catapultaBlanca, 12,12);
            juego.terminarTurno();
            juego.terminarTurno();
        }

        assertThrows(ElJuegoYaTerminoException.class,
                ()->{
                    juego.moverPieza(catapultaBlanca, Direccion.derecha());
                });
    }*/
}
