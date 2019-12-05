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

        Scene juegoPrincipal = new Scene(vistaJuego,1366,768);

        PresentacionView presentacion = new PresentacionView(stage,juegoPrincipal);
        Scene bienvenidos = new Scene(presentacion);

        stage.setScene(bienvenidos);
        stage.setMaximized(true);
        stage.show();
    }
}
