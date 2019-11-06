package fiuba.algo3.tp2;

public class Soldado_Infanteria extends Entidad {

    public Soldado_Infanteria() {

        costo = 1;
        puntos_de_vida = 100;
        danio = 10;
    }

    public Soldado_Infanteria(int un_color) {

        costo = 1;
        puntos_de_vida = 100;
        danio = 10;
        color = un_color;
    }
}
