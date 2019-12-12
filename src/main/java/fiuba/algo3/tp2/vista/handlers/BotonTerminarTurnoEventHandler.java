package fiuba.algo3.tp2.vista.handlers;

import fiuba.algo3.tp2.juego.Algochess;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonTerminarTurnoEventHandler implements EventHandler<ActionEvent> {
    private Algochess algochess;

    public BotonTerminarTurnoEventHandler(Algochess algochess){
        this.algochess = algochess;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        this.algochess.terminarTurno();
    }
}
