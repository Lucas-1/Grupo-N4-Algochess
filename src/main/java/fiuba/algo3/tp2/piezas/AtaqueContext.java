package fiuba.algo3.tp2.piezas;

public class AtaqueContext {

    AtaqueStrategy ataqueStrategy;

    public void setAtaqueStrategy(AtaqueStrategy ataqueStrategy) {

        this.ataqueStrategy = ataqueStrategy;
    }

    public void atacar(SoldadoDeInfanteria soldado, Pieza receptor, int danio) {

        ataqueStrategy.atacar(soldado, receptor, danio);
    }

    public void atacar(Jinete jinete, Pieza receptor, int danio) {

        ataqueStrategy.atacar(jinete,receptor, danio);

    }

    public void atacar(Catapulta catapulta, Pieza receptor, int danio) {

        ataqueStrategy.atacar(catapulta,receptor, danio);

    }

}
