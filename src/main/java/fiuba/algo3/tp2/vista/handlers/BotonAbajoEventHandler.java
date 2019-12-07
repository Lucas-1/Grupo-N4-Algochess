package fiuba.algo3.tp2.vista.handlers;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.juego.Algochess;
import fiuba.algo3.tp2.movimiento.Direccion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAbajoEventHandler implements EventHandler<ActionEvent> {

    Algochess algochess;
    Pieza pieza;

    public BotonAbajoEventHandler(Algochess algochess){
        this.algochess = algochess;
        this.pieza = null;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        algochess.moverPieza(pieza, Direccion.abajo());
    }
    public void setPieza(Pieza pieza){
        this.pieza = pieza;
    }
}