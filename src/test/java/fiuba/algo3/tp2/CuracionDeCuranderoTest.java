package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.excepciones.PiezaEstaMuertaException;
import fiuba.algo3.tp2.excepciones.NoPuedeCurarPiezaDelOtroEquipo;
import fiuba.algo3.tp2.piezas.Catapulta;
import fiuba.algo3.tp2.piezas.Curandero;
import fiuba.algo3.tp2.piezas.Jinete;
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

        catapulta.atacarPieza(jinete);

        curandero.curarPieza(jinete);
        assertEquals(jinete.getPuntosDeVida(), 95);
    }

    @Test
    public void test02CuranderoNoPuedeCurarUnidadEnemiga() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Curandero curandero = new Curandero(blanco);
        Jinete jinete = new Jinete(negro);

        assertThrows(NoPuedeCurarPiezaDelOtroEquipo.class,
                ()->{
                    curandero.curarPieza(jinete);
                });
    }

    @Test
    public void test03CuranderoNoPuedeCurarUnidadMuerta() {

        Color blanco = new Blanco();
        Color negro = new Negro();
        Jinete jinete = new Jinete(blanco);
        Curandero curandero = new Curandero(blanco);
        Catapulta catapulta = new Catapulta(negro);

        catapulta.atacarPieza(jinete);
        catapulta.atacarPieza(jinete);
        catapulta.atacarPieza(jinete);
        catapulta.atacarPieza(jinete);
        /** mata al jinete */
        catapulta.atacarPieza(jinete);

        assertThrows(PiezaEstaMuertaException.class,
                ()->{
                    curandero.curarPieza(jinete);
                });
    }

    @Test
    public void test04CuranderoNoPuedeCurarCatapulta() {

        Color blanco = new Blanco();

        Curandero curandero = new Curandero(blanco);
        Catapulta catapulta = new Catapulta(blanco);

        curandero.curarPieza(catapulta);
        /** Los puntos de vida de la catapulta no cambian */
        assertEquals(50, catapulta.getPuntosDeVida());
    }
}