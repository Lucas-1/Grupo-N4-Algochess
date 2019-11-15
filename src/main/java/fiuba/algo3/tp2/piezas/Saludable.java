package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.PuntosDeCuracion;
import fiuba.algo3.tp2.excepciones.NoPuedeCurarPiezaDelOtroEquipo;

public abstract class Saludable extends Pieza {

    protected PuntosDeCuracion puntosDeCuracion;

    public void curarPieza(Pieza pieza) {

        if(!this.esDeMiEquipo(pieza))
            throw new NoPuedeCurarPiezaDelOtroEquipo();

        pieza.recibirVida(puntosDeCuracion.getPuntosCuracion());
    }
}
