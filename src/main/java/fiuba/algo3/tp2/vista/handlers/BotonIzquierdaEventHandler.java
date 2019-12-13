package fiuba.algo3.tp2.vista.handlers;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.juego.Algochess;
import fiuba.algo3.tp2.movimiento.Direccion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class BotonIzquierdaEventHandler implements EventHandler<ActionEvent> {

    private final Stage stage;
    private Algochess algochess;
    private Pieza pieza;

    public BotonIzquierdaEventHandler(Algochess algochess, Stage stage){
        this.algochess = algochess;
        this.pieza = null;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        algochess.moverPieza(pieza, Direccion.izquierda());
        algochess.getTablero().notifyObservers();

        final Popup popup = new Popup();
        popup.setAutoFix(true);
        popup.setAnchorX(1440);
        popup.setAnchorY(180);
        popup.setAutoHide(true);
        popup.setHideOnEscape(true);
        Label popupText = new Label( "Moviste la pieza a la izquierda");
        popupText.getStylesheets().add("css/popup.css");
        popup.getContent().addAll(popupText);
        popup.show(stage);
    }

    public void setPieza(Pieza pieza){
        this.pieza = pieza;
    }
}
