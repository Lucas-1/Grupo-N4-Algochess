package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Algochess;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class FaseDeCompraView extends BorderPane {

    private Stage stage;
    private Algochess algochess;
    private TableroView vistaTablero;
    private TiendaView vistaTienda;
    private BorderPane interfaz;

    public FaseDeCompraView(Stage stage, Algochess algochess) {

        this.stage = stage;
        this.algochess = algochess;



        vistaTablero = new TableroView(algochess);

        BackgroundImage imagenDeFondo = new BackgroundImage(new Image("file:src/main/resources/bg-madera.png"), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        vistaTienda = new TiendaView();

        this.setCenter(vistaTablero);
        this.setRight(vistaTienda);

        VBox izquierda = new VBox();
        izquierda.setPadding(new Insets(20,20,20,20));
        izquierda.setSpacing(30);
        Label info1 = new Label("Jugador comprando: Carlitos");
        Label info2 = new Label("Color: Blanco");
        Label info3 = new Label("Puntos restantes: 15");
        Label info4 = new Label("Jinete, costo 3 .... blablabla");
        izquierda.getChildren().addAll(info1,info2,info3,info4);
        this.setLeft(izquierda);


        VBox borrameDespues = new VBox();
        borrameDespues.setPadding(new Insets(20,20,20,20));
        borrameDespues.setSpacing(30);
        Label msj = new Label("Arrasta una pieza de la tienda al tablero para comprarla");
        msj.setTextFill(Color.WHITE);

        Button botonRustico = new Button("Terminar la compra");
        botonRustico.setOnAction( e-> {

            JuegoView vistaJuego = new JuegoView(algochess,stage,vistaTablero);
            Scene juegoPrincipal = new Scene(vistaJuego);

            stage.setScene(juegoPrincipal);
            stage.setFullScreenExitHint("");
            stage.setFullScreen(true);
        });

        borrameDespues.getChildren().addAll(botonRustico,msj);
        this.setTop(borrameDespues);
        borrameDespues.setAlignment(Pos.BASELINE_CENTER);
    }


}
