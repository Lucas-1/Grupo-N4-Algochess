package fiuba.algo3.tp2.piezas;

public class AtaqueCercanoStrategy implements AtaqueStrategy {


    @Override
    public void atacar(SoldadoDeInfanteria soldado, Pieza receptor, int danio) {

        receptor.perderVida(danio);

    }

    @Override
    public void atacar(Jinete jinete, Pieza receptor, int danio) {

        // jinete depende de las piezas que lo rodean

    }

    @Override
    public void atacar(Catapulta catapulta, Pieza receptor, int danio) {


        // catapulta no ataca en distancia cercana

    }
}
