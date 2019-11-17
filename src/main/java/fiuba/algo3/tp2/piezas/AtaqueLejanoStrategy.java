package fiuba.algo3.tp2.piezas;

public class AtaqueLejanoStrategy implements AtaqueStrategy {

    @Override
    public void atacar(SoldadoDeInfanteria soldado, Pieza receptor, int danio) {

        // no ataca distancia lejos

    }

    @Override
    public void atacar(Jinete jinete, Pieza receptor, int danio) {

        // no ataca distancia lejos
    }

    @Override
    public void atacar(Catapulta catapulta, Pieza receptor, int danio) {

        catapulta.atacarPieza(receptor);
    }
}
