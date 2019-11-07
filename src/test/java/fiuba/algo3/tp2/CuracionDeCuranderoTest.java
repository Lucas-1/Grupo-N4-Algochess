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

        catapulta.atacar(jinete);

        curandero.atacar(jinete);
        assertEquals(jinete.getPuntosDeVida(), 95);
    }

    @Test
    public void test02CuranderoNoPuedeCurarUnidadEnemiga() {

        Curandero curandero = new Curandero(1);
        Jinete jinete = new Jinete(2);

        assertThrows(NoPuedeCurarEntidadDelOtroEquipo.class,
                ()->{
                    curandero.atacar(jinete);
                });
    }

    @Test
    public void test03CuranderoNoPuedeCurarUnidadMuerta() {

        Jinete jinete = new Jinete(1);
        Curandero curandero = new Curandero(1);
        Catapulta catapulta = new Catapulta(2);

        catapulta.atacar(jinete);
        catapulta.atacar(jinete);
        catapulta.atacar(jinete);
        catapulta.atacar(jinete);
        catapulta.atacar(jinete); // mata al jinete

        assertThrows(EntidadEstaMuertaException.class,
                ()->{
                    curandero.atacar(jinete);
                });
    }

    @Test
    public void test04CuranderoNoPuedeCurarCatapulta() {

        Curandero curandero = new Curandero(1);
        Catapulta catapulta = new Catapulta(1);

        curandero.atacar(catapulta);
        assertEquals(50,catapulta.getPuntosDeVida()); // Los puntos de vida de la catapulta no cambian
    }
}