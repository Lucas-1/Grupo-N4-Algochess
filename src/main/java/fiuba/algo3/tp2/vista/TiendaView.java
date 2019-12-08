package fiuba.algo3.tp2.vista;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;

public class TiendaView extends Group {

    private GridPane vistaTienda;

    public TiendaView() {
        this.vistaTienda = new GridPane();
        this.delimitarTamanioDelContenedor();
        //this.agregarTexturaContenedor();
        this.llenarContenedor();
        this.addView(vistaTienda);
    }
    private void addView(GridPane vista) {
        this.getChildren().add(vista);
    }

    private void delimitarTamanioDelContenedor() {
        this.vistaTienda.setPrefWidth(363);
        this.vistaTienda.setAlignment(Pos.CENTER);
        this.vistaTienda.setGridLinesVisible(true);
        this.vistaTienda.setVgap(50);
        this.vistaTienda.setPadding(new Insets(50,5,0,5));
    }


    private void llenarContenedor() {
        ImageView soldado = new ImageView(new Image("file:src/main/resources/soldadoPlaceholder.png"));
        ImageView curandero = new ImageView(new Image("file:src/main/resources/curanderoPlaceholder.png"));
        ImageView jinete = new ImageView(new Image("file:src/main/resources/jinetePlaceholder.png"));
        ImageView catapulta = new ImageView(new Image("file:src/main/resources/catapultaPlaceholder.png"));
        ImageView tiendaIcono = new ImageView(new Image("file:src/main/resources/ic-shop.png"));


        tiendaIcono.setFitWidth(75);
        tiendaIcono.setFitHeight(75);

        this.vistaTienda.add(tiendaIcono, 0,0);
        this.vistaTienda.add(soldado, 0, 1);
        this.vistaTienda.add(curandero, 0, 2);
        this.vistaTienda.add(jinete, 0, 3);
        this.vistaTienda.add(catapulta, 0, 4);

        this.habilitarMoverPiezaAlTablero();
    }

    /*private void agregarTexturaContenedor() {
        Image textura = new Image("file:src/main/resources/bg-madera.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(textura, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.vistaTienda.setBackground(new Background(imagenDeFondo));
    }*/

    private void habilitarMoverPiezaAlTablero() {
        Image soldado = new Image("file:src/main/resources/soldadoPlaceholder.png");
        Image curandero = new Image("file:src/main/resources/curanderoPlaceholder.png");
        Image jinete = new Image("file:src/main/resources/jinetePlaceholder.png");
        Image catapulta = new Image("file:src/main/resources/catapultaPlaceholder.png");

        vistaTienda.getChildren().get(2).setOnDragDetected(event -> {
            Dragboard db = vistaTienda.getChildren().get(1).startDragAndDrop(TransferMode.COPY);
            ClipboardContent cb = new ClipboardContent();
            cb.putImage(soldado);
            db.setContent(cb);
            event.consume();
        });
        vistaTienda.getChildren().get(3).setOnDragDetected(event -> {
            Dragboard db = vistaTienda.getChildren().get(2).startDragAndDrop(TransferMode.COPY);
            ClipboardContent cb = new ClipboardContent();
            cb.putImage(curandero);

            db.setContent(cb);
            event.consume();
        });
        vistaTienda.getChildren().get(4).setOnDragDetected(event -> {
            Dragboard db = vistaTienda.getChildren().get(3).startDragAndDrop(TransferMode.COPY);
            ClipboardContent cb = new ClipboardContent();
            cb.putImage(jinete);

            db.setContent(cb);
            event.consume();
        });
        vistaTienda.getChildren().get(5).setOnDragDetected(event -> {
            Dragboard db = vistaTienda.getChildren().get(4).startDragAndDrop(TransferMode.COPY);
            ClipboardContent cb = new ClipboardContent();
            cb.putImage(catapulta);

            db.setContent(cb);
            event.consume();
        });
    }
}
