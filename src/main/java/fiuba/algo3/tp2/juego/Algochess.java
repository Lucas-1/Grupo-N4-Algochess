package fiuba.algo3.tp2.juego;

import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.flujoDelJuego.AdministradorEventosGenerales;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Danina;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Saludable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;

public class Algochess {

    private AdministradorEventosGenerales administradorEventos;

    public Algochess() {

        administradorEventos = new AdministradorEventosGenerales();

    }

    public void iniciarJuego(Jugador jugadorBlanco, Jugador jugadorNegro){
        administradorEventos.iniciarJuego(jugadorBlanco,jugadorNegro);
    }

    public void jugadorComprarPieza(Pieza pieza, int fila, int columna){
        administradorEventos.jugadorComprarPieza(pieza, fila, columna);
    }

    public void terminarTurno(){
        administradorEventos.terminarTurno();
    }

    public void moverPieza(Pieza pieza, Direccion direccion){
        administradorEventos.moverPieza(pieza,direccion);
    }

    public void atacarCon(Danina pieza, int fila, int columna) {
        administradorEventos.atacarCon(pieza, fila, columna);
    }

    public void curarCon(Saludable pieza, int fila, int columna){
        administradorEventos.curarCon(pieza,fila,columna);
    }

    public void acomodarPieza(Pieza pieza, int fila, int columna){
        administradorEventos.acomodarPieza(pieza, fila, columna);
    }

    //
    public Tablero getTablero() {

        return administradorEventos.getTablero();
    }

    /**metodo para testing solamente*/
    public boolean casilleroOcupado(int fila, int columna) {
        return administradorEventos.casilleroOcupado(fila,columna);
    }
}
