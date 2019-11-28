package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.PuntosDeVida;
import fiuba.algo3.tp2.TipoDeBatallon;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.NoPuedeCurarPiezaDelOtroEquipo;

import java.util.ArrayList;

public class Curandero extends Saludable {

    private static final int PRECIO = 2;
    private static final int CURACION = 15;

    public Curandero(Color color) {

        this.curacion = new Ataque();
        this.precio = PRECIO;
        this.color = color;
        this.puntosDeCuracion = CURACION;
        this.puntosDeVida = new PuntosDeVida(this);
    }

    @Override
    public void curar(Pieza pieza, int distanciaConPieza) {

        if(!this.esDeMiEquipo(pieza))
            throw new NoPuedeCurarPiezaDelOtroEquipo();
        this.setRangoDeAlcance(distanciaConPieza);
        curacion.curar(this, pieza, this.rangoDeAlcance);

    }

    @Override
    public void unirseABatallonHorizontal(TipoDeBatallon batallon, Pieza pieza) {

    }
    @Override
    public void unirseABatallonVertical(TipoDeBatallon batallon, Pieza pieza) {

    }

    public void setRangoJineteCercano(Jinete jinete){

        if(!jinete.esDeMiEquipo(this)){
            jinete.setRangoCercano();
        }
    }

}
