package fiuba.algo3.tp2.piezas;

import java.util.ArrayList;

public class RangoDeAlcanceMediaDistancia implements RangoDeAlcance {


    @Override
    public void atacar(SoldadoDeInfanteria soldado, Pieza receptor) {

        // no ataca a distancia media
    }

    @Override
    public void atacar(Jinete jinete, Pieza receptor) {

        receptor.perderVida(jinete.getDanio());

    }

    @Override
    public void atacar(Catapulta catapulta, Pieza receptor, ArrayList<Pieza> contiguas) {

        // no ataca distancia media
    }


    @Override
    public void curar(Curandero curandero, Pieza receptor) {

        // no cura en distancia media
    }
}
