package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Algochess;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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

        HBox elementosNegro = new HBox();
        elementosNegro.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        elementosNegro.setMaxWidth(300);
        elementosNegro.setAlignment(Pos.CENTER);
        elementosNegro.setSpacing(20);

        Label mensajeNegro = new Label("Jugador negro:");
        TextField entradaNegro = new TextField();

        elementosNegro.getChildren().addAll(mensajeNegro, entradaNegro);

        HBox elementosBlanco = new HBox();
        elementosBlanco.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        elementosBlanco.setMaxWidth(300);
        elementosBlanco.setAlignment(Pos.CENTER);
        elementosBlanco.setSpacing(20);

        Label mensaje = new Label("Jugador blanco:");
        TextField entradaBlanco = new TextField();

        elementosBlanco.getChildren().addAll(mensaje, entradaBlanco);


        Button comenzar = new Button("Jugar!");
        comenzar.setMaxWidth(200);

        comenzar.setOnAction(e-> {

            String nombreBlanco = entradaBlanco.getText();
            String nombreNegro = entradaNegro.getText();

            if(nombreBlanco.equals("") || nombreNegro.equals("")) {

                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setContentText("INGRESAR AMBOS NOMBRES");

                entradaBlanco.clear(); entradaNegro.clear();
                alerta.show();

            } else if(nombreBlanco.equals(nombreNegro)) {

                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setContentText("NO PUEDEN LLEVAR EL MISMO NOMBRE");

                entradaBlanco.clear(); entradaNegro.clear();
                alerta.show();

            } else {

                algochess.cargarNombreBlanco(nombreBlanco);
                algochess.cargarNombreNegro(nombreNegro);

                stage.setMaximized(true);
                stage.setScene(scene);
            }
        });

        this.getChildren().add(textoPresentacion);
        this.getChildren().add(elementosBlanco);
        this.getChildren().add(elementosNegro);
        this.getChildren().add(comenzar);
    }


}