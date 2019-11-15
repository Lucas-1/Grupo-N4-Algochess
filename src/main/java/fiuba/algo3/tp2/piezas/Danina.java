package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.PuntosDeAtaque;
import fiuba.algo3.tp2.excepciones.NoPuedeAtacarEntidadDelMismoEquipo;

public abstract class Danina extends Pieza {

    protected PuntosDeAtaque puntosDeAtaque;

    public void atacarPieza(Pieza pieza) {

        if(this.esDeMiEquipo(pieza))
            throw new NoPuedeAtacarEntidadDelMismoEquipo();

        pieza.perderVida(puntosDeAtaque.getDanioDelAtaque());
    }
}
