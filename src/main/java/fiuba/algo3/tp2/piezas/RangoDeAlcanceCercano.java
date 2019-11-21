package fiuba.algo3.tp2.piezas;

import java.util.ArrayList;

public class RangoDeAlcanceCercano implements RangoDeAlcance {


    @Override
    public void atacar(SoldadoDeInfanteria soldado, Pieza receptor) {

        receptor.perderVida(soldado.getDanio());
    }

    @Override
    public void atacar(Jinete jinete, Pieza receptor) {

        if(jinete.calcularDistancia(receptor.getPosicion()) <= 2){
            receptor.perderVida(jinete.getDanio());
        }


    }

    @Override
    public void atacar(Catapulta catapulta, Pieza receptor, ArrayList<Pieza> contiguas) {


        // no ataca de cerca
    }

    @Override
    public void curar(Curandero curandero, Pieza receptor) {

        receptor.recibirVida(curandero.getCuracion());

    }

}
