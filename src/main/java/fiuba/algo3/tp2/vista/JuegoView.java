package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.juego.Algochess;
import javafx.scene.Group;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class JuegoView extends Group {
    BorderPane interfaz;
    Algochess algochess;
    TableroView vistaTablero;
    ControlesView controlesBlanco;
    ControlesView controlesNegro;
    MenuBar menuBar;
    TextArea consola;

    public JuegoView(Algochess algochess){
        this.algochess = algochess;
        interfaz = new BorderPane();
        controlesBlanco = new ControlesView(algochess);
        controlesNegro = new ControlesView(algochess);
        vistaTablero = new TableroView(algochess);

        menuBar = new MenuBar();
        consola = new TextArea();


        interfaz.setCenter(vistaTablero);
        interfaz.setLeft(controlesBlanco);
        interfaz.setRight(controlesNegro);
        interfaz.setTop(menuBar);
        interfaz.setBottom(consola);


        this.getChildren().add(interfaz);

    }

}
