package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Algochess;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Aplicacion extends Application {

    public static void main (String[] args){
        launch(args);
    }

    public void start(Stage stage){

        stage.setTitle("AlgoChess");
        Algochess algochess = new Algochess();
        TableroView vistaTablero = new TableroView(algochess);

        BorderPane juego = new BorderPane();

        juego.setPadding(new Insets(100,100,100,100));
        juego.setCenter(vistaTablero);

        Scene juegoPrincipal = new Scene(juego);

        new PresentacionView(stage,juegoPrincipal,algochess);

        stage.setMaximized(true);
        stage.show();
    }
}
