package fiuba.algo3.tp2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CuracionDeCuranderoTest {

    @Test
    public void test01CuranderoCuraJineteAliadoAtacadoPorCatapulta() {

        Color blanco = new Blanco();
        Color negro = new Negro();

        Jinete jinete = new Jinete(blanco);
        Curandero curandero = new Curandero(blanco);
        Catapulta catapulta = new Catapulta(negro);

        catapulta.accionContra(jinete);

        curandero.accionContra(jinete);
        assertEquals(jinete.getPuntosDeVida(), 95);
    }

    @Test
    public void test02CuranderoNoPuedeCurarUnidadEnemiga() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Curandero curandero = new Curandero(blanco);
        Jinete jinete = new Jinete(negro);

        assertThrows(NoPuedeCurarEntidadDelOtroEquipo.class,
                ()->{
                    curandero.accionContra(jinete);
                });
    }

    @Test
    public void test03CuranderoNoPuedeCurarUnidadMuerta() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jinete jinete = new Jinete(blanco);
        Curandero curandero = new Curandero(blanco);
        Catapulta catapulta = new Catapulta(negro);

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

        Color blanco = new Blanco();

        Curandero curandero = new Curandero(blanco);
        Catapulta catapulta = new Catapulta(blanco);

        curandero.accionContra(catapulta);
        /** Los puntos de vida de la catapulta no cambian */
        assertEquals(50, catapulta.getPuntosDeVida());
    }
}