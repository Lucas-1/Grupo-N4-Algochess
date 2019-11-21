package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.PuntosDeVida;
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
        this.puntosDeVida = new PuntosDeVida(this);
    }

    public void curarPieza(Pieza pieza) {

        if(!this.esDeMiEquipo(pieza))
            throw new NoPuedeCurarPiezaDelOtroEquipo();

        pieza.recibirVida(CURACION);
    }

    @Override
    public void curar(Pieza pieza, int distanciaConPieza) {

        this.setRangoDeAlcance(distanciaConPieza);
        curacion.curar(this, pieza, this.rangoDeAlcance);

    }

    @Override
    public void unirseABatallon(Batallon batallon, Color color) {

    }

    @Override
    public boolean esSoldado() {
        return false;
    }

    public void setRangoJineteCercano(Jinete jinete){
        if(!jinete.esDeMiEquipo(this)){
            jinete.setDanio(5);
            jinete.setRangoCercano();
        }
    }
}
