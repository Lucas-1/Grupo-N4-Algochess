package fiuba.algo3.tp2.movimiento;

import fiuba.algo3.tp2.colores.Color;

public class Posicion {

    private int direccionFila;
    private int direccionColumna;

    public Posicion (int dirFila, int dirCol){
        direccionColumna = dirCol;
        direccionFila = dirFila;
    }

    public int calcularDistancia(Posicion posicion) {

        int distanciaColumna = Math.abs(direccionColumna - posicion.getDireccionColumna());
        int distanciaFila = Math.abs(direccionFila - posicion.getDireccionFila());

        System.out.println(distanciaColumna + distanciaFila);
        return distanciaColumna + distanciaFila;
    }

    public boolean estoyDelLadoEnemigo(Color color) {

        if(direccionFila >= 10  & color.esBlanco())
            return true;

        if(direccionFila <= 9 & color.esNegro())
            return true;

        return false;
    }

    public int getDireccionColumna() {

        return direccionColumna;
    }

    public void setDireccionColumna(int direccionColumna) {

        this.direccionColumna = direccionColumna;
    }

    public int getDireccionFila() {

        return direccionFila;
    }

    public void setDireccionFila(int direccionFila) {

        this.direccionFila = direccionFila;
    }
}
