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

        JuegoView vistaJuego = new JuegoView(algochess);
        Scene juegoPrincipal = new Scene(vistaJuego,1280,720);

        PresentacionView presentacion = new PresentacionView(stage,juegoPrincipal);
        Scene bienvenidos = new Scene(presentacion, 1280, 720);

        stage.setScene(bienvenidos);
        stage.setFullScreen(false);
        stage.show();
    }
}
