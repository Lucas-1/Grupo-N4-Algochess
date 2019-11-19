package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.PuntosDeVida;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.NoPuedeAtacarPiezaDelMismoEquipo;

import java.util.ArrayList;

public class SoldadoDeInfanteria extends Pieza {

    private static final int PRECIO = 1;
    private int danio;

    public SoldadoDeInfanteria(Color color) {

        this.precio = PRECIO;
        this.color = color;
        this.puntosDeVida = new PuntosDeVida(this);
        ataqueContext = new AtaqueContext();
        danio = 10;
    }


    public void atacar(Pieza pieza, int distanciaConPieza, ArrayList<Pieza> contiguas) {

        this.setAtaqueContext(distanciaConPieza);

        if (this.esDeMiEquipo(pieza))
            throw new NoPuedeAtacarPiezaDelMismoEquipo();

        if(this.estoyDelLadoEnemigo()) {
            danio = (int) (danio * 0.95);
        } else {
            danio = 10;
        }

        ataqueContext.atacar(this, pieza, danio);
    }
}
