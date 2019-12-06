package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.juego.Algochess;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class JuegoView extends Group {
    private BorderPane interfaz;
    private Algochess algochess;
    private TableroView vistaTablero;
    private TiendaView vistaTienda;
    private ControlesView controlesBlanco;
    private ControlesView controlesNegro;
    private MenuBar menuBar;
    private TextArea consola;

    public JuegoView(Algochess algochess){
        this.algochess = algochess;
        interfaz = new BorderPane();
        controlesBlanco = new ControlesView(algochess);
        controlesNegro = new ControlesView(algochess);
        vistaTablero = new TableroView(algochess);
        vistaTienda = new TiendaView();
        menuBar = new MenuBar();
        consola = new TextArea();


        interfaz.setCenter(vistaTablero);
        interfaz.setPadding(Insets.EMPTY);
        interfaz.setLeft(controlesBlanco);
        interfaz.setRight(vistaTienda);
        interfaz.setTop(menuBar);
        interfaz.setBottom(consola);


        this.getChildren().add(interfaz);

    }

}
