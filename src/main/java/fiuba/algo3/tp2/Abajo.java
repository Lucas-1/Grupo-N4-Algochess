package fiuba.algo3.tp2;

public class Abajo extends Direccion {

    public Abajo() {

    }

    @Override
    public Posicion desplazarPosicion(Posicion posicionActual){
        posicionActual.setDireccionFila(posicionActual.getDireccionFila() + 1);
        return posicionActual;
    }

    @Override
    public Direccion direccionOpuesta(){
        return new Arriba();
    }
}
