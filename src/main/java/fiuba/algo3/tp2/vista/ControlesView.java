package fiuba.algo3.tp2.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class ControlesView extends Group {

    VBox controles;

    public ControlesView(){
        controles = new VBox();
        Text nombre = new Text("Jugador: ");
        Text piezaActual = new Text("Pieza: ");
        Button botonArriba = new Button("Arriba");
        Button botonAbajo = new Button("Abajo");
        Button botonDerecha = new Button("Derecha") ;
        Button botonIzquierda = new Button("Izquierda");
        Button botonAtacar = new Button("Atacar!");

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

        controles.getChildren().add(nombre);
        controles.getChildren().add(piezaActual);
        controles.getChildren().add(mando);
        this.getChildren().add(controles);
    }
}
