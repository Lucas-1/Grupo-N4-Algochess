package fiuba.algo3.tp2.vista.handlers;

import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.juego.Algochess;
import fiuba.algo3.tp2.vista.FaseDeCompraView;
import fiuba.algo3.tp2.vista.InformacionJugadorView;
import fiuba.algo3.tp2.vista.JuegoView;
import fiuba.algo3.tp2.vista.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BotonTerminarCompraEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Algochess algochess;
    private TableroView vistaTablero;
    private FaseDeCompraView escena;
    private int turnosTranscurridos;

    public BotonTerminarCompraEventHandler(int turnosTranscurridos, Algochess algochess, TableroView vistaTablero, Stage stage, FaseDeCompraView escena) {

        this.turnosTranscurridos = turnosTranscurridos;
        this.algochess = algochess;
        this.vistaTablero = vistaTablero;
        this.stage = stage;
        this.escena = escena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        turnosTranscurridos++;

        if(turnosTranscurridos == 2) {

            algochess.terminarTurno();
            JuegoView vistaJuego = new JuegoView(algochess, vistaTablero, stage);
            Scene juegoPrincipal = new Scene(vistaJuego);

            stage.setScene(juegoPrincipal);
            stage.setFullScreenExitHint("");
            stage.setFullScreen(true);

        } else {

            algochess.terminarTurno();
            Jugador jugadorConTurno = algochess.obtenerJugadorConTurno();

            InformacionJugadorView info = new InformacionJugadorView(jugadorConTurno);
            this.escena.actualizarColoresTienda();
            escena.setLeft(info);
            info.setPadding(new Insets(0,0,0,105));
        }


    }
}
