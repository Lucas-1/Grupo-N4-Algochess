package fiuba.algo3.tp2.flujoDelJuego.fasesDeJuego;

import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.excepciones.NoSePuedeRealizarEstaAccionEnLaFaseDeCompraException;
import fiuba.algo3.tp2.excepciones.NoSePuedenAcomodarPiezasEnEstaFaseDelJuegoException;
import fiuba.algo3.tp2.flujoDelJuego.AdministradorEventosPorTurno;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Danina;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Saludable;

public class FaseDeCompra extends FaseDeJuego{


    public FaseDeCompra(Jugador jugadorBlanco, Jugador jugadorNegro){
        this.administradorEventosPorTurno = new AdministradorEventosPorTurno(jugadorBlanco, jugadorNegro);
    }


    private FaseDeJuego pasarASiguiente() {
        return new FaseDeDistribucion(this.administradorEventosPorTurno);
    }

    @Override
    public FaseDeJuego cambiarDeFaseSiEsNecesario() {
        if(this.administradorEventosPorTurno.terminoLaFase(this))
            return this.pasarASiguiente();
        return this;
    }

    @Override
    public void moverPieza(Pieza pieza, Direccion direccion, Tablero tablero) {
        try{
            throw new NoSePuedeRealizarEstaAccionEnLaFaseDeCompraException("No podes mover piezas en la fase inicial");
        }catch (NoSePuedeRealizarEstaAccionEnLaFaseDeCompraException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void atacarCon(Danina pieza, int fila, int columna, Tablero tablero) {
        try{
            throw new NoSePuedeRealizarEstaAccionEnLaFaseDeCompraException("No podes atacar en la fase inicial");
        }catch (NoSePuedeRealizarEstaAccionEnLaFaseDeCompraException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void curarCon(Saludable pieza, int fila, int columna, Tablero tablero) {
        try{
            throw new NoSePuedeRealizarEstaAccionEnLaFaseDeCompraException("No podes curar en la fase inicial");
        }catch (NoSePuedeRealizarEstaAccionEnLaFaseDeCompraException e){
            System.out.println(e.getMessage());
        }
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
