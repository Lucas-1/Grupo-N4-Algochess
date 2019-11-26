package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.excepciones.NoPuedeCurarPiezaDelOtroEquipo;

public abstract class Saludable extends Pieza {

    protected Ataque curacion;
    protected int puntosDeCuracion;

    public abstract void curar(Pieza pieza, int distanciaConPieza);

    public void curar(Pieza pieza){
        pieza.recibirVida(this.puntosDeCuracion);
    }


}
