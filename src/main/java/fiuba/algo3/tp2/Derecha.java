package fiuba.algo3.tp2;

public class Derecha extends Direccion{

    @Override
    public Posicion desplazarPosicion(Posicion posicionActual){
        posicionActual.setDireccionColumna(posicionActual.getDireccionColumna() + 1);
        return posicionActual;
    }

    @Override
    public Direccion direccionOpuesta(){
        return new Izquierda();
    }

}
