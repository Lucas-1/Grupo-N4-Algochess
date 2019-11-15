package fiuba.algo3.tp2.movimiento;

public class Posicion {

    private int direccionFila;
    private int direccionColumna;

    public Posicion (int dirFila, int dirCol){
        direccionColumna = dirCol;
        direccionFila = dirFila;
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
