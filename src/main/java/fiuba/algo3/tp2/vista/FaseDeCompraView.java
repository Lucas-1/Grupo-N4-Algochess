package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.juego.Algochess;
import fiuba.algo3.tp2.vista.handlers.BotonTerminarCompraEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class FaseDeCompraView extends BorderPane {

    private Stage stage;
    private Algochess algochess;
    private TableroView vistaTablero;
    private TiendaView vistaTienda;
    private int turnosTranscurridos;

    public FaseDeCompraView(Stage stage, Algochess algochess) {

        turnosTranscurridos = 0;

        this.stage = stage;
        this.algochess = algochess;

        BackgroundImage imagenDeFondo = new BackgroundImage(new Image("file:src/main/resources/bg-madera.jpg"), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        vistaTablero = new TableroView(algochess);
        vistaTienda = new TiendaView(algochess);

        this.setCenter(vistaTablero);
        this.setRight(vistaTienda);

        Jugador jugadorConTurno = algochess.obtenerJugadorConTurno();
        InformacionJugadorView info = new InformacionJugadorView(jugadorConTurno);
        this.setLeft(info);
        info.setAlignment(Pos.CENTER);


        VBox menu = new VBox();
        menu.setPadding(new Insets(20,20,20,20));
        menu.setSpacing(20);

        Label mensaje = new Label("BIENVENIDO A LA FASE DE COMPRA. PRESIONA EL BOTON PARA FINALIZAR");
        mensaje.setTextFill(Color.WHITE);

        Button terminarCompra = new Button("Terminar la compra");
        BotonTerminarCompraEventHandler terminarCompraHandler = new BotonTerminarCompraEventHandler(turnosTranscurridos,algochess,vistaTablero,stage,this);
        terminarCompra.setOnAction(terminarCompraHandler);

        menu.getChildren().addAll(terminarCompra,mensaje);

        this.setTop(menu);
        menu.setAlignment(Pos.CENTER);
    }
}
