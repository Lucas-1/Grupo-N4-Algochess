package fiuba.algo3.tp2;

import fiuba.algo3.tp2.piezas.*;

public class Tienda {

    public Pieza comprarPieza(Pieza pieza, Billetera billetera){

        return pieza.serComprada(billetera);
    }

}
