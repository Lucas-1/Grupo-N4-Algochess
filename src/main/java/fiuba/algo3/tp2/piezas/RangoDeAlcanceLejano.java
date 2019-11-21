package fiuba.algo3.tp2.piezas;

import java.util.ArrayList;

public class RangoDeAlcanceLejano implements RangoDeAlcance {

    @Override
    public void atacar(SoldadoDeInfanteria soldado, Pieza receptor, int danio) {

        // no ataca distancia lejos
    }

    @Override
    public void atacar(Jinete jinete, Pieza receptor, int danio) {

        // no ataca distancia lejos
    }

    @Override
    public void atacar(Catapulta catapulta, Pieza receptor, ArrayList<Pieza> contiguas) {


        for(int i=0; i < contiguas.size(); i++) {

            Pieza pieza = contiguas.get(i);
            pieza.perderVida(catapulta.getDanioCatapulta());
        }
    }

    @Override
    public void curar(Curandero curandero, Pieza pieza) {

        // no cura distancia lejos
    }
}
