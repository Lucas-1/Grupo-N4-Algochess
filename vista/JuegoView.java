package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Algochess;
import javafx.geometry.Pos;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class JuegoView extends VBox {

    private BorderPane interfaz;
    private Algochess algochess;
    private TableroView vistaTablero;
    private ControlesView controles;
    private MenuBar menuBar;
    private TextField consola;

    public JuegoView(Algochess algochess, TableroView vistaTablero){

        this.algochess = algochess;
        interfaz = new BorderPane();

        this.setAlignment(Pos.CENTER);

        controles = new ControlesView(this.algochess);
        this.vistaTablero = vistaTablero;
        vistaTablero.setControl(controles);

        menuBar = new MenuBar();
        consola = new TextField();
        BackgroundImage imagenDeFondo = new BackgroundImage(new Image("file:src/main/resources/bg-madera.jpg"), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        interfaz.setCenter(vistaTablero);
        interfaz.setLeft(controles);

        interfaz.setBottom(consola);

        BorderPane.setAlignment(vistaTablero, Pos.CENTER);
        BorderPane.setAlignment(controles, Pos.CENTER_RIGHT);

        BorderPane.setAlignment(consola, Pos.BOTTOM_LEFT);

        this.getChildren().add(interfaz);
    }
}
