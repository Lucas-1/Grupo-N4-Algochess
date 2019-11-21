package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.excepciones.NoPuedeAtacarPiezaDelMismoEquipo;

import java.util.ArrayList;

public abstract class Danina extends Pieza {

    protected Ataque ataque;


    public abstract void atacar(Pieza pieza, int distanciaConPieza, ArrayList<Pieza> contiguas);
}
