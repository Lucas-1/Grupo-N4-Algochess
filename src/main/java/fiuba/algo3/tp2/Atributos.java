package fiuba.algo3.tp2;

public class Atributos {
    private int posicionX;
    private int posicionY;
    private int puntosDeVida;
    private int costo;
    private int puntosDePoder;
    private int color; /** 1 jugador blanco |  2 jugador negro */


    public Atributos(Catapulta catapulta, int color){

        costo = 5;
        puntosDeVida = 50;
        puntosDePoder = 20;
        this.color = color;
    }
    public Atributos(Curandero curandero, int color){

        costo = 2;
        puntosDeVida = 75;
        puntosDePoder = 15;
        this.color = color;

    }
    public Atributos(Jinete jinete, int color){

        costo = 3;
        puntosDeVida = 100;
        puntosDePoder = 5;
        this.color = color;
    }
    public Atributos(SoldadoDeInfanteria soldadoDeInfanteria, int color){

        costo = 1;
        puntosDeVida = 100;
        puntosDePoder = 10;
        this.color = color;
    }

    public int getColor() {
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

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionX(int nuevaPosicionX) {
        this.posicionX = nuevaPosicionX;
    }

    public void setPosicionY(int nuevaPosicionY) {
        this.posicionY = nuevaPosicionY;
    }
}
