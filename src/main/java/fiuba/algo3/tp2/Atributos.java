package fiuba.algo3.tp2;

public class Atributos {

    private int posicionColumna;
    private int posicionFila;
    private int puntosDeVida;
    private int costo;
    private int puntosDePoder;
    private Color color;


    public Atributos(Catapulta catapulta, Color color, int posicionFila, int posicionColumna){

        costo = 5;
        puntosDeVida = 50;
        puntosDePoder = 20;
        this.color = color;
        this.setPosicionFila(posicionFila);
        this.setPosicionColumna(posicionColumna);
    }
    public Atributos(Curandero curandero, Color color, int posicionFila, int posicionColumna){

        costo = 2;
        puntosDeVida = 75;
        puntosDePoder = 15;
        this.color = color;
        this.setPosicionColumna(posicionColumna);
        this.setPosicionFila(posicionFila);
    }

    public Atributos(Jinete jinete, Color color, int posicionFila, int posicionColumna){

        costo = 3;
        puntosDeVida = 100;
        puntosDePoder = 5;
        this.color = color;
        this.setPosicionFila(posicionFila);
        this.setPosicionColumna(posicionColumna);
    }

    public Atributos(SoldadoDeInfanteria soldadoDeInfanteria, Color color, int posicionFila, int posicionColumna){

        costo = 1;
        puntosDeVida = 100;
        puntosDePoder = 10;
        this.color = color;
        this.setPosicionColumna(posicionColumna);
        this.setPosicionFila(posicionFila);
    }

    public Color getColor() {
        return color;
    }

    public int getPuntosDePoder() {
        return puntosDePoder;
    }

    public boolean estoyMuerta() {
        return (puntosDeVida <= 0);
    }

    public void sacarVida(int danioRecibido) {
        puntosDeVida -= danioRecibido;
    }

    public void recibirVida(int vidaRecibida) {
        puntosDeVida += vidaRecibida;
    }

    public int getCosto() { return costo; }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }

    public int getPosicionColumna() {
        return posicionColumna;
    }

    public int getPosicionFila() {
        return posicionFila;
    }

    public void setPosicionColumna(int nuevaPosicionColumna) {
        this.posicionColumna = nuevaPosicionColumna;
    }

    public void setPosicionFila(int nuevaPosicionFila) {
        this.posicionFila = nuevaPosicionFila;
    }
}
