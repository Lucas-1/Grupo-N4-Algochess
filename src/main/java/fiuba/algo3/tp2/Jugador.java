package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.piezas.Pieza;
import java.util.ArrayList;

public class Jugador {

    private AdministradorDePiezas administradorDePiezas;
    private Color color;

    public Jugador(Color color) {

        administradorDePiezas = new AdministradorDePiezas();
        this.color = color;
    }

    public void insertarPiezaEnPosicion(Pieza pieza, int posicionFila, int posicionColumna, Tablero tablero) {

        administradorDePiezas.agregarPieza(pieza, posicionFila,posicionColumna,tablero,color);
    }

    public void borrarPieza(Tablero tablero, int posicionFila, int posicionColumna) {

        Pieza pieza = tablero.obtenerPieza(posicionFila,posicionColumna);
        administradorDePiezas.borrarPieza(pieza);
        tablero.borrarPieza(posicionFila, posicionColumna);
    }

    public void atacarCon(Pieza pieza, int posicionFila, int posicionColumna, Tablero tablero) {

        Pieza receptor = tablero.obtenerPieza(posicionFila,posicionColumna);
        Posicion posReceptor = new Posicion(posicionFila,posicionColumna);
        int distanciaEntrePiezas = pieza.calcularDistancia(posReceptor);
        ArrayList<Pieza> contiguas = administradorDePiezas.obtenerPiezasContiguas(posicionFila,posicionColumna,tablero);
        pieza.atacar(receptor, distanciaEntrePiezas, contiguas);
    }

    public boolean sigueEnJuego() {

        return administradorDePiezas.sigueEnJuego();
    }

    public void moverPieza(Pieza pieza, Direccion direccion, Tablero tablero){

        Posicion posiscion = pieza.getPosicion();


        if(pieza.esSoldado()) {

            ArrayList<Pieza> batallon = administradorDePiezas.obtenerSoldadosContiguos(posiscion.getPosicionFila(),posiscion.getPosicionColumna(),tablero,color);

            if(batallon.size() == 3) {

                for(int i = 0; i < 3; i++)
                    tablero.moverPieza(batallon.get(i),direccion);

            } else {
                tablero.moverPieza(pieza,direccion);
            }

        } else {

            tablero.moverPieza(pieza,direccion);
        }

    }

    //
    public int getPuntosDeCompraDisponibles() {

        return administradorDePiezas.getPuntosDeCompraDisponibles();
    }

}
