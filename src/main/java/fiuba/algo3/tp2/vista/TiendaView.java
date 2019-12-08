package fiuba.algo3.tp2.vista;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
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
        this.llenarContenedor();
        this.addView(vistaTienda);
    }
    private void addView(GridPane vista) {
        this.getChildren().add(vista);
    }

    private void delimitarTamanioDelContenedor() {
        this.vistaTienda.setPrefWidth(500);
        this.vistaTienda.setAlignment(Pos.CENTER);
        this.vistaTienda.setGridLinesVisible(true);
        this.vistaTienda.setVgap(50);
        this.vistaTienda.setPadding(new Insets(50,5,0,5));
    }


    private void llenarContenedor() {
        ImageView tiendaIcono = new ImageView(new Image("file:src/main/resources/ic-shop-open.png", 200, 200, false, false));
        ImageView soldado = new ImageView(new Image("file:src/main/resources/ic-soldado.png", 200, 200, false, false));
        ImageView curandero = new ImageView(new Image("file:src/main/resources/ic-curandero.png", 200, 200, false, false));
        ImageView jinete = new ImageView(new Image("file:src/main/resources/ic-jinete.png", 200, 200, false, false));
        ImageView catapulta = new ImageView(new Image("file:src/main/resources/ic-catapulta.png", 200, 200, false, false));



        tiendaIcono.setFitWidth(100);
        tiendaIcono.setFitHeight(100);

        soldado.setCursor(Cursor.CLOSED_HAND);
        curandero.setCursor(Cursor.CLOSED_HAND);
        jinete.setCursor(Cursor.CLOSED_HAND);
        catapulta.setCursor(Cursor.CLOSED_HAND);

        this.vistaTienda.add(tiendaIcono, 0,0);
        this.vistaTienda.add(soldado, 0, 1);
        this.vistaTienda.add(curandero, 1, 1);
        this.vistaTienda.add(jinete, 0, 2);
        this.vistaTienda.add(catapulta, 1, 2);

        this.habilitarMoverPiezaAlTablero();
    }

    private void habilitarMoverPiezaAlTablero() {
        Image soldado = new Image("file:src/main/resources/ic-soldado.png", 40, 40, false, false);
        Image curandero = new Image("file:src/main/resources/ic-curandero.png", 40, 40, false, false);
        Image jinete = new Image("file:src/main/resources/ic-jinete.png", 40, 40, false, false);
        Image catapulta = new Image("file:src/main/resources/ic-catapulta.png", 40, 40, false, false);

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
