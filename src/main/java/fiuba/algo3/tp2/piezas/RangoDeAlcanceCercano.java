package fiuba.algo3.tp2.piezas;

import java.util.ArrayList;

public class RangoDeAlcanceCercano implements RangoDeAlcance {


    @Override
    public void atacar(SoldadoDeInfanteria soldado, Pieza receptor, int danio) {

        receptor.perderVida(danio);
    }

    @Override
    public void atacar(Jinete jinete, Pieza receptor, int danio) {

        if(jinete.calcularDistancia(receptor.getPosicion()) <= 2){
            receptor.perderVida(danio);
        }


    }

    @Override
    public void atacar(Catapulta catapulta, Pieza receptor, ArrayList<Pieza> contiguas) {


        // no ataca de cerca
    }

    @Override
    public void curar(Curandero curandero, Pieza pieza) {

        curandero.curarPieza(pieza);
    }

}
