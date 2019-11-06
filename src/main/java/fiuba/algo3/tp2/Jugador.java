package fiuba.algo3.tp2;

public class Jugador {

    private int puntos_disponibles; // 20
    private int cantidad_de_entidades;
    private int color;

    public Jugador() {

        puntos_disponibles = 20;
        cantidad_de_entidades = 0;

    }

    public Jugador(int un_color) {

        puntos_disponibles = 20;
        cantidad_de_entidades = 0;
        color = un_color;
    }

    public void insertarEntidadEnPosicion(Entidad entidad, int pos_fila, int pos_columna, Tablero tablero) {

        if (puntos_disponibles < entidad.getCosto()) {
            throw new JugadorNoLeAlcanzaParaEntidadException();
        }
        tablero.agregarUnidad(entidad, pos_fila, pos_columna);
        puntos_disponibles = puntos_disponibles - entidad.getCosto();

    }

    //getter
    public int getPuntosDisponibles() {

        return  puntos_disponibles;
    }
}
