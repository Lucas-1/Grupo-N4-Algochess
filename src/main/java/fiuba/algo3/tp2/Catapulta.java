package fiuba.algo3.tp2;

public class Catapulta extends Entidad {

    public Catapulta(Color color, int posFila, int posColumna) {
        atributos = new Atributos(this, color, posFila, posColumna);
    }

    @Override
    public void recibirVida(int vidaRecibida) {
    }
}
