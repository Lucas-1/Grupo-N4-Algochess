package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.Observer;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.excepciones.CasilleroEstaVacioException;
import fiuba.algo3.tp2.juego.Algochess;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class TableroView extends Group implements Observer {

    public double ancho;
    public double largo;
    private final static double ANCHO_CASILLERO = 40;
    private final static double LARGO_CASILLERO = 40;

    private Algochess algochess;
    private Tablero tablero;
    private GridPane tableroView;
    private Pane[][] casilleros;
    private PiezasView piezasView;
    private ControlesView control;

    public TableroView(Algochess algochess) {

        this.algochess = algochess;
        this.tablero = algochess.getTablero();
        this.tablero.addObserver(this);
        tableroView = new GridPane();
        ancho = ANCHO_CASILLERO * tablero.obtenerTamanioTablero();
        largo = LARGO_CASILLERO * tablero.obtenerTamanioTablero();
        casilleros = new Pane[(int)ancho][(int)largo];
        piezasView = new PiezasView();

        for(int i = 0; i < tablero.obtenerTamanioTablero()/2; i++){
            for(int j = 0; j < tablero.obtenerTamanioTablero(); j++){

                Pane v = new Pane();
                v.setMinHeight(LARGO_CASILLERO);
                v.setMinWidth(ANCHO_CASILLERO);
                v.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                this.setearRecibirPieza(v);
                casilleros[i][j] = v;
                tableroView.add(v,i,j);
            }
        }

        for(int i = tablero.obtenerTamanioTablero()/2; i < tablero.obtenerTamanioTablero(); i++){
            for(int j = 0; j < tablero.obtenerTamanioTablero(); j++){

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
                algochess.jugadorComprarPieza(piezasView.colocar(piezaNuevaString),tableroView.getRowIndex(casillero),tableroView.getColumnIndex(casillero));
            }
        });
        casillero.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                control.setPiezaAMover(obtenerPiezaDeInterfaz(casillero));
                System.out.println(obtenerPiezaDeInterfaz(casillero).getNombre());
            }
        });
    }

    public Pieza obtenerPiezaDeInterfaz(Pane casillero){

        return this.tablero.obtenerPieza(tableroView.getRowIndex(casillero),tableroView.getColumnIndex(casillero));
    }

    private void actualizarCasilleroDeInterfaz(Pieza pieza,int fila,int columna){

        Pane casilleroNuevo;
        ObservableList<Node> casilleros = tableroView.getChildren();

        for(Node casillero: casilleros){

            if(fila == tableroView.getRowIndex(casillero) && columna == tableroView.getColumnIndex(casillero)){

                casilleroNuevo = (Pane) casillero;
                casilleroNuevo.getChildren().clear();
                casilleroNuevo.getChildren().add(new ImageView(piezasView.dibujar(pieza.getNombre())));
                casilleros.set(casilleros.indexOf(casillero),casilleroNuevo);
            }
        }

    }

    private void actualizarVistaTablero(){

        for(int i = 0;i < tablero.obtenerTamanioTablero();i++){
            for(int j = 0;j < tablero.obtenerTamanioTablero();j++){

                try {

                    casilleros[i][j].getChildren().clear();
                    casilleros[i][j].getChildren().add(new ImageView(piezasView.dibujar(tablero.obtenerPieza(i,j).getNombre())));

                } catch (CasilleroEstaVacioException e){

                }
            }
        }
    }

    public void change(){

        actualizarVistaTablero();
    }

    public void setControl(ControlesView control) {

        this.control = control;
    }



}
