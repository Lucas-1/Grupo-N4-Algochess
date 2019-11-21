package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.PiezasContiguas;
import fiuba.algo3.tp2.PuntosDeVida;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.NoPuedeCurarPiezaDelOtroEquipo;

import java.util.ArrayList;

public class Curandero extends Pieza {

    private static final int PRECIO = 2;
    private static final int CURACION = 15;

    public Curandero(Color color) {

        this.precio = PRECIO;
        this.color = color;
        this.puntosDeVida = new PuntosDeVida(this);
    }

    public void curarPieza(Pieza pieza) {

        if(!this.esDeMiEquipo(pieza))
            throw new NoPuedeCurarPiezaDelOtroEquipo();

        pieza.recibirVida(CURACION);
    }

    @Override
    public void atacar(Pieza pieza, int distanciaConPieza, ArrayList<Pieza> contiguas) {

        this.setAtaque(distanciaConPieza);
        ataque.atacar(this, pieza);

    }

    @Override
    public void unirseABatallon(PiezasContiguas batallon, Color color) {

    }

    @Override
    public boolean esSoldado() {
        return false;
    }
}
