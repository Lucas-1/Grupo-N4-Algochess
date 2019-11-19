package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.PuntosDeCuracion;
import fiuba.algo3.tp2.PuntosDeVida;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.NoPuedeAtacarPiezaDelMismoEquipo;
import fiuba.algo3.tp2.excepciones.NoPuedeCurarPiezaDelOtroEquipo;

import java.util.ArrayList;

public class Curandero extends Pieza {

    private static final int PRECIO = 2;
    private int curacion;

    public Curandero(Color color) {

        this.precio = PRECIO;
        this.color = color;
        this.puntosDeVida = new PuntosDeVida(this);
        curacion = 15;
    }

    public void atacarPieza(Pieza pieza) {

        // curandero no puede atacar
    }

    public void curarPieza(Pieza pieza) {

        if(!this.esDeMiEquipo(pieza))
            throw new NoPuedeCurarPiezaDelOtroEquipo();

        pieza.recibirVida(curacion);
    }

    @Override
    public void atacar(Pieza pieza, int distanciaConPieza, ArrayList<Pieza> contiguas) {

        this.setAtaqueContext(distanciaConPieza);
        ataqueContext.atacar(this, pieza);

    }
}
