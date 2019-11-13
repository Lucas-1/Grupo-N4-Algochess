package fiuba.algo3.tp2;

public class Blanco implements Color{


    public boolean esBlanco() {
        return true;
    }

    public boolean esNegro() {
        return false;
    }

    public boolean esDelMismoColor(Color unColor) {
        return unColor.esBlanco();
    }

}
