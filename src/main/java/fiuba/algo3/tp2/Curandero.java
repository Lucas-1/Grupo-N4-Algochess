package fiuba.algo3.tp2;

public class Curandero extends Entidad {


    public Curandero(int un_color) {

        costo = 2;
        puntos_de_vida = 75;
        danio = 15; // cura 15 puntos de vida.
        color = un_color;

    }

        @Override
        public void atacar(Entidad una_entidad) {

            if(color != una_entidad.getColor())
                throw new NoPuedeCurarEntidadDelOtroEquipo();

            una_entidad.recibirVida(danio);
        }
}
