package fiuba.algo3.tp2;

public class Tablero {

    private Casillero[][] casilleros = new Casillero[20][20];

    public Tablero() {

        // Primeras 10 filas color '1'
        for(int fila = 0; fila<10; fila++) {
            for(int columna = 0; columna<20; columna++) {
                casilleros[fila][columna] = new Casillero(fila,columna,1);
            }
        }

        // Siguientes 10 filas color '2'
        for(int fila = 10; fila<20; fila++) {
            for(int columna = 0; columna<20; columna++) {
                casilleros[fila][columna] = new Casillero(fila,columna,2);
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

    // getter
    public Casillero getCasillero(int pos_fila, int pos_columna) {

        return casilleros[pos_fila][pos_columna];
    }




}
