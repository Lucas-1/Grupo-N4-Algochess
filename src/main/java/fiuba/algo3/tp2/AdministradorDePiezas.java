package fiuba.algo3.tp2;


import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.piezas.Batallon;
import fiuba.algo3.tp2.piezas.Pieza;

import java.util.ArrayList;


public class AdministradorDePiezas {

    private final int CANTIDAD_DINERO_INICIAL = 20;

    private ArrayList<Pieza> piezas;
    private PiezasContiguas piezasContiguas;
    private Billetera billetera;
    private Tienda tienda;
    private Batallon batallon;


    public AdministradorDePiezas() {

        piezas = new ArrayList<Pieza>();
        piezasContiguas = new PiezasContiguas();
        batallon = new Batallon();
        billetera = new Billetera(CANTIDAD_DINERO_INICIAL);
        tienda = new Tienda();
    }

    public boolean sigueEnJuego() {

        return !(piezas.isEmpty()); /* Jugador se queda sin piezas, pierde. */
    }

    public void borrarPieza(Pieza pieza) {

        piezas.remove(pieza);
    }

    public void agregarPieza(Pieza pieza, int posicionFila, int posicionColumna, Tablero tablero) {

        Posicion posicion = new Posicion(posicionFila,posicionColumna);
        Pieza piezaComprada = tienda.comprarPieza(pieza, billetera);
        tablero.agregarPieza(piezaComprada, posicionFila, posicionColumna);
        pieza.setPosicion(posicion);
        piezas.add(pieza);
    }

    public ArrayList<Pieza> obtenerPiezasContiguas(Posicion posicion, Tablero tablero) {

        return piezasContiguas.obtenerPiezasContiguas(posicion,tablero);
    }

    public void moverPieza(Pieza pieza, Direccion direccion, Tablero tablero) {

        batallon.armadoBatallon(pieza,piezas);
        batallon.moverBatallon(pieza,direccion,tablero);
    }

    public int getPuntosDeCompraDisponibles() {

        return billetera.dineroRestante();
    }


}
