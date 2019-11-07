package fiuba.algo3.tp2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AtaqueDeSoldadoDeInfanteriaTest {
    @Test
    public void test01SoldadoDeInfanteriaAtacaJineteYLeQuita10PuntosDeVida() {

        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(1);
        Jinete jineteEnemigo = new Jinete(2);

        /** soldado ataca a jinete enemigo con 10 puntos de danio. */
        soldado.accionContra(jineteEnemigo);

        /** soldado enemigo pasa de tener 100 puntos de vida a tener 90. */
        assertEquals(90, jineteEnemigo.getPuntosDeVida());
    }

    @Test
    public void test02SoldadoDeInfanteriaAtacaCatapultaYLeQuita10PuntosDeVida() {

        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(1);
        Catapulta catapultaEnemiga = new Catapulta(2);

        soldado.accionContra(catapultaEnemiga);

        assertEquals(40, catapultaEnemiga.getPuntosDeVida());
    }

    @Test
    public void test03SoldadoDeInfanteriaAtacaOtroSoldadoDeInfanteriaYLeQuita10PuntosDeVida() {

        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(1);
        SoldadoDeInfanteria soldadoEnemigo = new SoldadoDeInfanteria(2);

        soldado.accionContra(soldadoEnemigo);

        assertEquals(90, soldadoEnemigo.getPuntosDeVida());
    }

    @Test
    public void test04SoldadoDeInfanteriaAtacaCuranderoYLeQuita10PuntosDeVida() {

        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(1);
        Curandero curanderoEnemigo = new Curandero(2);

        soldado.accionContra(curanderoEnemigo);

        assertEquals(65, curanderoEnemigo.getPuntosDeVida());
    }

    @Test
    public void test05SoldadoDeInfanteriaNoPuedeAtacarPiezaMuerta() {

        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(1);
        Catapulta catapultaEnemiga = new Catapulta(2);

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

        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(1);
        Jinete jineteAliado = new Jinete(1);

        assertThrows(NoPuedeAtacarEntidadDelMismoEquipo.class,
                ()->{
                    soldado.accionContra(jineteAliado);
                });
    }
}
