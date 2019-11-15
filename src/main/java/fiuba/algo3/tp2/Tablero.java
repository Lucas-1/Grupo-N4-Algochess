package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.piezas.Pieza;

public class Tablero {

    private Casillero[][] casilleros;
    private Tablero lado1;
    private Tablero lado2;
    /**el tablero tiene a su vez 2 variables tableros que corresponde una a cada jugador*/

    public Tablero() {
        casilleros = new Casillero[20][20];
        Color blanco = new Blanco();
        Color negro = new Negro();

        /* Primeras 10 filas color blanco */
        for(int fila = 0; fila<10; fila++) {
            for(int columna = 0; columna<20; columna++) {
                casilleros[fila][columna] = new Casillero(blanco);
            }
        }

        /* Siguientes 10 filas color negro */
        for(int fila = 10; fila<20; fila++) {
            for(int columna = 0; columna<20; columna++) {
                casilleros[fila][columna] = new Casillero(negro);
            }
        }
        /**al tener estos lados, podriamos sacar el tema de los colores ya que hay 2 tableros, cada uno sabe cual es el suyo*/
        lado1 = new Tablero(new Blanco());
        lado2 = new Tablero(new Negro());
    }
    public Tablero(Color color){

        /**le puse overflow al constructor para poder crear un tablero de menor tamaño, obviamente si vamos a usar esto no tiene sentido
         * que se le pase un color, asique habria que resolverlo de otra forma la construccion de los lados, capaz con el patron multiton*/
        casilleros = new Casillero[10][20];
        for(int fila = 0; fila<10; fila++) {
            for(int columna = 0; columna<20; columna++) {
                casilleros[fila][columna] = new Casillero(color);
            }
        }

    }

    public void agregarUnidad(Pieza pieza, int posicionFila, int posicionColumna, Color color) {

        Casillero casillero = casilleros[posicionFila][posicionColumna];

        if(casillero.esValida(color))
            casillero.agregarUnidad(pieza);
    }

    public void borrarUnidad(int posicionFila, int posicionColumna) {

        casilleros[posicionFila][posicionColumna].borrarUnidad();
    }

    public boolean casilleroOcupado(int posicionFila, int posicionColumna) {

        return casilleros[posicionFila][posicionColumna].estaOcupado();
    }

    public Casillero getCasillero(int posicionFila, int posicionColumna) {

        return casilleros[posicionFila][posicionColumna];
    }

    public void moverUnidad(Pieza pieza, Direccion dir){

        Posicion posicionActual = pieza.getPosicion();
        Casillero casillero = casilleros[posicionActual.getDireccionFila()][posicionActual.getDireccionColumna()];
        pieza.mover(dir);
        casillero.borrarUnidad();
        posicionActual = pieza.getPosicion();
        casillero = casilleros[posicionActual.getDireccionFila()][posicionActual.getDireccionColumna()];
        casillero.setearUnidad(pieza);
    }

    public Pieza getEntidad(int posicionFila, int posicionColumna) {

        return casilleros[posicionFila][posicionColumna].getPieza();
    }


    public Tablero getLadoJugador1() {
        return lado1;
    }

    public Tablero getLadoJugador2() {
        return lado2;
    }

    public void actualizarLados(Tablero tableroJugador1, Tablero tableroJugador2) {
        lado1 = tableroJugador1;
        lado2 = tableroJugador2;
    }
}
