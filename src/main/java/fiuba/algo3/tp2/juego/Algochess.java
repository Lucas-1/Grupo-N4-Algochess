package fiuba.algo3.tp2.juego;

import fiuba.algo3.tp2.Observable;
import fiuba.algo3.tp2.colores.Blanco;
import fiuba.algo3.tp2.colores.Negro;
import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.flujoDelJuego.AdministradorEventosGenerales;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Danina;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Saludable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;

import java.util.LinkedList;

public class Algochess{

    //private AdministradorEventosGenerales administradorEventos;

    private Tablero tablero;
    private LinkedList<Jugador> jugadores;


    public Algochess() {

        //administradorEventos = new AdministradorEventosGenerales();

        tablero = new Tablero();
        jugadores = new LinkedList();
    }

    public void iniciarJuego(Jugador jugadorBlanco, Jugador jugadorNegro){

        //administradorEventos.iniciarJuego(jugadorBlanco,jugadorNegro);

    }

    public void cargarNombreNegro(String nombreNegro) {

        Jugador jugadorNegro = new Jugador(new Negro(), nombreNegro);
        jugadores.add(jugadorNegro);
    }

    public void cargarNombreBlanco(String nombreBlanco) {

        Jugador jugadorBlanco = new Jugador(new Blanco(), nombreBlanco);
        jugadores.add(jugadorBlanco);
    }

    public void jugadorComprarPieza(Pieza pieza, int fila, int columna){

        //administradorEventos.jugadorComprarPieza(pieza, fila, columna);

        Jugador actual = jugadores.getFirst();
        actual.insertarPiezaEnPosicion(pieza,fila,columna,tablero);
    }

    public void moverPieza(Pieza pieza, Direccion direccion){

        //administradorEventos.moverPieza(pieza,direccion);

        Jugador actual = jugadores.getFirst();
        actual.moverPieza(pieza,direccion,tablero);
        System.out.println("Pieza se movió");

    }

    public void terminarTurno(){

        //administradorEventos.terminarTurno();


        /** le pasa el turno al proximo jugador poniendolo en el primer lugar de la lista
         * y el que estaba primero va al fondo**/
        Jugador temp = jugadores.getFirst();
        temp.terminarTurno();

        jugadores.removeFirst();
        jugadores.addLast(temp);

        System.out.println("Se cambió de turno ahora es turno del jugador: " + jugadores.getFirst().getNombre());

    }

    public Jugador obtenerJugadorConTurno() {

        return jugadores.getFirst();
    }

    public void atacarCon(Danina pieza, int fila, int columna) {

        //administradorEventos.atacarCon(pieza, fila, columna);

        Jugador actual = jugadores.getFirst();
        actual.atacarCon(pieza,fila,columna,tablero);
    }

    public void curarCon(Saludable pieza, int fila, int columna){

        //administradorEventos.curarCon(pieza,fila,columna);

        Jugador actual = jugadores.getFirst();
        actual.curarCon(pieza,fila,columna,tablero);
    }

    public void acomodarPieza(Pieza pieza, int fila, int columna){

        //administradorEventos.acomodarPieza(pieza, fila, columna);
    }


    /**metodos para testing solamente*/
    public boolean casilleroOcupado(int fila, int columna) {

        return tablero.casilleroOcupado(fila,columna);
    }

    public Tablero getTablero() {

        return tablero;
    }

    public int getPuntosDeCompraDelJugador() {
        return jugadores.getFirst().getPuntosDeCompraDisponibles();
    }
}
