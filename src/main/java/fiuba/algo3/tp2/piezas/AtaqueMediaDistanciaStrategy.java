package fiuba.algo3.tp2.piezas;

public class AtaqueMediaDistanciaStrategy implements AtaqueStrategy {


    @Override
    public void atacar(SoldadoDeInfanteria soldado, Pieza receptor, int danio) {

        // no ataca a distancia media
    }

    @Override
    public void atacar(Jinete jinete, Pieza receptor, int danio) {

        // depende de las piezas que lo rodean //

    }

    @Override
    public void atacar(Catapulta catapulta, Pieza receptor, int danio) {

        // no ataca en distancia media

    }
}
