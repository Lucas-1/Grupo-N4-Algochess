package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.excepciones.PiezaEstaMuertaException;
import fiuba.algo3.tp2.piezas.Catapulta;
import fiuba.algo3.tp2.piezas.Curandero;
import fiuba.algo3.tp2.piezas.Jinete;
import fiuba.algo3.tp2.piezas.SoldadoDeInfanteria;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AtaquesConCatapultaTest {

    @Test
    public void test01CatapultaAtacaJineteYLeQuita20PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Catapulta catapulta = new Catapulta(blanco);
        Jinete jineteEnemigo = new Jinete(negro);

        jugadorBlanco.insertarPiezaEnPosicion(catapulta,9,9,tablero);
        jugadorNegro.insertarPiezaEnPosicion(jineteEnemigo,19,19,tablero);

        jugadorBlanco.atacarCon(catapulta,19,19,tablero);

        assertEquals(80,jineteEnemigo.getPuntosDeVida());
    }
    @Test
    public void test02CatapultaAtacaCatapultaYLeQuita20PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Catapulta catapulta = new Catapulta(blanco);
        Catapulta catapultaEnemiga = new Catapulta(negro);

        jugadorBlanco.insertarPiezaEnPosicion(catapulta,9,9,tablero);
        jugadorNegro.insertarPiezaEnPosicion(catapultaEnemiga,19,19,tablero);

        jugadorBlanco.atacarCon(catapulta,19,19,tablero);

        assertEquals(30, catapultaEnemiga.getPuntosDeVida());
    }

    @Test
    public void test03CatapultaAtacaSoldadoDeInfanteriaYLeQuita20PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Catapulta catapulta = new Catapulta(blanco);
        SoldadoDeInfanteria soldadoEnemigo = new SoldadoDeInfanteria(negro);

        jugadorBlanco.insertarPiezaEnPosicion(catapulta,9,9,tablero);
        jugadorNegro.insertarPiezaEnPosicion(soldadoEnemigo,19,19,tablero);

        jugadorBlanco.atacarCon(catapulta,19,19,tablero);

        assertEquals(80, soldadoEnemigo.getPuntosDeVida());
    }

    @Test
    public void test04CatapultaAtacaCuranderoYLeQuita20PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Catapulta catapulta = new Catapulta(blanco);
        Curandero curanderoEnemigo = new Curandero(negro);

        jugadorBlanco.insertarPiezaEnPosicion(catapulta,9,9,tablero);
        jugadorNegro.insertarPiezaEnPosicion(curanderoEnemigo,19,19,tablero);

        jugadorBlanco.atacarCon(catapulta,19,19,tablero);

        assertEquals(55, curanderoEnemigo.getPuntosDeVida());
    }

    @Test
    public void test05CatapultaPuedeAtacarUnidadAliada() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Tablero tablero = new Tablero();

        Catapulta catapulta = new Catapulta(blanco);
        Jinete jineteAliado = new Jinete(blanco);

        jugadorBlanco.insertarPiezaEnPosicion(catapulta,9,9,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(jineteAliado,1,1,tablero);

        jugadorBlanco.atacarCon(catapulta,1,1,tablero);

        assertEquals(80, jineteAliado.getPuntosDeVida());

    }

    @Test
    public void test06CatapultaNoPuedeAtacarPiezaMuerta() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Catapulta catapulta = new Catapulta(blanco);
        Jinete jineteEnemigo = new Jinete(negro);

        jugadorBlanco.insertarPiezaEnPosicion(catapulta,9,9,tablero);
        jugadorNegro.insertarPiezaEnPosicion(jineteEnemigo,19,19,tablero);

        jugadorBlanco.atacarCon(catapulta,19,19,tablero);
        jugadorBlanco.atacarCon(catapulta,19,19,tablero);
        jugadorBlanco.atacarCon(catapulta,19,19,tablero);
        jugadorBlanco.atacarCon(catapulta,19,19,tablero);
        jugadorBlanco.atacarCon(catapulta,19,19,tablero);

        assertThrows(PiezaEstaMuertaException.class,
                ()->{
                    jugadorBlanco.atacarCon(catapulta,19,19,tablero);
                });
    }

    @Test
    public void test07CatapultaNoPuedeAtacarPiezaADistanciaMedia() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Catapulta catapulta = new Catapulta(blanco);
        jugadorBlanco.insertarPiezaEnPosicion(catapulta,9,9,tablero);

        Jinete jinete = new Jinete(negro);
        jugadorNegro.insertarPiezaEnPosicion(jinete,13,9, tablero);

        jugadorBlanco.atacarCon(catapulta,13,9,tablero);
        assertEquals(100, jinete.getPuntosDeVida());
    }

    @Test
    public  void test08CatapultaNoPuedeAtacarPiezaDistanciaCorta() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Catapulta catapulta = new Catapulta(blanco);
        jugadorBlanco.insertarPiezaEnPosicion(catapulta,9,9,tablero);

        Jinete jinete = new Jinete(negro);
        jugadorNegro.insertarPiezaEnPosicion(jinete,10,9, tablero);

        jugadorBlanco.atacarCon(catapulta,10,9,tablero);
        assertEquals(100, jinete.getPuntosDeVida());

    }





    @Test
    public void test09CatapultaAtacaPiezaYDaniaALaSiguientePiezaContigua() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Catapulta catapulta = new Catapulta(blanco);
        jugadorBlanco.insertarPiezaEnPosicion(catapulta,1,1,tablero);

        Jinete jinete = new Jinete(negro);
        jugadorNegro.insertarPiezaEnPosicion(jinete,18,18,tablero);
        Jinete jinete2 = new Jinete(negro);
        jugadorNegro.insertarPiezaEnPosicion(jinete2,18,19,tablero);

        jugadorBlanco.atacarCon(catapulta,18,18,tablero);

        assertEquals(80,jinete.getPuntosDeVida());
        assertEquals(80,jinete2.getPuntosDeVida());
    }


    @Test
    public void test10CatapultaAtacaPiezaYDaniaALasSiguientes4PiezasContiguas() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Catapulta catapulta = new Catapulta(blanco);
        jugadorBlanco.insertarPiezaEnPosicion(catapulta,1,1,tablero);

        Jinete jinete = new Jinete(negro);
        jugadorNegro.insertarPiezaEnPosicion(jinete,11,11,tablero);
        Jinete jinete2 = new Jinete(negro);
        jugadorNegro.insertarPiezaEnPosicion(jinete2,11,12,tablero);
        Jinete jinete3= new Jinete(negro);
        jugadorNegro.insertarPiezaEnPosicion(jinete3,11,13,tablero);
        Jinete jinete4 = new Jinete(negro);
        jugadorNegro.insertarPiezaEnPosicion(jinete4,12,12,tablero);
        Jinete jinete5 = new Jinete(negro);
        jugadorNegro.insertarPiezaEnPosicion(jinete5,12,11,tablero);


        jugadorBlanco.atacarCon(catapulta,11,11,tablero);

        assertEquals(80,jinete.getPuntosDeVida());
        assertEquals(80,jinete2.getPuntosDeVida());
        assertEquals(80,jinete3.getPuntosDeVida());
        assertEquals(80,jinete4.getPuntosDeVida());
        assertEquals(80,jinete5.getPuntosDeVida());
    }

    @Test
    public void test11CatapultaAtacaPiezaEnemigaYDaniaAliadoContiguo() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jugador jugadorBlanco = new Jugador(blanco);
        Jugador jugadorNegro = new Jugador(negro);
        Tablero tablero = new Tablero();

        Catapulta catapulta = new Catapulta(blanco);
        jugadorBlanco.insertarPiezaEnPosicion(catapulta,1,1,tablero);

        Jinete jineteAliado = new Jinete(blanco);
        jugadorBlanco.insertarPiezaEnPosicion(jineteAliado,9,5,tablero);

        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(negro);
        jugadorNegro.insertarPiezaEnPosicion(soldado, 10,5,tablero);

        jugadorBlanco.atacarCon(catapulta,10,5,tablero);

        assertEquals(80,jineteAliado.getPuntosDeVida());
        assertEquals(80,soldado.getPuntosDeVida());
    }
}
