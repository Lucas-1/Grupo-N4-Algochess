package fiuba.algo3.tp2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AtaqueDeJineteTest {

    @Test
    public void test01JineteAtacaOtroJineteYLeQuita5PuntosDeVida() {

        Jinete jinete = new Jinete(1);
        Jinete jineteEnemigo = new Jinete(2);

        /** jinete ataca a jinete enemigo con 5 puntos de danio. */
        jinete.accionContra(jineteEnemigo);

        /**jinete enemigo pasa de tener 100 puntos de vida a tener 95. */
        assertEquals(95, jineteEnemigo.getPuntosDeVida());
    }

    @Test
    public void test02JineteAtacaCatapultaYLeQuita5PuntosDeVida() {

        Jinete jinete = new Jinete(1);
        Catapulta catapultaEnemiga = new Catapulta(2);

        jinete.accionContra(catapultaEnemiga);

        assertEquals(45, catapultaEnemiga.getPuntosDeVida());
    }

    @Test
    public void test03JineteAtacaSoldadoDeInfanteriaYLeQuita5PuntosDeVida() {

        Jinete jinete = new Jinete(1);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(2);

        jinete.accionContra(soldado);

        assertEquals(95, soldado.getPuntosDeVida());
    }

    @Test
    public void test04JineteAtacaCuranderoYLeQuita5PuntosDeVida() {

        Jinete jinete = new Jinete(1);
        Curandero curanderoEnemigo = new Curandero(2);

        jinete.accionContra(curanderoEnemigo);

        assertEquals(70, curanderoEnemigo.getPuntosDeVida());
    }

    @Test
    public void test05JineteNoPuedeAtacarPiezaMuerta() {

        Jinete jinete = new Jinete(1);
        Catapulta catapultaEnemiga = new Catapulta(2);

        /** ataca 10 veces y la deja en 0 de vida */
        for(int i = 0; i < 10; i++) {
            jinete.accionContra(catapultaEnemiga);
        }

        /** falla atacar devuelta porque ya esta muerta */
        assertThrows(EntidadEstaMuertaException.class,
                ()->{
                    jinete.accionContra(catapultaEnemiga);
                });
    }

    @Test
    public void test06JineteNoPuedeAtacarUnidadAliada() {

        Jinete jinete = new Jinete(1);
        Jinete jineteAliado = new Jinete(1);

        assertThrows(NoPuedeAtacarEntidadDelMismoEquipo.class,
                ()->{
                    jinete.accionContra(jineteAliado);
                });
    }


}
