package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.Tablero;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Aplicacion extends Application {

    public static void main (String[] args){
        launch(args);
    }

    public void start(Stage stage){

        stage.setTitle("AlgoChess");
        Tablero tablero = new Tablero();

        BorderPane juego = new BorderPane();
        TableroView vistaTablero = new TableroView(tablero);
        juego.setCenter(vistaTablero);

        Scene juegoPrincipal = new Scene(juego);

        new PresentacionView(stage,juegoPrincipal);

        stage.setMaximized(true);
        stage.show();

    }
}
