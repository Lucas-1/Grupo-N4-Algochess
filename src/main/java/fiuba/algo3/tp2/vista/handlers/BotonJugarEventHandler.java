package fiuba.algo3.tp2.vista.handlers;

import fiuba.algo3.tp2.juego.Algochess;
import fiuba.algo3.tp2.vista.FaseDeCompraView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;


public class BotonJugarEventHandler implements EventHandler<ActionEvent> {


    private Algochess algochess;
    private TextField entradaBlanco;
    private TextField entradaNegro;
    private Stage stage;
    private Scene escenaJuego;

    public BotonJugarEventHandler(Algochess algochess, TextField entradaBlanco, TextField entradaNegro, Stage stage) {

        this.algochess = algochess;
        this.entradaBlanco = entradaBlanco;
        this.entradaNegro = entradaNegro;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        String nombreNegro = entradaNegro.getText();
        String nombreBlanco = entradaBlanco.getText();


        if(nombreBlanco.equals("") || nombreNegro.equals("")) {

            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setContentText("INGRESAR AMBOS NOMBRES");

            entradaBlanco.clear(); entradaNegro.clear();
            alerta.show();

        } else if(nombreBlanco.equals(nombreNegro)) {

            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setContentText("NO PUEDEN LLEVAR EL MISMO NOMBRE");

            entradaBlanco.clear(); entradaNegro.clear();
            alerta.show();

        } else {

            algochess.cargarNombreBlanco(nombreBlanco);
            algochess.cargarNombreNegro(nombreNegro);

            FaseDeCompraView faseCompras = new FaseDeCompraView(stage,algochess);
            Scene escenaJuego = new Scene(faseCompras);

            stage.setScene(escenaJuego);
            stage.setFullScreenExitHint("");
            stage.setFullScreen(true);
        }
    }
}
