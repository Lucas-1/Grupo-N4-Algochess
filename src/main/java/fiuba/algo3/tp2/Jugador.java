package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.piezas.Pieza;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private final int CANTIDAD_DINERO_INICIAL = 20;
    private AdministradorDePiezas administradorDePiezas;
    private Tienda tienda;
    private Billetera billetera;
    private Color color;

    public Jugador(Color color) {
        tienda = new Tienda();
        billetera = new Billetera(CANTIDAD_DINERO_INICIAL);
        administradorDePiezas = new AdministradorDePiezas();
        this.color = color;
    }

    public void insertarPiezaEnPosicion(Pieza pieza, int posicionFila, int posicionColumna, Tablero tablero) {

        administradorDePiezas.agregarPieza(pieza, posicionFila,posicionColumna,tablero,color, tienda, billetera);
    }

    public void borrarUnidad(Tablero tablero, int posicionFila, int posicionColumna) {

        Pieza pieza = tablero.obtenerPieza(posicionFila,posicionColumna);
        administradorDePiezas.borrarPieza(pieza);
        tablero.borrarUnidad(posicionFila, posicionColumna);
    }

    public void atacarCon(Pieza pieza, int posicionFila, int posicionColumna, Tablero tablero) {

        Pieza receptor = tablero.obtenerPieza(posicionFila,posicionColumna);
        Posicion posReceptor = new Posicion(posicionFila,posicionColumna);
        int distanciaEntrePiezas = pieza.calcularDistancia(posReceptor);
        pieza.atacar(receptor, distanciaEntrePiezas);

    }

    public boolean sigueEnJuego() {

        return administradorDePiezas.sigueEnJuego();
    }

    public void moverPieza(Pieza pieza, Direccion direccion, Tablero tablero){

        tablero.moverUnidad(pieza,direccion);
    }

    public int getPuntosDeCompraDisponibles() {

        return billetera.dineroRestante();
    }

}
