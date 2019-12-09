package fiuba.algo3.tp2.vista;

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
    private final static double ANCHO_CASILLERO = 40;
    private final static double LARGO_CASILLERO = 40;

    private Tablero tablero;
    private GridPane tableroView;
    private Pane[][] casilleros;
    private PiezasView piezasView;

    public TableroView(Algochess algochess) {

        this.tablero = algochess.getTablero();
        tableroView = new GridPane();
        ancho = ANCHO_CASILLERO * tablero.obtenerTamanioTablero();
        largo = LARGO_CASILLERO * tablero.obtenerTamanioTablero();
        casilleros = new Pane[(int)ancho][(int)largo];
        piezasView = new PiezasView();

        for(int i = 0; i < tablero.obtenerTamanioTablero(); i++){
            for(int j = 0; j < tablero.obtenerTamanioTablero()/2; j++){
                Pane v = new Pane();
                v.setMinHeight(LARGO_CASILLERO);
                v.setMinWidth(ANCHO_CASILLERO);
                v.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                this.setearRecibirPieza(v);
                casilleros[i][j] = v;
                tableroView.add(v,i,j);
            }
        }

        for(int i = 0; i < tablero.obtenerTamanioTablero(); i++){
            for(int j = tablero.obtenerTamanioTablero()/2; j < tablero.obtenerTamanioTablero(); j++){
                Pane v = new Pane();
                v.setMinHeight(LARGO_CASILLERO);
                v.setMinWidth(ANCHO_CASILLERO);
                v.setBackground(new Background(new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY)));
                this.setearRecibirPieza(v);
                casilleros[i][j] = v;
                tableroView.add(v,i,j);
            }
        }

        tableroView.setGridLinesVisible(true);
        tableroView.setPadding(new Insets(10));
        this.getChildren().add(tableroView);
    }

    private void addView(ImageView imagen,int fila,int columna) {
        this.tableroView.add(imagen,fila,columna);
    }

    private void setearRecibirPieza(Pane casillero){

        casillero.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //if (event.getDragboard().hasImage()) {
                event.acceptTransferModes(TransferMode.ANY);
                //}
            }
        });
        casillero.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                String piezaNuevaString = event.getDragboard().getString();
                Image piezaNuevaImg = event.getDragboard().getImage();
                ImageView piezaNueva = new ImageView(piezaNuevaImg);
                casillero.getChildren().clear();
                casillero.getChildren().add(piezaNueva);
                piezasView.dibujar(piezaNuevaString,tablero,tableroView.getRowIndex(casillero),tableroView.getColumnIndex(casillero));
            }
        });
    }





}
