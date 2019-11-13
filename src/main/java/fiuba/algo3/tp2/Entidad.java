package fiuba.algo3.tp2;

public abstract class Entidad {

    protected Atributos atributos;


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

    public int getPosicionX() {
        return atributos.getPosicionX();
    }

    public int getPosicionY() {
        return atributos.getPosicionY();
    }


    public void setPosicion(int nuevaPosicionX,int nuevaPosicionY){
        
        atributos.setPosicionX(nuevaPosicionX);
        atributos.setPosicionY(nuevaPosicionY);
    }
}
