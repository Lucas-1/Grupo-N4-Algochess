package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.excepciones.CasilleroEstaOcupadoException;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.piezas.Pieza;


import java.util.ArrayList;

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
            casillero.agregarPieza(pieza);
    }

    public void borrarUnidad(int posicionFila, int posicionColumna) {

        casilleros[posicionFila][posicionColumna].borrarPieza();
    }

    public boolean casilleroOcupado(int posicionFila, int posicionColumna) {

        return casilleros[posicionFila][posicionColumna].estaOcupado();
    }

    public void obtenerContiguos(Posicion posicion, ArrayList<Pieza> contiguos) {

        int posFila = posicion.getPosicionFila();
        int posColumna = posicion.getPosicionColumna();

        // posicion donde ataco
        if(this.estaDentroDelMapa(posFila,posColumna)) {

            Pieza pieza = casilleros[posFila][posColumna].getPieza();
            if(pieza != null && !contiguos.contains(pieza))
                contiguos.add(pieza);
        }

        // abajo
        if(this.estaDentroDelMapa(posFila+1,posColumna)) {

            Pieza pieza = casilleros[posFila+1][posColumna].getPieza();
            if(pieza != null && !contiguos.contains(pieza))
                contiguos.add(pieza);
        }

        //arriba
        if(this.estaDentroDelMapa(posFila-1,posColumna)){

            Pieza pieza = casilleros[posFila-1][posColumna].getPieza();
            if(pieza != null && !contiguos.contains(pieza))
                contiguos.add(pieza);
        }

        //derecha
        if(this.estaDentroDelMapa(posFila, posColumna+1)) {

            Pieza pieza = casilleros[posFila][posColumna+1].getPieza();
            if(pieza != null && !contiguos.contains(pieza))
                contiguos.add(pieza);
        }

        //izquierda
        if(this.estaDentroDelMapa(posFila,posColumna-1)) {

            Pieza pieza = casilleros[posFila][posColumna-1].getPieza();
            if(pieza != null && !contiguos.contains(pieza))
                contiguos.add(pieza);
        }
    }

    public boolean estaDentroDelMapa(int posFila, int posColumna) {

        return ((posFila >= 0 && posFila <= 19) && (posColumna >= 0 && posColumna <= 19));
    }

    public void moverPieza(Pieza pieza, Direccion direccion) {

        Posicion posicionOriginal = pieza.getPosicion();
        Posicion posicionNueva = direccion.calcularSiguientePosicion(pieza.getPosicion());

        if(this.estaDentroDelMapa(posicionNueva.getPosicionFila(),posicionNueva.getPosicionColumna())) {

            if(!this.casilleroOcupado(posicionNueva.getPosicionFila(),posicionNueva.getPosicionColumna())) {
                pieza.mover(direccion);
                casilleros[posicionOriginal.getPosicionFila()][posicionOriginal.getPosicionColumna()].borrarPieza();
                casilleros[posicionNueva.getPosicionFila()][posicionNueva.getPosicionColumna()].setPieza(pieza);
            } else {
                throw new CasilleroEstaOcupadoException();
            }
        }
    }

    public Pieza obtenerPieza(int posicionFila, int posicionColumna) {

        return casilleros[posicionFila][posicionColumna].getPieza();
    }


}
