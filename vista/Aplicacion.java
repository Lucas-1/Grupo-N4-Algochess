package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Algochess;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Aplicacion extends Application {

    public static void main (String[] args){
        launch(args);
    }

    public void start(Stage stage) {

        stage.setTitle("AlgoChess");
        Algochess algochess = new Algochess();

        FaseDeCompraView faseCompras = new FaseDeCompraView(stage,algochess);
        Scene comprarPiezas = new Scene(faseCompras);

        //JuegoView vistaJuego = new JuegoView(algochess,stage);
        //Scene juegoPrincipal = new Scene(vistaJuego);

        PresentacionView presentacion = new PresentacionView(stage,comprarPiezas);
        Scene bienvenidos = new Scene(presentacion);

        bienvenidos.getStylesheets().add("css/presentacion.css");
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        stage.setScene(bienvenidos);
        stage.show();
    }
}
