package fiuba.algo3.tp2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CuracionDeCuranderoTest {

    @Test
    public void test01CuranderoCuraJineteAliadoAtacadoPorCatapulta() {

        Jinete jinete = new Jinete(1);
        Curandero curandero = new Curandero(1);
        Catapulta catapulta = new Catapulta(2);

        catapulta.accionContra(jinete);

        curandero.accionContra(jinete);
        assertEquals(jinete.getPuntosDeVida(), 95);
    }

    @Test
    public void test02CuranderoNoPuedeCurarUnidadEnemiga() {

        Curandero curandero = new Curandero(1);
        Jinete jinete = new Jinete(2);

        assertThrows(NoPuedeCurarEntidadDelOtroEquipo.class,
                ()->{
                    curandero.accionContra(jinete);
                });
    }

    @Test
    public void test03CuranderoNoPuedeCurarUnidadMuerta() {

        Jinete jinete = new Jinete(1);
        Curandero curandero = new Curandero(1);
        Catapulta catapulta = new Catapulta(2);

        catapulta.accionContra(jinete);
        catapulta.accionContra(jinete);
        catapulta.accionContra(jinete);
        catapulta.accionContra(jinete);
        /** mata al jinete */
        catapulta.accionContra(jinete);

        assertThrows(EntidadEstaMuertaException.class,
                ()->{
                    curandero.accionContra(jinete);
                });
    }

    @Test
    public void test04CuranderoNoPuedeCurarCatapulta() {

        Curandero curandero = new Curandero(1);
        Catapulta catapulta = new Catapulta(1);

        curandero.accionContra(catapulta);
        /** Los puntos de vida de la catapulta no cambian */
        assertEquals(50, catapulta.getPuntosDeVida());
    }
}