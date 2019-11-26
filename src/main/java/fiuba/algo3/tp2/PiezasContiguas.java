package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.piezas.Pieza;

import java.util.ArrayList;

public class PiezasContiguas {

    private ArrayList<Pieza> piezas;

    public PiezasContiguas() {

        piezas = new ArrayList<Pieza>();
    }

    public ArrayList<Pieza> obtenerPiezasContiguas(Posicion posicion, Tablero tablero) {

        piezas.clear();

        tablero.obtenerContiguos(posicion, this);

        int i = 0;

        while (i < piezas.size()) {
            tablero.obtenerContiguos(piezas.get(i).getPosicion(), this);
            i++;
        }

        return piezas;
    }


    public boolean contiene(Pieza pieza) {

        return piezas.contains(pieza);
    }

    public void agregar(Pieza pieza) {

        if(!this.contiene(pieza))
            piezas.add(pieza);
    }
}
