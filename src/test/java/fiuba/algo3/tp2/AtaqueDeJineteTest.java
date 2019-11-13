package fiuba.algo3.tp2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AtaqueDeJineteTest {

    @Test
    public void test01JineteAtacaOtroJineteYLeQuita5PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jinete jinete = new Jinete(blanco,5,5);
        Jinete jineteEnemigo = new Jinete(negro,15,15);

        /** jinete ataca a jinete enemigo con 5 puntos de danio. */
        jinete.accionContra(jineteEnemigo);

        /**jinete enemigo pasa de tener 100 puntos de vida a tener 95. */
        assertEquals(95, jineteEnemigo.getPuntosDeVida());
    }

    @Test
    public void test02JineteAtacaCatapultaYLeQuita5PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jinete jinete = new Jinete(blanco,5,5);
        Catapulta catapultaEnemiga = new Catapulta(negro,15,15);

        jinete.accionContra(catapultaEnemiga);

        assertEquals(45, catapultaEnemiga.getPuntosDeVida());
    }

    @Test
    public void test03JineteAtacaSoldadoDeInfanteriaYLeQuita5PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jinete jinete = new Jinete(blanco,5,5);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(negro,15,15);

        jinete.accionContra(soldado);

        assertEquals(95, soldado.getPuntosDeVida());
    }

    @Test
    public void test04JineteAtacaCuranderoYLeQuita5PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jinete jinete = new Jinete(blanco,5,5);
        Curandero curanderoEnemigo = new Curandero(negro,15,15);

        jinete.accionContra(curanderoEnemigo);

        assertEquals(70, curanderoEnemigo.getPuntosDeVida());
    }

    @Test
    public void test05JineteNoPuedeAtacarPiezaMuerta() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jinete jinete = new Jinete(blanco,5,5);
        Catapulta catapultaEnemiga = new Catapulta(negro,15,15);

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

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jinete jinete = new Jinete(blanco,5,5);
        Jinete jineteAliado = new Jinete(blanco,6,6);

        assertThrows(NoPuedeAtacarEntidadDelMismoEquipo.class,
                ()->{
                    jinete.accionContra(jineteAliado);
                });
    }
}
