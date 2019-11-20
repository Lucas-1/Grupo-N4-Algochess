package fiuba.algo3.tp2;


import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.piezas.Pieza;

import java.util.ArrayList;


public class AdministradorDePiezas {

    private final int CANTIDAD_DINERO_INICIAL = 20;

    private ArrayList<Pieza> piezas;
    private PiezasContiguas piezasContiguas;
    private Billetera billetera;
    private Tienda tienda;


    public AdministradorDePiezas() {

        piezas = new ArrayList<Pieza>();
        piezasContiguas = new PiezasContiguas();
        billetera = new Billetera(CANTIDAD_DINERO_INICIAL);
        tienda = new Tienda();
    }

    public boolean sigueEnJuego() {

        return !(piezas.isEmpty()); /* Jugador se queda sin piezas, pierde. */
    }

    public void borrarPieza(Pieza pieza) {

        piezas.remove(pieza);
    }

    public void agregarPieza(Pieza pieza, int posicionFila, int posicionColumna, Tablero tablero, Color color) {

        Posicion posicion = new Posicion(posicionFila,posicionColumna);
        Pieza piezaComprada = tienda.comprarPieza(pieza, billetera);
        tablero.agregarUnidad(piezaComprada, posicionFila, posicionColumna, color);
        pieza.setPosicion(posicion);
        piezas.add(pieza);
    }

    public ArrayList<Pieza> obtenerPiezasContiguas(int posFila, int posColumna, Tablero tablero) {

        return piezasContiguas.obtenerPiezasContiguas(posFila,posColumna,tablero);
    }

    public ArrayList<Pieza> obtenerSoldadosContiguos(int posFila, int posColumna, Tablero tablero, Color color) {

        return  piezasContiguas.obtenerSoldadosContiguos(posFila, posColumna, color, tablero);
    }

    public int getPuntosDeCompraDisponibles() {

        return billetera.dineroRestante();
    }
}
