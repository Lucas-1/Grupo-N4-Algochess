package fiuba.algo3.tp2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AtaqueDeSoldadoDeInfanteriaTest {
    @Test
    public void test01SoldadoDeInfanteriaAtacaJineteYLeQuita10PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Jinete jineteEnemigo = new Jinete(negro);

        /** soldado ataca a jinete enemigo con 10 puntos de danio. */
        soldado.accionContra(jineteEnemigo);

        /** soldado enemigo pasa de tener 100 puntos de vida a tener 90. */
        assertEquals(90, jineteEnemigo.getPuntosDeVida());
    }

    @Test
    public void test02SoldadoDeInfanteriaAtacaCatapultaYLeQuita10PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();

        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Catapulta catapultaEnemiga = new Catapulta(negro);

        soldado.accionContra(catapultaEnemiga);

        assertEquals(40, catapultaEnemiga.getPuntosDeVida());
    }

    @Test
    public void test03SoldadoDeInfanteriaAtacaOtroSoldadoDeInfanteriaYLeQuita10PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        SoldadoDeInfanteria soldadoEnemigo = new SoldadoDeInfanteria(negro);

        soldado.accionContra(soldadoEnemigo);

        assertEquals(90, soldadoEnemigo.getPuntosDeVida());
    }

    @Test
    public void test04SoldadoDeInfanteriaAtacaCuranderoYLeQuita10PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Curandero curanderoEnemigo = new Curandero(negro);

        soldado.accionContra(curanderoEnemigo);

        assertEquals(65, curanderoEnemigo.getPuntosDeVida());
    }

    @Test
    public void test05SoldadoDeInfanteriaNoPuedeAtacarPiezaMuerta() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Catapulta catapultaEnemiga = new Catapulta(negro);

        /** ataca 5 veces y la deja en 0 de vida */
        for(int i = 0; i < 5; i++) {
            soldado.accionContra(catapultaEnemiga);
        }

        /** falla atacar devuelta porque ya esta muerta */
        assertThrows(EntidadEstaMuertaException.class,
                ()->{
                    soldado.accionContra(catapultaEnemiga);
                });
    }

    @Test
    public void test06JineteNoPuedeAtacarUnidadAliada() {

        Color blanco = new Blanco();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(blanco);
        Jinete jineteAliado = new Jinete(blanco);

        assertThrows(NoPuedeAtacarEntidadDelMismoEquipo.class,
                ()->{
                    soldado.accionContra(jineteAliado);
                });
    }
}
