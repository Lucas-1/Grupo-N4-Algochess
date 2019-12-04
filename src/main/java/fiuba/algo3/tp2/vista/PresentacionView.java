package fiuba.algo3.tp2.vista;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class PresentacionView {

    Stage stage;

    public PresentacionView(Stage stage,Scene scene){

        this.stage = stage;

        VBox presentacion = new VBox();

        presentacion.setAlignment(Pos.CENTER);
        presentacion.setSpacing(50);

        Background fondo = new Background(new BackgroundImage(new Image("bg-presentacion.jpg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1920, 1080, false, false, false, false)));


        presentacion.setBackground(fondo);


        Text textoPresentacion = new Text("AlgoChess");
        textoPresentacion.setFill(Color.WHITE);
        textoPresentacion.setStroke(Color.BLACK);
        textoPresentacion.setStrokeWidth(2);
        textoPresentacion.setFont(Font.font("Verdana", FontWeight.BOLD,80));

        Button comenzar = new Button("Jugar");
        comenzar.setMaxWidth(200);

        comenzar.setOnAction(e-> {
            stage.setMaximized(true);
            stage.setScene(scene);
        });

        presentacion.getChildren().add(textoPresentacion);
        presentacion.getChildren().add(comenzar);

        Scene bienvenidos = new Scene(presentacion);
        stage.setScene(bienvenidos);


        stage.show();
    }


}
