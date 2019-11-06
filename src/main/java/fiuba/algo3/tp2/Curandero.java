package fiuba.algo3.tp2;

public class Curandero extends Entidad {


    public Curandero() {

        costo = 2;
        puntos_de_vida = 75;
        danio = -15; // cura 15 puntos de vida.

    }

    public Curandero(int un_color) {

        costo = 2;
        puntos_de_vida = 75;
        danio = -15; // cura 15 puntos de vida.
        color = un_color;

    }

}
