package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.PuntosDeVida;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.NoPuedeAtacarPiezaDelMismoEquipo;

public class Jinete extends Pieza {

    private static final int PRECIO = 3;
    private int danio;

    public Jinete(Color color) {
        this.precio = PRECIO;
        this.color = color;
        this.puntosDeVida = new PuntosDeVida(this);
        danio = 5;
    }
    public void atacarPieza(Pieza pieza) {

        if(this.esDeMiEquipo(pieza))
            throw new NoPuedeAtacarPiezaDelMismoEquipo();

        pieza.perderVida(danio);
    }


    @Override
    public void atacar(Pieza pieza, int distanciaConPieza) {

    }
}



