package fiuba.algo3.tp2.vista;
import fiuba.algo3.tp2.piezas.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class PiezasView  {

    ImageView catapultaImagen;
    ImageView jineteImagen;
    ImageView curanderoImagen;
    ImageView soldadoImagen;

    public PiezasView() {
        this.catapultaImagen = new ImageView(new Image("catapultaPlaceholder.png"));
        this.curanderoImagen = new ImageView(new Image("curanderoPlaceHolder.png"));
        this.jineteImagen = new ImageView(new Image("jinetePlaceholder.png"));
        this.soldadoImagen = new ImageView(new Image("soldadoPlaceholder.png"));
    }

    public void dibujar(Pieza pieza, StackPane casillero){

    }

    public void dibujar(Jinete jinete,StackPane casillero){
        casillero.getChildren().add(this.jineteImagen);
    }

    public void dibujar(Catapulta catapulta,StackPane casillero){
        casillero.getChildren().add(this.catapultaImagen);
    }

    public void dibujar(Curandero curandero,StackPane casillero){
        casillero.getChildren().add(this.curanderoImagen);
    }
    public void dibujar(SoldadoDeInfanteria soldadoDeInfanteria,StackPane casillero){
        casillero.getChildren().add(this.soldadoImagen);
    }

}
