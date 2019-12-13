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


        Jugador jugadorConTurno = algochess.obtenerJugadorConTurno();
        this.setLeft(this.setInformacionJugador(jugadorConTurno));
        VBox menu = new VBox();

        menu.getStylesheets().add("css/menu.css");

        menu.setPadding(new Insets(20,0,0,0));
        menu.setSpacing(5);

        Label mensaje = new Label("--- BIENVENIDO A LA FASE DE COMPRA. PRESIONA EL BOTON PARA FINALIZAR ---");

        Label tip = new Label("\n" + "Arrasta una pieza de la tienda al tablero para comprarla \n" +
                "Recorda que solo podes poner piezas de tu lado del tablero que corresponde con tu color");

        tip.setId("tip");

        Button terminarCompra = new Button("Terminar la compra");


        vistaTablero = new TableroView(algochess, this);
        vistaTienda = new TiendaView(algochess);

        this.setAlignment(vistaTienda, Pos.CENTER_RIGHT);

        this.setCenter(vistaTablero);
        this.setRight(vistaTienda);


        BotonTerminarCompraEventHandler terminarCompraHandler = new BotonTerminarCompraEventHandler(turnosTranscurridos,algochess,vistaTablero,stage,this);
        terminarCompra.setOnAction(terminarCompraHandler);

        menu.getChildren().addAll(terminarCompra,mensaje, tip);

        this.setTop(menu);
        menu.setAlignment(Pos.TOP_CENTER);

    }

    private InformacionJugadorView setInformacionJugador(Jugador jugadorConTurno) {

        InformacionJugadorView info = new InformacionJugadorView(jugadorConTurno);
        info.setPadding(new Insets(0,0,0,100));
        return info;
    }

    public void actualizarInformacionJugador(Jugador jugadorConTurno){

        this.setLeft(setInformacionJugador(jugadorConTurno));
    }
}
