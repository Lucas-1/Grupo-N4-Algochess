package fiuba.algo3.tp2.vista.handlers;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.juego.Algochess;
import fiuba.algo3.tp2.movimiento.Direccion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class BotonArribaEventHandler implements EventHandler<ActionEvent> {

    private final Stage stage;
    private Algochess algochess;
    private Pieza pieza;

    public BotonArribaEventHandler(Algochess algochess, Stage stage){
        this.algochess = algochess;
        this.pieza = null;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        algochess.moverPieza(pieza, Direccion.arriba());
        algochess.getTablero().notifyObservers();

        final Popup popup = new Popup();
        HBox popupText = new HBox();
        popup.setAutoFix(true);
        popup.setAnchorX(450);
        popup.setAnchorY(50);
        popup.setAutoHide(true);
        popup.setHideOnEscape(true);
        Label primeraParteDelTexto = new Label( "Moviste la pieza ");
        Label segundaParteDelTexto = new Label(pieza.getNombre() + " ");
        segundaParteDelTexto.setId("nombre-pieza");
        Label terceraParteDelTexto = new Label(pieza.getColor().comoString());
        if(pieza.getColor().comoString() == "blanco") {
            terceraParteDelTexto.setId("color-blanco");
        }else {
            terceraParteDelTexto.setId("color-negro");
        }
        Label cuartaParteDelTexto = new Label(" hacia arriba");
        popupText.getChildren().addAll(primeraParteDelTexto,segundaParteDelTexto,terceraParteDelTexto,cuartaParteDelTexto);
        popupText.getStylesheets().add("css/popup.css");
        popup.getContent().addAll(popupText);
        popup.show(stage);
    }

    public void setPieza(Pieza pieza){
        this.pieza = pieza;
    }

}
