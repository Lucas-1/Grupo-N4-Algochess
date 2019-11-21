package fiuba.algo3.tp2.piezas;

import java.util.ArrayList;

public class Ataque {


    public void atacar(SoldadoDeInfanteria soldado, Pieza receptor, int danio, RangoDeAlcance rangoDeAlcance) {

        rangoDeAlcance.atacar(soldado, receptor, danio);
    }

    public void atacar(Jinete jinete, Pieza receptor, int danio, RangoDeAlcance rangoDeAlcance) {

        rangoDeAlcance.atacar(jinete,receptor, danio);

    }

    public void atacar(Catapulta catapulta, Pieza receptor,ArrayList<Pieza> contiguas, RangoDeAlcance rangoDeAlcance) {

        rangoDeAlcance.atacar(catapulta,receptor,contiguas);

    }

    public void curar(Curandero curandero, Pieza pieza, RangoDeAlcance rangoDeAlcance) {

        rangoDeAlcance.curar(curandero,pieza);
    }
}
