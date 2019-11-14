package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private final int POSICION_MI_TABLERO = 0;
    private final int POSICION_TABLERO_ENEMIGO = 1;
    private int puntos_disponibles; //  clase admin de enti
    private int cantidad_de_entidades; //  clase admin de enti
    private Color color;

    public Jugador(Color color) {

        puntos_disponibles = 20;
        cantidad_de_entidades = 0;
        this.color = color;
    }

    public void insertarEntidadEnPosicion(Entidad entidad, int posicionFila, int posicionColumna, Tablero tablero) {

        if (puntos_disponibles < entidad.getCosto())
            throw new JugadorNoLeAlcanzaParaEntidadException();

        tablero.agregarUnidad(entidad, posicionFila, posicionColumna, color);
        entidad.setPosicion(posicionFila,posicionColumna);
        puntos_disponibles = puntos_disponibles - entidad.getCosto();
        ++cantidad_de_entidades;
    }

    public void borrarUnidad(Tablero tablero, int posicionFila, int posicionColumna) {

        tablero.borrarUnidad(posicionFila, posicionColumna);
        --cantidad_de_entidades;
    }

    public boolean sigueEnJuego() {

        return (cantidad_de_entidades != 0);
    }

    public void moverEntidad(Entidad entidad,Direccion direccion, Tablero tablero){
        tablero.moverUnidad(entidad,direccion);
    }

    public void inicializarEntidades(Tablero tablero) {

        //
    }

    public int getPuntosDisponibles() {

        return  puntos_disponibles;
    }

    public void moverUnaEntidad(Tablero tablero) {

        //

    }

    public void atacar(Tablero tablero) {

        //

    }

    public Tablero faseInicial(Tablero tablero) {
        return colocarPiezasIniciales(tablero);
    }

    private Tablero colocarPiezasIniciales(Tablero tablero) {
        // aca coloca las piezas iniciales
        return tablero;
    }

    public List<Tablero> realizarTurno(Tablero miLado, Tablero ladoEnemigo) {
        // mueve piezas
        List<Tablero> tableros = new ArrayList<Tablero>();
        tableros.add(POSICION_MI_TABLERO, miLado);
        tableros.add(POSICION_TABLERO_ENEMIGO, ladoEnemigo);
        return tableros;
    }
}
