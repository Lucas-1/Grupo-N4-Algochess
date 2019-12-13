package fiuba.algo3.tp2.vista.handlers;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Saludable;
import fiuba.algo3.tp2.juego.Algochess;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCurarEventHandler implements EventHandler<ActionEvent> {

    Algochess algochess;
    Pieza curandero;
    Pieza paciente;
    protected Boolean curacionEnProgreso;

    public BotonCurarEventHandler(Algochess algochess) {
        this.algochess = algochess;
        curandero = null;
        paciente = null;
        curacionEnProgreso = false;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        curacionEnProgreso = true;
    }

    public void setCurandero(Pieza pieza) {
        this.curandero = pieza;
    }

    public void setPaciente(Pieza victima) {
        this.paciente = victima;
        algochess.curarCon((Saludable) curandero, victima.getPosicion().getPosicionFila(), victima.getPosicion().getPosicionColumna());
        algochess.obtenerJugadorDelTurnoSiguiente().actualizarPiezas(algochess.getTablero());
        algochess.getTablero().notifyObservers();
        curacionEnProgreso = false;
    }

    public Boolean curacionEnProgreso() {
        return curacionEnProgreso;
    }

}
