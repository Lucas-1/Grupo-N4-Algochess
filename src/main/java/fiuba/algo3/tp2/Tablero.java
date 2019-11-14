package fiuba.algo3.tp2;

public class Tablero {

    private Casillero[][] casilleros;
    private Tablero lado1;
    private Tablero lado2;

    public Tablero() {
        casilleros = new Casillero[20][20];
        Color blanco = new Blanco();
        Color negro = new Negro();

        /* Primeras 10 filas color blanco */
        for(int fila = 0; fila<10; fila++) {
            for(int columna = 0; columna<20; columna++) {
                casilleros[fila][columna] = new Casillero(blanco);
            }
        }

        /* Siguientes 10 filas color negro */
        for(int fila = 10; fila<20; fila++) {
            for(int columna = 0; columna<20; columna++) {
                casilleros[fila][columna] = new Casillero(negro);
            }
        }
        lado1 = new Tablero(new Blanco());
        lado2 = new Tablero(new Negro());
    }
    public Tablero(Color color){
        casilleros = new Casillero[10][20];
        for(int fila = 0; fila<10; fila++) {
            for(int columna = 0; columna<20; columna++) {
                casilleros[fila][columna] = new Casillero(color);
            }
        }

    }

    public void agregarUnidad(Entidad entidad, int pos_fila, int pos_columna, Color color) {

        Casillero casillero = casilleros[pos_fila][pos_columna];
        casillero.agregarUnidad(entidad, color);
    }

    public void borrarUnidad(int pos_fila, int pos_columna) {

        casilleros[pos_fila][pos_columna].borrarUnidad();
    }

    public boolean casilleroOcupado(int pos_fila, int pos_columna) {

        return casilleros[pos_fila][pos_columna].estaOcupado();
    }

    public Casillero getCasillero(int pos_fila, int pos_columna) {

        return casilleros[pos_fila][pos_columna];
    }

    public Entidad getEntidad(int posicionFila, int posicionColumna) {

        return casilleros[posicionFila][posicionColumna].getEntidad();
    }

    public void moverUnidad(Entidad entidad,Direccion dir){
        Posicion posicionActual = entidad.getPosicion();
        Casillero casillero = casilleros[posicionActual.getDireccionX()][posicionActual.getDireccionY()];
        entidad.mover(dir);
        casillero.borrarUnidad();
        posicionActual = entidad.getPosicion();
        casillero = casilleros[posicionActual.getDireccionX()][posicionActual.getDireccionY()];
        casillero.agregarUnidad(entidad);

    }


    public Tablero getLadoJugador1() {
        return lado1;
    }

    public Tablero getLadoJugador2() {
        return lado2;
    }

    public void actualizarLados(Tablero tableroJugador1, Tablero tableroJugador2) {
        lado1 = tableroJugador1;
        lado2 = tableroJugador2;
    }
}
