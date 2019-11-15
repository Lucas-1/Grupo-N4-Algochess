package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.PuntosDeCuracion;
import fiuba.algo3.tp2.PuntosDeVida;
import fiuba.algo3.tp2.colores.Color;

public class Curandero extends Saludable {

    private static final int PRECIO = 2;

    public Curandero(Color color) {
        this.precio = PRECIO;
        this.color = color;
        this.puntosDeCuracion = new PuntosDeCuracion(this);
        this.puntosDeVida = new PuntosDeVida(this);
    }
}
