package fiuba.algo3.tp2;

public abstract class Entidad {

    protected Atributos atributos;
    protected Movimiento mov;
    protected Posicion posicion;


    public void accionContra(Entidad entidad) {

        if(this.esDeMiEquipo(entidad))
            throw new NoPuedeAtacarEntidadDelMismoEquipo();

        entidad.sacarVida(atributos.getPuntosDePoder());
    }

    public void sacarVida(int danioRecibido) {

        if(atributos.estoyMuerta())
            throw new EntidadEstaMuertaException();

        atributos.sacarVida(danioRecibido);
    }

    public void recibirVida(int vidaRecibida) {

        if(atributos.estoyMuerta())
            throw new EntidadEstaMuertaException();

        atributos.recibirVida(vidaRecibida);
    }

    public boolean esDeMiEquipo(Entidad otraEntidad) {

        Color miColor = this.getColor();
        Color suColor = otraEntidad.getColor();

        return miColor.esDelMismoColor(suColor);

    }


    public Color getColor() {
        return atributos.getColor();
    }

    public int getCosto() {
        return atributos.getCosto();
    }

    public int getPuntosDeVida() {
        return atributos.getPuntosDeVida();
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
}
