package fiuba.algo3.tp2.piezas;

import java.util.ArrayList;

public class Ataque {

    TipoDeAtaque tipoDeAtaque;

    public void setTipoDeAtaque(TipoDeAtaque tipoDeAtaque) {

        this.tipoDeAtaque = tipoDeAtaque;
    }

    public void atacar(SoldadoDeInfanteria soldado, Pieza receptor, int danio) {

        tipoDeAtaque.atacar(soldado, receptor, danio);
    }

    public void atacar(Jinete jinete, Pieza receptor, int danio) {

        tipoDeAtaque.atacar(jinete,receptor, danio);

    }

    public void atacar(Catapulta catapulta, Pieza receptor,ArrayList<Pieza> contiguas) {

        tipoDeAtaque.atacar(catapulta,receptor,contiguas);

    }

    public void atacar(Curandero curandero, Pieza pieza) {

        tipoDeAtaque.atacar(curandero,pieza);
    }
}
