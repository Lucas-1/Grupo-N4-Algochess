package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.piezas.Pieza;

public class Tablero {

    private Casillero[][] casilleros;

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

    public void moverUnidad(Pieza pieza, Direccion dir){

        Posicion posicionActual = pieza.getPosicion();
        Casillero casillero = casilleros[posicionActual.getDireccionFila()][posicionActual.getDireccionColumna()];
        pieza.mover(dir);
        casillero.borrarUnidad();
        posicionActual = pieza.getPosicion();
        casillero = casilleros[posicionActual.getDireccionFila()][posicionActual.getDireccionColumna()];
        casillero.setearUnidad(pieza);
    }

    public Pieza obtenerPieza(int posicionFila, int posicionColumna) {

        return casilleros[posicionFila][posicionColumna].getPieza();
    }


}
