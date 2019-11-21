package fiuba.algo3.tp2.movimiento;

import fiuba.algo3.tp2.colores.Color;

public class Posicion {

    private int posicionFila;
    private int posicionColumna;

    public Posicion (int posFila, int posColumna){

        posicionColumna = posColumna;
        posicionFila = posFila;
    }

    public int calcularDistancia(Posicion posicion) {

        int distanciaColumna = Math.abs(posicionColumna - posicion.getPosicionColumna());
        int distanciaFila = Math.abs(posicionFila - posicion.getPosicionFila());

        return distanciaColumna + distanciaFila;
    }

    public boolean estoyDelLadoEnemigo(Color color) {

        if(posicionFila >= 10  & color.esBlanco())
            return true;

        if(posicionFila <= 9 & color.esNegro())
            return true;

        return false;
    }

    public int restarAtaqueLadoEnemigo( int danio, Color color) {

        if(this.estoyDelLadoEnemigo(color))
            return (int)(danio*0.95);

        return 0;
    }

    public int getPosicionColumna() {

        return posicionColumna;
    }

    public int getPosicionFila() {

        return posicionFila;
    }

}
