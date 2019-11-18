package fiuba.algo3.tp2;

import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.piezas.Pieza;

public class Algochess {

    private AdministradorEventos administradorEventos;
    /*private Jugador jugadorBlanco;
    private Jugador jugadorNegro;
    private Tablero tablero;*/

    public Algochess(Jugador jugador1, Jugador jugador2) {

        administradorEventos = new AdministradorEventos(jugador1,jugador2);
        //administradorEventos.preparativosIniciales();

        /*
        Color blanco = new Blanco();
        Color negro = new Negro();
        jugadorBlanco = new Jugador(blanco);
        jugadorNegro = new Jugador(negro);
        tablero = new Tablero();*/
    }
    public void jugador1ComprarPieza(Pieza pieza){
        administradorEventos.jugador1ComprarPieza(pieza);
    }
    public void jugador2ComprarPieza(Pieza pieza){
        administradorEventos.jugador2ComprarPieza(pieza);
    }
    public void jugador1AcomodarPieza(Posicion posicionInicial, Posicion posicionDeseada, int posicionPiezaBanco){
        administradorEventos.jugador1AcomodarPieza(posicionInicial, posicionDeseada, posicionPiezaBanco);
    }
    public void jugador2AcomodarPieza(Posicion posicionInicial, Posicion posicionDeseada, int posicionPiezaBanco){
        administradorEventos.jugador2AcomodarPieza(posicionInicial, posicionDeseada, posicionPiezaBanco);
    }
    public void jugador1MoverPieza(Pieza pieza, Direccion direccion){
        administradorEventos.jugador1MoverPieza(pieza, direccion);
    }
    public void jugador2MoverPieza(Pieza pieza, Direccion direccion){
        administradorEventos.jugador2MoverPieza(pieza, direccion);
    }

    /*public void inicializarPiezas() {

        jugadorBlanco.inicializarPiezas(tablero);
        jugadorNegro.inicializarPiezas(tablero);
    }

    public void Jugar() {
        this.inicializarPiezas();
        while(true) {

            jugadorBlanco.moverUnaPieza(tablero);
            jugadorBlanco.atacar(tablero);

            if(!jugadorNegro.sigueEnJuego()) {
               System.out.println("Gano el blanco");
               break;
            }

            jugadorNegro.moverUnaPieza(tablero);
            jugadorNegro.atacar(tablero);

            if(!jugadorBlanco.sigueEnJuego()) {
                System.out.println("Gano el negro");
                break;
            }
        }
    }*/
    //getters para pruebas

    /*public Jugador getJugadorBlanco() {
        return jugadorBlanco;
    }
    public Jugador getJugadorNegro(){
        return jugadorNegro;
    }
    public Tablero getTablero() {
        return tablero;
    }*/

}
