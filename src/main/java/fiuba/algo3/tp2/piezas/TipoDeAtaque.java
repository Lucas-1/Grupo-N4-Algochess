package fiuba.algo3.tp2.piezas;

import java.util.ArrayList;

public interface TipoDeAtaque {

    public void atacar(SoldadoDeInfanteria soldado, Pieza receptor, int danio);

    public void atacar(Jinete jinete, Pieza receptor, int danio);

    public void atacar(Catapulta catapulta, Pieza receptor, ArrayList<Pieza> contiguas);

    public void atacar(Curandero curandero, Pieza pieza);
}
