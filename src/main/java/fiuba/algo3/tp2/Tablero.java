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

    public void agregarUnidad(Entidad entidad, int pos_fila, int pos_columna) {

        casilleros[pos_fila][pos_columna].agregarUnidad(entidad);
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




}
