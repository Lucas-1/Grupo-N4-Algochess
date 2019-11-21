package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.Billetera;
import fiuba.algo3.tp2.PiezasContiguas;
import fiuba.algo3.tp2.PuntosDeVida;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.NoPuedeAtacarPiezaDelMismoEquipo;

import java.util.ArrayList;

public class Jinete extends Danina {

    private static final int PRECIO = 3;
    private static final int DANIO_JINETE = 5;

    public Jinete(Color color) {
        this.precio = PRECIO;
        this.color = color;
        this.puntosDeVida = new PuntosDeVida(this);
    }


    @Override
    public void atacar(Pieza pieza, int distanciaConPieza, ArrayList<Pieza> contiguas) {

        // depende las que la rodean. meter strategy


        if(this.esDeMiEquipo(pieza))
            throw new NoPuedeAtacarPiezaDelMismoEquipo();

        pieza.perderVida(DANIO_JINETE);
    }

    @Override
    public void unirseABatallon(Batallon batallon, Color color) {

    }

    @Override
    public boolean esSoldado() {
        return false;
    }

    public static int getDanio() {
        return DANIO_JINETE;
    }

}



