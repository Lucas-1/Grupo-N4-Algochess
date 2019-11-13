package fiuba.algo3.tp2;

public class Curandero extends Entidad {


    public Curandero(Color color, int posFila, int posColumna) {
        atributos = new Atributos(this, color, posFila, posColumna);
    }

    @Override
    public void accionContra(Entidad entidad) {

        if(!this.esDeMiEquipo(entidad))
            throw new NoPuedeCurarEntidadDelOtroEquipo();

        entidad.recibirVida(atributos.getPuntosDePoder());
    }
}
