package fiuba.algo3.tp2;

public class Jugador {

    private AdministradorDeEntidades administradorDeEntidades;
    private Color color;

    public Jugador(Color color) {

        administradorDeEntidades = new AdministradorDeEntidades();
        this.color = color;
    }

    public void insertarEntidad(Entidad entidad, int posicionFila, int posicionColumna, Tablero tablero) {

        administradorDeEntidades.agregarEntidad(entidad, posicionFila,posicionColumna,tablero,color);

    }

    public void borrarEntidad(Tablero tablero, int posicionFila, int posicionColumna) {

        Entidad entidad = tablero.getEntidad(posicionFila,posicionColumna);
        administradorDeEntidades.borrarEntidad(entidad);
        tablero.borrarUnidad(posicionFila, posicionColumna);
    }

    public boolean sigueEnJuego() {

        return administradorDeEntidades.sigueEnJuego();
    }

    public void moverEntidad(Entidad entidad,Direccion direccion, Tablero tablero){

        int nuevaPosicionColumna = entidad.getPosicionColumna() + direccion.getDireccionX();
        int nuevaPosicionFila = entidad.getPosicionFila() + direccion.getDireccionY();

        tablero.borrarUnidad(entidad.getPosicionFila(),entidad.getPosicionColumna());
        tablero.agregarUnidad(entidad,nuevaPosicionFila,nuevaPosicionColumna,color);
    }

    public void inicializarEntidades(Tablero tablero) {

        //
    }

    public int getPuntosDisponibles() {

        return administradorDeEntidades.getPuntosDisponibles();
    }

    public void moverUnaEntidad(Tablero tablero) {

        //

    }

    public void atacar(Tablero tablero) {

        //

    }
}
