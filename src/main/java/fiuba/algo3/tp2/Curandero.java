package fiuba.algo3.tp2;

public class Curandero extends Entidad {


    public Curandero(int color) {
        atributos = new Atributos(this, color);
    }

    @Override
    public void accionContra(Entidad entidad) {

        if(atributos.getColor() != entidad.getColor())
            throw new NoPuedeCurarEntidadDelOtroEquipo();

        entidad.recibirVida(atributos.getPuntosDePoder());
    }
}
