package fiuba.algo3.tp2;

import fiuba.algo3.tp2.piezas.Catapulta;
import fiuba.algo3.tp2.piezas.Curandero;
import fiuba.algo3.tp2.piezas.Jinete;
import fiuba.algo3.tp2.piezas.SoldadoDeInfanteria;

public class PuntosDeVida {
    private int vidaActual;

    public PuntosDeVida(SoldadoDeInfanteria soldado){
        vidaActual = 100;
    }
    public PuntosDeVida(Jinete jinete){
        vidaActual = 100;
    }
    public PuntosDeVida(Catapulta catapulta){
        vidaActual = 50;
    }
    public PuntosDeVida(Curandero curandero){
        vidaActual = 75;
    }


    public void restarPuntos(int puntos){
        vidaActual -= puntos;
    }
    public void aumentarPuntos(int puntos){
        vidaActual += puntos;
    }
    public int getVidaRestante() {
        return vidaActual;
    }
    public boolean estoyMuerta() {
        return (vidaActual <= 0);
    }
}
