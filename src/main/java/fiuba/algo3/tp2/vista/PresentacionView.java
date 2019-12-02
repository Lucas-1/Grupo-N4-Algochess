package fiuba.algo3.tp2.vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PresentacionView {
    Stage stage;

    public PresentacionView(Stage stage,Scene scene){
        this.stage = stage;

        Background background = new Background(new BackgroundImage(new Image("bg-presentacion.jpg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1366, 768, false, false, false, false)));

        StackPane presentacion = new StackPane();
        Text textoPresentacion = new Text("Bienvenido a AlgoChess");
        textoPresentacion.setFill(Color.WHITE);
        textoPresentacion.setFont(Font.font("Verdana", FontWeight.BOLD,70));
        Button comenzar = new Button("Comenzar juego");
        presentacion.setAlignment(textoPresentacion, Pos.CENTER);
        presentacion.setAlignment(comenzar,Pos.BOTTOM_CENTER);
        presentacion.setBackground(background);
        presentacion.getChildren().add(textoPresentacion);
        presentacion.getChildren().add(comenzar);
        Scene pres = new Scene(presentacion);
        stage.setScene(pres);

        comenzar.setOnAction(e-> {
            stage.setMaximized(true);
            stage.setScene(scene);
        });

        stage.show();

    }


}
