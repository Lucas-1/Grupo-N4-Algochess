package fiuba.algo3.tp2.vista.handlers;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.Danina;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.juego.Algochess;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAtacarEventHandler implements EventHandler<ActionEvent> {

    Algochess algochess;
    Pieza atacante;
    Pieza victima;
    protected Boolean ataqueEnProgreso;

    public BotonAtacarEventHandler(Algochess algochess){
        this.algochess = algochess;
        atacante = null;
        victima = null;
        ataqueEnProgreso = false;
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
    }

    public Boolean ataqueEnProgreso(){
        return ataqueEnProgreso;
    }
}
