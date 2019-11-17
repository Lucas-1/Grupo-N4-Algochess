package fiuba.algo3.tp2.piezas;

public interface AtaqueStrategy {

    public void atacar(SoldadoDeInfanteria soldado, Pieza receptor, int danio);

    public void atacar(Jinete jinete, Pieza receptor, int danio);

    public void atacar(Catapulta catapulta, Pieza receptor, int danio);



}
