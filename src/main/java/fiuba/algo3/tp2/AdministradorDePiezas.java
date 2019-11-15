package fiuba.algo3.tp2;


import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.piezas.Pieza;

import java.util.ArrayList;


public class AdministradorDePiezas {
    private ArrayList<Pieza> entidades;

    public AdministradorDePiezas() {
        entidades = new ArrayList<Pieza>();
    }

    public boolean sigueEnJuego() {

        return !(entidades.isEmpty()); /* Jugador se queda sin entidades, pierde. */
    }

    public void borrarEntidad(Pieza pieza) {

        entidades.remove(pieza);
    }

    public void agregarEntidad(Pieza pieza, int posicionFila, int posicionColumna, Tablero tablero, Color color, Tienda tienda, Billetera billetera) {

        Pieza piezaComprada = tienda.comprarPieza(pieza, billetera);
        tablero.agregarUnidad(piezaComprada,posicionFila,posicionColumna,color);

        piezaComprada.setPosicion(posicionFila,posicionColumna);
        entidades.add(piezaComprada);


    }
}
