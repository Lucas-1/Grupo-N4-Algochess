package fiuba.algo3.tp2.flujoDelJuego.fasesDeJuego;

import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.excepciones.NoSePuedeComprarPiezasEnFaseDeBatallaException;
import fiuba.algo3.tp2.excepciones.NoSePuedenAcomodarPiezasEnEstaFaseDelJuegoException;
import fiuba.algo3.tp2.flujoDelJuego.AdministradorEventosPorTurno;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Danina;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Saludable;

public class FaseDeBatalla extends FaseDeJuego{


    public FaseDeBatalla(AdministradorEventosPorTurno administradorEventosPorTurno) {
        this.administradorEventosPorTurno = administradorEventosPorTurno;
    }
    @Override
    public void jugadorComprarPieza(Pieza pieza, int fila, int columna, Tablero tablero){
        try{
            throw new NoSePuedeComprarPiezasEnFaseDeBatallaException("La fase inicial ya termino");
        }catch (NoSePuedeComprarPiezasEnFaseDeBatallaException e){
            System.out.println(e.getMessage());
        }
    }

    private FaseDeJuego pasarASiguiente() {
        return new FaseFinalDeJuego();
    }

    @Override
    public FaseDeJuego cambiarDeFaseSiEsNecesario() {
        if(this.administradorEventosPorTurno.terminoLaFase(this))
            return this.pasarASiguiente();
        return this;
    }

    @Override
    public void moverPieza(Pieza pieza, Direccion direccion, Tablero tablero) {
        this.administradorEventosPorTurno.moverPieza(pieza,direccion,tablero);
    }

    @Override
    public void atacarCon(Danina pieza, int fila, int columna, Tablero tablero) {
        this.administradorEventosPorTurno.atacarCon(pieza, fila, columna, tablero);
    }

    @Override
    public void curarCon(Saludable pieza, int fila, int columna, Tablero tablero) {
        this.administradorEventosPorTurno.curarCon(pieza,fila,columna,tablero);

    }

    @Override
    public void acomodarPieza(Pieza pieza, int fila, int columna, Tablero tablero) {
        try{
            throw new NoSePuedenAcomodarPiezasEnEstaFaseDelJuegoException("No te encontras en fase de distribucion");
        }catch (NoSePuedenAcomodarPiezasEnEstaFaseDelJuegoException e){
            System.out.println(e.getMessage());
        }
    }
}
