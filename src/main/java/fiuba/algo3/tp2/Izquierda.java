package fiuba.algo3.tp2;

public class Izquierda extends Direccion {

    public Izquierda(){


    }

    @Override
    public Posicion desplazarPosicion(Posicion posicionActual){
        posicionActual.setDireccionX(posicionActual.getDireccionX() - 1);
        return posicionActual;
    }

    @Override
    public Direccion direccionOpuesta(){
        return new Derecha();
    }
}
