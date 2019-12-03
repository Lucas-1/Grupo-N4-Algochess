package fiuba.algo3.tp2;

import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.excepciones.CasilleroDeLadoEnemigoException;
import fiuba.algo3.tp2.excepciones.CasilleroEstaOcupadoException;
import fiuba.algo3.tp2.piezas.Pieza;

public class Casillero {

    private Color color;
    private Pieza pieza;

    public Casillero(Color color) {

        this.color = color;
        pieza = null;
    }

    public boolean puedoAgregarla(Color unColor) {
        try {
            if(pieza != null)
                throw new CasilleroEstaOcupadoException("No podes colocar una pieza en un casillero ocupado");


            if (!color.esDelMismoColor(unColor))
                throw new CasilleroDeLadoEnemigoException("No podes colocar piezas en el lado enemigo");
        }catch (CasilleroEstaOcupadoException | CasilleroDeLadoEnemigoException e){
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public void agregarPieza(Pieza pieza) {

       if(this.puedoAgregarla(pieza.getColor()))
           this.pieza = pieza;

    }

    public void setPieza(Pieza pieza) {

        this.pieza = pieza;
    }

    public void borrarPieza() {

        pieza = null;
    }

    public Pieza getPieza() {

        return pieza;
    }

    public boolean estaOcupado() {

        return pieza != null;
    }

    public void agregarPiezaAContiguos(PiezasContiguas contiguas) {

        if(pieza != null)
            contiguas.agregar(pieza);
    }
}
