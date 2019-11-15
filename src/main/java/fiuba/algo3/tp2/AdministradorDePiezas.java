package fiuba.algo3.tp2;


import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.piezas.Pieza;

import java.util.ArrayList;


public class AdministradorDePiezas {
    private ArrayList<Pieza> piezas;

    public AdministradorDePiezas() {
        piezas = new ArrayList<Pieza>();
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

        piezaComprada.setPosicion(posicionFila,posicionColumna);
        piezas.add(piezaComprada);


    }
}
