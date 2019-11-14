package fiuba.algo3.tp2;

public class Derecha extends Direccion{

    public Derecha(){


    }

    @Override
    public Posicion desplazarPosicion(Posicion posicionActual){
        posicionActual.setDireccionX(posicionActual.getDireccionX() + 1);
        return posicionActual;
    }

    @Override
    public Direccion direccionOpuesta(){
        return new Izquierda();
    }

}
