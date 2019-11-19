package fiuba.algo3.tp2.piezas;

import java.util.ArrayList;

public class AtaqueCercanoStrategy implements AtaqueStrategy {


    @Override
    public void atacar(SoldadoDeInfanteria soldado, Pieza receptor, int danio) {

        receptor.perderVida(danio);
    }

    @Override
    public void atacar(Jinete jinete, Pieza receptor, int danio) {

        // jinete depende de las piezas que lo rodean

    }

    @Override
    public void atacar(Catapulta catapulta, Pieza receptor, ArrayList<Pieza> contiguas) {


        // no ataca de cerca
    }

    @Override
    public void atacar(Curandero curandero, Pieza pieza) {

        curandero.curarPieza(pieza);
    }

}
