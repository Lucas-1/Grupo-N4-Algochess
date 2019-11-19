package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.*;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.PiezaEstaMuertaException;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;

import java.util.ArrayList;

public abstract class Pieza {

    protected PuntosDeVida puntosDeVida;
    protected Color color;
    protected int precio;
    protected Posicion posicion;
    protected AtaqueContext ataqueContext;


    public abstract void atacar(Pieza pieza, int distanciaConPieza, ArrayList<Pieza> contiguas);

    public void setAtaqueContext(int distanciaConPieza) {

        if(distanciaConPieza < 3) {
            ataqueContext.setAtaqueStrategy(new AtaqueCercanoStrategy());
        } else if(distanciaConPieza < 6) {
            ataqueContext.setAtaqueStrategy(new AtaqueMediaDistanciaStrategy());
        } else {
            ataqueContext.setAtaqueStrategy(new AtaqueLejanoStrategy());
        }
    }

    public void perderVida(int danioRecibido) {

        if(puntosDeVida.estoyMuerta())
            throw new PiezaEstaMuertaException();

        puntosDeVida.quitarVida(danioRecibido);
    }

    public void recibirVida(int vidaRecibida) {

        if(puntosDeVida.estoyMuerta())
            throw new PiezaEstaMuertaException();

        puntosDeVida.aumentarVida(vidaRecibida);
    }

    public int calcularDistancia(Posicion posPieza) {

        return posicion.calcularDistancia(posPieza);
    }

    public boolean esDeMiEquipo(Pieza otraPieza) {

        return color.esDelMismoColor(otraPieza.getColor());
    }

    public boolean estoyDelLadoEnemigo() {

        return posicion.estoyDelLadoEnemigo(color);
    }


    public Color getColor() {
        return color;
    }

    public int getPuntosDeVida() {
        return puntosDeVida.getVidaRestante();
    }

    public Posicion getPosicion() {
        return this.posicion;
    }


    public void mover(Direccion direccion) {

        posicion = direccion.calcularSiguientePosicion(posicion);
    }

    public void setPosicion(Posicion posicion) {

        this.posicion = posicion;
    }

    public Pieza serComprada(Billetera billetera) {
        billetera.retirarDinero(this.precio);
        return this;
    }
}
