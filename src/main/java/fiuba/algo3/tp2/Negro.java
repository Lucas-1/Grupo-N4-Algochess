package fiuba.algo3.tp2;

public class Negro implements Color {

    public boolean esBlanco() {
        return false;
    }

    public boolean esNegro() {
        return true;
    }

    public boolean esDelMismoColor(Color unColor) {
        return unColor.esNegro();
    }

}
