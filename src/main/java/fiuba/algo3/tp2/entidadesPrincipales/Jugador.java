package fiuba.algo3.tp2.entidadesPrincipales;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.administrador.AdministradorDePiezas;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Danina;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Jinete;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Saludable;

import java.util.ArrayList;

public class Jugador {

    private AdministradorDePiezas administradorDePiezas;
    private Color color;

    public Jugador(Color color) {

        administradorDePiezas = new AdministradorDePiezas();
        this.color = color;
    }

    public void insertarPiezaEnPosicion(Pieza pieza, int posicionFila, int posicionColumna, Tablero tablero) {

        administradorDePiezas.agregarPieza(pieza, posicionFila,posicionColumna,tablero);
    }

    public void borrarPieza(Tablero tablero, int posicionFila, int posicionColumna) {

        Pieza pieza = tablero.obtenerPieza(posicionFila,posicionColumna);
        administradorDePiezas.borrarPieza(pieza);

        tablero.borrarPieza(new Posicion(posicionFila,posicionColumna));
    }

    public void atacarCon(Danina pieza, int posicionFila, int posicionColumna, Tablero tablero) {

        Pieza receptor = tablero.obtenerPieza(posicionFila,posicionColumna);
        Posicion posReceptor = new Posicion(posicionFila,posicionColumna);
        int distanciaEntrePiezas = pieza.calcularDistancia(posReceptor);
        ArrayList<Pieza> contiguas = administradorDePiezas.obtenerPiezasContiguas(posReceptor,tablero);
        pieza.atacar(receptor, distanciaEntrePiezas, contiguas);
    }

    public void atacarCon(Jinete jinete, int posicionFila, int posicionColumna, Tablero tablero) {

        Pieza receptor = tablero.obtenerPieza(posicionFila,posicionColumna);
        Posicion posReceptor = new Posicion(posicionFila,posicionColumna);
        int distanciaEntrePiezas = jinete.calcularDistancia(posReceptor);
        ArrayList<Pieza> contiguas = administradorDePiezas.obtenerPiezasContiguas(jinete.getPosicion(),tablero);
        jinete.atacar(receptor, distanciaEntrePiezas, contiguas);
    }


    public void curarCon(Saludable pieza, int posicionFila, int posicionColumna, Tablero tablero){

        Pieza receptor = tablero.obtenerPieza(posicionFila,posicionColumna);
        Posicion posReceptor = new Posicion(posicionFila,posicionColumna);
        int distanciaEntrePiezas = pieza.calcularDistancia(posReceptor);
        pieza.curar(receptor, distanciaEntrePiezas);
    }

    public boolean sigueEnJuego() {

        return administradorDePiezas.sigueEnJuego();
    }

    public void moverPieza(Pieza pieza, Direccion direccion, Tablero tablero){

        administradorDePiezas.moverPieza(pieza, direccion, tablero);
    }

    public void actualizarPiezas(Tablero tablero) {

        administradorDePiezas.actualizarPiezas(tablero);
    }

    //
    public int getPuntosDeCompraDisponibles() {

        return administradorDePiezas.getPuntosDeCompraDisponibles();
    }
}
