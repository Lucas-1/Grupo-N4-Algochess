package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.tienda.Tienda;
import fiuba.algo3.tp2.juego.Algochess;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;

public class ColocarPiezasView extends Group {

    VBox contenedorPiezas;
    Tienda tienda;
    Jugador jugador;

    public ColocarPiezasView(Jugador jugador){

        this.tienda = new Tienda();
        this.jugador = jugador;

        ImageView catapulta = new ImageView(new Image("file:src/recursos/catapultaPlaceholder.png"));
        ImageView curandero = new ImageView(new Image("file:src/recursos/curanderoPlaceHolder.png"));
        ImageView jinete = new ImageView(new Image("file:src/recursos/jinetePlaceholder.png"));
        ImageView soldado = new ImageView(new Image("file:src/recursos/soldadoPlaceholder.png"));

        Label puntosDeCompra = new Label("Puntos de compra disponibles: "+ jugador.getPuntosDeCompraDisponibles());

        contenedorPiezas.getChildren().add(soldado);
        contenedorPiezas.getChildren().add(catapulta);
        contenedorPiezas.getChildren().add(jinete);
        contenedorPiezas.getChildren().add(curandero);
        contenedorPiezas.getChildren().add(puntosDeCompra);
        this.setearMoverPiezasATablero();

        this.getChildren().add(contenedorPiezas);

    }

    private void setearMoverPiezasATablero(){

        Image soldado = new Image("file:src/recursos/soldadoPlaceholder.png");
        Image jinete = new Image("file:src/recursos/jinetePlaceholder.png");
        Image curandero = new Image("file:src/recursos/curanderoPlaceHolder.png");
        Image catapulta = new Image("file:src/recursos/catapultaPlaceholder.png");


        contenedorPiezas.getChildren().get(0).setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!(jugador.getPuntosDeCompraDisponibles() == 0)) {
                    Dragboard db = contenedorPiezas.getChildren().get(0).startDragAndDrop(TransferMode.COPY);
                    ClipboardContent cb = new ClipboardContent();
                    cb.putImage(soldado);
                    db.setContent(cb);
                    event.consume();
                }
            }
        });

        contenedorPiezas.getChildren().get(1).setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!(jugador.getPuntosDeCompraDisponibles() == 0)) {
                    Dragboard db = contenedorPiezas.getChildren().get(1).startDragAndDrop(TransferMode.COPY);
                    ClipboardContent cb = new ClipboardContent();
                    cb.putImage(catapulta);
                    db.setContent(cb);
                    event.consume();
                }
            }
        });

        contenedorPiezas.getChildren().get(2).setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!(jugador.getPuntosDeCompraDisponibles() == 0)) {
                    Dragboard db = contenedorPiezas.getChildren().get(2).startDragAndDrop(TransferMode.COPY);
                    ClipboardContent cb = new ClipboardContent();
                    cb.putImage(jinete);
                    db.setContent(cb);
                    event.consume();
                }
            }
        });

        contenedorPiezas.getChildren().get(3).setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!(jugador.getPuntosDeCompraDisponibles() == 0)) {
                    Dragboard db = contenedorPiezas.getChildren().get(3).startDragAndDrop(TransferMode.COPY);
                    ClipboardContent cb = new ClipboardContent();
                    cb.putImage(curandero);
                    db.setContent(cb);
                    event.consume();
                }
            }
        });


    }


}
