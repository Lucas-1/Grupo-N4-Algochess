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

    public boolean esContigua(Posicion posicion) {

        int distancia = this.calcularDistancia(posicion);
        return (distancia <= 1);
    }

    public boolean esValida() {

        return ((posicionFila >= 0 && posicionFila < 20) && (posicionColumna >= 0 && posicionColumna < 20));
    }

    public int getPosicionColumna() {

        return posicionColumna;
    }

    public int getPosicionFila() {

        return posicionFila;
    }

}
