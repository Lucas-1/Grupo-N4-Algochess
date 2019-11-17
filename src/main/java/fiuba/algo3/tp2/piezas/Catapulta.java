package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.PuntosDeVida;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.NoPuedeAtacarPiezaDelMismoEquipo;
import fiuba.algo3.tp2.movimiento.Direccion;

public class Catapulta extends Pieza {

    private static final int PRECIO = 5;
    private int danio;

    public Catapulta(Color color) {
        this.precio = PRECIO;
        this.color = color;
        this.puntosDeVida = new PuntosDeVida(this);
        danio = 20;
    }

    @Override
    public void atacar(Pieza pieza, int distanciaConPieza) {

    }

    @Override
    public void recibirVida(int vidaRecibida) {
    }

    @Override
    public void mover(Direccion dir){

    }

    public void atacarPieza(Pieza pieza) {

        if(this.esDeMiEquipo(pieza))
            throw new NoPuedeAtacarPiezaDelMismoEquipo();

        pieza.perderVida(danio);
    }
}
