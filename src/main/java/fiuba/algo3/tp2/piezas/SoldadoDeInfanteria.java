package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.PuntosDeAtaque;
import fiuba.algo3.tp2.PuntosDeVida;
import fiuba.algo3.tp2.colores.Color;

public class SoldadoDeInfanteria extends Danina {

    private static final int PRECIO = 1;

    public SoldadoDeInfanteria(Color color) {
        this.precio = PRECIO;
        this.color = color;
        this.puntosDeAtaque = new PuntosDeAtaque(this);
        this.puntosDeVida = new PuntosDeVida(this);
    }
}
