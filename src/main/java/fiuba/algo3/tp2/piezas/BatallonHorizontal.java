package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.TipoDeBatallon;

import java.util.ArrayList;

public class BatallonHorizontal extends TipoDeBatallon {

    public void armarBatallon(Pieza pieza, ArrayList<Pieza> piezas) {

        soldados.clear();
        pieza.unirseABatallonHorizontal(this,pieza);

        int i = 0;
        while(i < soldados.size()) {

            Pieza soldadoActual = soldados.get(i);
            for(int j = 0; j<piezas.size(); j++)
                (piezas.get(j)).unirseABatallonHorizontal(this,soldadoActual);
            i++;
        }


    }

}
