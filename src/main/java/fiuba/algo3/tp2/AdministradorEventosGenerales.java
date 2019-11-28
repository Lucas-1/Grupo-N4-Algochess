/**faltaria todavia resolver el ataque de las piezas, y como administrar la compra y posicionamiento de las piezas, dejo el codigo viejo comentado por si lo quieren reutilizar*/
/**faltaria todavia resolver el ataque de las piezas, y como administrar la compra y posicionamiento de las piezas, dejo el codigo viejo comentado por si lo quieren reutilizar*/
/**faltaria todavia resolver el ataque de las piezas, y como administrar la compra y posicionamiento de las piezas, dejo el codigo viejo comentado por si lo quieren reutilizar*/
/**faltaria todavia resolver el ataque de las piezas, y como administrar la compra y posicionamiento de las piezas, dejo el codigo viejo comentado por si lo quieren reutilizar*/
/**faltaria todavia resolver el ataque de las piezas, y como administrar la compra y posicionamiento de las piezas, dejo el codigo viejo comentado por si lo quieren reutilizar*/
package fiuba.algo3.tp2;

import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.piezas.Pieza;

public class AdministradorEventosGenerales {
    /** esta clase se encarga de mandar las fases correspondientes y darles instrucciones*/
    private Tablero tablero;
    private FaseDeJuego faseDeJuego;

    public AdministradorEventosGenerales(){
        this.tablero = new Tablero();

    }

    public void iniciarJuego(Jugador jugadorBlanco, Jugador jugadorNegro){
        this.faseDeJuego = new FaseInicial(jugadorBlanco,jugadorNegro);
    }

    public void jugadorComprarPieza(Pieza pieza) {
        faseDeJuego.jugadorComprarPieza(pieza);
    }

    public void terminarTurno() {
        faseDeJuego.actualizarInformacionJugador();
        faseDeJuego.pasarASiguienteTurno();
        faseDeJuego = faseDeJuego.cambiarDeFaseSiEsNecesario();
    }

    public void moverPieza(Pieza pieza, Direccion direccion) {
        faseDeJuego.moverPieza(pieza, direccion, this.tablero);
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


}
