package fiuba.algo3.tp2.vista;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class PiezasView  {

    ImageView catapultaImagen;
    ImageView jineteImagen;
    ImageView curanderoImagen;
    ImageView soldadoImagen;

    public PiezasView() {

        this.catapultaImagen = new ImageView(new Image("file:src/recursos/catapultaPlaceholder.png"));
        this.curanderoImagen = new ImageView(new Image("file:src/recursos/curanderoPlaceHolder.png"));
        this.jineteImagen = new ImageView(new Image("file:src/recursos/jinetePlaceholder.png"));
        this.soldadoImagen = new ImageView(new Image("file:src/recursos/soldadoPlaceholder.png"));
    }

    public void dibujar(Pieza pieza, Pane casillero){

    }

    public void dibujar(Jinete jinete,Pane casillero){

        casillero.getChildren().add(this.jineteImagen);
    }

    public void dibujar(Catapulta catapulta,Pane casillero) {

        casillero.getChildren().add(this.catapultaImagen);
    }

    public void dibujar(Curandero curandero, Pane casillero){

        casillero.getChildren().add(this.curanderoImagen);
    }

    public void dibujar(SoldadoDeInfanteria soldadoDeInfanteria,StackPane casillero){
        casillero.getChildren().add(this.soldadoImagen);
    }

}
