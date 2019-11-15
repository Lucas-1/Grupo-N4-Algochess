package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.*;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.EntidadEstaMuertaException;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Movimiento;
import fiuba.algo3.tp2.movimiento.Posicion;

public abstract class Pieza {

    protected PuntosDeVida puntosDeVida;
    protected Color color;
    protected int precio;
    protected Movimiento mov;
    protected Posicion posicion;


    public void perderVida(int danioRecibido) {

        if(puntosDeVida.estoyMuerta())
            throw new EntidadEstaMuertaException();

        puntosDeVida.restarPuntos(danioRecibido);
    }

    public void recibirVida(int vidaRecibida) {

        if(puntosDeVida.estoyMuerta())
            throw new EntidadEstaMuertaException();

        puntosDeVida.aumentarPuntos(vidaRecibida);
    }

    public boolean esDeMiEquipo(Pieza otraPieza) {

        Color miColor = this.getColor();
        Color suColor = otraPieza.getColor();

        return miColor.esDelMismoColor(suColor);

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


    public void setPosicion(int nuevaPosicionFila,int nuevaPosicionColumna){

        this.posicion = new Posicion(nuevaPosicionFila,nuevaPosicionColumna);
        this.mov = new Movimiento();
    }

    public void mover(Direccion dir){
        this.mov.establecerDireccion(dir);
        this.posicion = this.mov.calcularPosicionSiguiente(this.posicion);
    }

    public Pieza serComprada(Billetera billetera) {
        billetera.retirarDinero(this.precio);
        return this;
    }
}
