package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.PuntosDeAtaque;
import fiuba.algo3.tp2.PuntosDeVida;
import fiuba.algo3.tp2.colores.Color;

public class Jinete extends Danina {

    private static final int PRECIO = 3;

    public Jinete(Color color) {
        this.precio = PRECIO;
        this.color = color;
        this.puntosDeAtaque = new PuntosDeAtaque(this);
        this.puntosDeVida = new PuntosDeVida(this);
    }


}
