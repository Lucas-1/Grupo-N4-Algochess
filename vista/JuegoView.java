package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.flujoDelJuego.fasesDeJuego.FaseDeCompra;
import fiuba.algo3.tp2.juego.Algochess;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class JuegoView extends BorderPane {

    private Algochess algochess;
    private TableroView vistaTablero;
    private Stage stage;
    private TiendaView vistaTienda;
    private ControlesView controles;
    private ControlesView controlesNegro;
    private MenuBar menuBar;

    private TextField consola;

    public JuegoView(Algochess algochess,Stage stage, TableroView vistaTablero){

        this.algochess = algochess;
        this.stage = stage;
        this.vistaTablero = vistaTablero;

        controles = new ControlesView(this.algochess);
        controlesNegro = new ControlesView(this.algochess);

        menuBar = new MenuBar();

        consola = new TextField();

        BackgroundImage imagenDeFondo = new BackgroundImage(new Image("file:src/main/resources/bg-madera.png"), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        this.setCenter(vistaTablero);
        this.setLeft(controles);
        this.setBottom(consola);

        controles.setAlignment(Pos.CENTER);

    }
}
