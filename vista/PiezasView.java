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

    private HashMap<String,Image> mapDeImagenes;
    private HashMap<String,Pieza> mapDePiezasBlancas;
    private HashMap<String,Pieza> mapDePiezasNegras;


    public PiezasView() {
        mapDePiezasNegras = this.iniciarMapDePiezas(new Negro());
        mapDePiezasBlancas = this.iniciarMapDePiezas(new Blanco());
        mapDeImagenes = this.iniciarMapDeImagenes();
    }


    private HashMap iniciarMapDePiezas(Color color){
        HashMap mapDePiezas = new HashMap();
        mapDePiezas.put("soldado",new SoldadoDeInfanteria(color));
        mapDePiezas.put("jinete",new Jinete(color));
        mapDePiezas.put("curandero",new Curandero(color));
        mapDePiezas.put("catapulta",new Catapulta(color));
        return mapDePiezas;
    }

    private HashMap iniciarMapDeImagenes(){
        HashMap mapDeImagenes = new HashMap();
        mapDeImagenes.put("Soldado",new Image("file:src/main/resources/ic-soldado-negro.png",40, 40, false, false));
        mapDeImagenes.put("Jinete",new Image("file:src/main/resources/ic-jinete-negro.png", 40, 40, false, false));
        mapDeImagenes.put("Curandero",new Image("file:src/main/resources/ic-curandero-negro.png", 40, 40, false, false));
        mapDeImagenes.put("Catapulta",new Image("file:src/main/resources/ic-catapulta-negro.png", 40, 40, false, false));
        return mapDeImagenes;
    }

    public Pieza colocar(String pieza) {
        return mapDePiezasBlancas.get(pieza);
    }

    public Image dibujar(String pieza){
        return mapDeImagenes.get(pieza);
    }

}
