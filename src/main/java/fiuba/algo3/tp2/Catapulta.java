package fiuba.algo3.tp2;

public class Catapulta extends Entidad {

    public Catapulta(int un_color) {

        costo = 5;
        puntos_de_vida = 50;
        danio = 20;
        color = un_color;
    }

    @Override
    public void recibirVida(int vida_recibida) {

        // no hace nada. Catapulta no se puede curar.

    }
}
