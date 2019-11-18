package fiuba.algo3.tp2;


import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.piezas.Pieza;

import java.util.ArrayList;


public class AdministradorDePiezas {
    private ArrayList<Pieza> piezas;
    private Tienda tienda;

    public AdministradorDePiezas() {
        piezas = new ArrayList<Pieza>();
        tienda = new Tienda();
    }

    public boolean sigueEnJuego() {

        return !(piezas.isEmpty()); /* Jugador se queda sin piezas, pierde. */
    }

    public void borrarPieza(Pieza pieza) {

        piezas.remove(pieza);
    }

    public void agregarPieza(Pieza pieza, Tablero tablero, Posicion posicion, Billetera billetera, Color color) {

        Pieza piezaComprada = tienda.comprarPieza(pieza, billetera);
        tablero.agregarUnidad(piezaComprada, posicion, color);

        piezaComprada.setPosicion(posicion);
        piezas.add(piezaComprada);


    }

    public void comprarPieza(Pieza pieza, Billetera billetera) {
        Pieza piezaComprada = tienda.comprarPieza(pieza, billetera);
        piezas.add(piezaComprada);
    }

    public void acomodarPieza(Posicion posicionInicial, Posicion posicionDeseada, int indexPieza, Tablero tablero, Color color) {
        Pieza pieza = piezas.get(indexPieza);
        tablero.agregarUnidad(pieza, posicionDeseada, color);
        piezas.remove(indexPieza);
        tablero.borrarUnidad(posicionInicial);
    }
}
