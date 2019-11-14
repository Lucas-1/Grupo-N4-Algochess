package fiuba.algo3.tp2;

public class Curandero extends Entidad {


    public Curandero(Color color) {
        atributos = new AtributosCurandero(color);
    }

    @Override
    public void accionContra(Entidad entidad) {

        if(!this.esDeMiEquipo(entidad))
            throw new NoPuedeCurarEntidadDelOtroEquipo();

        entidad.recibirVida(atributos.getPuntosDePoder());
    }
}
