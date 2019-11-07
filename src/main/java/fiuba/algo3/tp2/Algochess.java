package fiuba.algo3.tp2;

public class Algochess {

    private Jugador jugadorBlanco;
    private Jugador jugadorNegro;
    private Tablero tablero;
    private int estado; /** 0 = en juego | 1 = gana el blanco | 2 = gana el negro */

    public Algochess() {

        jugadorBlanco = new Jugador(1);
        jugadorNegro = new Jugador(2);
        tablero = new Tablero();
        estado = 0;
    }
}
