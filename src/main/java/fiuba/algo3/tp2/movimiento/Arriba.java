package fiuba.algo3.tp2.movimiento;

public class Arriba extends Direccion {

    public Arriba() {

    }

    @Override
    public Posicion desplazarPosicion(Posicion posicionActual){

        posicionActual.setFila(posicionActual.getFila() - 1);
        return posicionActual;
    }

    @Override
    public Direccion direccionOpuesta(){
        return new Abajo();
    }
}
