package fiuba.algo3.tp2;

import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.piezas.Pieza;

public class AdministradorEventos {
    /** esta clase se encarga de mandar fase inicial, y hacer pasar los turnos hasta que alguien pierda*/
    private AdministradorEventosPorTurno administradorEventosPorTurno;
    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;

    public AdministradorEventos(Jugador jugador1, Jugador jugador2){
        this.tablero = new Tablero();
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    /*public void iniciarJuego(){
        while(administradorEventosPorTurno.juegoContinua()){
            administradorEventosPorTurno.nuevoTurno();
        }
    }

    public void preparativosIniciales(){
        administradorEventosPorTurno.faseInicial();
    }

    public void mostrarResultado() {
        // implementar, podria ser con el nombre del jugador
    }*/

    public void jugador1ComprarPieza(Pieza pieza) {
        jugador1.comprarPieza(pieza);
    }
    public void jugador2ComprarPieza(Pieza pieza) {
        jugador2.comprarPieza(pieza);
    }

    public void jugador1AcomodarPieza(Posicion posicionInicial, Posicion posicionDeseada, int posicionPiezaBanco) {
        jugador1.acomodarPieza(posicionInicial, posicionDeseada, posicionPiezaBanco, tablero);
    }

    public void jugador2AcomodarPieza(Posicion posicionInicial, Posicion posicionDeseada, int posicionPiezaBanco) {
        jugador2.acomodarPieza(posicionInicial, posicionDeseada, posicionPiezaBanco, tablero);
    }

    public void jugador1MoverPieza(Pieza pieza, Direccion direccion) {
        jugador1.moverPieza(pieza, direccion, tablero);
    }

    public void jugador2MoverPieza(Pieza pieza, Direccion direccion) {
        jugador2.moverPieza(pieza, direccion, tablero);
    }
}
