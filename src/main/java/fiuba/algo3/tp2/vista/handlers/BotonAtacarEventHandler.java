package fiuba.algo3.tp2.vista.handlers;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.Danina;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.juego.Algochess;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class BotonAtacarEventHandler implements EventHandler<ActionEvent> {

    private Algochess algochess;
    private Pieza atacante;
    private Pieza victima;
    protected Boolean ataqueEnProgreso;
    private Stage stage;

    public BotonAtacarEventHandler(Algochess algochess, Stage stage){
        this.algochess = algochess;
        atacante = null;
        victima = null;
        ataqueEnProgreso = false;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        ataqueEnProgreso = true;
    }
    public void setAtacante(Pieza pieza){
        this.atacante = pieza;
    }

    public void setVictima(Pieza victima) {
        this.victima = victima;
        algochess.atacarCon((Danina) atacante,victima.getPosicion().getPosicionFila(),victima.getPosicion().getPosicionColumna());
        algochess.obtenerJugadorDelTurnoSiguiente().actualizarPiezas(algochess.getTablero());
        if(algochess.juegoTerminado()){
            //aca va el popup de juego terminado
        }
        algochess.getTablero().notifyObservers();
        ataqueEnProgreso = false;

        final Popup popup = new Popup();
        popup.setAutoFix(true);
        popup.setAnchorX(1440);
        popup.setAnchorY(180);
        popup.setAutoHide(true);
        popup.setHideOnEscape(true);
        Label popupText = new Label( "Ataque realizado.");
        popupText.getStylesheets().add("css/popup.css");
        popup.getContent().addAll(popupText);
        popup.show(stage);
    }

    public Boolean ataqueEnProgreso(){
        return ataqueEnProgreso;
    }
}
