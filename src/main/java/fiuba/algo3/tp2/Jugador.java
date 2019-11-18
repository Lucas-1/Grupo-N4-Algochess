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
    private String nombre;
    private Billetera billetera;
    private final int POSICION_MI_TABLERO = 0;
    private final int POSICION_TABLERO_ENEMIGO = 1;
    private Color color;

    public Jugador(Color color, String nombre) {
        this.nombre = nombre;
        billetera = new Billetera(CANTIDAD_DINERO_INICIAL);
        administradorDePiezas = new AdministradorDePiezas();
        this.color = color;
    }

    public void insertarPiezaEnPosicion(Pieza pieza, Posicion posicion, Tablero tablero) {

        administradorDePiezas.agregarPieza(pieza, tablero, posicion,billetera, color);
    }

    public void borrarUnidad(Tablero tablero, Posicion posicion) {

        Pieza pieza = tablero.getPieza(posicion);
        administradorDePiezas.borrarPieza(pieza);
        tablero.borrarUnidad(posicion);
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

    /*public Tablero faseInicial(Tablero tablero) {
        return colocarPiezasIniciales(tablero);
    }*

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
    }*/

    public void comprarPieza(Pieza pieza) {
        administradorDePiezas.comprarPieza(pieza, billetera);
    }

    public void acomodarPieza(Posicion posicionInicial, Posicion posicionDeseada, int posicionPiezaBanco, Tablero tablero) {
        administradorDePiezas.acomodarPieza(posicionInicial, posicionDeseada, posicionPiezaBanco, tablero, color);
    }
}
