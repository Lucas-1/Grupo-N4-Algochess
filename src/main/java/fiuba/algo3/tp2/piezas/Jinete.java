package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.PuntosDeVida;
import fiuba.algo3.tp2.TipoDeBatallon;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.NoPuedeAtacarPiezaDelMismoEquipo;

import java.util.ArrayList;

public class Jinete extends Danina {

    private static final int PRECIO = 3;

    public Jinete(Color color) {
        this.precio = PRECIO;
        this.color = color;
        this.puntosDeVida = new PuntosDeVida(this);
        ataque = new Ataque();
    }


    @Override
    public void atacar(Pieza pieza, int distanciaConPieza, ArrayList<Pieza> contiguas) {

        this.setRangoMediaDistancia();

        int i = 0;
        while (i < contiguas.size()){
            contiguas.get(i).setRangoJineteCercano(this);
            i++;
        }


        if(this.esDeMiEquipo(pieza))
            throw new NoPuedeAtacarPiezaDelMismoEquipo();


        ataque.atacar(this, pieza, this.rangoDeAlcance);
    }

    public void atacar(Pieza pieza, TipoDeAtaque tipoDeAtaque){
        tipoDeAtaque.atacar(pieza);
    }

    @Override
    public void atacar(Pieza pieza) {
    }

    @Override
    public void unirseABatallonHorizontal(TipoDeBatallon batallon, Pieza pieza) {

    }
    @Override
    public void unirseABatallonVertical(TipoDeBatallon batallon, Pieza pieza) {

    }

    protected void setRangoCercano(){
        this.rangoDeAlcance = new RangoDeAlcanceCercano();
    }

    protected void setRangoMediaDistancia(){
        this.rangoDeAlcance = new RangoDeAlcanceMediaDistancia();
    }

    public void setRangoJineteCercano(Jinete jinete){

        if(!jinete.esDeMiEquipo(this) && jinete != this){
            jinete.setRangoCercano();
        }
    }

}



