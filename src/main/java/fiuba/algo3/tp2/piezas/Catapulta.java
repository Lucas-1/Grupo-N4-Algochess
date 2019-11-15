package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.PuntosDeAtaque;
import fiuba.algo3.tp2.PuntosDeVida;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.movimiento.Direccion;

public class Catapulta extends Danina {

    private static final int PRECIO = 5;

    public Catapulta(Color color) {
        this.precio = PRECIO;
        this.color = color;
        this.puntosDeAtaque = new PuntosDeAtaque(this);
        this.puntosDeVida = new PuntosDeVida(this);
    }

    @Override
    public void recibirVida(int vidaRecibida) {
    }

    @Override
    public void mover(Direccion dir){

    }
}
