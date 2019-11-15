package fiuba.algo3.tp2;

import fiuba.algo3.tp2.piezas.Catapulta;
import fiuba.algo3.tp2.piezas.Jinete;
import fiuba.algo3.tp2.piezas.SoldadoDeInfanteria;

public class PuntosDeAtaque {
    private int poderAtaque;

    public PuntosDeAtaque(SoldadoDeInfanteria soldado){
        poderAtaque = 10;
    }
    public PuntosDeAtaque(Jinete jinete){
        poderAtaque = 5;
    }
    public PuntosDeAtaque(Catapulta catapulta){
        poderAtaque = 20;
    }

    public int getDanioDelAtaque() {
        return poderAtaque;
    }
}
