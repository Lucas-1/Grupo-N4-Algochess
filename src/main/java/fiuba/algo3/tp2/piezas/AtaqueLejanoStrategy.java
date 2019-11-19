package fiuba.algo3.tp2.piezas;

import java.util.ArrayList;

public class AtaqueLejanoStrategy implements AtaqueStrategy {

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

        int i = 0;
        while(i < contiguas.size()) {

            Pieza pieza = contiguas.get(i);
            catapulta.atacarPieza(pieza);
            i++;
        }
    }

    @Override
    public void atacar(Curandero curandero, Pieza pieza) {

        // no cura distancia lejos
    }
}
