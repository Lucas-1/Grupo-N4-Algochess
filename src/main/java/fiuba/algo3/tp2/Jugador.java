package fiuba.algo3.tp2;

public class Jugador {

    private int puntos_disponibles;
    private int cantidad_de_entidades;
    private Color color;

    public Jugador(Color color) {

        puntos_disponibles = 20;
        cantidad_de_entidades = 0;
        this.color = color;
    }

    public void insertarEntidadEnPosicion(Entidad entidad, int posicionFila, int posicionColumna, Tablero tablero) {

        if (puntos_disponibles < entidad.getCosto())
            throw new JugadorNoLeAlcanzaParaEntidadException();

        tablero.agregarUnidad(entidad, posicionFila, posicionColumna);
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

        int nuevaPosicionX = entidad.getPosicionX() + direccion.getDireccionX();
        int nuevaPosicionY = entidad.getPosicionY() + direccion.getDireccionY();
        tablero.borrarUnidad(entidad.getPosicionX(),entidad.getPosicionY());
        tablero.agregarUnidad(entidad,nuevaPosicionX,nuevaPosicionY);
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
}
