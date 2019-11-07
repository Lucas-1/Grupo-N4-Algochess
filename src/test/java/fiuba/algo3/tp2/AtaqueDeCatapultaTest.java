package fiuba.algo3.tp2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AtaqueDeCatapultaTest {


    @Test
    public void test01CatapultaAtacaJineteYLeQuita20PuntosDeVida() {

        Catapulta catapulta = new Catapulta(1);
        Jinete jineteEnemigo = new Jinete(2);

        catapulta.accionContra(jineteEnemigo);

        assertEquals(80,jineteEnemigo.getPuntosDeVida());
    }
    @Test
    public void test02CatapultaAtacaCatapultaYLeQuita20PuntosDeVida() {

        Catapulta catapulta = new Catapulta(1);
        Catapulta catapultaEnemiga = new Catapulta(2);

        catapulta.accionContra(catapultaEnemiga);

        assertEquals(30, catapultaEnemiga.getPuntosDeVida());
    }

    @Test
    public void test03CatapultaAtacaSoldadoDeInfanteriaYLeQuita20PuntosDeVida() {

        Catapulta catapulta = new Catapulta(1);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(2);

        catapulta.accionContra(soldado);

        assertEquals(80, soldado.getPuntosDeVida());
    }

    @Test
    public void test04CatapultaAtacaCuranderoYLeQuita20PuntosDeVida() {

        Catapulta catapulta = new Catapulta(1);
        Curandero curanderoEnemigo = new Curandero(2);

        catapulta.accionContra(curanderoEnemigo);

        assertEquals(55, curanderoEnemigo.getPuntosDeVida());
    }

    @Test
    public void test05CatapultaNoPuedeAtacarUnidadAliada() {

        Catapulta catapulta = new Catapulta(1);
        Jinete jineteAliado = new Jinete(1);

        assertThrows(NoPuedeAtacarEntidadDelMismoEquipo.class,
                ()->{
                    catapulta.accionContra(jineteAliado);
                });
    }

    @Test
    public void test06CatapultaNoPuedeAtacarPiezaMuerta() {

        Catapulta catapulta = new Catapulta(1);
        Jinete jinete = new Jinete(2);

        catapulta.accionContra(jinete);
        catapulta.accionContra(jinete);
        catapulta.accionContra(jinete);
        catapulta.accionContra(jinete);
        catapulta.accionContra(jinete);

        assertThrows(EntidadEstaMuertaException.class,
                ()->{
                    catapulta.accionContra(jinete);
                });
    }
}
