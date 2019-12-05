package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.juego.Algochess;
import fiuba.algo3.tp2.vista.handlers.BotonAbajoEventHandler;
import fiuba.algo3.tp2.vista.handlers.BotonArribaEventHandler;
import fiuba.algo3.tp2.vista.handlers.BotonDerechaEventHandler;
import fiuba.algo3.tp2.vista.handlers.BotonIzquierdaEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class ControlesView extends Group {

    Jugador jugador;
    VBox controles;
    Text nombre;
    Text piezaActual;
    BotonArribaEventHandler botonArribaEventHandler;
    BotonAbajoEventHandler botonAbajoEventHandler;
    BotonDerechaEventHandler botonDerechaEventHandler;
    BotonIzquierdaEventHandler botonIzquierdaEventHandler;

    public ControlesView(Algochess algochess){
        controles = new VBox();
        nombre = new Text("Jugador: ");
        piezaActual = new Text("Pieza: ");
        Button botonArriba = new Button("Arriba");
        Button botonAbajo = new Button("Abajo");
        Button botonDerecha = new Button("Derecha") ;
        Button botonIzquierda = new Button("Izquierda");
        Button botonAtacar = new Button("Atacar!");

        botonArribaEventHandler = new BotonArribaEventHandler(algochess);
        botonAbajoEventHandler = new BotonAbajoEventHandler(algochess);
        botonDerechaEventHandler = new BotonDerechaEventHandler(algochess);
        botonIzquierdaEventHandler = new BotonIzquierdaEventHandler(algochess);

        botonArriba.setOnAction(botonArribaEventHandler);
        botonAbajo.setOnAction(botonAbajoEventHandler);
        botonDerecha.setOnAction(botonDerechaEventHandler);
        botonIzquierda.setOnAction(botonIzquierdaEventHandler);

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
        mando.setPrefHeight(150);
        mando.getChildren().addAll(botonAbajo,botonArriba,botonAtacar,botonDerecha,botonIzquierda);

        controles.setSpacing(10);
        controles.getChildren().add(nombre);
        controles.getChildren().add(piezaActual);
        controles.getChildren().add(mando);
        this.getChildren().add(controles);
    }

    public void setPiezaAMover(Pieza pieza){
        if(pieza != null){
            piezaActual = new Text(piezaActual + pieza.getNombre());
            botonAbajoEventHandler.setPieza(pieza);
            botonArribaEventHandler.setPieza(pieza);
            botonDerechaEventHandler.setPieza(pieza);
            botonIzquierdaEventHandler.setPieza(pieza);
        }
    }
}
