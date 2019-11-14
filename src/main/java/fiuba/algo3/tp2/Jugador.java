package fiuba.algo3.tp2;

public class Jugador {

    private AdministradorDeEntidades administradorDeEntidades;
    private Color color;

    public Jugador(Color color) {

        administradorDeEntidades = new AdministradorDeEntidades();
        this.color = color;
    }

    public void insertarEntidadEnPosicion(Entidad entidad, int posicionFila, int posicionColumna, Tablero tablero) {

        administradorDeEntidades.agregarEntidad(entidad, posicionFila,posicionColumna,tablero,color);
    }

    public void borrarUnidad(Tablero tablero, int posicionFila, int posicionColumna) {

        Entidad entidad = tablero.getEntidad(posicionFila,posicionColumna);
        administradorDeEntidades.borrarEntidad(entidad);
        tablero.borrarUnidad(posicionFila, posicionColumna);
    }

    public boolean sigueEnJuego() {

        return administradorDeEntidades.sigueEnJuego();
    }

    public void moverEntidad(Entidad entidad,Direccion direccion, Tablero tablero){

        tablero.moverUnidad(entidad,direccion);
    }

    public int getPuntosDisponibles() {

        return administradorDeEntidades.getPuntosDisponibles();
    }

    //

    public void agregarCatapulta(Tablero tablero, int posFila, int posColumna) {

        administradorDeEntidades.agregarCatapulta(tablero,color,posFila,posColumna);
    }

    public void agregarJinete(Tablero tablero, int posFila, int posColumna) {

        administradorDeEntidades.agregarJinete(tablero,color,posFila,posColumna);
    }

    public void agregarSoldadoInfanteria(Tablero tablero, int posFila, int posColumna) {

        administradorDeEntidades.agregarSoldadoInfanteria(tablero,color,posFila,posColumna);
    }

    public void agregarCurandero(Tablero tablero, int posFila, int posColumna) {

        administradorDeEntidades.agregarCurandero(tablero,color,posFila,posColumna);
    }
}
