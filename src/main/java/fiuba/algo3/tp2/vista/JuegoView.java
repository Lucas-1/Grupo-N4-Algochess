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
    private TiendaView vistaTienda;
    private ControlesView controles;
    private ControlesView controlesNegro;
    private MenuBar menuBar;
    private TextField consola;

    public JuegoView(Algochess algochess){

        this.algochess = algochess;
        interfaz = new BorderPane();

        this.setAlignment(Pos.CENTER);

        vistaTablero = new TableroView(algochess);
        vistaTienda = new TiendaView();
        controles = new ControlesView(this.algochess);
        controlesNegro = new ControlesView(this.algochess);
        menuBar = new MenuBar();
        consola = new TextField();
        BackgroundImage imagenDeFondo = new BackgroundImage(new Image("file:src/main/resources/bg-madera.jpg"), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        interfaz.setCenter(vistaTablero);
        interfaz.setLeft(controles);
        interfaz.setRight(vistaTienda);
        interfaz.setBottom(consola);

        BorderPane.setAlignment(vistaTablero, Pos.CENTER);
        BorderPane.setAlignment(controles, Pos.CENTER_RIGHT);
        BorderPane.setAlignment(vistaTienda, Pos.CENTER_LEFT);
        BorderPane.setAlignment(consola, Pos.BOTTOM_LEFT);

        this.getChildren().add(interfaz);
    }
}
