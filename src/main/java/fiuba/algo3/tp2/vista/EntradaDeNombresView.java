package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Algochess;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EntradaDeNombresView extends VBox {

    private Stage stage;

    public EntradaDeNombresView(Stage stage, Scene juego) {

        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20, 20, 20, 20));
        this.setSpacing(25);

        HBox elementos = new HBox();
        elementos.setAlignment(Pos.CENTER);
        elementos.setSpacing(100);

        Label mensaje = new Label("Ingrese el nombre del jugador negro:");
        TextField entrada = new TextField();
        Button enviarNegro = new Button("Enviar");

        elementos.getChildren().addAll(mensaje, entrada,enviarNegro);
        this.getChildren().addAll(elementos);

        enviarNegro.setOnAction(e -> {

            System.out.println("Nombre negro: " + entrada.getText());
            // algochess.cargarNombreNegro(nombreNegro);

            mensaje.setText("Ingrese el nombre del jugador blanco:");

            Button enviarBlanco = new Button("Enviar");
            elementos.getChildren().remove(enviarNegro);
            elementos.getChildren().add(enviarBlanco);

            enviarBlanco.setOnAction(ee -> {

                System.out.println("Nombre blanco: " + entrada.getText());
                // algochess.cargarNombreBlanco(nombreBlanco);
                stage.setScene(juego);
            });

        });

    }
}
