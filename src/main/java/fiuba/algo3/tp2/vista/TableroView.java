package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.Observer;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.juego.Algochess;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class TableroView extends Group {

    public double ancho;
    public double largo;
    private double anchoCasillero = 32;
    private double largoCasillero = 32;

    private Tablero tablero;
    private GridPane tableroView;
    private Pane[][] casilleros;

    public TableroView(Algochess algochess) {

        this.tablero = algochess.getTablero();
        tableroView = new GridPane();
        ancho = anchoCasillero * tablero.obtenerTamanioTablero();
        largo = largoCasillero * tablero.obtenerTamanioTablero();
        casilleros = new Pane[(int)ancho][(int)largo];

        for(int i = 0; i < tablero.obtenerTamanioTablero(); i++){
            for(int j = 0; j < tablero.obtenerTamanioTablero()/2; j++){
                Pane v = new Pane();
                v.setMinHeight(largoCasillero);
                v.setMinWidth(anchoCasillero);
                v.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                this.setearRecibirPieza(v);
                casilleros[i][j] = v;
                tableroView.add(v,i,j);
            }
        }

        for(int i = 0; i < tablero.obtenerTamanioTablero(); i++){
            for(int j = tablero.obtenerTamanioTablero()/2; j < tablero.obtenerTamanioTablero(); j++){
                Pane v = new Pane();
                v.setMinHeight(largoCasillero);
                v.setMinWidth(anchoCasillero);
                v.setBackground(new Background(new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY)));
                this.setearRecibirPieza(v);
                casilleros[i][j] = v;
                tableroView.add(v,i,j);
            }
        }

        tableroView.setGridLinesVisible(true);
        tableroView.setPadding(new Insets(10));
        this.addView(tableroView);
    }

    private void addView(GridPane tableroView) {
        this.getChildren().add(tableroView);
    }

    private void setearRecibirPieza(Pane casillero){

        casillero.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                if (event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.ANY);
                }
            }
        });
        casillero.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Image casilleroOcupado = event.getDragboard().getImage();
                ImageView imagen = new ImageView(casilleroOcupado);
                casillero.getChildren().add(imagen);
            }
        });
    }





}
