package fiuba.algo3.tp2;

public class Blanco implements Color{

    @Override
    public boolean esBlanco() {
        return true;
    }

    @Override
    public boolean esNegro() {
        return false;
    }

    @Override
    public boolean esDelMismoColor(Color unColor) {
        return unColor.esBlanco();
    }

}
