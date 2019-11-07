package fiuba.algo3.tp2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AtaqueDeJineteTest {

    @Test
    public void test01JineteAtacaOtroJineteYLeQuita5PuntosDeVida() {

        Jinete jinete = new Jinete(1);
        Jinete jinete_enemigo = new Jinete(2);

        // jinete ataca a jinete enemigo con 5 puntos de danio.
        jinete.atacar(jinete_enemigo);
        //jinete enemigo pasa de tener 100 puntos de vida a tener 95.

        assertEquals(jinete_enemigo.getPuntosDeVida(), 95);
    }

    @Test
    public void test02JineteAtacaCatapultaYLeQuita5PuntosDeVida() {

        Jinete jinete = new Jinete(1);
        Catapulta catapulta_enemiga = new Catapulta(2);

        jinete.atacar(catapulta_enemiga);

        assertEquals(catapulta_enemiga.getPuntosDeVida(),45);
    }

    @Test
    public void test03JineteAtacaSoldadoInfanteriaYQuita5PuntosDeVida() {

        Jinete jinete = new Jinete(1);
        Soldado_Infanteria soldado_enemigo = new Soldado_Infanteria(2);

        jinete.atacar(soldado_enemigo);

        assertEquals(soldado_enemigo.getPuntosDeVida(), 95);
    }

    @Test
    public void test04JineteAtacaCuranderoYLeQuita5PuntosDeVida() {

        Jinete jinete = new Jinete(1);
        Curandero curandero_enemigo = new Curandero(2);

        jinete.atacar(curandero_enemigo);

        assertEquals(curandero_enemigo.getPuntosDeVida(), 70);
    }

    @Test
    public void test05JineteNoPuedeAtacarPiezaMuerta() {

        Jinete jinete = new Jinete(1);
        Catapulta catapulta_enemiga = new Catapulta(2);

        for(int i = 0; i < 10; i++)
            jinete.atacar(catapulta_enemiga); // ataca 10 veces y la deja en 0 de vida

        assertThrows(EntidadEstaMuertaException.class,
                ()->{
                    jinete.atacar(catapulta_enemiga); // falla atacar devuelta porque ya esta muerta
                });
    }

    @Test
    public void test06JineteNoPuedeAtacarUnidadAliada() {

        Jinete jinete = new Jinete(1);
        Jinete jinete_aliado = new Jinete(1);

        assertThrows(NoPuedeAtacarEntidadDelMismoEquipo.class,
                ()->{
                    jinete.atacar(jinete_aliado);
                });
    }


}
