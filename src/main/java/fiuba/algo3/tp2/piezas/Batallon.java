package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.Tablero;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;

import java.util.ArrayList;

public class Batallon {

    private final int TAMANIO_MAX_BATALLON = 3;

    private ArrayList<Pieza> soldados;

    public Batallon() {

        soldados = new ArrayList<Pieza>();
    }

    public boolean estaLleno() {

        return (soldados.size() == TAMANIO_MAX_BATALLON);
    }

    public void moverBatallon(Posicion posicion, Color color , Tablero tablero, Direccion direccion) {

        soldados.clear();
        tablero.obtenerSoldadosContiguos(posicion,color,this);

        int i = 0;
        while (i < soldados.size()) {
            tablero.obtenerSoldadosContiguos(soldados.get(i).getPosicion(),color,this);
            i++;
        }

        if(soldados.size() == TAMANIO_MAX_BATALLON) {

            for(int j = 0; j < TAMANIO_MAX_BATALLON; j++)
                tablero.moverPieza(soldados.get(j),direccion);

        } else {

            tablero.moverPieza(soldados.get(0),direccion);
        }
    }

    public boolean contiene(Pieza pieza) {

        return soldados.contains(pieza);
    }

    public void agregar(Pieza pieza) {

        soldados.add(pieza);
    }
}
