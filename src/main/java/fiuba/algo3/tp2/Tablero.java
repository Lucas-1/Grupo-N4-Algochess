package fiuba.algo3.tp2;

public class Tablero {

    private Casillero[][] casilleros = new Casillero[20][20];

    public Tablero() {

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
    }

    public void agregarUnidad(Entidad entidad, int pos_fila, int pos_columna, Color color) {

        Casillero casillero = casilleros[pos_fila][pos_columna];

        if(casillero.esValida(color))
            casillero.agregarUnidad(entidad);
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




}
