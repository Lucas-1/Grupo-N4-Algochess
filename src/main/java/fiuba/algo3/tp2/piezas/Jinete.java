package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.Billetera;
import fiuba.algo3.tp2.PiezasContiguas;
import fiuba.algo3.tp2.PuntosDeVida;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.NoPuedeAtacarPiezaDelMismoEquipo;

import java.util.ArrayList;

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
    public void atacar(Pieza pieza, int distanciaConPieza, ArrayList<Pieza> contiguas) {

        // depende las que la rodean. meter strategy
    }

    @Override
    public void unirseABatallon(Batallon batallon, Color color) {

    }

    @Override
    public boolean esSoldado() {
        return false;
    }

}



