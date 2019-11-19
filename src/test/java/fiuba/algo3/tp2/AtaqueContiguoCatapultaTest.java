package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.piezas.Catapulta;
import fiuba.algo3.tp2.piezas.Jinete;
import fiuba.algo3.tp2.piezas.SoldadoDeInfanteria;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AtaqueContiguoCatapultaTest {

    @Test
    public void test01CatapultaAtacaPiezaYDaniaALaSiguientePiezaContigua() {

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

        jugadorBlanco.atacarCon(catapulta,11,11,tablero);

        assertEquals(80,jinete.getPuntosDeVida());
        assertEquals(80,jinete2.getPuntosDeVida());
    }


    @Test
    public void test02CatapultaAtacaPiezaYDaniaALasSiguientes4PiezasContiguas() {

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
    public void test03CatapultaAtacaPiezaEnemigaYDaniaAliadoContiguo() {

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
