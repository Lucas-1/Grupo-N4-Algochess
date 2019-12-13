package fiuba.algo3.tp2.entidadesPrincipales;

import fiuba.algo3.tp2.entidadesPrincipales.piezas.administrador.AdministradorDePiezas;
import fiuba.algo3.tp2.colores.Color;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.excepciones.CasilleroEstaVacioException;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Danina;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Jinete;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Saludable;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

public class Jugador {

    private StreamHandler streamHandler = new StreamHandler();
    private static final Logger logger = Logger.getLogger( Jugador.class.getName() );

    private AdministradorDePiezas administradorDePiezas;
    private Color color;
    private String nombre;
    private AdministradorDeJugadas adminDeJugadas;

    public Jugador(Color color, String nombre) {

        logger.addHandler(streamHandler);
        this.administradorDePiezas = new AdministradorDePiezas();
        this.color = color;
        this.nombre = nombre;
        this.adminDeJugadas = new AdministradorDeJugadas();
    }

    public Jugador(Color color) {

        administradorDePiezas = new AdministradorDePiezas();
        this.color = color;
        this.nombre = "";
    }

    public void insertarPiezaEnPosicion(Pieza pieza, int posicionFila, int posicionColumna, Tablero tablero) {

        administradorDePiezas.agregarPieza(pieza, posicionFila,posicionColumna,tablero);
    }

    public void borrarPieza(Tablero tablero, int posicionFila, int posicionColumna) {

        Pieza pieza = tablero.obtenerPieza(posicionFila,posicionColumna);
        administradorDePiezas.borrarPieza(pieza);

        tablero.borrarPieza(new Posicion(posicionFila,posicionColumna));
    }

    public void atacarCon(Danina pieza, int posicionFila, int posicionColumna, Tablero tablero) {


        adminDeJugadas.atacarCon(pieza, posicionFila,  posicionColumna, tablero,administradorDePiezas,logger);

    }

    public void atacarCon(Jinete jinete, int posicionFila, int posicionColumna, Tablero tablero) {

        adminDeJugadas.atacarCon(jinete,posicionFila,posicionColumna,tablero,administradorDePiezas,logger);
    }


    public void curarCon(Saludable pieza, int posicionFila, int posicionColumna, Tablero tablero){

        adminDeJugadas.curarCon(pieza,posicionFila,posicionColumna,tablero,logger);
    }

    public void terminarTurno() {

        adminDeJugadas.terminarTurno();
    }

    public boolean sigueEnJuego() {

        return administradorDePiezas.sigueEnJuego();
    }

    public void moverPieza(Pieza pieza, Direccion direccion, Tablero tablero){

        adminDeJugadas.moverPieza(pieza,direccion,tablero,administradorDePiezas);
    }

    public void actualizarPiezas(Tablero tablero) {

        administradorDePiezas.actualizarPiezas(tablero);
    }

    //
    public int getPuntosDeCompraDisponibles() {

        return administradorDePiezas.getPuntosDeCompraDisponibles();
    }

    public String getNombre(){
        return this.nombre;
    }


    public Object colorComoString() {

        return color.comoString();
    }

    public int getCantidadPiezasDeJugador() {

        return administradorDePiezas.getCantidadDePiezas();
    }
}
