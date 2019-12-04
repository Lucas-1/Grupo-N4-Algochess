package fiuba.algo3.tp2.flujoDelJuego;

import fiuba.algo3.tp2.flujoDelJuego.fasesDeJuego.FaseDeJuego;
import fiuba.algo3.tp2.flujoDelJuego.fasesDeJuego.FaseDeCompra;
import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.excepciones.ElJuegoYaTerminoException;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Danina;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Saludable;

public class AdministradorEventosGenerales {
    /** esta clase se encarga de mandar las fases correspondientes y darles instrucciones*/
    private Tablero tablero;
    private FaseDeJuego faseDeJuego;

    public AdministradorEventosGenerales(){
        this.tablero = new Tablero();

    }

    public void iniciarJuego(Jugador jugadorBlanco, Jugador jugadorNegro){
        this.faseDeJuego = new FaseDeCompra(jugadorBlanco,jugadorNegro);
    }

    public void jugadorComprarPieza(Pieza pieza, int fila, int columna) {
        try {
            faseDeJuego.jugadorComprarPieza(pieza, fila, columna, this.tablero);
        }catch (ElJuegoYaTerminoException e){
            System.out.println(e.getMessage());
        }
    }

    public void terminarTurno() {
        faseDeJuego.actualizarInformacionJugador(this.tablero);
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

    public Tablero getTablero(){

        return  tablero;
    }

    public void cambiarNombreNegro(String nombre) {


    }

    /**metodo para testing solamente*/
    public boolean casilleroOcupado(int fila, int columna) {
        return tablero.casilleroOcupado(fila,columna);
    }

    public void acomodarPieza(Pieza pieza, int fila, int columna) {
        faseDeJuego.acomodarPieza(pieza, fila, columna, tablero);
    }
}
