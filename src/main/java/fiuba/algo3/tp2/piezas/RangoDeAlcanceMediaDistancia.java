package fiuba.algo3.tp2.piezas;

import java.util.ArrayList;

public class RangoDeAlcanceMediaDistancia implements RangoDeAlcance {


    @Override
    public void atacar(SoldadoDeInfanteria soldado, Pieza receptor, int danio) {

        // no ataca a distancia media
    }

    @Override
    public void atacar(Jinete jinete, Pieza receptor, int danio) {

        // depende de las piezas que lo rodean //

    }

    @Override
    public void atacar(Catapulta catapulta, Pieza receptor, ArrayList<Pieza> contiguas) {

        // no ataca distancia media
    }


    @Override
    public void curar(Curandero curandero, Pieza pieza) {

        // no cura en distancia media
    }
}
