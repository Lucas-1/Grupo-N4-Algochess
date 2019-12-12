package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Danina;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.juego.Algochess;
import fiuba.algo3.tp2.vista.handlers.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class ControlesView extends VBox {

    Jugador jugador;
    VBox controles;
    Label nombre;
    Label piezaActual;
    BotonArribaEventHandler botonArribaEventHandler;
    BotonAbajoEventHandler botonAbajoEventHandler;
    BotonDerechaEventHandler botonDerechaEventHandler;
    BotonIzquierdaEventHandler botonIzquierdaEventHandler;
    BotonAtacarEventHandler botonAtacarEventHandler;
    BotonTerminarTurnoEventHandler botonTerminarTurnoEventHandler;


    public ControlesView(Algochess algochess){
        this.controles = new VBox();
        controles.setId("controles");
        VBox boxJugador = new VBox();
        VBox boxPieza = new VBox();
        nombre = new Label("Turno de: ");
        piezaActual = new Label("Pieza seleccionada: ");

        Label nombreJugadorConTurno = new Label("pepe");
        Label nombrePiezaSeleccionada = new Label("jinete");

        nombreJugadorConTurno.setId("jugador-label");
        nombrePiezaSeleccionada.setId("pieza-label");

        Button botonArriba = new Button();
        Button botonAbajo = new Button();
        Button botonDerecha = new Button() ;
        Button botonIzquierda = new Button();
        Button botonAtacar = new Button();
        Button botonTerminarTurno = new Button("Terminar Turno");

        controles.getStylesheets().add("css/controles.css");

        Image flechaIzquierda = new Image("file:src/main/resources/ic-arrow-left.png", 80, 80, false, false);
        Image flechaDerecha = new Image("file:src/main/resources/ic-arrow-right.png", 80,80,false,false);
        Image flechaArriba = new Image("file:src/main/resources/ic-arrow-up.png", 80,80,false,false);
        Image flechaAbajo = new Image("file:src/main/resources/ic-arrow-down.png", 80,80,false,false);
        Image espadasCruzadas = new Image("file:src/main/resources/ic-swords.png", 80,80,false,false);



        botonIzquierda.setGraphic(new ImageView(flechaIzquierda));
        botonDerecha.setGraphic(new ImageView(flechaDerecha));
        botonArriba.setGraphic(new ImageView(flechaArriba));
        botonAbajo.setGraphic(new ImageView(flechaAbajo));
        botonAtacar.setGraphic(new ImageView(espadasCruzadas));


        botonArribaEventHandler = new BotonArribaEventHandler(algochess);
        botonAbajoEventHandler = new BotonAbajoEventHandler(algochess);
        botonDerechaEventHandler = new BotonDerechaEventHandler(algochess);
        botonIzquierdaEventHandler = new BotonIzquierdaEventHandler(algochess);
        botonAtacarEventHandler = new BotonAtacarEventHandler(algochess);
        botonTerminarTurnoEventHandler = new BotonTerminarTurnoEventHandler(algochess);


        botonArriba.setOnAction(botonArribaEventHandler);
        botonAbajo.setOnAction(botonAbajoEventHandler);
        botonDerecha.setOnAction(botonDerechaEventHandler);
        botonIzquierda.setOnAction(botonIzquierdaEventHandler);
        botonAtacar.setOnAction(botonAtacarEventHandler);
        botonTerminarTurno.setOnAction(botonTerminarTurnoEventHandler);

        botonTerminarTurno.setId("boton-terminar-turno");

        StackPane mando = new StackPane();

        mando.setAlignment(botonArriba,Pos.TOP_CENTER);
        mando.setAlignment(botonAbajo,Pos.BOTTOM_CENTER);
        mando.setAlignment(botonDerecha,Pos.CENTER_RIGHT);
        mando.setAlignment(botonIzquierda,Pos.CENTER_LEFT);
        mando.setAlignment(botonAtacar,Pos.CENTER);
        mando.setMargin(botonArriba, new Insets(10, 0, 0, 0));
        mando.setMargin(botonDerecha, new Insets(0, 10, 0, 0));
        mando.setMargin(botonAbajo, new Insets(0, 0, 10, 0));
        mando.setMargin(botonIzquierda, new Insets(0, 0, 0, 10));
        mando.setPrefWidth(250);
        mando.setPrefHeight(350);
        mando.getChildren().addAll(botonAbajo,botonArriba,botonAtacar,botonDerecha,botonIzquierda);

        controles.setSpacing(50);
        boxJugador.getChildren().addAll(nombre, nombreJugadorConTurno);
        controles.getChildren().add(boxJugador);
        boxPieza.getChildren().addAll(piezaActual, nombrePiezaSeleccionada);
        controles.getChildren().add(boxPieza);
        controles.getChildren().add(mando);
        controles.getChildren().add(botonTerminarTurno);

        VBox.setMargin(botonTerminarTurno, new Insets(0, 0, 0, 60));

        this.setPrefWidth(363);
        this.getChildren().add(controles);
    }

    public void setPiezaAMover(Pieza pieza){
        if(pieza != null){
            botonAbajoEventHandler.setPieza(pieza);
            botonArribaEventHandler.setPieza(pieza);
            botonDerechaEventHandler.setPieza(pieza);
            botonIzquierdaEventHandler.setPieza(pieza);
        }
    }

    public void setAtaque(Danina pieza){
        if(botonAtacarEventHandler.ataqueEnProgreso()){
            botonAtacarEventHandler.setVictima(pieza);
        }
        else {
            botonAtacarEventHandler.setAtacante(pieza);
        }
    }
}
