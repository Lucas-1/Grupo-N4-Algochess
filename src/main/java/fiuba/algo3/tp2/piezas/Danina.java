package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.PuntosDeAtaque;
import fiuba.algo3.tp2.excepciones.NoPuedeAtacarPiezaDelMismoEquipo;

public abstract class Danina extends Pieza {

    protected PuntosDeAtaque puntosDeAtaque;

    public void atacarPieza(Pieza pieza) {

        if(this.esDeMiEquipo(pieza))
            throw new NoPuedeAtacarPiezaDelMismoEquipo();

        pieza.perderVida(puntosDeAtaque.getDanioDelAtaque());
    }
}
