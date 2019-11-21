package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.PuntosDeVida;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.NoPuedeAtacarPiezaDelMismoEquipo;

import java.util.ArrayList;

public class SoldadoDeInfanteria extends Danina {

    private static final int PRECIO = 1;
    private static final int DANIO_SOLDADO = 10;

    public SoldadoDeInfanteria(Color color) {

        this.precio = PRECIO;
        this.color = color;
        puntosDeVida = new PuntosDeVida(this);
        ataque = new Ataque();
    }

    public void atacar(Pieza pieza, int distanciaConPieza, ArrayList<Pieza> contiguas) {

        this.setRangoDeAlcance(distanciaConPieza);

        if (this.esDeMiEquipo(pieza))
            throw new NoPuedeAtacarPiezaDelMismoEquipo();

        ataque.atacar(this, pieza, DANIO_SOLDADO, this.rangoDeAlcance);

    }

    @Override
    public void unirseABatallon(Batallon batallon, Color color) {

        if(!batallon.estaLleno() && color.esDelMismoColor(this.color))
            batallon.agregar(this);
    }

    @Override
    public boolean esSoldado() {
        return  true;
    }
}
