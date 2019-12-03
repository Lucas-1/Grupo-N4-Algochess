/**faltaria todavia resolver el ataque de las piezas, y como administrar la compra y posicionamiento de las piezas, dejo el codigo viejo comentado por si lo quieren reutilizar*/
/**faltaria todavia resolver el ataque de las piezas, y como administrar la compra y posicionamiento de las piezas, dejo el codigo viejo comentado por si lo quieren reutilizar*/
/**faltaria todavia resolver el ataque de las piezas, y como administrar la compra y posicionamiento de las piezas, dejo el codigo viejo comentado por si lo quieren reutilizar*/
/**faltaria todavia resolver el ataque de las piezas, y como administrar la compra y posicionamiento de las piezas, dejo el codigo viejo comentado por si lo quieren reutilizar*/
/**faltaria todavia resolver el ataque de las piezas, y como administrar la compra y posicionamiento de las piezas, dejo el codigo viejo comentado por si lo quieren reutilizar*/
package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.ElJuegoYaTerminoException;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Posicion;
import fiuba.algo3.tp2.piezas.Danina;
import fiuba.algo3.tp2.piezas.Pieza;
import fiuba.algo3.tp2.piezas.Saludable;

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

    public void jugadorComprarPieza(Pieza pieza, int fila, int columna) {
        try {
            faseDeJuego.jugadorComprarPieza(pieza, fila, columna, this.tablero);
        }catch (ElJuegoYaTerminoException e){
            System.out.println(e.getMessage());
        }
    }

    public void terminarTurno() {
        faseDeJuego.actualizarInformacionJugador();
        faseDeJuego.pasarASiguienteTurno();
        faseDeJuego = faseDeJuego.cambiarDeFaseSiEsNecesario();
    }

    public void moverPieza(Pieza pieza, Direccion direccion) {
        try{
            faseDeJuego.moverPieza(pieza, direccion, this.tablero);
        }catch (ElJuegoYaTerminoException e){
            System.out.println(e.getMessage());
        }
    }

    public void atacarCon(Danina pieza, int fila, int columna) {
        try{
            faseDeJuego.atacarCon(pieza, fila, columna, this.tablero);
        }catch (ElJuegoYaTerminoException e){
            System.out.println(e.getMessage());
        }
    }

    public void curarCon(Saludable pieza, int fila, int columna) {
        try{
            faseDeJuego.curarCon(pieza, fila, columna, this.tablero);
        }catch (ElJuegoYaTerminoException e){
            System.out.println(e.getMessage());
        }
    }

    /**metodo para testing solamente*/
    public boolean casilleroOcupado(int fila, int columna) {
        return tablero.casilleroOcupado(fila,columna);
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
