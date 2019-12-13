package fiuba.algo3.tp2.entidadesPrincipales;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.Danina;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Jinete;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Saludable;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.administrador.AdministradorDePiezas;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.excepciones.CasilleroEstaVacioException;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdministradorDeJugadas {

    private static final int MAX_JUGADA_POR_TURNO = 1;

    private int ataquesRealizados;
    private int movimientosRealizados;

    public AdministradorDeJugadas() {

        ataquesRealizados = 0;
        movimientosRealizados = 0;

    }


    public void moverPieza(Pieza pieza, Direccion direccion, Tablero tablero, AdministradorDePiezas admin) {

        if(movimientosRealizados < 1) {
            admin.moverPieza(pieza, direccion, tablero);
            movimientosRealizados++;
        }
    }

    public void atacarCon(Danina pieza, int posicionFila, int posicionColumna, Tablero tablero, AdministradorDePiezas admin, Logger logger) {


        if (ataquesRealizados < 1) {

            try {

                Pieza receptor = tablero.obtenerPieza(posicionFila, posicionColumna);
                Posicion posReceptor = new Posicion(posicionFila, posicionColumna);
                int distanciaEntrePiezas = pieza.calcularDistancia(posReceptor);
                ArrayList<Pieza> contiguas = admin.obtenerPiezasContiguas(posReceptor, tablero);
                pieza.atacar(receptor, distanciaEntrePiezas, contiguas);
                ataquesRealizados++;

            } catch (CasilleroEstaVacioException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
    }

    public void atacarCon(Jinete jinete, int posicionFila, int posicionColumna, Tablero tablero, AdministradorDePiezas admin, Logger logger) {

        if (ataquesRealizados < 1) {

            try {

                Pieza receptor = tablero.obtenerPieza(posicionFila, posicionColumna);
                Posicion posReceptor = new Posicion(posicionFila, posicionColumna);
                int distanciaEntrePiezas = jinete.calcularDistancia(posReceptor);
                ArrayList<Pieza> contiguas = admin.obtenerPiezasContiguas(jinete.getPosicion(), tablero);
                jinete.atacar(receptor, distanciaEntrePiezas, contiguas);
                ataquesRealizados++;

            } catch (CasilleroEstaVacioException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }

        }
    }


    public void curarCon(Saludable pieza, int posicionFila, int posicionColumna, Tablero tablero, Logger logger) {

        if (ataquesRealizados < 1) {

            try {

                Pieza receptor = tablero.obtenerPieza(posicionFila, posicionColumna);
                Posicion posReceptor = new Posicion(posicionFila, posicionColumna);
                int distanciaEntrePiezas = pieza.calcularDistancia(posReceptor);
                pieza.curar(receptor, distanciaEntrePiezas);
                ataquesRealizados++;

            } catch (CasilleroEstaVacioException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
    }

    public void terminarTurno() {

        ataquesRealizados = 0;
        movimientosRealizados = 0;
    }





}
