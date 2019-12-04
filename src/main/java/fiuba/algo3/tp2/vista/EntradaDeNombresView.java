package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Algochess;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EntradaDeNombresView extends VBox {

    private Stage stage;

    public EntradaDeNombresView(Stage stage, Algochess algochess, Scene juego) {

        this.stage = stage;
        this.setPadding(new Insets(20,20,20,20));
        this.setSpacing(50);

        HBox elementos = new HBox();
        elementos.setSpacing(100);

        Label mensaje = new Label("Ingrese un nombre para el jugador negro: ");
        TextField entrada = new TextField();
        Button enviarNegro = new Button("enviar");

        elementos.getChildren().addAll(mensaje,entrada);
        this.getChildren().addAll(elementos,enviarNegro);

        enviarNegro.setOnAction( e-> {

            System.out.println("Nombre negro: " + entrada.getText());
            // algochess.cargarNombreNegro(nombreNegro);
            mensaje.setText("Ahora para el jugador blanco: ");

            Button enviarBlanco = new Button("enviar");
            this.getChildren().remove(enviarNegro);
            this.getChildren().add(enviarBlanco);

            enviarBlanco.setOnAction( ee -> {

                System.out.println("Nombre blanco: " + entrada.getText());
                // algochess.cargarNombreBlanco(nombreBlanco);
                stage.setScene(juego);
            });

        });

    }

}
