package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.piezas.Batallon;
import fiuba.algo3.tp2.piezas.Pieza;

public class Tablero {

    private static final int LIMITE_SUPERIOR = 20;
    private static final int LIMITE_INFERIOR = 0;

    private Casillero[][] casilleros;

    public Tablero() {

        casilleros = new Casillero[LIMITE_SUPERIOR][LIMITE_SUPERIOR];
        Color blanco = new Blanco();
        Color negro = new Negro();

        /* Primeras 10 filas color blanco */
        for(int fila = LIMITE_INFERIOR; fila<LIMITE_SUPERIOR/2; fila++) {
            for(int columna = LIMITE_INFERIOR; columna<LIMITE_SUPERIOR; columna++) {
                casilleros[fila][columna] = new Casillero(blanco);
            }
        }

        /* Siguientes 10 filas color negro */
        for(int fila = LIMITE_SUPERIOR/2; fila<LIMITE_SUPERIOR; fila++) {
            for(int columna = LIMITE_INFERIOR; columna<LIMITE_SUPERIOR; columna++) {
                casilleros[fila][columna] = new Casillero(negro);
            }
        }
    }

    public void agregarPieza(Pieza pieza, int posicionFila, int posicionColumna) {

        Casillero casillero = casilleros[posicionFila][posicionColumna];
        casillero.agregarPieza(pieza);
    }

    public void borrarPieza(int posicionFila, int posicionColumna) {

        casilleros[posicionFila][posicionColumna].borrarPieza();
    }

    public boolean casilleroOcupado(int posicionFila, int posicionColumna) {

        return casilleros[posicionFila][posicionColumna].estaOcupado();
    }

    public void obtenerContiguos(Posicion posicion, PiezasContiguas contiguos) {

        int posFila = posicion.getPosicionFila();
        int posColumna = posicion.getPosicionColumna();

        // posicion donde ataco
        if(this.estaDentroDelMapa(posFila,posColumna)) {

            Pieza pieza = casilleros[posFila][posColumna].getPieza();
            if(pieza != null && !contiguos.contiene(pieza))
                contiguos.agregar(pieza);
        }

        // abajo
        if(this.estaDentroDelMapa(posFila+1,posColumna)) {

            Pieza pieza = casilleros[posFila+1][posColumna].getPieza();
            if(pieza != null && !contiguos.contiene(pieza))
                contiguos.agregar(pieza);
        }

        //arriba
        if(this.estaDentroDelMapa(posFila-1,posColumna)){

            Pieza pieza = casilleros[posFila-1][posColumna].getPieza();
            if(pieza != null && !contiguos.contiene(pieza))
                contiguos.agregar(pieza);
        }

        //derecha
        if(this.estaDentroDelMapa(posFila, posColumna+1)) {

            Pieza pieza = casilleros[posFila][posColumna+1].getPieza();
            if(pieza != null && !contiguos.contiene(pieza))
                contiguos.agregar(pieza);
        }

        //izquierda
        if(this.estaDentroDelMapa(posFila,posColumna-1)) {

            Pieza pieza = casilleros[posFila][posColumna-1].getPieza();
            if(pieza != null && !contiguos.contiene(pieza))
                contiguos.agregar(pieza);
        }
    }

    public boolean estaDentroDelMapa(int posFila, int posColumna) {

        return ((posFila >= LIMITE_INFERIOR && posFila < LIMITE_SUPERIOR) && (posColumna >= LIMITE_INFERIOR && posColumna < LIMITE_SUPERIOR));
    }

    public void moverPieza(Pieza pieza, Direccion direccion) {

        Posicion posicionActual = pieza.getPosicion();
        Posicion posicionNueva = direccion.calcularSiguientePosicion(pieza.getPosicion());

        if(this.estaDentroDelMapa(posicionNueva.getPosicionFila(),posicionNueva.getPosicionColumna())) {

            if(!this.casilleroOcupado(posicionNueva.getPosicionFila(),posicionNueva.getPosicionColumna())) {

                pieza.moverA(posicionNueva);
                casilleros[posicionActual.getPosicionFila()][posicionActual.getPosicionColumna()].borrarPieza();
                posicionNueva = pieza.getPosicion();
                casilleros[posicionNueva.getPosicionFila()][posicionNueva.getPosicionColumna()].setPieza(pieza);
            }
        }
    }

    public void obtenerSoldadosContiguos(Posicion posicion, Color color, Batallon batallon) {

        int posFila = posicion.getPosicionFila();
        int posColumna = posicion.getPosicionColumna();

        // posicion de soldado original
        if(this.estaDentroDelMapa(posFila,posColumna)) {

            Pieza pieza = casilleros[posFila][posColumna].getPieza();
            if(pieza != null && !batallon.contiene(pieza))
                pieza.unirseABatallon(batallon,color);
        }

        // abajo
        if(this.estaDentroDelMapa(posFila+1,posColumna)) {

            Pieza pieza = casilleros[posFila+1][posColumna].getPieza();
            if(pieza != null && !batallon.contiene(pieza))
                pieza.unirseABatallon(batallon,color);
        }

        //arriba
        if(this.estaDentroDelMapa(posFila-1,posColumna)){

            Pieza pieza = casilleros[posFila-1][posColumna].getPieza();
            if(pieza != null && !batallon.contiene(pieza))
                pieza.unirseABatallon(batallon,color);
        }

        //derecha
        if(this.estaDentroDelMapa(posFila, posColumna+1)) {

            Pieza pieza = casilleros[posFila][posColumna+1].getPieza();
            if(pieza != null && !batallon.contiene(pieza))
                pieza.unirseABatallon(batallon,color);
        }

        //izquierda
        if(this.estaDentroDelMapa(posFila,posColumna-1)) {

            Pieza pieza = casilleros[posFila][posColumna-1].getPieza();
            if(pieza != null && !batallon.contiene(pieza))
                pieza.unirseABatallon(batallon,color);
        }
    }

    public Pieza obtenerPieza(int posicionFila, int posicionColumna) {

        return casilleros[posicionFila][posicionColumna].getPieza();
    }

}
