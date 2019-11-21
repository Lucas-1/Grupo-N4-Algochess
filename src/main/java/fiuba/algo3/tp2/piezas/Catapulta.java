package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.PuntosDeVida;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.movimiento.Posicion;

import java.util.ArrayList;

public class Catapulta extends Danina {

    private static final int PRECIO = 5;
    private static final int DANIO_CATAPULTA = 20;

    public Catapulta(Color color) {

        precio = PRECIO;
        this.color = color;
        puntosDeVida = new PuntosDeVida(this);
        ataque = new Ataque();
    }

    @Override
    public void atacar(Pieza pieza, int distanciaConPieza, ArrayList<Pieza> contiguas) {

        this.setRangoDeAlcance(distanciaConPieza);
        ataque.atacar(this, pieza,contiguas, this.rangoDeAlcance);
    }

    @Override
    public void recibirVida(int vidaRecibida) {

    }

    @Override
    public void unirseABatallon(Batallon batallon, Color color) {

    }

    @Override
    public void moverA(Posicion posicionNueva) {

    }

    @Override
    public boolean esSoldado() {
        return false;
    }

    public static int getDanio() {
        return DANIO_CATAPULTA;
    }

    @Override

    public void setRangoJineteCercano(Jinete jinete){
        if(!jinete.esDeMiEquipo(this)){
            jinete.setDanio(5);
            jinete.setRangoCercano();
        }
    }
}
