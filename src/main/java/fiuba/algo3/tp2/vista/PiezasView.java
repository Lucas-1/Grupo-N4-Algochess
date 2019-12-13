package fiuba.algo3.tp2.vista;
import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.*;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class PiezasView  {

    private HashMap<String,Image> mapDeImagenes;
    private HashMap<String,Tooltip> mapTooltipPiezas;
    private HashMap<String,Pieza> mapDePiezas;


    public PiezasView() {

        mapTooltipPiezas = this.iniciarMapDeTooltips();
    }

    private HashMap<String, Tooltip> iniciarMapDeTooltips() {

        HashMap mapDeTooltips = new HashMap();
        mapDeTooltips.put("soldado", new Tooltip("Danio: 10\n" +
                                                    "Vida maxima: 100"));

        mapDeTooltips.put("jinete", new Tooltip("Danio con espada: 5\n" +
                                                    "Danio con arco: 15\n" +
                                                    "Vida maxima: 100"));

        mapDeTooltips.put("curandero", new Tooltip("Curacion: 15\n" +
                                                        "Vida maxima: 75"));

        mapDeTooltips.put("catapulta", new Tooltip("Danio: 20\n" +
                                                        "Vida maxima: 50"));

        return mapDeTooltips;
    }

    private void actualizarMapDeTooltips(Pieza pieza) {

        mapTooltipPiezas.put(pieza.getNombre()+System.identityHashCode(pieza), new Tooltip("Vida actual: " + pieza.getPuntosDeVida()));
    }


    private HashMap iniciarMapDePiezas(Color color){

        HashMap mapDePiezas = new HashMap();
        mapDePiezas.put("soldado",new SoldadoDeInfanteria(color));
        mapDePiezas.put("jinete",new Jinete(color));
        mapDePiezas.put("curandero",new Curandero(color));
        mapDePiezas.put("catapulta",new Catapulta(color));
        return mapDePiezas;
    }

    private HashMap iniciarMapDeImagenes(Color color){

        HashMap mapDeImagenes = new HashMap();

        String urlSoldado = "file:src/main/resources/ic-soldado-" + color.comoString() + ".png";
        String urlJinete = "file:src/main/resources/ic-jinete-" + color.comoString() + ".png";
        String urlCurandero = "file:src/main/resources/ic-curandero-" + color.comoString() + ".png";
        String urlCatapulta = "file:src/main/resources/ic-catapulta-" + color.comoString() + ".png";


        mapDeImagenes.put("soldado", new Image(urlSoldado, 40, 40, false, false));
        mapDeImagenes.put("jinete", new Image(urlJinete, 40, 40, false, false));
        mapDeImagenes.put("curandero", new Image(urlCurandero, 40, 40, false, false));
        mapDeImagenes.put("catapulta", new Image(urlCatapulta, 40, 40, false, false));

        return mapDeImagenes;


    }

    public Pieza colocar(String pieza, Color color) {


        mapDePiezas = this.iniciarMapDePiezas(color);
        return mapDePiezas.get(pieza);
    }

    public Image dibujar(String pieza, Color color){

        mapDeImagenes = this.iniciarMapDeImagenes(color);
        return mapDeImagenes.get(pieza);
    }

    public Tooltip getTooltip(String pieza) {

        return mapTooltipPiezas.get(pieza);
    }

    public Tooltip getTooltip(String nombrePieza, Pieza pieza) {

        actualizarMapDeTooltips(pieza);
        return mapTooltipPiezas.get(nombrePieza+System.identityHashCode(pieza));
    }
}
