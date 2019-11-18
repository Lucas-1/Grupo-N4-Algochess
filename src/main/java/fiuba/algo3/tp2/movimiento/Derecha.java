package fiuba.algo3.tp2.movimiento;

public class Derecha extends Direccion{

    @Override
    public Posicion desplazarPosicion(Posicion posicionActual){
        posicionActual.setColumna(posicionActual.getColumna() + 1);
        return posicionActual;
    }

    @Override
    public Direccion direccionOpuesta(){
        return new Izquierda();
    }

}
