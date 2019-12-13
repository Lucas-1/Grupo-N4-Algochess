package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class InformacionJugadorView extends VBox {

    Label nombre;
    Label color;
    Label puntosRestantes;
    Label cantidadDePiezas;
    Label tip;

    public InformacionJugadorView(Jugador jugadorConTurno) {


        this.setPadding(new Insets(20,20,20,20));
        this.setSpacing(20);

        Label nombre = new Label("Jugador comprando: " + jugadorConTurno.getNombre());
        Label color = new Label("Color: "  + jugadorConTurno.colorComoString());
        Label puntosRestantes = new Label("Puntos restantes: " + jugadorConTurno.getPuntosDeCompraDisponibles());
        Label cantidadDePiezas = new Label("Cantidad de piezas: " + jugadorConTurno.getCantidadPiezasDeJugador());
        Label tip = new Label("\n" + "Arrasta una pieza de la tienda al tablero para comprarla \n" +
                "Recorda que solo podes poner piezas de tu lado del tablero que corresponde con tu color");



        nombre.setTextFill(Color.WHITE);
        color.setTextFill(Color.WHITE);
        puntosRestantes.setTextFill(Color.WHITE);
        cantidadDePiezas.setTextFill(Color.WHITE);
        tip.setTextFill(Color.WHITE);

        this.getChildren().addAll(nombre, color, puntosRestantes,cantidadDePiezas,tip);

    }

}
