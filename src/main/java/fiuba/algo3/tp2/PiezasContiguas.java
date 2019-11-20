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

    public ArrayList<Pieza> obtenerPiezasContiguas(int posFila, int posColumna, Tablero tablero) {

        piezas.clear();

        Posicion posicion = new Posicion(posFila, posColumna);
        tablero.obtenerContiguos(posicion, this);

        int i = 0;

        while (i < piezas.size()) {
            tablero.obtenerContiguos(piezas.get(i).getPosicion(), this);
            i++;
        }

        return piezas;
    }

    public ArrayList<Pieza> obtenerSoldadosContiguos(int posFila, int posColumna, Color color , Tablero tablero) {

        piezas.clear();
        tablero.obtenerSoldadosContiguos(posFila,posColumna,color, this);

        int i = 0;

        while (i < piezas.size()) {
            tablero.obtenerSoldadosContiguos(piezas.get(i).getPosicion().getPosicionFila(),piezas.get(i).getPosicion().getPosicionColumna(), color,this);
            i++;
        }

        return piezas;
    }

    public boolean batallonLleno() {

        return (piezas.size() == 3);
    }

    public boolean contiene(Pieza pieza) {

        return piezas.contains(pieza);
    }

    public void agregar(Pieza pieza) {

        piezas.add(pieza);
    }
}
