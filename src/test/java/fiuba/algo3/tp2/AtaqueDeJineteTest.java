package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.excepciones.PiezaEstaMuertaException;
import fiuba.algo3.tp2.excepciones.NoPuedeAtacarPiezaDelMismoEquipo;
import fiuba.algo3.tp2.piezas.Catapulta;
import fiuba.algo3.tp2.piezas.Curandero;
import fiuba.algo3.tp2.piezas.Jinete;
import fiuba.algo3.tp2.piezas.SoldadoDeInfanteria;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AtaqueDeJineteTest {

    @Test
    public void test01JineteAtacaOtroJineteYLeQuita5PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jinete jinete = new Jinete(blanco);
        Jinete jineteEnemigo = new Jinete(negro);

        /** jinete ataca a jinete enemigo con 5 puntos de danio. */
        jinete.atacarPieza(jineteEnemigo);

        /**jinete enemigo pasa de tener 100 puntos de vida a tener 95. */
        assertEquals(95, jineteEnemigo.getPuntosDeVida());
    }

    @Test
    public void test02JineteAtacaCatapultaYLeQuita5PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jinete jinete = new Jinete(blanco);
        Catapulta catapultaEnemiga = new Catapulta(negro);

        jinete.atacarPieza(catapultaEnemiga);

        assertEquals(45, catapultaEnemiga.getPuntosDeVida());
    }

    @Test
    public void test03JineteAtacaSoldadoDeInfanteriaYLeQuita5PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jinete jinete = new Jinete(blanco);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(negro);

        jinete.atacarPieza(soldado);

        assertEquals(95, soldado.getPuntosDeVida());
    }

    @Test
    public void test04JineteAtacaCuranderoYLeQuita5PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jinete jinete = new Jinete(blanco);
        Curandero curanderoEnemigo = new Curandero(negro);

        jinete.atacarPieza(curanderoEnemigo);

        assertEquals(70, curanderoEnemigo.getPuntosDeVida());
    }

    @Test
    public void test05JineteNoPuedeAtacarPiezaMuerta() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jinete jinete = new Jinete(blanco);
        Catapulta catapultaEnemiga = new Catapulta(negro);

        /** ataca 10 veces y la deja en 0 de vida */
        for(int i = 0; i < 10; i++) {
            jinete.atacarPieza(catapultaEnemiga);
        }

        /** falla atacar devuelta porque ya esta muerta */
        assertThrows(PiezaEstaMuertaException.class,
                ()->{
                    jinete.atacarPieza(catapultaEnemiga);
                });
    }

    @Test
    public void test06JineteNoPuedeAtacarUnidadAliada() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jinete jinete = new Jinete(blanco);
        Jinete jineteAliado = new Jinete(blanco);

        assertThrows(NoPuedeAtacarPiezaDelMismoEquipo.class,
                ()->{
                    jinete.atacarPieza(jineteAliado);
                });
    }
}
