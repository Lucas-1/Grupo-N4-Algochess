package fiuba.algo3.tp2.movimiento;

public class Abajo extends Direccion {

    public Abajo() {

    }

    @Override
    public Posicion desplazarPosicion(Posicion posicionActual){
        posicionActual.setFila(posicionActual.getFila() + 1);
        return posicionActual;
    }

    @Override
    public Direccion direccionOpuesta(){
        return new Arriba();
    }
}
