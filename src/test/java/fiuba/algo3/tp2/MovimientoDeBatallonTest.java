package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.piezas.SoldadoDeInfanteria;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovimientoDeBatallonTest {

    @Test
    public void test01TresSoldadosFormanBatallonYSeMuevenJuntos() {

        Jugador jugadorBlanco = new Jugador(new Blanco());
        Tablero tablero = new Tablero();

        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria(new Blanco());
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria(new Blanco());

        jugadorBlanco.insertarPiezaEnPosicion(soldado1,3,3,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado2,3,4,tablero);
        jugadorBlanco.insertarPiezaEnPosicion(soldado3,3,5,tablero);

      //  jugadorBlanco.moverPieza(soldado1, new Arriba(), tablero); // se tienen que mover las 3 para arriba





    }
}
