package fiuba.algo3.tp2;


import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.piezas.Pieza;

import java.util.ArrayList;


public class AdministradorDePiezas {

    private ArrayList<Pieza> piezas;
    private ArrayList<Pieza> contiguas;

    public AdministradorDePiezas() {

        piezas = new ArrayList<Pieza>();
        contiguas = new ArrayList<Pieza>();
    }

    public boolean sigueEnJuego() {

        return !(piezas.isEmpty()); /* Jugador se queda sin piezas, pierde. */
    }

    public void borrarPieza(Pieza pieza) {

        piezas.remove(pieza);
    }

    public void agregarPieza(Pieza pieza, int posicionFila, int posicionColumna, Tablero tablero, Color color, Tienda tienda, Billetera billetera) {

        Pieza piezaComprada = tienda.comprarPieza(pieza, billetera);
        tablero.agregarUnidad(piezaComprada,posicionFila,posicionColumna,color);

        Posicion posicion = new Posicion(posicionFila,posicionColumna);
        piezaComprada.setPosicion(posicion);
        piezas.add(piezaComprada);
    }

    public ArrayList<Pieza> obtenerPiezasContiguas(int posFila, int posColumna, Tablero tablero) {

        contiguas.clear();

        Posicion posicion = new Posicion(posFila, posColumna);
        tablero.obtenerContiguos(posicion,contiguas);

        int i = 0;
        while(i < contiguas.size()) {
            tablero.obtenerContiguos(contiguas.get(i).getPosicion(),contiguas);
            i++;
        }

        return contiguas;
    }
}
