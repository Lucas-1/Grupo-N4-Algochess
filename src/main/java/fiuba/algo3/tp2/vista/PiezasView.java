package fiuba.algo3.tp2.vista;
import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.*;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class PiezasView  {

    HashMap mapDeImagenes;
    HashMap mapDePiezasBlancas;
    HashMap mapDePiezasNegras;


    public PiezasView() {
        mapDePiezasNegras = this.iniciarMapDePiezas(new Negro());
        mapDePiezasBlancas = this.iniciarMapDePiezas(new Blanco());
    }


    private HashMap iniciarMapDePiezas(Color color){
        HashMap mapDePiezas = new HashMap();
        mapDePiezas.put("soldado",new SoldadoDeInfanteria(color));
        mapDePiezas.put("jinete",new Jinete(color));
        mapDePiezas.put("curandero",new Curandero(color));
        mapDePiezas.put("catapulta",new Catapulta(color));
        return mapDePiezas;
    }

    public void dibujar(String pieza, Tablero tablero,int fila,int columna) {
        tablero.agregarPieza((Pieza) mapDePiezasBlancas.get(pieza), fila, columna);
    }

}
