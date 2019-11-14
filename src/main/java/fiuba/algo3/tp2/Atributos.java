package fiuba.algo3.tp2;

public abstract class Atributos {

    private int puntosDeVida;
    private int costo;
    private int puntosDePoder;
    private Color color;


    protected Atributos(int puntosDeVida, int costo, int puntosDePoder, Color color){

        this.puntosDeVida = puntosDeVida;
        this.costo = costo;
        this.puntosDePoder = puntosDePoder;
        this.color = color;
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

}
