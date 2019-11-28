/**faltaria todavia resolver el ataque de las piezas, y como administrar la compra y posicionamiento de las piezas, dejo el codigo viejo comentado por si lo quieren reutilizar*/
/**faltaria todavia resolver el ataque de las piezas, y como administrar la compra y posicionamiento de las piezas, dejo el codigo viejo comentado por si lo quieren reutilizar*/
/**faltaria todavia resolver el ataque de las piezas, y como administrar la compra y posicionamiento de las piezas, dejo el codigo viejo comentado por si lo quieren reutilizar*/
/**faltaria todavia resolver el ataque de las piezas, y como administrar la compra y posicionamiento de las piezas, dejo el codigo viejo comentado por si lo quieren reutilizar*/
/**faltaria todavia resolver el ataque de las piezas, y como administrar la compra y posicionamiento de las piezas, dejo el codigo viejo comentado por si lo quieren reutilizar*/
package fiuba.algo3.tp2;

import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.piezas.Pieza;

public class Algochess {

    private AdministradorEventosGenerales administradorEventos;
    /*private Jugador jugadorBlanco;
    private Jugador jugadorNegro;
    private Tablero tablero;*/

    public Algochess() {

        administradorEventos = new AdministradorEventosGenerales();
        //administradorEventos.preparativosIniciales();

        /*
        Color blanco = new Blanco();
        Color negro = new Negro();
        jugadorBlanco = new Jugador(blanco);
        jugadorNegro = new Jugador(negro);
        tablero = new Tablero();*/
    }

    public void iniciarJuego(Jugador jugadorBlanco, Jugador jugadorNegro){
        administradorEventos.iniciarJuego(jugadorBlanco,jugadorNegro);
    }

    public void jugadorComprarPieza(Pieza pieza){
        administradorEventos.jugadorComprarPieza(pieza);
    }

    public void terminarTurno(){
        administradorEventos.terminarTurno();
    }

    public void moverPieza(Pieza pieza, Direccion direccion){
        administradorEventos.moverPieza(pieza,direccion);
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
