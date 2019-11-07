package fiuba.algo3.tp2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AtaqueDeCatapultaTest {


    @Test
    public void test01CatapultaPuedeAtacarJineteEnemigoYSaca20PuntosDeVida() {

        Catapulta catapulta = new Catapulta(1);
        Jinete jinete_enemigo = new Jinete(2);

        catapulta.atacar(jinete_enemigo);

        assertEquals(80,jinete_enemigo.getPuntosDeVida());
    }

    @Test
    public void test02CatapultaNoPuedeAtacarJineteAliado() {

        Catapulta catapulta = new Catapulta(1);
        Jinete jinete_aliado = new Jinete(1);

        assertThrows(NoPuedeAtacarEntidadDelMismoEquipo.class,
                ()->{
                    catapulta.atacar(jinete_aliado);
                });
    }

    @Test
    public void test03CatapultaNoPuedeAtacarJineteEnemigoMuerto() {

        Catapulta catapulta = new Catapulta(1);
        Jinete jinete = new Jinete(2);

        catapulta.atacar(jinete);
        catapulta.atacar(jinete);
        catapulta.atacar(jinete);
        catapulta.atacar(jinete);
        catapulta.atacar(jinete);

        assertThrows(EntidadEstaMuertaException.class,
                ()->{
                    catapulta.atacar(jinete);
                });
    }
}
