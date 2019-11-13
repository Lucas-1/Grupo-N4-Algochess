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
        Catapulta catapulta = new Catapulta(blanco);
        Jinete jineteEnemigo = new Jinete(negro);

        catapulta.accionContra(jineteEnemigo);

        assertEquals(80,jineteEnemigo.getPuntosDeVida());
    }
    @Test
    public void test02CatapultaAtacaCatapultaYLeQuita20PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Catapulta catapulta = new Catapulta(blanco);
        Catapulta catapultaEnemiga = new Catapulta(negro);

        catapulta.accionContra(catapultaEnemiga);

        assertEquals(30, catapultaEnemiga.getPuntosDeVida());
    }

    @Test
    public void test03CatapultaAtacaSoldadoDeInfanteriaYLeQuita20PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Catapulta catapulta = new Catapulta(blanco);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(negro);

        catapulta.accionContra(soldado);

        assertEquals(80, soldado.getPuntosDeVida());
    }

    @Test
    public void test04CatapultaAtacaCuranderoYLeQuita20PuntosDeVida() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Catapulta catapulta = new Catapulta(blanco);
        Curandero curanderoEnemigo = new Curandero(negro);

        catapulta.accionContra(curanderoEnemigo);

        assertEquals(55, curanderoEnemigo.getPuntosDeVida());
    }

    @Test
    public void test05CatapultaNoPuedeAtacarUnidadAliada() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Catapulta catapulta = new Catapulta(blanco);
        Jinete jineteAliado = new Jinete(blanco);

        assertThrows(NoPuedeAtacarEntidadDelMismoEquipo.class,
                ()->{
                    catapulta.accionContra(jineteAliado);
                });
    }

    @Test
    public void test06CatapultaNoPuedeAtacarPiezaMuerta() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Catapulta catapulta = new Catapulta(blanco);
        Jinete jinete = new Jinete(negro);

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
