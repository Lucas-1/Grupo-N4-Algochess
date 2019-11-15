package fiuba.algo3.tp2.movimiento;

import fiuba.algo3.tp2.movimiento.Derecha;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;

public class Izquierda extends Direccion {

    @Override
    public Posicion desplazarPosicion(Posicion posicionActual){
        posicionActual.setDireccionColumna(posicionActual.getDireccionColumna() - 1);
        return posicionActual;
    }

    @Override
    public Direccion direccionOpuesta(){
        return new Derecha();
    }
}
