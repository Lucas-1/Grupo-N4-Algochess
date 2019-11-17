package fiuba.algo3.tp2;

import fiuba.algo3.tp2.piezas.Curandero;

public class PuntosDeCuracion {
    private int poderCuracion;

    public PuntosDeCuracion(Curandero curandero){
        poderCuracion = 15;
    }

    public int getPuntosCuracion() {
        return poderCuracion;
    }
}
