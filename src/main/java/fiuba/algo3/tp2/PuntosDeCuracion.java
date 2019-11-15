package fiuba.algo3.tp2;

import fiuba.algo3.tp2.piezas.Curandero;
import fiuba.algo3.tp2.piezas.Saludable;

public class PuntosDeCuracion {
    private int poderCuracion;

    public PuntosDeCuracion(Curandero curandero){
        poderCuracion = 15;
    }

    public int getPuntosCuracion() {
        return poderCuracion;
    }
}
