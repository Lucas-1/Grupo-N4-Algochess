package fiuba.algo3.tp2.colores;

public class Negro implements Color {

    @Override
    public boolean esBlanco() {
        return false;
    }

    @Override
    public boolean esNegro() {
        return true;
    }

    @Override
    public boolean esDelMismoColor(Color unColor) {
        return unColor.esNegro();
    }

}
