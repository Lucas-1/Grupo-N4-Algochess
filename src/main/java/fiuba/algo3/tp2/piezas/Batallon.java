package fiuba.algo3.tp2.piezas;

import fiuba.algo3.tp2.Tablero;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;

import java.util.ArrayList;

public class Batallon {

    private final int TAMANIO_MAX_BATALLON = 3;

    private ArrayList<Pieza> soldados;

    public Batallon() {

        soldados = new ArrayList<Pieza>();
    }

    public boolean estaCompleto() {

        return (soldados.size() == TAMANIO_MAX_BATALLON);
    }

    public void moverSoldadosEnBatallon(Tablero tablero, Direccion direccion) {

        for(int i = 0; i<TAMANIO_MAX_BATALLON; i++)
            tablero.moverPieza(soldados.get(i),direccion);
    }

    public void armadoBatallon(Pieza pieza, Direccion direccion, ArrayList<Pieza> piezas) {

        soldados.clear();
        pieza.unirseABatallon(this,pieza);

        int i = 0;
        while(i < soldados.size()) {

            Pieza soldadoActual = soldados.get(i);
            for(int j = 0; j<piezas.size(); j++)
                (piezas.get(j)).unirseABatallon(this,soldadoActual);
            i++;
        }
    }

    public void moverBatallon(Pieza pieza, Direccion direccion, Tablero tablero) {

        if(this.estaCompleto())
            this.moverSoldadosEnBatallon(tablero, direccion);
         else
            tablero.moverPieza(pieza,direccion);
    }

    public boolean contiene(Pieza pieza) {

        return soldados.contains(pieza);
    }

    public void agregar(Pieza pieza) {

        if(!this.contiene(pieza) && !this.estaCompleto())
            soldados.add(pieza);
    }

}
