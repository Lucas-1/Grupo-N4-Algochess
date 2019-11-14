package fiuba.algo3.tp2;

public class Abajo extends Direccion {

    public Abajo() {

    }

    @Override
    public Posicion desplazarPosicion(Posicion posicionActual){
        posicionActual.setDireccionY(posicionActual.getDireccionY() - 1);
        return posicionActual;
    }

    @Override
    public Direccion direccionOpuesta(){
        return new Arriba();
    }
}
