package fiuba.algo3.tp2.vista;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class TiendaView extends Group {

    private GridPane d;
    private VBox vistaTienda;
    HBox tiendaHBox;
    HBox primeraHBox;
    HBox segundaHBox;

    public TiendaView() {

        vistaTienda = new VBox();

        this.prepararLaTienda();

    }

    private void prepararLaTienda() {

        tiendaHBox = new HBox();
        primeraHBox = new HBox();
        segundaHBox = new HBox();


        Tooltip tooltipSoldado = new Tooltip("Precio: 1\n" +
                                                "Danio: 10\n" +
                                                "Tip: tiene la mejor relacion en costo-stats");
        Tooltip tooltipJinete = new Tooltip("Precio: 3\n" +
                                               "Danio con espada: 5\n" +
                                               "Danio con arco: 15\n" +
                                               "Tip: Cuando hay enemigos cerca utiliza la espada");
        Tooltip tooltipCurandero = new Tooltip("Precio: 2\n" +
                                                  "Curacion: 15\n" +
                                                  "Tip: No puede atacar, cura piezas aliadas");
        Tooltip tooltipCatapulta = new Tooltip("Precio: 5\n" +
                                                  "Danio: 20\n" +
                                                  "Tip: No puede ser curada pero tiene un gran alcance");

        vistaTienda.setId("tienda");

        ImageView tiendaIcono = new ImageView(new Image("file:src/main/resources/ic-shop-open.png", 200, 200, false, false));
        ImageView soldado = new ImageView(new Image("file:src/main/resources/ic-soldado-negro-seleccionado.png", 200, 200, false, false));
        ImageView jinete = new ImageView(new Image("file:src/main/resources/ic-jinete-negro-seleccionado.png", 200, 200, false, false));
        ImageView curandero = new ImageView(new Image("file:src/main/resources/ic-curandero-blanco.png"));//poner al curandero 3ero para q mantenga mejor calidad la img.
        ImageView catapulta = new ImageView(new Image("file:src/main/resources/ic-catapulta-blanco-seleccionado.png", 200, 200, false, false));

        curandero.setFitWidth(200);
        curandero.setFitHeight(200);


        tiendaIcono.setFitWidth(100);
        tiendaIcono.setFitHeight(100);

        soldado.setCursor(Cursor.CLOSED_HAND);
        curandero.setCursor(Cursor.CLOSED_HAND);
        jinete.setCursor(Cursor.CLOSED_HAND);
        catapulta.setCursor(Cursor.CLOSED_HAND);


        Tooltip.install(soldado, tooltipSoldado);
        tooltipSoldado.setShowDuration(Duration.INDEFINITE);
        tooltipSoldado.setShowDelay(Duration.seconds(.1));

        Tooltip.install(curandero, tooltipCurandero);
        tooltipCurandero.setShowDuration(Duration.INDEFINITE);
        tooltipCurandero.setShowDelay(Duration.seconds(.1));

        Tooltip.install(jinete, tooltipJinete);
        tooltipJinete.setShowDuration(Duration.INDEFINITE);
        tooltipJinete.setShowDelay(Duration.seconds(.1));

        Tooltip.install(catapulta, tooltipCatapulta);
        tooltipCatapulta.setShowDuration(Duration.INDEFINITE);
        tooltipCatapulta.setShowDelay(Duration.seconds(.1));



        tiendaHBox.getChildren().add(tiendaIcono);
        tiendaHBox.setAlignment(Pos.CENTER);

        primeraHBox.getChildren().addAll(soldado,jinete);
        segundaHBox.getChildren().addAll(curandero,catapulta);

        primeraHBox.setSpacing(30);
        segundaHBox.setSpacing(30);

        vistaTienda.getChildren().addAll(tiendaHBox, primeraHBox, segundaHBox);

        vistaTienda.setSpacing(15);


        vistaTienda.getStylesheets().add("css/tienda.css");

        this.getChildren().add(vistaTienda);

        this.habilitarMoverPiezaAlTablero();

    }

    private void habilitarMoverPiezaAlTablero() {
        Image soldado = new Image("file:src/main/resources/ic-soldado-negro-seleccionado.png", 40, 40, false, false);
        Image jinete = new Image("file:src/main/resources/ic-jinete-negro-seleccionado.png", 40, 40, false, false);
        Image curandero = new Image("file:src/main/resources/ic-curandero-blanco.png", 40, 40, false, false);
        Image catapulta = new Image("file:src/main/resources/ic-catapulta-blanco-seleccionado.png", 40, 40, false, false);

        primeraHBox.getChildren().get(0).setOnDragDetected(event -> {
            Dragboard db = primeraHBox.getChildren().get(0).startDragAndDrop(TransferMode.COPY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString("soldado");
            cb.putImage(soldado);
            db.setContent(cb);
            event.consume();
        });
        primeraHBox.getChildren().get(1).setOnDragDetected(event -> {
            Dragboard db = primeraHBox.getChildren().get(1).startDragAndDrop(TransferMode.COPY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString("jinete");
            cb.putImage(jinete);
            db.setContent(cb);
            event.consume();
        });
        segundaHBox.getChildren().get(0).setOnDragDetected(event -> {
            Dragboard db = segundaHBox.getChildren().get(0).startDragAndDrop(TransferMode.COPY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString("curandero");
            cb.putImage(curandero);
            db.setContent(cb);
            event.consume();
        });
        segundaHBox.getChildren().get(1).setOnDragDetected(event -> {
            Dragboard db = segundaHBox.getChildren().get(1).startDragAndDrop(TransferMode.COPY);
            ClipboardContent cb = new ClipboardContent();
            cb.putString("catapulta");
            cb.putImage(catapulta);
            db.setContent(cb);
            event.consume();
        });
    }
}
