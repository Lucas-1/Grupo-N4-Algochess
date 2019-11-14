package fiuba.algo3.tp2;

public class Arriba extends Direccion {

    public Arriba() {

    }

    @Override
    public Posicion desplazarPosicion(Posicion posicionActual){
        posicionActual.setDireccionY(posicionActual.getDireccionY() + 1);
        return posicionActual;
    }

    @Override
    public Direccion direccionOpuesta(){
        return new Abajo();
    }
}
