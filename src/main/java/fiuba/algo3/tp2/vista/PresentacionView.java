package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Algochess;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class PresentacionView extends VBox {

    Stage stage;

    public PresentacionView(Stage stage, Scene scene){

        this.stage = stage;


        Algochess algochess = new Algochess();

        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        double w = visualBounds.getWidth();
        double h = visualBounds.getHeight();

        this.setAlignment(Pos.CENTER);
        this.setSpacing(50);

        Background fondo = new Background(new BackgroundImage(new Image("bg-presentacion.jpg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(w, h, false, false, false, false)));

        this.setBackground(fondo);

        Text textoPresentacion = new Text("AlgoChess");
        textoPresentacion.setFill(Color.WHITE);
        textoPresentacion.setStroke(Color.BLACK);
        textoPresentacion.setStrokeWidth(2);
        textoPresentacion.setFont(Font.font("Verdana", FontWeight.BOLD,80));

        Button comenzar = new Button("Jugar");
        comenzar.setMaxWidth(200);

        comenzar.setOnAction(e-> {

            stage.setMaximized(true);
            Scene entradaNombres = new Scene(new EntradaDeNombresView(stage,scene,algochess),w,h);
            stage.setScene(entradaNombres);
        });

        this.getChildren().add(textoPresentacion);
        this.getChildren().add(comenzar);
    }


}
