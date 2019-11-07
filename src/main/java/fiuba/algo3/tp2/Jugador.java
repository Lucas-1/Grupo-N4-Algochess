package fiuba.algo3.tp2;

public class Jugador {

    private int puntos_disponibles; // 20
    private int cantidad_de_entidades;
    private int color;

    public Jugador(int un_color) {

        puntos_disponibles = 20;
        cantidad_de_entidades = 0;
        color = un_color;
    }

    public void insertarEntidadEnPosicion(Entidad entidad, int pos_fila, int pos_columna, Tablero tablero) {

        if (puntos_disponibles < entidad.getCosto())
            throw new JugadorNoLeAlcanzaParaEntidadException();

        tablero.agregarUnidad(entidad, pos_fila, pos_columna);
        entidad.setPosicion(pos_fila,pos_columna);
        puntos_disponibles = puntos_disponibles - entidad.getCosto();
        ++cantidad_de_entidades;
    }

    public void borrarUnidad(Tablero tablero, int pos_fila, int pos_columna) {

        tablero.borrarUnidad(pos_fila, pos_columna);
        --cantidad_de_entidades;

    }

    public boolean sigue_en_juego() {

        return (cantidad_de_entidades != 0);
    }

    public void moverEntidad(Entidad entidad,Direccion direccion, Tablero tablero){
        int nuevaPosicionX = entidad.getPosicionX() + direccion.getDireccionX();
        int nuevaPosicionY = entidad.getPosicionY() + direccion.getDireccionY();
        tablero.borrarUnidad(entidad.getPosicionX(),entidad.getPosicionY());
        tablero.agregarUnidad(entidad,nuevaPosicionX,nuevaPosicionY);
    }



    //getter para prueba
    public int getPuntosDisponibles() {

        return  puntos_disponibles;
    }
}
