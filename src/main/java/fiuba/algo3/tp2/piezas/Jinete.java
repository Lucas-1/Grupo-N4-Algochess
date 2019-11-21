package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.Billetera;
import fiuba.algo3.tp2.PiezasContiguas;
import fiuba.algo3.tp2.PuntosDeVida;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.NoPuedeAtacarPiezaDelMismoEquipo;

import java.util.ArrayList;

public class Jinete extends Danina {

    private static final int PRECIO = 3;
    private static int DANIO_JINETE = 15;

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


        ataque.atacar(this, pieza, DANIO_JINETE, this.rangoDeAlcance);
    }

    @Override
    public void unirseABatallon(Batallon batallon, Color color) {

    }

    @Override
    public boolean esSoldado() {
        return false;
    }

    protected void setRangoCercano(){
        this.rangoDeAlcance = new RangoDeAlcanceCercano();
    }

    protected void setRangoMediaDistancia(){
        this.rangoDeAlcance = new RangoDeAlcanceMediaDistancia();
    }

    public void setRangoJineteCercano(Jinete jinete){
        if(!jinete.esDeMiEquipo(this) && jinete != this){
            jinete.setDanio(5);
            jinete.setRangoCercano();
        }
    }

    public void setDanio(int danio){
        this.DANIO_JINETE = danio;
    }

    public static int getDanio() {
        return DANIO_JINETE;
    }

}



