package fiuba.algo3.tp2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AtaqueDeCatapultaTest {


    @Test
    public void test01CatapultaAtacaJineteYLeQuita20PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Catapulta catapulta = new Catapulta(blanco,5,5);
        Jinete jineteEnemigo = new Jinete(negro,15,15);

        catapulta.accionContra(jineteEnemigo);

        assertEquals(80,jineteEnemigo.getPuntosDeVida());
    }
    @Test
    public void test02CatapultaAtacaCatapultaYLeQuita20PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Catapulta catapulta = new Catapulta(blanco,5,5);
        Catapulta catapultaEnemiga = new Catapulta(negro,15,15);

        catapulta.accionContra(catapultaEnemiga);

        assertEquals(30, catapultaEnemiga.getPuntosDeVida());
    }

    @Test
    public void test03CatapultaAtacaSoldadoDeInfanteriaYLeQuita20PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Catapulta catapulta = new Catapulta(blanco,5,5);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(negro,15,15);

        catapulta.accionContra(soldado);

        assertEquals(80, soldado.getPuntosDeVida());
    }

    @Test
    public void test04CatapultaAtacaCuranderoYLeQuita20PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Catapulta catapulta = new Catapulta(blanco,5,5);
        Curandero curanderoEnemigo = new Curandero(negro,15,15);

        catapulta.accionContra(curanderoEnemigo);

        assertEquals(55, curanderoEnemigo.getPuntosDeVida());
    }

    @Test
    public void test05CatapultaNoPuedeAtacarUnidadAliada() {

        Color blanco = new Blanco();
        Catapulta catapulta = new Catapulta(blanco,5,5);
        Jinete jineteAliado = new Jinete(blanco,6,6);

        assertThrows(NoPuedeAtacarEntidadDelMismoEquipo.class,
                ()->{
                    catapulta.accionContra(jineteAliado);
                });
    }

    @Test
    public void test06CatapultaNoPuedeAtacarPiezaMuerta() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Catapulta catapulta = new Catapulta(blanco,5,5);
        Jinete jinete = new Jinete(negro,15,15);

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
