package fiuba.algo3.tp2;

public class Atributos {
    private int puntosDeVida;
    private int costo;
    private int puntosDePoder;
    private Color color;


    public Atributos(Catapulta catapulta, Color color){

        costo = 5;
        puntosDeVida = 50;
        puntosDePoder = 20;
        this.color = color;
    }
    public Atributos(Curandero curandero, Color color){

        costo = 2;
        puntosDeVida = 75;
        puntosDePoder = 15;
        this.color = color;

    }
    public Atributos(Jinete jinete, Color color){

        costo = 3;
        puntosDeVida = 100;
        puntosDePoder = 5;
        this.color = color;
    }
    public Atributos(SoldadoDeInfanteria soldadoDeInfanteria, Color color){

        costo = 1;
        puntosDeVida = 100;
        puntosDePoder = 10;
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
