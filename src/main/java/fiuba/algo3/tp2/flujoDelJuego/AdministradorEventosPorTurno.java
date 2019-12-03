package fiuba.algo3.tp2.flujoDelJuego;

import fiuba.algo3.tp2.entidadesPrincipales.Jugador;
import fiuba.algo3.tp2.entidadesPrincipales.tablero.Tablero;
import fiuba.algo3.tp2.excepciones.YaNoSePuedeAtacarEsteTurnoException;
import fiuba.algo3.tp2.excepciones.YaNoSePuedeCurarEsteTurnoException;
import fiuba.algo3.tp2.excepciones.YaSeMovioUnaPiezaEsteTurnoException;
import fiuba.algo3.tp2.flujoDelJuego.fasesDeJuego.FaseDeBatalla;
import fiuba.algo3.tp2.flujoDelJuego.fasesDeJuego.FaseInicial;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Danina;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Pieza;
import fiuba.algo3.tp2.entidadesPrincipales.piezas.Saludable;

public class AdministradorEventosPorTurno {
    private Turno turno;
    private Jugador jugadorConTurno;
    private LimitacionesDeJugadorPorTurno limitaciones;

    public AdministradorEventosPorTurno(Jugador jugadorBlanco, Jugador jugadorNegro){
        this.turno = new Turno(jugadorBlanco, jugadorNegro);
        this.jugadorConTurno = turno.getJugadorConTurno();
        this.limitaciones = new LimitacionesDeJugadorPorTurno();

    }

    public void actualizarInformacionJugador(Tablero tablero) {
        turno.actualizarInformacionJugador(this.jugadorConTurno, tablero);
    }

    public void pasarASiguienteTurno() {
        jugadorConTurno = turno.pasarASiguiente();
        limitaciones.reiniciarLimitaciones();
    }

    public void jugadorComprarPieza(Pieza pieza, int fila, int columna, Tablero tablero) {
        jugadorConTurno.insertarPiezaEnPosicion(pieza, fila, columna, tablero);
    }

    public boolean terminoLaFase(FaseInicial faseDeJuego) {
        return turno.turnosInicialesCumplidos();
    }

    public boolean terminoLaFase(FaseDeBatalla faseDeJuego) {
        return this.turno.hayAlgunJugadorMuerto();
    }

    public void moverPieza(Pieza pieza, Direccion direccion, Tablero tablero) {
        try{
            if(!limitaciones.puedoRealizarMovimiento())
                throw new YaSeMovioUnaPiezaEsteTurnoException("Solo se puede mover 1 pieza por turno");
        }catch (YaSeMovioUnaPiezaEsteTurnoException e){
            System.out.println(e.getMessage());
            return;
        }

        jugadorConTurno.moverPieza(pieza,direccion,tablero);
        limitaciones.limitarMovimiento();
    }

    public void atacarCon(Danina pieza, int fila, int columna, Tablero tablero) {
        try{
            if (!limitaciones.puedoRealizarAtaque())
                throw new YaNoSePuedeAtacarEsteTurnoException("Solo se puede atacar/curar 1 vez por turno");
        }catch (YaNoSePuedeAtacarEsteTurnoException e){
            System.out.println(e.getMessage());
            return;
        }

        jugadorConTurno.atacarCon(pieza, fila, columna, tablero);
        limitaciones.limitarAtaque();
    }

    public void curarCon(Saludable pieza, int fila, int columna, Tablero tablero) {
        try{
            if(!limitaciones.puedoRealizarCuracion())
                throw new YaNoSePuedeCurarEsteTurnoException("Solo se puede atacar/curar 1 vez por turno");
        }catch (YaNoSePuedeCurarEsteTurnoException e){
            System.out.println(e.getMessage());
            return;
        }


        jugadorConTurno.curarCon(pieza,fila,columna,tablero);
        limitaciones.limitarCuracion();
    }




    /*
    //esta clase se encarga de avisar al jugador que es su face inicial o turno, tambien de actualizar el tablero despues de cada jugada.
    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;

    public AdministradorEventosPorTurno(Jugador jugador1, Jugador jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        tablero = new Tablero();
    }

    public void faseInicial() {




        /*Tablero tableroJugador1 = tablero.getLadoJugador1();
        Tablero tableroJugador2 = tablero.getLadoJugador2();


        // aca faltaria pedirle el nombre a cada jugador o en el constructor directamente

        //el jugador pone piezas iniciales y devuelve su lado actualizado
        tableroJugador1 = jugador1.faseInicial(tableroJugador1);
        tableroJugador2 = jugador2.faseInicial(tableroJugador2);

        //el mapa general se actualiza con las piezas iniciales puestas de ambos lados
        tablero.actualizarLados(tableroJugador1, tableroJugador2);
    }
    public void nuevoTurno() {
        // cada jugador devuelve una lista con su tablero en index 0 y tablero enemigo en index 1
        List<Tablero> tableros = jugador1.realizarTurno(tablero.getLadoJugador1(), tablero.getLadoJugador2()); //el jugador mueve una pieza, necesita ambos tableros por si va a territorio enemigo.
        tablero.actualizarLados(tableros.get(0), tableros.get(1));
        tableros = jugador2.realizarTurno(tablero.getLadoJugador2(), tablero.getLadoJugador1());
        tablero.actualizarLados(tableros.get(1), tableros.get(0));
        //aca irian los ataques porque ya tenemos los tableros actualizados, o podrian estar en el turno de cada jugador.

    }

    public boolean juegoContinua() {
        return !perdioAlgunJugador();
    }

    private boolean perdioAlgunJugador() {
        //perdio alguien? hay que verificarlo aca
        return false;
    }
*/
}