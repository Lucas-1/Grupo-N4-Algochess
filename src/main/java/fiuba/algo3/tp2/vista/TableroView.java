package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.Observer;
import fiuba.algo3.tp2.Tablero;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class TableroView extends Group implements Observer {

    public double ancho;
    public double largo;
    private double anchoCasillero = 32;
    private double largoCasillero = 32;

    private Tablero tablero;
    private GridPane tableroView;
    private PiezasView piezas;
    private StackPane[][] casilleros;

    public TableroView(Tablero tablero) {

        tableroView = new GridPane();
        ancho = anchoCasillero * tablero.obtenerTamanioTablero();
        largo = largoCasillero * tablero.obtenerTamanioTablero();
        casilleros = new StackPane[(int)ancho][(int)largo];
        piezas = new PiezasView();
        this.tablero = tablero;

        for(int i = 0; i < tablero.obtenerTamanioTablero()/2; i++){
            for(int j = 0; j < tablero.obtenerTamanioTablero(); j++){
                StackPane v = new StackPane();
                v.setMinHeight(largoCasillero);
                v.setMinWidth(anchoCasillero);
                v.setBackground(new Background(new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY)));
                casilleros[i][j] = v;
                tableroView.add(v,i,j);
            }
        }

        for(int i = tablero.obtenerTamanioTablero()/2; i < tablero.obtenerTamanioTablero(); i++){
            for(int j = 0; j < tablero.obtenerTamanioTablero(); j++){
                StackPane v = new StackPane();
                v.setMinHeight(largoCasillero);
                v.setMinWidth(anchoCasillero);
                v.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                casilleros[i][j] = v;
                tableroView.add(v,i,j);
            }
        }

        tableroView.setGridLinesVisible(true);
        this.addView(tableroView);
    }

    private void addView(GridPane tableroView) {
        this.getChildren().add(tableroView);
    }

    public void agregarPiezas(Tablero tablero){

        for(int i = 0;i < tablero.obtenerTamanioTablero();i++){
            for(int j = 0;j < tablero.obtenerTamanioTablero();j++){
                piezas.dibujar(tablero.obtenerPieza(i,j),casilleros[i][j]);
            }
        }
    }

    public void borrarPiezas(Tablero tablero){

        for(int i = 0;i < tablero.obtenerTamanioTablero();i++){
            for(int j = 0;j < tablero.obtenerTamanioTablero();j++){
                casilleros[i][j].getChildren().removeAll();
            }
        }
    }

    public void change(){

        this.borrarPiezas(tablero);
        this.agregarPiezas(tablero);
    }
}
