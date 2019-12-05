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

    public void start(Stage stage) {

        stage.setTitle("AlgoChess");
        Algochess algochess = new Algochess();

        TableroView vistaTablero = new TableroView(algochess);

        BorderPane juego = new BorderPane();
        juego.setPadding(new Insets(25,25,25,25));
        juego.setCenter(vistaTablero);

        Scene juegoPrincipal = new Scene(juego,1920,1080);

        PresentacionView presentacion = new PresentacionView(stage,juegoPrincipal);
        Scene bienvenidos = new Scene(presentacion);

        stage.setScene(bienvenidos);
        stage.setMaximized(true);
        stage.show();
    }
}
