package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.juego.Algochess;
import javafx.scene.Group;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class JuegoView extends Group {

    private BorderPane interfaz;
    private Algochess algochess;
    private TableroView vistaTablero;
    private TiendaView vistaTienda;
    private ControlesView controlesBlanco;
    private ControlesView controlesNegro;
    private MenuBar menuBar;
    private TextField consola;

    public JuegoView(Algochess algochess){

        this.algochess = algochess;
        interfaz = new BorderPane();
        vistaTablero = new TableroView(algochess);
        vistaTienda = new TiendaView();
        controlesBlanco = new ControlesView(this.algochess);
        controlesNegro = new ControlesView(this.algochess);
        menuBar = new MenuBar();
        consola = new TextField();
        BackgroundImage imagenDeFondo = new BackgroundImage(new Image("file:src/main/resources/bg-tienda.jpg"), BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        interfaz.setBackground(new Background(imagenDeFondo));


        interfaz.setCenter(vistaTablero);
        interfaz.setLeft(controlesBlanco);
        interfaz.setRight(vistaTienda);
        interfaz.setBottom(consola);


        this.getChildren().add(interfaz);

    }

}
