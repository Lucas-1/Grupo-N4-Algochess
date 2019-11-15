package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.piezas.Pieza;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private final int CANTIDAD_DINERO_INICIAL = 20;
    private AdministradorDePiezas administradorDePiezas;
    private Tienda tienda;
    private Billetera billetera;
    private final int POSICION_MI_TABLERO = 0;
    private final int POSICION_TABLERO_ENEMIGO = 1;
    private Color color;

    public Jugador(Color color) {
        tienda = new Tienda();
        billetera = new Billetera(CANTIDAD_DINERO_INICIAL);
        administradorDePiezas = new AdministradorDePiezas();
        this.color = color;
    }

    public void insertarEntidadEnPosicion(Pieza pieza, int posicionFila, int posicionColumna, Tablero tablero) {

        administradorDePiezas.agregarEntidad(pieza, posicionFila,posicionColumna,tablero,color, tienda, billetera);
    }

    public void borrarUnidad(Tablero tablero, int posicionFila, int posicionColumna) {

        Pieza pieza = tablero.getEntidad(posicionFila,posicionColumna);
        administradorDePiezas.borrarEntidad(pieza);
        tablero.borrarUnidad(posicionFila, posicionColumna);
    }

    public boolean sigueEnJuego() {

        return administradorDePiezas.sigueEnJuego();
    }

    public void moverEntidad(Pieza pieza, Direccion direccion, Tablero tablero){
        tablero.moverUnidad(pieza,direccion);
    }

    public int getPuntosDeCompraDisponibles() {
        return billetera.dineroRestante();
    }

    public Tablero faseInicial(Tablero tablero) {
        return colocarPiezasIniciales(tablero);
    }

    private Tablero colocarPiezasIniciales(Tablero tablero) {
        // aca coloca las piezas iniciales, hay que ver como resolver la compra de las piezas
        return tablero;
    }

    public List<Tablero> realizarTurno(Tablero miLado, Tablero ladoEnemigo) {
        // mueve una pieza y devuelve ambos tableros, puede que haya cruzado a territorio enemigo, implementar el movimiento.
        List<Tablero> tableros = new ArrayList<Tablero>();
        tableros.add(POSICION_MI_TABLERO, miLado);
        tableros.add(POSICION_TABLERO_ENEMIGO, ladoEnemigo);
        return tableros;
    }

}
