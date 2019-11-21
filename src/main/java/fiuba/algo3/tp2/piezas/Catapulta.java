package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.PiezasContiguas;
import fiuba.algo3.tp2.PuntosDeVida;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.movimiento.Posicion;

import java.util.ArrayList;

public class Catapulta extends Pieza {

    private static final int PRECIO = 5;
    private static final int DANIO = 20;

    public Catapulta(Color color) {

        precio = PRECIO;
        this.color = color;
        puntosDeVida = new PuntosDeVida(this);
        ataque = new Ataque();
    }

    @Override
    public void atacar(Pieza pieza, int distanciaConPieza, ArrayList<Pieza> contiguas) {

        this.setAtaque(distanciaConPieza);
        ataque.atacar(this, pieza,contiguas);
    }

    @Override
    public void recibirVida(int vidaRecibida) {

    }

    @Override
    public void unirseABatallon(PiezasContiguas batallon, Color color) {

    }

    @Override
    public void moverA(Posicion posicionNueva) {

    }

    @Override
    public boolean esSoldado() {
        return false;
    }

    public void atacarPieza(Pieza pieza) {

        pieza.perderVida(DANIO);
    }
}
