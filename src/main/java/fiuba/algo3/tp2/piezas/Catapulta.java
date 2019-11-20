package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.Billetera;
import fiuba.algo3.tp2.PiezasContiguas;
import fiuba.algo3.tp2.PuntosDeVida;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.NoPuedeAtacarPiezaDelMismoEquipo;
import fiuba.algo3.tp2.movimiento.Direccion;

import java.util.ArrayList;

public class Catapulta extends Pieza {

    private static final int PRECIO = 5;
    private static final int DANIO = 20;

    public Catapulta(Color color) {

        precio = PRECIO;
        this.color = color;
        puntosDeVida = new PuntosDeVida(this);
        ataqueContext = new AtaqueContext();
    }

    @Override
    public void atacar(Pieza pieza, int distanciaConPieza, ArrayList<Pieza> contiguas) {

        this.setAtaqueContext(distanciaConPieza);
        ataqueContext.atacar(this, pieza,contiguas);
    }

    @Override
    public void recibirVida(int vidaRecibida) {

    }

    @Override
    public void unirseABatallon(PiezasContiguas batallon, Color color) {

    }

    @Override
    public void mover(Direccion direccion) {

    }

    @Override
    public boolean esSoldado() {
        return false;
    }

    public void atacarPieza(Pieza pieza) {

        pieza.perderVida(DANIO);
    }
}
