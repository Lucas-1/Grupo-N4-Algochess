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

    public void agregarUnidad(Entidad entidad, int posicionFila, int posicionColumna, Color color) {

        Casillero casillero = casilleros[posicionFila][posicionColumna];

        if(casillero.esValida(color))
            casillero.agregarUnidad(entidad);
    }

    public void borrarUnidad(int posicionFila, int posicionColumna) {

        casilleros[posicionFila][posicionColumna].borrarUnidad();
    }

    public boolean casilleroOcupado(int posicionFila, int posicionColumna) {

        return casilleros[posicionFila][posicionColumna].estaOcupado();
    }

    public Casillero getCasillero(int posicionFila, int posicionColumna) {

        return casilleros[posicionFila][posicionColumna];
    }

    public void moverUnidad(Entidad entidad,Direccion dir){

        Posicion posicionActual = entidad.getPosicion();
        Casillero casillero = casilleros[posicionActual.getDireccionFila()][posicionActual.getDireccionColumna()];
        entidad.mover(dir);
        casillero.borrarUnidad();
        posicionActual = entidad.getPosicion();
        casillero = casilleros[posicionActual.getDireccionFila()][posicionActual.getDireccionColumna()];
        casillero.setearUnidad(entidad);
    }

    public Entidad getEntidad(int posicionFila, int posicionColumna) {

        return casilleros[posicionFila][posicionColumna].getEntidad();
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
