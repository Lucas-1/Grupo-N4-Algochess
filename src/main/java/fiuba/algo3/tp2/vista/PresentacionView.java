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

public class PresentacionView {

    Stage stage;

    public PresentacionView(Stage stage,Scene scene){

        this.stage = stage;

        VBox presentacion = new VBox();

        presentacion.setAlignment(Pos.CENTER);
        presentacion.setSpacing(75);

        Text textoPresentacion = new Text("Bienvenido a AlgoChess");
        textoPresentacion.setFill(Color.BLACK);
        textoPresentacion.setFont(Font.font("Verdana", FontWeight.BOLD,64));

        Button comenzar = new Button("Comenzar juego");
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
